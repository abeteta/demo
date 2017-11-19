package com.example;

import com.Application;
import com.bo.Usuarios;
import com.bs.service.UsuarioService;
import com.dto.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

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
        PerfilDTO response = new PerfilDTO();
        request.setId_user(7);
        response = usuarioService.findUsuario(request);
        assertNotNull(response);
    }

    @Test
    public void usuarioRegistrado() {
        UsuarioPasswordDTO usuarioPasswordDTO = new UsuarioPasswordDTO();
        usuarioPasswordDTO.setEmail("alex@prueba.com");
        usuarioPasswordDTO.setPassword("123");
        UsuarioRegistradoDTO existeUsuario = usuarioService.usuarioRegistrado(usuarioPasswordDTO);
        assertNotNull(existeUsuario);
    }

    @Test
    public void cambioEstadoUsuario() {
        CambioEstadoUsuarioDTO request = new CambioEstadoUsuarioDTO();
        request.setId_usuario(7);
        Boolean cambio = usuarioService.cambiaEstadoUsuario(request);
        assertNotNull(cambio);
    }

    @Test
    public void listaUsuariosActivos() {

        EstadoUsuarioDTO request = new EstadoUsuarioDTO();
        request.setEstado(1);
        List<UsuariosActivosDTO> response = usuarioService.listadoUsuariosActivos(request);
        assertNotNull(response);
    }


}
