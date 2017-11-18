package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
public class CursoDTO implements Serializable {

    private static final long serialVersionUID = 5917846600988884046L;

    private Integer id_curso;
    private String desc_curso;

    public CursoDTO () {super();}

    public CursoDTO(Integer id_curso, String desc_curso) {
        this.id_curso = id_curso;
        this.desc_curso = desc_curso;
    }

    public Integer getId_curso() {
        return id_curso;
    }

    public void setId_curso(Integer id_curso) {
        this.id_curso = id_curso;
    }

    public String getDesc_curso() {
        return desc_curso;
    }

    public void setDesc_curso(String desc_curso) {
        this.desc_curso = desc_curso;
    }
}
