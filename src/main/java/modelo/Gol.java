package modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import daos.GolDAO;
import vo.GolVO;



@Entity
@Table(name="goles")
public class Gol implements Serializable{

	private static final long serialVersionUID = -2136912557393660111L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGol;
	private int minuto;
	@Column(name="sentido")
	private String tipo;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name ="idJugador")
	private Jugador jugador;
	
	@OneToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "idPartido")
	private Partido partido;
	
	public Gol() {}
	
	public Gol(Jugador jugador, Partido partido, int minuto, String tipo) {
		this.setIdGol(null);
		this.jugador = jugador;
		this.partido = partido;
		this.minuto = minuto;
		this.tipo = tipo;
	}
	
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

	public Integer getIdGol() {
		return idGol;
	}

	public void setIdGol(Integer idGol) {
		this.idGol = idGol;
	}
	
	public void grabar() {
		GolDAO.getInstancia().grabar(this);
	}
	
	public GolVO toVO() {
		return new GolVO(minuto, tipo, jugador.toVO(), partido.toVO());

	}

}
