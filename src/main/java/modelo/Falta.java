package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import daos.FaltaDAO;
import vo.FaltaVO;




@Entity
@Table(name="faltas")
public class Falta implements Serializable {

	private static final long serialVersionUID = -5456419988426707888L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFalta;
	private int minuto;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name ="idJugador")
	private Jugador jugador;
	
	@OneToOne
	@JoinColumn(name ="idPartido")
	private Partido partido;
	
	@OneToOne
	@JoinColumn(name ="idCampeonato")
	private Campeonato campeonato;
	
	
	
	public Falta(Jugador jugador, Partido partido, Campeonato campeonato, int minuto, String tipo) {
		this.idFalta = null;
		this.jugador = jugador;
		this.partido = partido;
		this.campeonato = campeonato;
		this.minuto = minuto;
		this.tipo = tipo;
	}
	public Falta() {}
	public Jugador getJugador() {
		return jugador;
	}

	public Partido getPartido() {
		return partido;
	}

	public int getMinuto() {
		return minuto;
	}

	public String getTipo() {
		return tipo;
	}

	public Integer getIdFalta() {
		return idFalta;
	}

	public void setIdFalta(Integer idFalta) {
		this.idFalta = idFalta;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	public void grabar() {
		FaltaDAO.getInstancia().grabar(this);
	}

	@Override
	public String toString() {
		return "Falta [idFalta=" + idFalta + ", minuto=" + minuto + ", tipo=" + tipo + ", jugador=" + jugador
				+ ", partido=" + partido + ", campeonato=" + campeonato + "]";
	}
	
	public FaltaVO toVO() {
		return new FaltaVO(minuto, tipo, jugador.toVO(), partido.toVO(), campeonato.toVO());

	}
	
	
}
