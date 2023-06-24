package com.geekster.Url_Hit_counter.controller;

import com.geekster.Url_Hit_counter.model.UserHit;
import com.geekster.Url_Hit_counter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    private UrlHitService urlHitService;

    @GetMapping("/username/{username}/count")
    public ResponseEntity<UserHit> getHitCount(@PathVariable("username") String username) {
        int count = urlHitService.getCount(username);
        UserHit userHit = new UserHit(username,count);
        return new ResponseEntity<>(userHit, HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<UserHit>> findAll() {
        List<UserHit> userHits = urlHitService.findAll().entrySet().stream()
                .map(entry -> new UserHit(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(userHits, HttpStatus.OK);
    }
}
