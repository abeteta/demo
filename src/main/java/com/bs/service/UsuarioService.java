package com.bs.service;

import com.bo.Usuarios;
import com.dto.*;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/3/17
 */
public interface UsuarioService {
    Usuarios findOne(Integer id_user);
    PerfilDTO findUsuario(UsuarioDTO usuario);
    UsuarioRegistradoDTO usuarioRegistrado(UsuarioPasswordDTO usuarioPasswordDTO);
    Boolean cambiaEstadoUsuario(CambioEstadoUsuarioDTO cambioEstadoUsuarioDTO);
    List<UsuariosActivosDTO> listadoUsuariosActivos(EstadoUsuarioDTO estadoUsuarioDTO);
}
