package com.tenpo.tenpo.business.session;

import com.nimbusds.oauth2.sdk.TokenResponse;
import com.nimbusds.openid.connect.sdk.LogoutRequest;
import com.tenpo.tenpo.api.session.AuthToken;
import com.tenpo.tenpo.api.session.LoginRq;
import com.tenpo.tenpo.business.exception.UserAlreadyExistException;
import com.tenpo.tenpo.business.mapper.UserMapper;
import com.tenpo.tenpo.business.model.SessionData;
import com.tenpo.tenpo.business.model.User;
import com.tenpo.tenpo.business.repository.RoleRepository;
import com.tenpo.tenpo.business.repository.UserRepository;
import com.tenpo.tenpo.business.session.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@Slf4j
public class SessionService implements ISessionService {

    ###################### AGREGAR REDISSSSSSSSSSSS ##########################33 para manejo de sessiones y el token???

    private static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void signUp(final UserDTO userDTO) throws UserAlreadyExistException {
       if (userExist(userDTO.getEmail())) {
           log.error("Already exist an user with the same email: ");
           throw new UserAlreadyExistException("Already exist an user with the same email: " + userDTO.getEmail());
        }

        User user = UserMapper.INSTANCE.dtoToModel(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEnabled(true);
        user.setRoles(Collections.singletonList(roleRepository.findByName(ROLE_USER)));
        userRepository.save(user);

        //return userRepository.save(user);

    }

    public AuthToken login(final String email, final String password) {
        log.info("");
        User user = userRepository.findByEmail(email);
        passwordEncoder.matches(password, user.getPassword());
        log.info("");
        return UserMapper.INSTANCE.modelToDto(user);
    }

    private boolean userExist(final String email) {
        return userRepository.findByEmail(email) != null;
    }


    @Override
    @Transactional
    public AuthToken login(LoginRq loginRequest) {
        authenticationResolver.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        TokenResponse tokenResponse = jwtService.generateTokenResponse();
        if (!sessionRepository.existsByUsername(loginRequest.getUsername())) {
            sessionRepository.save(new SessionData(getUserId(), loginRequest.getUsername(), tokenResponse.getValue()));
            LOGGER.info("The {}'s session was created. Login was successful.", loginRequest.getUsername());
        } else {
            LOGGER.info("Username {} is already logged in. Returns the new token.", loginRequest.getUsername());
            updateSessionInformation(loginRequest, tokenResponse);
        }
        return tokenResponse;
    }

    @Override
    @Transactional
    public void logout(LogoutRequest logoutRequest) {
        String username = jwtService.getUsername(logoutRequest.getToken());
        sessionRepository.deleteByUsername(username);
        getUserDetails().ifPresent(userDetails -> userDetails.setCredentialsNonExpired(false));
        LOGGER.info("Username {} logged out successfully", username);
    }

    @Override
    @Transactional
    public void signIn(SignInRequest signInRequest) {
        if (!userRepository.existsUserByUsername(signInRequest.getUsername())) {
            saveAndCreateSession(signInRequest);
            LOGGER.info("Username {} was created.", signInRequest.getUsername());
        } else {
            String msg = format("Username %s already exists.", signInRequest.getUsername());
            LOGGER.info(msg);
            throw new UsernameNotAvailableException(msg);
        }
    }

    @Override
    public boolean existSessionByToken(String token) {
        return sessionRepository.existsByToken(token);
    }

    @Override
    public UserData getUserData(String username) {
        return userRepository.findByUsername(username);
    }

    private void updateSessionInformation(LoginRequest loginRequest, TokenResponse tokenResponse) {
        SessionData currentSessionData = sessionRepository.getByUsername(loginRequest.getUsername());
        currentSessionData.setToken(tokenResponse.getValue());
        sessionRepository.save(currentSessionData);
    }

    private void saveAndCreateSession(SignInRequest signInRequest) {
        UserData newUser = new UserData(signInRequest.getUsername(), passwordEncoder.encode(signInRequest.getPassword()));
        UserData userData = userRepository.save(newUser);
        generateCredential(userData);
    }
}
