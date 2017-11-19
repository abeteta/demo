package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
public class CambioEstadoUsuarioDTO implements Serializable{
    private static final long serialVersionUID = -1181093932678336281L;

    private Integer id_usuario;

    public CambioEstadoUsuarioDTO () {super();}

    public CambioEstadoUsuarioDTO(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
}
