package com.bs.service.impl;


import com.bo.Usuarios;
import com.bs.service.UsuarioService;
import com.dto.EmailPasswordDTO;
import com.dto.UsuarioDTO;
import com.repository.UsuarioRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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
    public Boolean usuarioRegistrado(String email, String password) {

        Integer idUsuario = usuarioRepository.findIdUsuario(email, password);
        Boolean existeUsuario = (idUsuario!=null) ? true : false;

        return existeUsuario;
    }

    @Transactional
    public Integer findIdUsuario(String email, String password) {

        Integer idUsuario = usuarioRepository.findIdUsuario(email, password);

        return idUsuario = (idUsuario!=null) ? idUsuario : 0;
    }

    @Override
    public Usuarios findOne(Integer id_user) {
        return usuarioRepository.findOne(id_user);
    }
}
