package com.bs.service.impl;

import com.bo.Identifire.IdVersusCursos;
import com.bo.Versus;
import com.bo.VersusCurso;
import com.bs.service.VersusCursosService;
import com.dto.VersusCursosDTO;
import com.repository.VersusCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 11/18/17
 */
@Service
public class VersusCursosImpl implements VersusCursosService{

    private VersusCursoRepository versusCursoRepository;

    @Autowired
    public VersusCursosImpl(VersusCursoRepository versusCursoRepository) {
        Assert.notNull(versusCursoRepository, "versusRepository no debe ser null");
        this.versusCursoRepository = versusCursoRepository;
    }

    @Transactional
    public Boolean grabaVersusCursos(List<VersusCursosDTO> request) {

        Boolean graboVersusCursos = null;
        VersusCurso response = new VersusCurso();
        try {
            for (VersusCursosDTO listadocursos : request) {
                IdVersusCursos idVersusCursos = new IdVersusCursos();
                VersusCurso newVersusCursos = new VersusCurso();

                idVersusCursos.setId_versus(listadocursos.getId_versus());
                idVersusCursos.setId_curso(listadocursos.getId_curso());
                
                newVersusCursos.setIdVersusCursos(idVersusCursos);
                versusCursoRepository.saveAndFlush(newVersusCursos);
            }
        graboVersusCursos = true;
        } catch (NullPointerException npe) {
        }
        return graboVersusCursos;
    }
}
