package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import daos.ResponsableDAO;
import vo.ResponsableVO;

@Entity
@Table(name = "representantes")

public class Responsable implements Comparable<Responsable>, Serializable{


	private static final long serialVersionUID = -4317766801455346265L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idRepresentante")
	private Integer legajo;
	
	@Override
	public String toString() {
		return "Responsable [legajo=" + legajo + ", documento=" + documento + ", nombre=" + nombre + ", club=" + club
				+ "]";
	}

	private String documento;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn (name="idClub")
	private Club club;
	
	public Responsable() {}
	
	public Responsable(String documento, String nombre, Club club) {
		this.legajo = null;
		this.documento = documento;
		this.nombre = nombre;
		this.club = club;
	}

	public String getDocumento() {
		return documento;
	}

	public String getNombre() {
		return nombre;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	@Override
	public int compareTo(Responsable o) {
		return this.documento.compareTo(o.getDocumento());
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void grabar() {
		ResponsableDAO.getInstancia().grabar(this);
		
	}

	public void eliminar() {
		ResponsableDAO.getInstancia().eliminar(this);
		
	}
	public ResponsableVO toVO() {
		return new ResponsableVO(legajo, nombre, documento, club.toVO());
	}

}
