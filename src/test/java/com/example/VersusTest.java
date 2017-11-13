package com.example;

import com.Application;
import com.bs.service.VersusService;
import com.dto.VersusDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/5/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class VersusTest {
    @Autowired
    private VersusService versusService;

    @Test
    public void findQuiz() {
        VersusDTO request = new VersusDTO();
        VersusDTO response = new VersusDTO();
        request.setEstado_versus(1);
        request.setId_jugador_primario(8);
        response = versusService.buscarQuiz(request);
        assertNotNull(response);
    }

    @Test
    public void findOponente() {
        VersusDTO request = new VersusDTO();
        request.setId_versus(4);
        request.setId_jugador_primario(8);
        Integer idOponente = versusService.buscaOponente(request);
        assertNotNull(idOponente);
    }

    @Test
    public void findTurnoPrimerJugador() {
        VersusDTO request = new VersusDTO();
        request.setId_versus(4);
        request.setId_jugador_primario(8);
        Boolean esMiTurno = versusService.buscarTurnoPrimerJugador(request);
        assertNotNull(esMiTurno);
    }

    @Test
    public void findTurnoSegundoJugador() {
        VersusDTO request = new VersusDTO();
        request.setId_versus(4);
        request.setId_jugador_secundario(7);
        Boolean esMiTurno = versusService.buscarTurnoSegundoJugador(request);
        assertNotNull(esMiTurno);
    }

    @Test
    public void cambioDeTurno() {
        Integer idVersus =4;
        Boolean cambioDeTurno = versusService.cambioDeTurno(idVersus);
        assertNotNull(cambioDeTurno);
    }

    @Test
    public void finalizaQuiz() {
        Integer idVersus =4;
        Boolean finQuiz = versusService.finalizaQuiz(idVersus);
        assertNotNull(finQuiz);
    }
}
