package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import daos.tablaPosicionesDAO;
import exeptions.tablaPosicionesException;

import vo.tablaPosicionesVO;

@Entity
@Table(name = "tablaPosiciones")

public class tablaPosiciones implements  Serializable {


	private static final long serialVersionUID = 283142308257609370L;


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTabla;
	
	//LISTA DE CLUB CON ONE TOM MANY Y  SOLO DE ESTE LADO.
	
	/*
	@OneToMany
	@JoinColumn(name="idClub")
	private List<Club> clubes;
	*/
	
	@OneToOne
	@JoinColumn(name = "idClub")
	private Club c;
	
	@OneToOne
	@JoinColumn(name = "idCampeonato")
	private Campeonato camp;
	

	
	
	private Integer cantidadJugados;
	
	
	private Integer cantidadganados;
	private Integer cantidadempatados;
	private Integer cantidadperdidos;
	
	private Integer golesFavor;
	private Integer golesContra;
	private Integer diferenciaGoles;
	private Integer puntos;
	private Float promedio;
	private String estado;
	
	public tablaPosiciones() {}
	
	
	public tablaPosiciones( Campeonato campe,Integer cantidadJugados, Integer cantidadganados,
						    Integer cantidadempatados, Integer cantidadperdidos, Integer golesFavor,
						    Integer golesContra,Integer diferenciaGoles,Integer puntos,
						     Float promedio ) {
		
		this.camp=campe;
		//this.clubes=new ArrayList<Club>();
		this.cantidadJugados=cantidadJugados;
		this.cantidadganados=cantidadganados;
		this.cantidadempatados=cantidadempatados;
		this.cantidadperdidos=cantidadperdidos;
		this.puntos=0;
		this.golesFavor=golesFavor;
		this.golesContra=golesContra;
		this.promedio=promedio;
		this.diferenciaGoles=0;
		this.setEstado("");
		

	}


	public void insertarClube(Club c) throws tablaPosicionesException {
		this.c=c;
		tablaPosicionesDAO.getInstancia().actualizar(this);
	}
	

	public void validarPosiciones() throws tablaPosicionesException {
		this.setEstado("");
		tablaPosicionesDAO.getInstancia().actualizar(this);
	}



	public Integer getIdTabla() {
		return idTabla;
	}


	public void setIdTabla(Integer idTabla) {
		this.idTabla = idTabla;
	}


	public Club getC() {
		return c;
	}


	public void setC(Club c) {
		this.c = c;
	}


	public Campeonato getCamp() {
		return camp;
	}


	public void setCamp(Campeonato camp) {
		this.camp = camp;
	}


	public Integer getCantidadJugados() {
		return cantidadJugados;
	}

	public void setCantidadJugados(Integer cantidadJugados) {
		this.cantidadJugados = cantidadJugados;
	}

	public Integer getCantidadganados() {
		return cantidadganados;
	}

	public void setCantidadganados(Integer cantidadganados) {
		this.cantidadganados = cantidadganados;
	}

	public Integer getCantidadempatados() {
		return cantidadempatados;
	}

	public void setCantidadempatados(Integer cantidadempatados) {
		this.cantidadempatados = cantidadempatados;
	}

	public Integer getCantidadperdidos() {
		return cantidadperdidos;
	}

	public void setCantidadperdidos(Integer cantidadperdidos) {
		this.cantidadperdidos = cantidadperdidos;
	}

	public Integer getGolesFavor() {
		return golesFavor;
	}

	public void setGolesFavor(Integer golesFavor) {
		this.golesFavor = golesFavor;
	}

	public Integer getGolesContra() {
		return golesContra;
	}

	public void setGolesContra(Integer golesContra) {
		this.golesContra = golesContra;
	}

	public Integer getDiferenciaGoles() {
		return diferenciaGoles;
	}

	public void setDiferenciaGoles(Integer diferenciaGoles) {
		this.diferenciaGoles = diferenciaGoles;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void setPuntos(Integer puntos) {
		this.puntos = puntos;
	}

	public Float getPromedio() {
		return promedio;
	}

	public void setPromedio(Float promedio) {
		this.promedio = promedio;
	}

	
	
	
	public void grabar() {
		tablaPosicionesDAO.getInstancia().grabar(this);
	}
	
	public tablaPosicionesVO toVO() {
	return new tablaPosicionesVO( idTabla,
	  c.toVO(),
	  camp.toVO(),
	  cantidadJugados,
	  cantidadganados,
	  cantidadempatados,
	  cantidadperdidos,
	  golesFavor,
	  golesContra,
	  diferenciaGoles,
	  puntos,
	  promedio);
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
