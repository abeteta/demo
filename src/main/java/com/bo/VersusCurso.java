package com.bo;

import com.bo.Identifire.IdVersusCursos;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
@Entity
@Table(name="tb_versus_cursos")
public class VersusCurso implements Serializable {

    private static final long serialVersionUID = 5709689275197308336L;

    @EmbeddedId
    private IdVersusCursos idVersusCursos;

    public VersusCurso (){super();}

    public VersusCurso(IdVersusCursos idVersusCursos) {
        this.idVersusCursos = idVersusCursos;
    }

    public IdVersusCursos getIdVersusCursos() {
        return idVersusCursos;
    }

    public void setIdVersusCursos(IdVersusCursos idVersusCursos) {
        this.idVersusCursos = idVersusCursos;
    }
}
