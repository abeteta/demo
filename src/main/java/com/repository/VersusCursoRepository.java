package com.repository;


import com.bo.VersusCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
public interface VersusCursoRepository extends JpaRepository<VersusCurso, Integer> {

    @Query("SELECT V.idVersusCursos.id_curso FROM VersusCurso V WHERE V.idVersusCursos.id_versus =:idVersus")
    List<Integer> buscaCursosVersus(@Param("idVersus") Integer idVersus);
}
