package com.dto;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/7/17
 */
public class RespuestaResponseDTO implements Serializable {
    private static final long serialVersionUID = -3270584575205253127L;

    private Integer id_versus;
    private Integer id_jugador;
    private Integer id_curso;
    private Integer id_pregunta;
    private Integer id_respuesta;
    private Boolean resultado_respuesta;

    public RespuestaResponseDTO () {super();}

    public RespuestaResponseDTO(Integer id_versus, Integer id_jugador, Integer id_curso, Integer id_pregunta, Integer id_respuesta, Boolean resultado_respuesta) {
        this.id_versus = id_versus;
        this.id_jugador = id_jugador;
        this.id_curso = id_curso;
        this.id_pregunta = id_pregunta;
        this.id_respuesta = id_respuesta;
        this.resultado_respuesta = resultado_respuesta;
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

    public Boolean getResultado_respuesta() {
        return resultado_respuesta;
    }

    public void setResultado_respuesta(Boolean resultado_respuesta) {
        this.resultado_respuesta = resultado_respuesta;
    }
}
