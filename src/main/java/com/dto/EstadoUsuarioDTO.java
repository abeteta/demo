package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/19/17
 */
public class EstadoUsuarioDTO implements Serializable {
    private static final long serialVersionUID = -4356444753076227492L;

    private Integer estado;

    public EstadoUsuarioDTO (){super();}

    public EstadoUsuarioDTO(Integer estado) {
        this.estado = estado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
