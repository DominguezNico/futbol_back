package vo;

import java.io.Serializable;


public class ResponsableVO implements Serializable{

	private static final long serialVersionUID = 5796460288252291924L;
	
	private String nombre;
	private String documento;
	private ClubVO club;
	private int legajo; 
	public ResponsableVO() {}
	
	public ResponsableVO(String nombre, String documento, ClubVO club) {
		this.setNombre(nombre);
		this.setDocumento(documento);
		this.setClub(club);
	}

	public ResponsableVO(Integer legajo, String nombre, String documento, ClubVO club) {
		this.setNombre(nombre);
		this.setDocumento(documento);
		this.setClub(club);
		this.setLegajo(legajo);
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public void toModelo() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public ClubVO getClub() {
		return club;
	}

	public void setClub(ClubVO club) {
		this.club = club;
	}
}
