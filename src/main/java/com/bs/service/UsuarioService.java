package com.bs.service;

import com.bo.Usuarios;
import com.dto.PerfilDTO;
import com.dto.UsuarioDTO;
import com.dto.UsuarioPasswordDTO;
import com.dto.UsuarioRegistradoDTO;

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
}
