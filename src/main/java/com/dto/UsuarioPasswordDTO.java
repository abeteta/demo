package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/12/17
 */
public class UsuarioPasswordDTO  implements Serializable{

    private static final long serialVersionUID = -8744305220821935864L;
    private String email;
    private String password;

    public UsuarioPasswordDTO () {super();}

    public UsuarioPasswordDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
