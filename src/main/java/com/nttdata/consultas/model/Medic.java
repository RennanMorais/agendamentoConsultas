package com.nttdata.consultas.model;

public class Medic {

	private String name;
	private String speciality;
	private String address;

	public Medic() {

	};

	public Medic(String name, String speciality, String address) {
		super();
		this.name = name;
		this.speciality = speciality;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
