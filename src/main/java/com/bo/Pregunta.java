package com.bo;

import com.bo.Identifire.IdPregunta;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/28/17
 */
@Entity
@Table(name="tb_pregunta")
public class Pregunta {

    @EmbeddedId
    private IdPregunta id;

    private String desc_pregunta;

    public Pregunta () {super();}

    @OneToMany(targetEntity = Respuestas.class, fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(name = "id_curso", referencedColumnName ="id_curso", insertable = false, updatable = false),
            @JoinColumn(name = "id_pregunta", referencedColumnName ="id_pregunta", insertable = false, updatable = false)})
    private List<Respuestas> respuestas;

    public Pregunta(IdPregunta id, String desc_pregunta, List<Respuestas> respuestas) {
        this.id = id;
        this.desc_pregunta = desc_pregunta;
        this.respuestas = respuestas;
    }

    public IdPregunta getId() {
        return id;
    }

    public void setId(IdPregunta id) {
        this.id = id;
    }

    public String getDesc_pregunta() {
        return desc_pregunta;
    }

    public void setDesc_pregunta(String desc_pregunta) {
        this.desc_pregunta = desc_pregunta;
    }

    public List<Respuestas> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuestas> respuestas) {
        this.respuestas = respuestas;
    }
}
