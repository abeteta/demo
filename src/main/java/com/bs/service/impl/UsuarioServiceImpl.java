package com.bs.service.impl;


import com.bo.Usuarios;
import com.bs.service.UsuarioService;
import com.dto.EmailPasswordDTO;
import com.dto.UsuarioDTO;
import com.dto.UsuarioPasswordDTO;
import com.dto.UsuarioRegistradoDTO;
import com.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.print.DocFlavor;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/3/17
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        Assert.notNull(usuarioRepository, "usuarioRepository no debe ser null");
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public UsuarioDTO findUsuario(UsuarioDTO request) {

        UsuarioDTO response = new UsuarioDTO();
        Usuarios usuario  = usuarioRepository.findOne(request.getId_user());

        response.setId_user(usuario.getId_user());
        response.setNombre(usuario.getNombre());
        response.setApellido(usuario.getApellido());
        response.setEmail(usuario.getEmail());
        response.setId_usertype(usuario.getId_usertype());
        return response;
    }

    @Transactional
    public UsuarioRegistradoDTO usuarioRegistrado(UsuarioPasswordDTO usuarioPasswordDTO) {

        UsuarioRegistradoDTO response = new UsuarioRegistradoDTO();
        String email = usuarioPasswordDTO.getEmail();
        String password = usuarioPasswordDTO.getPassword();

        Integer idUsuario = usuarioRepository.findIdUsuario(email, password);
        Boolean existeUsuario = (idUsuario!=null) ? true : false;

        response.setUsuarioRegistrado(existeUsuario);
        response.setIdUsuario(idUsuario);

        return response;
    }

    @Override
    public Usuarios findOne(Integer id_user) {
        return usuarioRepository.findOne(id_user);
    }
}
