package com.example;

import com.Application;
import com.bo.VersusCurso;
import com.bs.service.VersusCursosService;
import com.bs.service.VersusService;
import com.dto.VersusCursosDTO;
import com.dto.VersusDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class VersusCursosTest {

        @Autowired
        private VersusCursosService versusCursosService;

        @Test
        public void grabaVersusCursos() {
            List<VersusCursosDTO> request = new ArrayList<VersusCursosDTO>();
            VersusCursosDTO dato1 = new VersusCursosDTO() ;
            VersusCursosDTO dato2 = new VersusCursosDTO() ;
            dato1.setId_versus(29);
            dato1.setId_curso(1);
            dato2.setId_versus(29);
            dato2.setId_curso(2);
            request.add(dato1);
            request.add(dato2);
            Boolean response = false;
            response = versusCursosService.grabaVersusCursos(request);
            assertNotNull(response);
        }
}
