package com.bs.service;

import com.bo.Usuarios;
import com.dto.UsuarioDTO;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/3/17
 */
public interface UsuarioService {
    Usuarios findOne(Integer id_user);
    UsuarioDTO findUsuario(UsuarioDTO usuario);
    Boolean usuarioRegistrado(String email, String password);
    Integer findIdUsuario(String email, String password);
}
