package com.bo.Identifire;

import org.springframework.stereotype.Controller;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/28/17
 */
@Embeddable
public class IdPregunta implements Serializable{

    private static final long serialVersionUID = -3063846296901898113L;
    private Integer id_curso;
    private Integer id_pregunta;

    public IdPregunta () {super();}

    public IdPregunta(Integer id_curso, Integer id_pregunta) {
        this.id_curso = id_curso;
        this.id_pregunta = id_pregunta;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public Integer getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(Integer id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

}
