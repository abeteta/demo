package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
public class DificultadDTO implements Serializable {
    private static final long serialVersionUID = 2798736239598990483L;

    private Integer id_dificultad;
    private String  desc_dificultad;
    private Integer punteo;

    public DificultadDTO (){super();}

    public DificultadDTO(Integer id_dificultad, String desc_dificultad, Integer punteo) {
        this.id_dificultad = id_dificultad;
        this.desc_dificultad = desc_dificultad;
        this.punteo = punteo;
    }

    public Integer getId_dificultad() {
        return id_dificultad;
    }

    public void setId_dificultad(Integer id_dificultad) {
        this.id_dificultad = id_dificultad;
    }

    public String getDesc_dificultad() {
        return desc_dificultad;
    }

    public void setDesc_dificultad(String desc_dificultad) {
        this.desc_dificultad = desc_dificultad;
    }

    public Integer getPunteo() {
        return punteo;
    }

    public void setPunteo(Integer punteo) {
        this.punteo = punteo;
    }
}
