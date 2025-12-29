package com.infoveto.classic.api.service;

import com.infoveto.classic.api.ApiApplication;
import com.infoveto.classic.api.entity.Appointments;
import com.infoveto.classic.api.entity.Notifications;
import com.infoveto.classic.api.entity.Users;
import com.infoveto.classic.api.repository.UserRepository;
import com.infoveto.classic.api.repository.AnimalsRepository;
import com.infoveto.classic.api.repository.AppointmentsRepository;
import com.infoveto.classic.api.repository.FavoriteDiseasesRepository;
import com.infoveto.classic.api.repository.FavoriteMedicationsRepository;
import com.infoveto.classic.api.repository.FavoriteVeterinariansRepository;
import com.infoveto.classic.api.repository.AnimalDocumentsRepository;
import com.infoveto.classic.api.repository.NotificationsRepository;
import com.infoveto.classic.api.repository.ArticlesFeedbackRepository;
import com.infoveto.classic.api.repository.VetReviewsRepository;
import com.infoveto.classic.api.repository.UsersQuestionsRepository;
import com.infoveto.classic.api.repository.MailConfirmRepository;
import com.infoveto.classic.api.repository.AnimalTreatmentsRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.*;

@Service
public class UsersService {
    private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    @Resource
    private UserRepository userRepository;
    @Resource
    private AnimalsRepository animalsRepository;
    @Resource
    private AppointmentsRepository appointmentsRepository;
    @Resource
    private FavoriteDiseasesRepository favoriteDiseasesRepository;
    @Resource
    private FavoriteMedicationsRepository favoriteMedicationsRepository;
    @Resource
    private FavoriteVeterinariansRepository favoriteVeterinariansRepository;
    @Resource
    private AnimalDocumentsRepository animalDocumentsRepository;
    @Resource
    private NotificationsRepository notificationsRepository;
    @Resource
    private ArticlesFeedbackRepository articlesFeedbackRepository;
    @Resource
    private VetReviewsRepository vetReviewsRepository;
    @Resource
    private UsersQuestionsRepository usersQuestionsRepository;
    @Resource
    private MailConfirmRepository mailConfirmRepository;
    @Resource
    private AnimalTreatmentsRepository animalTreatmentsRepository;

    @Resource
    private PasswordEncoder passwordEncoder;

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public Map<String, Object> getStats(String userId) {
        Map<String, Object> stats = new HashMap<>();

            long animals = animalsRepository.countByUserId_Id(userId);
            long appointments = appointmentsRepository.countByUserId_Id(userId);
            long diseaseFavorites = favoriteDiseasesRepository.countByUserId_Id(userId);
            long medicationFavorites = favoriteMedicationsRepository.countByUserId_Id(userId);
            long veterinarianFavorites = favoriteVeterinariansRepository.countByUserId_Id(userId);
            long documents = animalDocumentsRepository.countByUser_Id(userId);
            long unreadNotifications = notificationsRepository.countByUserId_IdAndIsReadFalse(userId);

            Map<String, Object> favorites = new HashMap<>();
            favorites.put("diseases", diseaseFavorites);
            favorites.put("medications", medicationFavorites);
            favorites.put("veterinarians", veterinarianFavorites);
            favorites.put("total", diseaseFavorites + medicationFavorites + veterinarianFavorites);

            stats.put("animals", animals);
            stats.put("appointments", appointments);
            stats.put("favorites", favorites);
            stats.put("documents", documents);
            stats.put("unreadNotifications", unreadNotifications);

        return stats;
    }

    @Transactional
    public Users updateUser(String userId, Users updated) {
        Users u = userRepository.findById(userId).orElse(null);
        if (u == null) return null;

        // Update allowed fields
        u.setEmail(updated.getEmail());
        u.setFirstName(updated.getFirstName());
        u.setLastName(updated.getLastName());
        u.setBirthDate(updated.getBirthDate());
        u.setPhone(updated.getPhone());
        u.setAddress(updated.getAddress());
        u.setCity(updated.getCity());
        u.setPostalCode(updated.getPostalCode());
        u.setGenre(updated.getGenre());

        return userRepository.save(u);
    }

    @Transactional
    public void deleteUserAccount(String userId) {
        // delete child entities in order
        animalDocumentsRepository.deleteByUser_Id(userId);
        animalTreatmentsRepository.deleteByAnimal_UserId_Id(userId);
        animalsRepository.deleteByUserId_Id(userId);
        appointmentsRepository.deleteByUserId_Id(userId);
        favoriteDiseasesRepository.deleteByUserId_Id(userId);
        favoriteMedicationsRepository.deleteByUserId_Id(userId);
        favoriteVeterinariansRepository.deleteByUserId_Id(userId);
        notificationsRepository.deleteByUserId_Id(userId);
        articlesFeedbackRepository.deleteByUserId_Id(userId);
        vetReviewsRepository.deleteByUserId_Id(userId);
        usersQuestionsRepository.deleteByUserId_Id(userId);
        mailConfirmRepository.deleteByUserId_Id(userId);

        // finally delete user
        userRepository.deleteById(userId);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    public java.util.Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Map<String, Object> getActivity(String userId) {
        Map<String, Object> activity = new HashMap<>();

        List<Appointments> recentAppointments = appointmentsRepository.findTop5ByUserId_IdOrderByDateAppointementDesc(userId);

        List<Map<String, Object>> recentFavorites = new ArrayList<>();
        favoriteDiseasesRepository.findTop5ByUserId_IdOrderByAddedAtDesc(userId).forEach(fd -> {
            Map<String, Object> m = new HashMap<>();
            m.put("type", "disease");
            m.put("name", fd.getDiseases() != null ? fd.getDiseases().getName() : null);
            m.put("date", fd.getAddedAt());
            recentFavorites.add(m);
        });
        favoriteMedicationsRepository.findTop5ByUserId_IdOrderByAddedAtDesc(userId).forEach(fm -> {
            Map<String, Object> m = new HashMap<>();
            m.put("type", "medication");
            m.put("name", fm.getMedication() != null ? fm.getMedication().getName() : null);
            m.put("date", fm.getAddedAt());
            recentFavorites.add(m);
        });
        favoriteVeterinariansRepository.findTop5ByUserId_IdOrderByAddedAtDesc(userId).forEach(fv -> {
            Map<String, Object> m = new HashMap<>();
            m.put("type", "veterinarian");
            m.put("name", fv.getVeterinarians() != null ? fv.getVeterinarians().getLastnameUser() : null);
            m.put("date", fv.getAddedAt());
            recentFavorites.add(m);
        });

        // sort recentFavorites by date desc
        recentFavorites.sort((a, b) -> {
            Date da = (Date) a.get("date");
            Date db = (Date) b.get("date");
            if (da == null && db == null) return 0;
            if (da == null) return 1;
            if (db == null) return -1;
            return db.compareTo(da);
        });

        // create a trimmed list instead of reassigning recentFavorites (lambdas captured it)
        List<Map<String, Object>> topFavorites = recentFavorites.size() > 5
                ? new ArrayList<>(recentFavorites.subList(0, 5))
                : new ArrayList<>(recentFavorites);

        List<Notifications> recentNotifications = notificationsRepository.findTop5ByUserId_IdOrderByCreatedAtDesc(userId);

        activity.put("recentAppointments", recentAppointments);
        activity.put("recentFavorites", topFavorites);
        activity.put("recentNotifications", recentNotifications);

        return activity;
    }
}
