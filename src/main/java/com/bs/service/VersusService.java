package com.bs.service;

import com.dto.VersusDTO;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/4/17
 */
public interface VersusService {
    VersusDTO buscarQuiz(VersusDTO versus);
    Integer buscaOponente(VersusDTO versus);
    Boolean buscarTurnoPrimerJugador(VersusDTO versus);
    Boolean buscarTurnoSegundoJugador(VersusDTO versus);
    Boolean cambioDeTurno(VersusDTO versus);
    Boolean finalizaQuiz(Integer idVersus);
}
