package com.bo;

import com.bo.Identifire.IdRespuesta;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/29/17
 */
@Entity
@Table(name="tb_respuesta")
public class Respuestas {

    @EmbeddedId
    private IdRespuesta idRespuesta;

    private String desc_respuesta;

    public Respuestas () {super();}

    public Respuestas(IdRespuesta idRespuesta, String desc_respuesta) {
        this.idRespuesta = idRespuesta;
        this.desc_respuesta = desc_respuesta;
    }

    public IdRespuesta getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(IdRespuesta idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getDesc_respuesta() {
        return desc_respuesta;
    }

    public void setDesc_respuesta(String desc_respuesta) {
        this.desc_respuesta = desc_respuesta;
    }

    @Override
    public String toString() {
        return "Respuestas{" +
                "idRespuesta=" + idRespuesta +
                ", desc_respuesta='" + desc_respuesta + '\'' +
                '}';
    }
}
