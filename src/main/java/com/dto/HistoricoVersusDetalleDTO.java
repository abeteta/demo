package com.dto;

import com.bo.HistoricoVersusDetalle;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/6/17
 */
public class HistoricoVersusDetalleDTO implements Serializable {
    private static final long serialVersionUID = 7042474010119512859L;

    private Integer id_versus;
    private Integer id_jugador;
    private Integer id_curso;
    private Integer id_pregunta;
    private Integer id_respuesta;
    private Integer id_respuesta_correcta;
    private Integer punteo;

    public HistoricoVersusDetalleDTO () {super();}

    public HistoricoVersusDetalleDTO (HistoricoVersusDetalle historicoVersusDetalle){
        this.id_versus = historicoVersusDetalle.getIdHistoricoVersusDetalle().getId_versus();
        this.id_jugador = historicoVersusDetalle.getIdHistoricoVersusDetalle().getId_jugador();
        this.id_curso = historicoVersusDetalle.getIdHistoricoVersusDetalle().getId_curso();
        this.id_pregunta = historicoVersusDetalle.getIdHistoricoVersusDetalle().getId_pregunta();
        this.id_respuesta = historicoVersusDetalle.getIdHistoricoVersusDetalle().getId_respuesta();
        this.id_respuesta_correcta = historicoVersusDetalle.getId_respuesta_correcta();
        this.punteo = historicoVersusDetalle.getPunteo();
    }

    public HistoricoVersusDetalleDTO(Integer id_versus, Integer id_jugador, Integer id_curso, Integer id_pregunta, Integer id_respuesta, Integer id_respuesta_correcta, Integer punteo) {
        this.id_versus = id_versus;
        this.id_jugador = id_jugador;
        this.id_curso = id_curso;
        this.id_pregunta = id_pregunta;
        this.id_respuesta = id_respuesta;
        this.id_respuesta_correcta = id_respuesta_correcta;
        this.punteo = punteo;
    }

    public Integer getId_versus() {
        return id_versus;
    }

    public void setId_versus(Integer id_versus) {
        this.id_versus = id_versus;
    }

    public Integer getId_jugador() {
        return id_jugador;
    }

    public void setId_jugador(Integer id_jugador) {
        this.id_jugador = id_jugador;
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

    public Integer getId_respuesta() {
        return id_respuesta;
    }

    public void setId_respuesta(Integer id_respuesta) {
        this.id_respuesta = id_respuesta;
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
