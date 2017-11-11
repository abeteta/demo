package com.bs.service;

import com.bo.Area;

import java.util.List;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/20/17
 */
public interface AreaService {
    List<Area> findAll();
    Area findOne(Integer id_area);
}
