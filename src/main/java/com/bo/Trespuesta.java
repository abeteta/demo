package com.bo;

import com.bo.Identifire.IdRespuesta;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/7/17
 */
@Entity
@Table(name = "tb_respuesta")
public class Trespuesta implements Serializable {
    private static final long serialVersionUID = 6904466659496970403L;

    @EmbeddedId
    private IdRespuesta idRespuesta;
    private String desc_respuesta;
    private Integer indicador_respuesta;

    public Trespuesta ()  {super();}

    public Trespuesta(IdRespuesta idRespuesta, String desc_respuesta, Integer indicador_respuesta) {
        this.idRespuesta = idRespuesta;
        this.desc_respuesta = desc_respuesta;
        this.indicador_respuesta = indicador_respuesta;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getIndicador_respuesta() {
        return indicador_respuesta;
    }

    public void setIndicador_respuesta(Integer indicador_respuesta) {
        this.indicador_respuesta = indicador_respuesta;
    }
}
