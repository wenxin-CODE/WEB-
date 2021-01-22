package com.vueblog.shiro;
import lombok.Data;

import java.io.Serializable;

@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getEmail() {
        return email;
    }
}
