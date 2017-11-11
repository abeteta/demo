package com.example;

import com.Application;
import com.bo.Usuarios;
import com.bs.service.UsuarioService;
import com.dto.UsuarioDTO;
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
 * created on 11/3/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UsuarioTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void findUsuario() {
        UsuarioDTO request = new UsuarioDTO();
        UsuarioDTO response = new UsuarioDTO();
        request.setId_user(7);
        response = usuarioService.findUsuario(request);
        assertNotNull(response);
    }

    @Test
    public void usuarioRegistrado() {
        String email = "alex@prueba.com";
        String password = "123";
        Boolean existeUsuario = usuarioService.usuarioRegistrado(email,password);
        assertNotNull(existeUsuario);
    }

    @Test
    public void findIdUsuario() {
        String email = "alex@prueba.com";
        String password = "123";
        Integer idUsuario = usuarioService.findIdUsuario(email,password);
        assertNotNull(idUsuario);
    }
}
