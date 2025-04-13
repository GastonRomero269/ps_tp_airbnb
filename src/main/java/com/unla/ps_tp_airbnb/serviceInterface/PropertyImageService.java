package com.unla.ps_tp_airbnb.serviceInterface;

import java.util.List;

import com.unla.ps_tp_airbnb.model.PropertyImage;

public interface PropertyImageService {
    List<PropertyImage> findAll();
    PropertyImage findById(Long id);
    PropertyImage save(PropertyImage image);
    void delete(Long id);
}

