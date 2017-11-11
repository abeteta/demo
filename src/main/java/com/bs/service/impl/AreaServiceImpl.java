package com.bs.service.impl;

import com.bo.Area;
import com.bs.service.AreaService;
import com.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/20/17
 */
@Service
public class AreaServiceImpl implements AreaService {
    private AreaRepository areaRepository;

    @Autowired
    public AreaServiceImpl(AreaRepository areaRepository) {
        Assert.notNull(areaRepository, "areaRepository no debe ser null");
        this.areaRepository = areaRepository;
    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area findOne(Integer id) {
        return areaRepository.findOne(id);
    }

}
