package com.uca.capas.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="importancia")
public class Importancia {
	
	@Id
	@Column(name="c_importancia")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cImportancia;
	
	@OneToMany(mappedBy="importancia", fetch=FetchType.EAGER)
	private List<Contribuyente> contribuyente;
	
	@Column(name="s_importancia")
	@NotEmpty(message="El campo Importancia no puede ir vacio")
	@Size(max=30, message="El campo Importancia no debe tener mas de 30 caracteres")
	private String importancia;
	
	public Importancia() {}

	public Integer getcImportancia() {
		return cImportancia;
	}

	public void setcImportancia(Integer cImportancia) {
		this.cImportancia = cImportancia;
	}

	public List<Contribuyente> getContribuyente() {
		return contribuyente;
	}

	public void setContribuyente(List<Contribuyente> contribuyente) {
		this.contribuyente = contribuyente;
	}

	public String getImportancia() {
		return importancia;
	}

	public void setImportancia(String importancia) {
		this.importancia = importancia;
	}
}
