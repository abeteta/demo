package com.bo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/6/17
 */
@Entity
@Table(name="tb_historial_versus")
public class HistoricoVersus implements Serializable {
    private static final long serialVersionUID = 4019092077620579120L;

    @Id
    private Integer id_versus;

    private Integer id_jugador_primario;
    private Integer id_jugador_secundario;
    private Date fecha_versus;

    public HistoricoVersus () {super();}

    public HistoricoVersus(Integer id_jugador_primario, Integer id_jugador_secundario, Date fecha_versus) {
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
