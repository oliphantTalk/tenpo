package com.tenpo.tenpo.controller;

import com.tenpo.tenpo.api.session.LoginRq;
import com.tenpo.tenpo.api.session.SignUpRq;
import com.tenpo.tenpo.business.exception.UserAlreadyExistException;
import com.tenpo.tenpo.business.mapper.UserMapper;
import com.tenpo.tenpo.business.session.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@Slf4j
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignUpRq signUpRq) throws UserAlreadyExistException {
        log.info("");
        sessionService.signUp(UserMapper.INSTANCE.apiToDto(signUpRq));
        log.info("");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/login")
    public ResponseEntity<Void> login(@Valid @RequestBody LoginRq loginRq) {
        log.info("");
        sessionService.login(loginRq.getEmail(), loginRq.getPassword());
        log.info("");
        return ResponseEntity.ok().build();
    }

    @PostMapping("/user/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        log.info("");
        log.info("");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return ResponseEntity.ok("asdfasdf");
    }

    @GetMapping("/user/a")
    public ResponseEntity<String> a() {
        log.info("");
        log.info("");
        return ResponseEntity.ok("asdfasdf");
    }


}
