package com.dto;

import com.repository.UsuarioRepository;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/12/17
 */
public class UsuarioRegistradoDTO implements Serializable {

    private static final long serialVersionUID = -3410593405010545182L;
    private Boolean usuarioRegistrado;
    private Integer idUsuario;

    public UsuarioRegistradoDTO (){super();}

    public UsuarioRegistradoDTO(Boolean usuarioRegistrado, Integer idUsuario) {
        this.usuarioRegistrado = usuarioRegistrado;
        this.idUsuario = idUsuario;
    }

    public Boolean getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setUsuarioRegistrado(Boolean usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
