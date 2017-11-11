package com.bo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/21/17
 */
@Entity
@Table(name="tb_curso")

public class Curso implements Serializable {
    private static final long serialVersionUID = -30996952566684219L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_curso;

    private String desc_curso;
    private Integer id_area;

    public Curso (){super();}

    public Curso(String desc_curso, Integer id_area) {
        this.desc_curso = desc_curso;
        this.id_area = id_area;
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

    public Integer getId_area() {
        return id_area;
    }

    public void setId_area(Integer id_area) {
        this.id_area = id_area;
    }
}
