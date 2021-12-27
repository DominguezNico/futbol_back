package vo;

import java.io.Serializable;
import java.util.Date;


import modelo.Campeonato;


public class CampeonatoVO implements Serializable{

	private static final long serialVersionUID = 3922524537735496973L;

	private Integer idCampeonato;
	
	private String descripcion;
	

    private Date fechaInicio;

   
    private Date fechaFin;
    
	private String estado;
	
	public CampeonatoVO() {}
	
	public CampeonatoVO(Integer idCampeonato,String descripcion,Date fechaInicio,Date fechaFin, String estado) {
		this.idCampeonato=idCampeonato;
		this.descripcion=descripcion;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.estado=estado;
	}
	
	public Campeonato toModelo() {
		return new Campeonato( descripcion,  fechaInicio,  fechaFin,  estado);
	}

	public Integer getIdCampeonato() {
		return idCampeonato;
	}

	public void setIdCampeonato(Integer idCampeonato) {
		this.idCampeonato = idCampeonato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
