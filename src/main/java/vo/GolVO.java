package vo;

import java.io.Serializable;

import modelo.Gol;



public class GolVO implements Serializable{


	private static final long serialVersionUID = -1157619657541520040L;

	private int minuto;
	private String tipo;
	private JugadorVO jugador;
	private PartidoVO partido;
	
	public Gol toModelo() {
		return new Gol(jugador.toModelo(),partido.toModelo(), minuto, tipo);
	}
	
	public GolVO() {}

	public GolVO(int minuto, String tipo, JugadorVO jugador, PartidoVO partido) {
		this.minuto = minuto;
		this.tipo = tipo;
		this.jugador = jugador;
		this.partido = partido;
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


	
}
