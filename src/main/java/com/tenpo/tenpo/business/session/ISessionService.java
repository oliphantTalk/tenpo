package com.tenpo.tenpo.business.session;

import com.tenpo.tenpo.api.session.AuthToken;
import com.tenpo.tenpo.api.session.SignUpRq;

public interface ISessionService {

    void signUp(SignUpRq signUpRq);

    AuthToken login(String userId, String password);

    void logout();

}
