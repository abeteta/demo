package com.bo;

import com.bo.Identifire.IdPregunta;
import org.springframework.transaction.annotation.Transactional;

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
@Table(name = "tb_pregunta")
public class Tpregunta implements Serializable {

    private static final long serialVersionUID = -6711688338787810549L;
    @EmbeddedId
    private IdPregunta idPregunta;
    private String desc_pregunta;
    private Integer id_dificultad;
    private Integer id_estadop;

    public Tpregunta () {super();}

    public Tpregunta(IdPregunta idPregunta, String desc_pregunta, Integer id_dificultad, Integer id_estadop) {
        this.idPregunta = idPregunta;
        this.desc_pregunta = desc_pregunta;
        this.id_dificultad = id_dificultad;
        this.id_estadop = id_estadop;
    }

    public IdPregunta getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(IdPregunta idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDesc_pregunta() {
        return desc_pregunta;
    }

    public void setDesc_pregunta(String desc_pregunta) {
        this.desc_pregunta = desc_pregunta;
    }

    public Integer getId_dificultad() {
        return id_dificultad;
    }

    public void setId_dificultad(Integer id_dificultad) {
        this.id_dificultad = id_dificultad;
    }

    public Integer getId_estadop() {
        return id_estadop;
    }

    public void setId_estadop(Integer id_estadop) {
        this.id_estadop = id_estadop;
    }
}
