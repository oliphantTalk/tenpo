package com.tenpo.tenpo.business.model;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("session_data")
@Getter
@ToString
public class SessionData implements Serializable {

    public SessionData() {
    }

    public SessionData(String id, Long userEntityId, String email, String token) {
        this.id = id;
        this.userEntityId = userEntityId;
        this.email = email;
        this.token = token;
    }

    private String id;
    private Long userEntityId;
    private String email;
    private String token;

}
