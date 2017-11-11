package com.bo.Identifire;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/29/17
 */
public class IdRespuesta implements Serializable{


    private static final long serialVersionUID = -4321574495095832212L;
    private IdPregunta idPregunta;

    private Integer id_respuesta;

    public IdRespuesta () {super();}

    public IdRespuesta(IdPregunta idPregunta, Integer id_respuesta) {
        this.idPregunta = idPregunta;
        this.id_respuesta = id_respuesta;
    }

    public IdPregunta getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(IdPregunta idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Integer getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(Integer id_respuesta) {
        this.id_respuesta = id_respuesta;
    }

    @Override
    public String toString() {
        return "IdRespuesta{" +
                "idPregunta=" + idPregunta +
                ", id_respuesta=" + id_respuesta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdRespuesta that = (IdRespuesta) o;

        if (idPregunta != null ? !idPregunta.equals(that.idPregunta) : that.idPregunta != null) return false;
        return id_respuesta != null ? id_respuesta.equals(that.id_respuesta) : that.id_respuesta == null;
    }

    @Override
    public int hashCode() {
        int result = idPregunta != null ? idPregunta.hashCode() : 0;
        result = 31 * result + (id_respuesta != null ? id_respuesta.hashCode() : 0);
        return result;
    }
}
