package com.bo;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Alexander Beteta
 * @version 1.0.0
 * @since 1.0.0
 * created on 10/20/17
 */
@Entity
@Table(name="area")
public class Area implements Serializable {
    private static final long serialVersionUID = -1388912437788530149L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_area;

    private String desc_area;

    public Area (){}

    public Area(String desc_area) {
        this.desc_area = desc_area;
    }

    public Integer getId_area() {
        return id_area;
    }

    public void setId_area(Integer id_area) {
        this.id_area = id_area;
    }

    public String getDesc_area() {
        return desc_area;
    }

    public void setDesc_area(String desc_area) {
        this.desc_area = desc_area;
    }
}
