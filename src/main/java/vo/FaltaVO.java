package vo;

import java.io.Serializable;

import modelo.Falta;


public class FaltaVO implements Serializable{

	private static final long serialVersionUID = -7672796344990186207L;

	private int minuto;
	private String tipo;
	private JugadorVO jugador;
	private PartidoVO partido;
	private CampeonatoVO campeonato;
	
	public FaltaVO() {}
	
	public Falta toModelo() {
		return new Falta(jugador.toModelo(), partido.toModelo(), campeonato.toModelo(), minuto, tipo);
	}

	public FaltaVO(int minuto, String tipo, JugadorVO jugador, PartidoVO partido, CampeonatoVO campeonato) {
		this.minuto = minuto;
		this.tipo = tipo;
		this.jugador = jugador;
		this.partido = partido;
		this.campeonato = campeonato;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public JugadorVO getJugador() {
		return jugador;
	}

	public void setJugador(JugadorVO jugador) {
		this.jugador = jugador;
	}

	public PartidoVO getPartido() {
		return partido;
	}

	public void setPartido(PartidoVO partido) {
		this.partido = partido;
	}

	public CampeonatoVO getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(CampeonatoVO campeonato) {
		this.campeonato = campeonato;
	}

	@Override
	public String toString() {
		return "FaltaVO [minuto=" + minuto + ", tipo=" + tipo + ", jugador=" + jugador + ", partido=" + partido
				+ ", campeonato=" + campeonato + "]";
	}
	

	
	
	
}
