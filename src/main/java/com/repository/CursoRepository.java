package com.repository;

import com.bo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/21/17
 */
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
