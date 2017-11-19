package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/19/17
 */
public class UsuariosActivosDTO implements Serializable {
    private static final long serialVersionUID = -8049793457119605049L;

    private Integer id_usuario;
    private String nombre;

    public UsuariosActivosDTO (){super();}

    public UsuariosActivosDTO(Integer id_usuario, String nombre) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
