package vo;

import java.io.Serializable;

import modelo.Club;


public class ClubVO implements Serializable{

	private static final long serialVersionUID = 4318382185821080424L;
	
	private Integer idClub;
	private String nombre;
	private String direccion;
	
	
	public ClubVO() {}
	
	public ClubVO(Integer idClub, String nombre, String direccion) {
		this.idClub = idClub;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	
	public Club toModelo() {
		return new Club(idClub, nombre, direccion);
	}
	
	
	
	public Integer getIdClub() {
		return idClub;
	}


	public void setIdClub(Integer idClub) {
		this.idClub = idClub;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}





	
}
