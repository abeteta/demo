package com.repository;

import com.bo.Versus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/4/17
 */
public interface VersusRepository extends JpaRepository<Versus, Integer> {

    @Query("SELECT V.id_versus FROM Versus  V WHERE V.estado_versus =:estadoVersus")
    Integer findQuizActivo(@Param("estadoVersus") Integer estadoVersus);

    @Query("SELECT V.id_jugador_secundario FROM Versus  V WHERE V.id_versus =:idVersus AND V.id_jugador_primario=:idPrimerJugador")
    Integer findOponente(@Param("idVersus") Integer idVersus,
                                    @Param("idPrimerJugador") Integer idPrimerJugador);

    @Query("SELECT V.turno_jugador_primario FROM Versus  V WHERE V.id_versus =:idVersus AND V.id_jugador_primario=:idPrimerJugador")
    Boolean findTurnoPrimerJugador(@Param("idVersus") Integer idVersus,
                                     @Param("idPrimerJugador") Integer idPrimerJugador);

    @Query("SELECT V.turno_jugador_secundario FROM Versus  V WHERE V.id_versus =:idVersus AND V.id_jugador_secundario=:idSegundoJugador")
    Boolean findTurnoSegundoJugador(@Param("idVersus") Integer idVersus,
                                 @Param("idSegundoJugador") Integer idSegundoJugador);

}
