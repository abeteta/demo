package com.example;

import com.Application;
import com.bo.Pregunta;
import com.bo.Respuestas;
import com.bs.service.PreguntasService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/29/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PreguntasTest {

    @Autowired
    private PreguntasService preguntasService;

    @Test
    public void findPreguntas() {
        List<Integer> idCursos = Arrays.asList(1,2);
        List<Pregunta> listadoPreguntas = preguntasService.findPreguntas(idCursos);
        for (Pregunta pregunta: listadoPreguntas) {
            List<Respuestas> respuestas = pregunta.getRespuestas();
            System.out.println("Respuesta " + respuestas);
        }
        assertNotNull(listadoPreguntas);
    }
}
