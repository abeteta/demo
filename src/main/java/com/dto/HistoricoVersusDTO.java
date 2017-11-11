package com.dto;

import com.bo.HistoricoVersus;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/6/17
 */
public class HistoricoVersusDTO implements Serializable {

    private static final long serialVersionUID = 2332449335444519809L;
    private Integer id_versus;
    private Integer id_jugador_primario;
    private Integer id_jugador_secundario;
    private Date fecha_versus;

    public HistoricoVersusDTO () {super();}

    public HistoricoVersusDTO(HistoricoVersus historicoVersus){
        super();
        this.id_versus = historicoVersus.getId_versus();
        this.id_jugador_primario = historicoVersus.getId_jugador_primario();
        this.id_jugador_secundario = historicoVersus.getId_jugador_secundario();
        this.fecha_versus = historicoVersus.getFecha_versus();
    }

    public HistoricoVersusDTO(Integer id_versus, Integer id_jugador_primario, Integer id_jugador_secundario, Date fecha_versus) {
        this.id_versus = id_versus;
        this.id_jugador_primario = id_jugador_primario;
        this.id_jugador_secundario = id_jugador_secundario;
        this.fecha_versus = fecha_versus;
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

    public Integer getId_jugador_secundario() {
        return id_jugador_secundario;
    }

    public void setId_jugador_secundario(Integer id_jugador_secundario) {
        this.id_jugador_secundario = id_jugador_secundario;
    }

    public Date getFecha_versus() {
        return fecha_versus;
    }

    public void setFecha_versus(Date fecha_versus) {
        this.fecha_versus = fecha_versus;
    }
}
