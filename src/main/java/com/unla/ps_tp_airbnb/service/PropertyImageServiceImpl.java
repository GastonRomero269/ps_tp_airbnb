package com.unla.ps_tp_airbnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.ps_tp_airbnb.model.PropertyImage;
import com.unla.ps_tp_airbnb.repository.PropertyImageRepository;
import com.unla.ps_tp_airbnb.serviceInterface.PropertyImageService;

@Service
public class PropertyImageServiceImpl implements PropertyImageService {

    @Autowired
    private PropertyImageRepository propertyImageRepository;

    public List<PropertyImage> findAll() {
        return propertyImageRepository.findAll();
    }

    public PropertyImage findById(Long id) {
        return propertyImageRepository.findById(id).orElse(null);
    }

    public PropertyImage save(PropertyImage image) {
        return propertyImageRepository.save(image);
    }

    public void delete(Long id) {
        propertyImageRepository.deleteById(id);
    }
}

