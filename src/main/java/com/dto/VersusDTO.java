package com.dto;

import com.bo.Versus;

import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/4/17
 */
public class VersusDTO implements Serializable {
    private static final long serialVersionUID = 6832630032503782975L;

    private Integer id_versus;
    private Integer id_jugador_primario;
    private boolean turno_jugador_primario;
    private Integer id_jugador_secundario;
    private boolean turno_jugador_secundario;
    private Integer estado_versus;

    public VersusDTO () {super();}

    public VersusDTO (Versus versus){
        super();
        this.id_versus = versus.getId_versus();
        this.id_jugador_primario = versus.getId_jugador_primario();
        this.turno_jugador_primario = versus.isTurno_jugador_primario();
        this.id_jugador_secundario = versus.getId_jugador_secundario();
        this.turno_jugador_secundario = versus.isTurno_jugador_secundario();
        this.estado_versus = versus.getEstado_versus();
    }

    public VersusDTO(Integer id_versus, Integer id_jugador_primario, boolean turno_jugador_primario, Integer id_jugador_secundario, boolean turno_jugador_secundario, Integer estado_versus) {
        this.id_versus = id_versus;
        this.id_jugador_primario = id_jugador_primario;
        this.turno_jugador_primario = turno_jugador_primario;
        this.id_jugador_secundario = id_jugador_secundario;
        this.turno_jugador_secundario = turno_jugador_secundario;
        this.estado_versus = estado_versus;
    }

    public Integer getId_versus() {
        return id_versus;
    }

    public void setId_versus(Integer id_versus) {
        this.id_versus = id_versus;
    }

    public Integer getId_jugador_primario() {
        return id_jugador_primario;
    }

    public void setId_jugador_primario(Integer id_jugador_primario) {
        this.id_jugador_primario = id_jugador_primario;
    }

    public boolean isTurno_jugador_primario() {
        return turno_jugador_primario;
    }

    public void setTurno_jugador_primario(boolean turno_jugador_primario) {
        this.turno_jugador_primario = turno_jugador_primario;
    }

    public Integer getId_jugador_secundario() {
        return id_jugador_secundario;
    }

    public void setId_jugador_secundario(Integer id_jugador_secundario) {
        this.id_jugador_secundario = id_jugador_secundario;
    }

    public boolean isTurno_jugador_secundario() {
        return turno_jugador_secundario;
    }

    public void setTurno_jugador_secundario(boolean turno_jugador_secundario) {
        this.turno_jugador_secundario = turno_jugador_secundario;
    }

    public Integer getEstado_versus() {
        return estado_versus;
    }

    public void setEstado_versus(Integer estado_versus) {
        this.estado_versus = estado_versus;
    }
}
