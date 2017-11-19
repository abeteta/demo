package com.bs.controller;


import com.bo.Pregunta;
import com.bo.Usuarios;
import com.bs.service.UsuarioService;
import com.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/3/17
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        Assert.notNull(usuarioService, "usuarioService no debe ser null");
        this.usuarioService = usuarioService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/datosUsuario")
    public ResponseEntity<PerfilDTO> informacionUsuario(@RequestBody UsuarioDTO request) {
        return new ResponseEntity<>(usuarioService.findUsuario(request), HttpStatus.OK);
    }

/*        @RequestMapping(method = RequestMethod.GET, value = "/idUsuario")
    public ResponseEntity<Integer> findOne(@PathVariable("email") String email) {
        return new ResponseEntity<>(usuarioService.findIdUsuario(email), HttpStatus.OK);
    }*/

    @RequestMapping(method = RequestMethod.POST, value = "/usuarioRegistrado")
    public ResponseEntity<UsuarioRegistradoDTO> usuarioRegistrado(@RequestBody UsuarioPasswordDTO usuarioPasswordDTO) {
        return new ResponseEntity<>(usuarioService.usuarioRegistrado(usuarioPasswordDTO), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cambioEstado")
    public ResponseEntity<Boolean> cambioEstadoUsuario(@RequestBody CambioEstadoUsuarioDTO cambioEstadoUsuarioDTO) {
        return new ResponseEntity<>(usuarioService.cambiaEstadoUsuario(cambioEstadoUsuarioDTO), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/listadoUsuariosActivos")
    public ResponseEntity<List<UsuariosActivosDTO>> cambioEstadoUsuario(@RequestBody EstadoUsuarioDTO estadoUsuarioDTO) {
        return new ResponseEntity<>(usuarioService.listadoUsuariosActivos(estadoUsuarioDTO), HttpStatus.OK);
    }


}
