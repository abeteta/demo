package com.repository;

import com.bo.Identifire.IdPregunta;
import com.bo.Trespuesta;
import org.hibernate.boot.model.source.spi.JpaCallbackSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/7/17
 */
public interface TrespuestaRepository extends JpaRepository<Trespuesta, IdPregunta> {

    @Query("SELECT R.indicador_respuesta FROM Trespuesta R WHERE R.idRespuesta.idPregunta.id_curso =:id_curso " +
                            "AND R.idRespuesta.idPregunta.id_pregunta =:id_pregunta AND R.idRespuesta.id_respuesta =:id_respuesta")
    Integer findIndicadorRespuesta(@Param("id_curso") Integer id_curso,
                                   @Param("id_pregunta") Integer id_pregunta,
                                    @Param("id_respuesta")Integer id_respuesta);

    @Query("SELECT R.idRespuesta.id_respuesta FROM Trespuesta R WHERE R.idRespuesta.idPregunta.id_curso =:id_curso " +
            "AND R.idRespuesta.idPregunta.id_pregunta =:id_pregunta AND R.indicador_respuesta =:indicador_respuesta")
    Integer findRespuestaCorrecta(@Param("id_curso") Integer id_curso,
                                   @Param("id_pregunta") Integer id_pregunta,
                                   @Param("indicador_respuesta")Integer indicador_respuesta);
}
