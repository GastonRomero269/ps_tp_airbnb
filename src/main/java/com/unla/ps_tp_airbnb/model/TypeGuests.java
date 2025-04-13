package com.unla.ps_tp_airbnb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypeGuests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)	
	private Long id;
	private int adults;
	private int childs;
	private int babys;
	private int pets;
	
	public TypeGuests()
	{
		
	}

	public TypeGuests(Long id, int adults, int childs, int babys, int pets) {
		super();
		this.id = id;
		this.adults = adults;
		this.childs = childs;
		this.babys = babys;
		this.pets = pets;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChilds() {
		return childs;
	}

	public void setChilds(int childs) {
		this.childs = childs;
	}

	public int getBabys() {
		return babys;
	}

	public void setBabys(int babys) {
		this.babys = babys;
	}

	public int getPets() {
		return pets;
	}

	public void setPets(int pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "TypeGuests [id=" + id + ", adults=" + adults + ", childs=" + childs + ", babys=" + babys + ", pets="
				+ pets + "]";
	}

}
