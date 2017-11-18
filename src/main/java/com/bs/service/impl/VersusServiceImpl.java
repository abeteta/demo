package com.bs.service.impl;

import com.bo.Usuarios;
import com.bo.Versus;
import com.bs.service.VersusService;
import com.dto.UsuarioDTO;
import com.dto.VersusDTO;
import com.repository.UsuarioRepository;
import com.repository.VersusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/4/17
 */
@Service
public class VersusServiceImpl implements VersusService {
    private VersusRepository versusRepository;

    @Autowired
    public VersusServiceImpl(VersusRepository versusRepository) {
        Assert.notNull(versusRepository, "versusRepository no debe ser null");
        this.versusRepository = versusRepository;
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

}
