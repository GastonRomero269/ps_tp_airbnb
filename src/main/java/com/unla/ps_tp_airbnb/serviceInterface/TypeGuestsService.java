package com.unla.ps_tp_airbnb.serviceInterface;

import java.util.List;
import java.util.Optional;

import com.unla.ps_tp_airbnb.model.TypeGuests;

public interface TypeGuestsService {
    TypeGuests save(TypeGuests typeGuest);
    Optional<TypeGuests> findById(Long id);
    List<TypeGuests> findAll();
    void delete(Long id);
}
