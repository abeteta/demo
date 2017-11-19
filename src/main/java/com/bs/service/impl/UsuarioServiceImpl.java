package com.bs.service.impl;


import com.bo.Usuarios;
import com.bs.service.UsuarioService;
import com.dto.*;
import com.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

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
    public PerfilDTO findUsuario(UsuarioDTO request) {

        PerfilDTO response = new PerfilDTO();
        Usuarios usuario  = usuarioRepository.findOne(request.getId_user());

        response.setId_user(usuario.getId_user());
        response.setNombre(usuario.getNombre());
        response.setApellido(usuario.getApellido());
        response.setEmail(usuario.getEmail());
        response.setDesc_usertype("Jugador");
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

    @Transactional
    public Boolean cambiaEstadoUsuario(CambioEstadoUsuarioDTO request) {

        Boolean response = false;
        Usuarios usuario  = usuarioRepository.findOne(request.getId_usuario());
        if(!usuario.equals(null)){
            if(usuario.getEstado().equals(1)){
                usuario.setEstado(0);
            }  else {
                usuario.setEstado(1);
            }
            usuarioRepository.saveAndFlush(usuario);
            response = true;
        }
        return response;
    }

    @Transactional
    public List<UsuariosActivosDTO> listadoUsuariosActivos(EstadoUsuarioDTO request) {

        List<UsuariosActivosDTO> response = new ArrayList<UsuariosActivosDTO>();
        List<Integer> listids = usuarioRepository.usuariosActivos(request.getEstado());

        for(Integer list: listids){
            UsuariosActivosDTO usuariosActivosDTO = new UsuariosActivosDTO();
            Usuarios usuario = usuarioRepository.findOne(list.intValue());
            if(!usuario.equals(null)){
                usuariosActivosDTO.setId_usuario(usuario.getId_user());
                usuariosActivosDTO.setNombre(usuario.getNombre());
                response.add(usuariosActivosDTO);
            }
        }

        return response;
    }

    @Override
    public Usuarios findOne(Integer id_user) {
        return usuarioRepository.findOne(id_user);
    }
}
