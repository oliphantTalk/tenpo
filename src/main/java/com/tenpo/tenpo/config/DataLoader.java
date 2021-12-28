package com.tenpo.tenpo.config;

import com.tenpo.tenpo.business.model.User;
import com.tenpo.tenpo.business.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
public class DataLoader {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void load() {
        User user = new User();
        user.setPassword(passwordEncoder.encode("123456789"));
        user.setEmail("nanobarrena@gmail.com");
        user.setEnabled(true);
        userRepository.save(user);

    }


}
