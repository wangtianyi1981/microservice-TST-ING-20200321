package com.fhit.test.microcity2.entity;

import java.io.Serializable;

/**
 * @author wty
 * @create 2020-03-14 10:22
 */
public class City implements Serializable {
    private Integer id;
    private String name;
    private double area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
