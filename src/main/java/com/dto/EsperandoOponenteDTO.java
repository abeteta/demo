package com.dto;

import com.sun.corba.se.spi.activation.ServerAlreadyInstalled;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/19/17
 */
public class EsperandoOponenteDTO implements Serializable {

    private static final long serialVersionUID = -1052931012185907612L;

    private Integer id_jugador_secundario;
    private Integer estado_versus;

    public EsperandoOponenteDTO () {super();}

    public EsperandoOponenteDTO(Integer id_jugador_secundario, Integer estado_versus) {
        this.id_jugador_secundario = id_jugador_secundario;
        this.estado_versus = estado_versus;
    }

    public Integer getId_jugador_secundario() {
        return id_jugador_secundario;
    }

    public void setId_jugador_secundario(Integer id_jugador_secundario) {
        this.id_jugador_secundario = id_jugador_secundario;
    }

    public Integer getEstado_versus() {
        return estado_versus;
    }

    public void setEstado_versus(Integer estado_versus) {
        this.estado_versus = estado_versus;
    }
}
