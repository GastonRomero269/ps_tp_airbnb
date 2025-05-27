package com.unla.ps_tp_airbnb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.ps_tp_airbnb.model.TypeGuests;
import com.unla.ps_tp_airbnb.repository.TypeGuestsRepository;
import com.unla.ps_tp_airbnb.serviceInterface.TypeGuestsService;

@Service
public class TypeGuestsServiceImpl implements TypeGuestsService {

	@Autowired
	private TypeGuestsRepository typeGuestRepository;

	@Override
	public TypeGuests save(TypeGuests typeGuest) {
		return typeGuestRepository.save(typeGuest);
	}

	@Override
	public Optional<TypeGuests> findById(Long id) {
		return typeGuestRepository.findById(id);
	}

	@Override
	public List<TypeGuests> findAll() {
		return typeGuestRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		typeGuestRepository.deleteById(id);
	}

}
