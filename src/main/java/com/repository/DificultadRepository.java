package com.repository;

import com.bo.Dificultad;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/11/17
 */
public interface DificultadRepository extends JpaRepository<Dificultad, Integer> {
}
