package com.example;

import com.Application;
import com.bo.HistoricoVersus;
import com.bo.HistoricoVersusDetalle;
import com.bs.service.HistoricoVersusService;
import com.dto.RespuestaRequestDTO;
import com.dto.RespuestaResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/10/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GrabaRespuestasTest {

    @Autowired
    private HistoricoVersusService historicoVersusService;

    @Test
    public void grabaRespuesta() {
        RespuestaRequestDTO request = new RespuestaRequestDTO();
        RespuestaResponseDTO response = new RespuestaResponseDTO();
        request.setId_versus(5);
        request.setId_jugador(7);
        request.setId_curso(1);
        request.setId_pregunta(1);
        request.setId_respuesta(3);
        response = historicoVersusService.grabaRespuesta(request);
        assertNotNull(response);
    }

}
