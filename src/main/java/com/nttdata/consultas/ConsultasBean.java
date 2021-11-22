package com.nttdata.consultas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.PrimeFaces;
import com.nttdata.consultas.model.Consult;
import com.nttdata.consultas.model.Medic;

@SessionScoped
@ManagedBean(name = "consultasBean")
public class ConsultasBean {

	private String name;
	private String medicName;
	private String speciality;
	private String address;;
	private Medic medic;
	private List<Medic> medicList = new ArrayList<Medic>();
	private List<String> medicNameList = new ArrayList<String>();
	private List<String> medicAddress = new ArrayList<String>();
	private Date date;
	private Consult consult;
	private List<Consult> consultList = new ArrayList<Consult>();

	//Construtor para preenchimento automatico do field de médicos
	public ConsultasBean() {
		medic = new Medic("Dr. Jose", "Cardiologista", "Rua de Teste 1");
		medicList.add(medic);

		medic = new Medic("Dr. Pedro", "Ortopedista", "Rua de Teste 2");
		medicList.add(medic);

		medic = new Medic("Dr. Joao", "Oftalmologista", "Rua de Teste 3");
		medicList.add(medic);
		
		medic = new Medic("Dr. Felipe", "Odontologista", "Rua de Teste 4");
		medicList.add(medic);
	}

	//Alterar field de acordo com o médico selecionado
	public void alterarCampos(ValueChangeEvent e) {

		medicNameList.clear();
		medicAddress.clear();

		for (int i = 0; i < medicList.size(); i++) {
			if (medicList.get(i).getSpeciality().equalsIgnoreCase((String) e.getNewValue())) {
				medicNameList.add(medicList.get(i).getName());
				medicAddress.add(medicList.get(i).getAddress());
			}
		}

	}

	public String salvarConsulta() {
		consult = new Consult();

		consult.setPatient(name);
		consult.setMedic(medicName);
		consult.setSpeciality(speciality);
		consult.setAddress(address);
		consult.setDate(date);

		consultList.add(consult);
		showMessage();
		return "home.xhtml";
	}

	public void showMessage() {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Agendado!",
				" Agendamento realizado com sucesso!");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Medic getMedic() {
		return medic;
	}

	public void setMedic(Medic medic) {
		this.medic = medic;
	}

	public List<Medic> getMedicList() {
		return medicList;
	}

	public void setMedicList(List<Medic> medicList) {
		this.medicList = medicList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Consult getConsult() {
		return consult;
	}

	public void setConsult(Consult consult) {
		this.consult = consult;
	}

	public List<Consult> getConsultList() {
		return consultList;
	}

	public void setConsultList(List<Consult> consultList) {
		this.consultList = consultList;
	}

	public List<String> getMedicNameList() {
		return medicNameList;
	}

	public void setMedicNameList(List<String> medicNameList) {
		this.medicNameList = medicNameList;
	}

	public List<String> getMedicAddress() {
		return medicAddress;
	}

	public void setMedicAddress(List<String> medicAddress) {
		this.medicAddress = medicAddress;
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

	public String getMedicName() {
		return medicName;
	}

	public void setMedicName(String medicName) {
		this.medicName = medicName;
	}
}
