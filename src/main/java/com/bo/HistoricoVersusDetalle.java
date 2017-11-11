package com.bo;

import com.bo.Identifire.IdHistoricoVersusDetalle;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/6/17
 */
@Entity
@Table(name="tb_historial_versus_detalle")
public class HistoricoVersusDetalle implements Serializable {
    private static final long serialVersionUID = 3267153147138439335L;

    @EmbeddedId
    private IdHistoricoVersusDetalle idHistoricoVersusDetalle;

    private Integer id_respuesta_correcta;
    private Integer punteo;

    public HistoricoVersusDetalle () {super();}

    public HistoricoVersusDetalle(IdHistoricoVersusDetalle idHistoricoVersusDetalle, Integer id_respuesta_correcta, Integer punteo) {
        this.idHistoricoVersusDetalle = idHistoricoVersusDetalle;
        this.id_respuesta_correcta = id_respuesta_correcta;
        this.punteo = punteo;
    }

    public IdHistoricoVersusDetalle getIdHistoricoVersusDetalle() {
        return idHistoricoVersusDetalle;
    }

    public void setIdHistoricoVersusDetalle(IdHistoricoVersusDetalle idHistoricoVersusDetalle) {
        this.idHistoricoVersusDetalle = idHistoricoVersusDetalle;
    }

    public Integer getId_respuesta_correcta() {
        return id_respuesta_correcta;
    }

    public void setId_respuesta_correcta(Integer id_respuesta_correcta) {
        this.id_respuesta_correcta = id_respuesta_correcta;
    }

    public Integer getPunteo() {
        return punteo;
    }

    public void setPunteo(Integer punteo) {
        this.punteo = punteo;
    }
}
