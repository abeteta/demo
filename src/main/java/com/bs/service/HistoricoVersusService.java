package com.bs.service;

import com.bo.HistoricoVersus;
import com.dto.RespuestaRequestDTO;
import com.dto.RespuestaResponseDTO;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/6/17
 */
public interface HistoricoVersusService {
    HistoricoVersus findOne(Integer id_versus);
    RespuestaResponseDTO grabaRespuesta(RespuestaRequestDTO requestDTO);

}
