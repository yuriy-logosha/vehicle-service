package com.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class PrincipalController {

    private final static Logger log = LoggerFactory.getLogger(PrincipalController.class);

    @GetMapping("/whoami")
    public String whoami(Principal principal) {
        String username = principal.getName();
        JwtAuthenticationToken token = (JwtAuthenticationToken) principal;
        log.info("claims: " + token.getTokenAttributes());
        return username;
    }
}
