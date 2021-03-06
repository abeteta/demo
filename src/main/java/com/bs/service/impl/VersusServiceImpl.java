package com.bs.service.impl;

import com.bo.Usuarios;
import com.bo.Versus;
import com.bs.service.VersusService;
import com.dto.EsperandoOponenteDTO;
import com.dto.UsuarioDTO;
import com.dto.VersusCursosDTO;
import com.dto.VersusDTO;
import com.repository.UsuarioRepository;
import com.repository.VersusCursoRepository;
import com.repository.VersusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/4/17
 */
@Service
public class VersusServiceImpl implements VersusService {
    private VersusRepository versusRepository;
    private UsuarioRepository usuarioRepository;
    private VersusCursoRepository versusCursoRepository;

    @Autowired
    public VersusServiceImpl(VersusRepository versusRepository,
                             UsuarioRepository usuarioRepository,
                             VersusCursoRepository versusCursoRepository) {
        Assert.notNull(versusRepository, "versusRepository no debe ser null");
        Assert.notNull(usuarioRepository, "UsuarioRepository no debe ser null");
        Assert.notNull(versusCursoRepository, "versusCursoRepository no debe ser null");
        this.versusRepository = versusRepository;
        this.usuarioRepository = usuarioRepository;
        this.versusCursoRepository = versusCursoRepository;
    }

    @Transactional
    public VersusDTO grabaQuiz(VersusDTO request) {

        VersusDTO response = new VersusDTO();
        Versus newVersus = new Versus();
        Versus actualVersus = new Versus();

        try {
                newVersus.setId_jugador_primario(request.getId_jugador_primario());
                newVersus.setTurno_jugador_primario(true);
                newVersus.setId_jugador_secundario(request.getId_jugador_secundario());
                newVersus.setTurno_jugador_secundario(false);
                newVersus.setEstado_versus(1);
                versusRepository.saveAndFlush(newVersus);
                response = new VersusDTO(newVersus);
          

        } catch (NullPointerException npe) {
        }

        return response;
    }

    @Transactional
    public VersusDTO buscarQuiz(VersusDTO request) {

        VersusDTO response = new VersusDTO();
        Versus newVersus = new Versus();
        Versus actualVersus = new Versus();

        try {
            Integer idVersus  = versusRepository.findQuizActivo(request.getEstado_versus());

            // Crea nuevo quiz
            if(idVersus==null){
                newVersus.setId_jugador_primario(request.getId_jugador_primario());
                newVersus.setTurno_jugador_primario(true);
                newVersus.setId_jugador_secundario(0);
                newVersus.setTurno_jugador_secundario(false);
                newVersus.setEstado_versus(1);
                versusRepository.saveAndFlush(newVersus);
                response = new VersusDTO(newVersus);
            } else {
                actualVersus = versusRepository.findOne(idVersus);
                actualVersus.setId_jugador_secundario(request.getId_jugador_primario());
                actualVersus.setEstado_versus(2);
                versusRepository.saveAndFlush(actualVersus);
                response = new VersusDTO(actualVersus);
            }

        } catch (NullPointerException npe) {
        }

        return response;
    }

    @Transactional
    public Integer buscaOponente(VersusDTO request) {

        Integer idJugadorOponente = 0;
        try {
            idJugadorOponente  = versusRepository.findOponente(request.getId_versus(), request.getId_jugador_primario());

        } catch (NullPointerException npe) {
        }
        return idJugadorOponente;
    }


    @Transactional
    public Boolean buscarTurnoPrimerJugador(VersusDTO request) {

        Boolean turnoPrimerJugador = null;
        try {
            turnoPrimerJugador  = versusRepository.findTurnoPrimerJugador(request.getId_versus(),
                                                                        request.getId_jugador_primario());

        } catch (NullPointerException npe) {
        }
        return turnoPrimerJugador;
    }

    @Transactional
    public Boolean buscarTurnoSegundoJugador(VersusDTO request) {

        Boolean turnoSegundoJugador = null;
        try {
            turnoSegundoJugador  = versusRepository.findTurnoSegundoJugador(request.getId_versus(),
                    request.getId_jugador_secundario());

        } catch (NullPointerException npe) {
        }
        return turnoSegundoJugador;
    }

    @Transactional
    public Boolean cambioDeTurno(VersusDTO request) {

        Boolean cambioTurno = null;
        Integer idVersus = request.getId_versus();
        Versus versus = new Versus();
        try {
            versus = versusRepository.findOne(idVersus);

            if(null!=versus){
                if(versus.isTurno_jugador_primario()==true){
                    versus.setTurno_jugador_primario(false);
                    versus.setTurno_jugador_secundario(true);
                } else {
                    versus.setTurno_jugador_primario(true);
                    versus.setTurno_jugador_secundario(false);
                }
                versusRepository.saveAndFlush(versus);
                cambioTurno = true;

            }  else {
                cambioTurno = false;
            }

        } catch (NullPointerException npe) {
        }
        return cambioTurno;
    }

    @Transactional
    public Boolean finalizaQuiz(Integer idVersus) {

        Boolean finQuiz = null;
        Versus versus = new Versus();
        try {
            versus = versusRepository.findOne(idVersus);
            // Estado 3 = quiz Finalizado
            if(null!=versus){
                versus.setEstado_versus(3);
                versusRepository.saveAndFlush(versus);
                finQuiz = true;

            }  else {
                finQuiz = false;
            }

        } catch (NullPointerException npe) {
        }
        return finQuiz;
    }

    @Transactional
    public List<VersusCursosDTO> esperandoOponente(EsperandoOponenteDTO request) {

        List<VersusCursosDTO> listadoVersusCurso = new ArrayList<>();
        List<Integer> listadoCursosVersus = new ArrayList<Integer>();
        Versus versus = new Versus();
        try {
            Integer estado = request.getEstado_versus();
            Integer idJugadorSecundario = request.getId_jugador_secundario();
            Integer idVersus = versusRepository.esperandoOponente(estado, idJugadorSecundario);

            if(null!=idVersus){
                versus = versusRepository.findOne(idVersus);
                if(!versus.equals(null)){
                    versus.setEstado_versus(2);
                    versusRepository.saveAndFlush(versus);

                    Usuarios segundoJugador = usuarioRepository.findOne(idJugadorSecundario);
                    if(!segundoJugador.equals(null)){
                        segundoJugador.setEstado(2);
                        usuarioRepository.saveAndFlush(segundoJugador);

                        listadoCursosVersus = versusCursoRepository.buscaCursosVersus(idVersus);

                        if(listadoCursosVersus.size()>0) {
                            for (Integer i = 0 ; i<listadoCursosVersus.size() ; i++){
                                VersusCursosDTO versusCursosDTO = new VersusCursosDTO();
                                versusCursosDTO.setId_versus(idVersus);
                                versusCursosDTO.setId_curso(listadoCursosVersus.get(i));
                                listadoVersusCurso.add(versusCursosDTO);
                            }
                        }

                    }

                }

            }

        } catch (NullPointerException npe) {
        }
        return listadoVersusCurso;
    }

}
