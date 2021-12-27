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

import daos.MiembroDAO;
import vo.MiembroVO;

@Entity
@Table(name = "listaJugadoresPartido")
public class Miembro implements Serializable{


	private static final long serialVersionUID = 3151198457607546812L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer idLista;
	
	@OneToOne
	@JoinColumn(name = "idClub")
	private Club club;
	
	@ManyToOne
	@JoinColumn (name="idPartido")
	private Partido partido;
	
	@OneToOne()
	@JoinColumn(name = "idJugador")
	private Jugador jugador;
	
	private Integer ingreso;
	
	private Integer egreso;
	
	
	
	private String estadoJugadorPartido;
	public Miembro() {}
	
	@Override
	public String toString() {
		return "Miembro [idLista=" + idLista + ", club=" + club + ", partido=" + partido + ", jugador=" + jugador
		+ ", ingreso=" + ingreso + ", egreso=" + egreso + "]";
	}
	
	
	
	public Miembro(Club club, Partido partido, Jugador jugador) {
		this.club = club;
		this.partido = partido;
		this.jugador = jugador;
		this.ingreso = 0;
		this.egreso = 0;
		this.estadoJugadorPartido="activo";
	}
	
	
	
	public void BajaJugadorPartido() {
		this.estadoJugadorPartido="inactivo";
	}
	
	public void AltaJugadorPartido() {
		
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	
	
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public String getEstadoJugadorPartido() {
		return estadoJugadorPartido;
	}

	public void setEstadoJugadorPartido(String estadoJugadorPartido) {
		this.estadoJugadorPartido = estadoJugadorPartido;
	}

	public Club getClub() {
		return club;
	}
	
	
	
	public void setClub(Club club) {
		this.club = club;
	}
	
	
	
	public Partido getPartido() {
		return partido;
	}
	
	
	
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	
	
	public Integer getIngreso() {
		return ingreso;
	}
	
	
	
	
	
	public void setIngreso(Integer ingreso) {
		if (ingreso >= 0 && ingreso <=90) {
			this.ingreso = ingreso;
			MiembroDAO.getInstancia().actualizar(this);
		}
		else {
			System.out.println("El minuto de ingreso dado no es válido");
		}
	}
	
	
	
	public Integer getIdLista() {
		return idLista;
	}
	
	
	
	public void setIdLista(Integer idLista) {
		this.idLista = idLista;
	}
	
	
	
	public Integer getEgreso() {
		return egreso;
	}
	
	
	
	
	public void setEgreso(Integer egreso) {
		if (egreso > 0 && egreso <=90) {
			this.egreso = egreso;
			MiembroDAO.getInstancia().actualizar(this);
		}
		else {
			System.out.println("El minuto de egreso dado no es válido");
		}
	}
	
	
	
	public void grabar() {
		MiembroDAO.getInstancia().grabar(this);
	}
	
	
	
	public void eliminar() {
		MiembroDAO.getInstancia().eliminar(this);
	
	}
	
	
	public MiembroVO toVO() {
		return new MiembroVO(idLista, club.toVO(), jugador.toVO(), ingreso, egreso,estadoJugadorPartido);
	
	}
	
		
}