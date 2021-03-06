package com.bs.service;

import com.dto.EsperandoOponenteDTO;
import com.dto.VersusCursosDTO;
import com.dto.VersusDTO;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/4/17
 */
public interface VersusService {
    VersusDTO grabaQuiz(VersusDTO versus);
    VersusDTO buscarQuiz(VersusDTO versus);
    Integer buscaOponente(VersusDTO versus);
    Boolean buscarTurnoPrimerJugador(VersusDTO versus);
    Boolean buscarTurnoSegundoJugador(VersusDTO versus);
    Boolean cambioDeTurno(VersusDTO versus);
    Boolean finalizaQuiz(Integer idVersus);
    List<VersusCursosDTO> esperandoOponente(EsperandoOponenteDTO oponenteDTO);
}
