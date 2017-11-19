package com.bs.service;

import com.dto.VersusCursosDTO;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
public interface VersusCursosService {
    Boolean grabaVersusCursos(List<VersusCursosDTO> versusCursosDTO);
}
