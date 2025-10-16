package com.infoveto.classic.api.Controller;

import com.infoveto.classic.api.ApiApplication;
import com.infoveto.classic.api.Entity.TestingEntity;
import com.infoveto.classic.api.Service.TestingService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class TestingController {

    private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);
    @Resource
    private TestingService testingService;

    @GetMapping("/user/{username}")
    public ResponseEntity<?> findByUsername(@PathVariable String username){
        try {
            logger.info("[USER CONTROLLER] Find by username calling with username:" + username +" ! ");
            return ResponseEntity.ok().body(testingService.findAllByUsername(username));
        } catch (RuntimeException e) {
            logger.error("[USER CONTROLLER] Error : " + e.getMessage() );
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok().body(testingService.findAll());
        }catch (RuntimeException e) {
            logger.error("[USER CONTROLLER] Error : " + e.getMessage() );
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/user/{mail}")
    public ResponseEntity<?> findByMail(@PathVariable String mail){
        try{
            logger.info("[USER CONTROLLER] Find by username calling with email:" + mail +" ! ");
            List<TestingEntity> res = testingService.findAllByUserMail(mail);
            return ResponseEntity.ok().body(res);
        }catch (RuntimeException e) {
            logger.error("[USER CONTROLLER] Error : " + e.getMessage() );
            return ResponseEntity.badRequest().build();
        }
    }

}
