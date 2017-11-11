package com.repository;

import com.bo.Identifire.IdPregunta;
import com.bo.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/25/17
 */
public interface ListadoPreguntasRepository extends JpaRepository<Pregunta, IdPregunta> {

    @Query("FROM Pregunta P WHERE P.id.id_curso IN :idCursos ")
            //+             "ORDER BY RAND () LIMIT 10")
    List<Pregunta> findPreguntas(@Param("idCursos") List<Integer> idCursos);
}
                                                                         