package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="contribuyente")
public class Contribuyente {
	
	@Id
	@GeneratedValue(generator="contribuyente_c_contribuyente_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "contribuyente_c_contribuyente_seq", sequenceName = "public.contribuyente_c_contribuyente_seq", allocationSize = 1)
	@Column(name="c_contribuyente")
	private Integer cContribuyente;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="c_importancia")
	private Importancia importancia;
	
	@Transient
	private Integer cImportancia;
	
	@Column(name="s_nombre")
	@NotEmpty(message="El campo Nombre no puede ir vacio")
	@Size(max=30, message="El campo Nombre no debe tener mas de 30 caracteres")
	private String nombre;
	
	@Column(name="s_apellido")
	@NotEmpty(message="El campo Apellido no puede ir vacio")
	@Size(max=30, message="El campo Apellido no debe tener mas de 30 caracteres")
	private String apellido;
	
	@Column(name="s_nit")
	@NotEmpty(message="El campo NIT no puede ir vacio")
	@Pattern(regexp="^$|[0-9]{14}", message="El NIT no es valido")
	private String nit;
	
	@Column(name="f_fecha_ingreso")
	private Date fecha;

	public Contribuyente() {}

	public Integer getcContribuyente() {
		return cContribuyente;
	}

	public void setcContribuyente(Integer cContribuyente) {
		this.cContribuyente = cContribuyente;
	}

	public Importancia getImportancia() {
		return importancia;
	}

	public void setImportancia(Importancia importancia) {
		this.importancia = importancia;
	}

	public Integer getcImportancia() {
		return cImportancia;
	}

	public void setcImportancia(Integer cImportancia) {
		this.cImportancia = cImportancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
