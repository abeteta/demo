package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
public class VersusCursosDTO implements Serializable {
    private static final long serialVersionUID = -3859609012575568185L;

    private Integer id_versus;
    private Integer id_curso;

    public VersusCursosDTO () {super();}

    public VersusCursosDTO(Integer id_versus, Integer id_curso) {
        this.id_versus = id_versus;
        this.id_curso = id_curso;
    }

    public Integer getId_versus() {
        return id_versus;
    }

    public void setId_versus(Integer id_versus) {
        this.id_versus = id_versus;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }
}
