package com.repository;

import com.bo.HistoricoVersusDetalle;
import com.bo.Identifire.IdHistoricoVersusDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/6/17
 */
public interface HistoricoVersusDetalleRepository extends JpaRepository<HistoricoVersusDetalle, IdHistoricoVersusDetalle> {
}
