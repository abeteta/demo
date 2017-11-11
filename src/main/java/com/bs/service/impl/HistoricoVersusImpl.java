package com.bs.service.impl;

import com.bo.*;
import com.bo.Identifire.IdHistoricoVersusDetalle;
import com.bo.Identifire.IdPregunta;
import com.bo.Identifire.IdRespuesta;
import com.bs.service.HistoricoVersusService;
import com.dto.RespuestaRequestDTO;
import com.dto.RespuestaResponseDTO;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Date;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/6/17
 */
@Service
public class HistoricoVersusImpl implements HistoricoVersusService {

    private VersusRepository versusRepository;
    private HistoricoVersusRepository historicoVersusRepository;
    private HistoricoVersusDetalleRepository historicoVersusDetalleRepository;
    private TrespuestaRepository trespuestaRepository;
    private TpreguntaRepository tpreguntaRepository;
    private DificultadRepository dificultadRepository;


    @Autowired
    public HistoricoVersusImpl(VersusRepository versusRepository,
                                HistoricoVersusRepository historicoVersusRepository,
                               HistoricoVersusDetalleRepository historicoVersusDetalleRepository,
                                TrespuestaRepository trespuestaRepository,
                                TpreguntaRepository tpreguntaRepository,
                               DificultadRepository dificultadRepository) {
        Assert.notNull(versusRepository, "versusRepository no debe ser null");
        Assert.notNull(historicoVersusRepository, "historicoVersusRepository no debe ser null");
        Assert.notNull(historicoVersusDetalleRepository, "historicoVersusDetalleRepository no debe ser null");
        Assert.notNull(trespuestaRepository, "trespuestaRepository no debe ser null");
        Assert.notNull(tpreguntaRepository, "tpreguntaRepository no debe ser null");
        Assert.notNull(dificultadRepository, "dificultadRepository no debe ser null");
        this.versusRepository = versusRepository;
        this.historicoVersusRepository = historicoVersusRepository;
        this.historicoVersusDetalleRepository = historicoVersusDetalleRepository;
        this.trespuestaRepository = trespuestaRepository;
        this.tpreguntaRepository = tpreguntaRepository;
        this.dificultadRepository = dificultadRepository;
    }

    @Transactional
    public RespuestaResponseDTO grabaRespuesta(RespuestaRequestDTO request){
        RespuestaResponseDTO response = new RespuestaResponseDTO();

        HistoricoVersus historicoVersus = historicoVersusRepository.findOne(request.getId_versus());
        HistoricoVersusDetalle historicoVersusDetalle = new HistoricoVersusDetalle();
        IdHistoricoVersusDetalle idHistoricoVersusDetalle = new IdHistoricoVersusDetalle();
        Boolean respuestaCorrecta = false;

        // Graba encabezado de historico de versus (si es la primera pregunta)

        if(historicoVersus==null) {
            historicoVersus = new HistoricoVersus();
            Versus versus = versusRepository.findOne(request.getId_versus());
            historicoVersus.setId_versus(versus.getId_versus());
            historicoVersus.setId_jugador_primario(versus.getId_jugador_primario());
            historicoVersus.setId_jugador_secundario(versus.getId_jugador_secundario());
            historicoVersus.setFecha_versus(new Date());
            historicoVersusRepository.saveAndFlush(historicoVersus);
        }

        // Si ya existe el encabezado de historico de versus graba le detalle

        if(!historicoVersus.equals(null)){
            idHistoricoVersusDetalle.setId_versus(request.getId_versus());
            idHistoricoVersusDetalle.setId_jugador(request.getId_jugador());
            idHistoricoVersusDetalle.setId_curso(request.getId_curso());
            idHistoricoVersusDetalle.setId_pregunta(request.getId_pregunta());
            idHistoricoVersusDetalle.setId_respuesta(request.getId_respuesta());
            historicoVersusDetalle.setIdHistoricoVersusDetalle(idHistoricoVersusDetalle);

            // busca indicador de respuesta (indicador = 1 es correcta, de lo contrario es incorrecta)

            historicoVersusDetalle.setIdHistoricoVersusDetalle(idHistoricoVersusDetalle);
            Integer indicadorRespuesta = trespuestaRepository.findIndicadorRespuesta(request.getId_curso(),
                                                                                request.getId_pregunta(),
                                                                                    request.getId_respuesta());

            indicadorRespuesta = (!indicadorRespuesta.equals(null)) ? indicadorRespuesta : 0;

            Integer idRespuestaCorrecta = 0;
            Integer punteo = 0;

            //si la pregunta que respondieron es correcta
            if(indicadorRespuesta==1) {
                idRespuestaCorrecta = request.getId_respuesta();
                IdPregunta idPregunta = new IdPregunta();
                idPregunta.setId_curso(request.getId_curso());
                idPregunta.setId_pregunta(idRespuestaCorrecta);
                Tpregunta tpregunta = tpreguntaRepository.findOne(idPregunta);
                Dificultad dificultad = dificultadRepository.findOne(tpregunta.getId_dificultad());
                punteo = dificultad.getPunteo();
                respuestaCorrecta = true;

            } else {
                // Busca la le Id de la respuesta correcta
                idRespuestaCorrecta = trespuestaRepository.findRespuestaCorrecta(request.getId_curso(),
                                                                                    request.getId_pregunta(),
                                                                                        1);
                idRespuestaCorrecta = (idRespuestaCorrecta!=null) ? idRespuestaCorrecta : 0;

            }
            historicoVersusDetalle.setId_respuesta_correcta(idRespuestaCorrecta);

            // punteo de experiencia

            historicoVersusDetalle.setPunteo(punteo);
            historicoVersusDetalleRepository.saveAndFlush(historicoVersusDetalle);
        }

        response.setId_versus(request.getId_versus());
        response.setId_jugador(request.getId_jugador());
        response.setId_curso(request.getId_curso());
        response.setId_pregunta(request.getId_pregunta());
        response.setId_respuesta(request.getId_respuesta());
        response.setResultado_respuesta(respuestaCorrecta);
        return response;
    }

    @Override
    public HistoricoVersus findOne(Integer id) {
        return historicoVersusRepository.findOne(id);
    }

}
