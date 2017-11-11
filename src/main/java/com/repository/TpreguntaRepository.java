package com.repository;

import com.bo.Identifire.IdPregunta;
import com.bo.Tpregunta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/7/17
 */
public interface TpreguntaRepository extends JpaRepository<Tpregunta, IdPregunta> {
}
