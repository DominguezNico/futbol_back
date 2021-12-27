package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import daos.PartidoDAO;
import exeptions.PartidoException;
import vo.PartidoVO;

@Entity
@Table(name="partidos")
public class Partido implements Serializable {

	private static final long serialVersionUID = 8230147511793992306L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPartido;
	private int nroFecha;
	private int nroZona;
	private int categoria;
	private Integer golesLocal;
	private Integer golesVisitante;
	
	//private Date fechaPartido;
	private String fechaPartido;
	@Column(name="validadoLocal")
	private boolean convalidaLocal;
	@Column(name="validadoVisitante")
	private boolean convalidaVisitante;

	private String etapa="";

	@OneToOne
	@JoinColumn(name="idClubLocal")
	private Club clubLocal;
	
	@OneToOne
	@JoinColumn(name="idClubVisitante")
	private Club clubVisitante;
	
	@OneToOne
	@JoinColumn(name="idCampeonato")
	private Campeonato campeonato;
	
	@OneToMany(mappedBy="partido", fetch = FetchType.EAGER)
	private List<Miembro> jugadoresLocales;
	
	@OneToMany(mappedBy="partido", fetch = FetchType.EAGER)
	private List<Miembro> jugadoresVisitantes;
	


	public Partido() {}
	
	public Partido(int nroFecha, int nroZona, int categoria, Club clubLocal, Club clubVisitante, 
			       String fechaPartido, Campeonato campeonato,String etapa) {
		this.idPartido = null;
		this.nroFecha = nroFecha;
		this.nroZona = nroZona;
		this.categoria = categoria;
		this.clubLocal = clubLocal;
		this.clubVisitante = clubVisitante;
		this.golesLocal = 0;
		this.golesVisitante = 0;
		this.fechaPartido = fechaPartido;
		this.convalidaLocal = false;
		this.convalidaVisitante = false;
		this.campeonato = campeonato;
		this.jugadoresLocales = new ArrayList<Miembro>();
		this.jugadoresVisitantes = new ArrayList<Miembro>();
		this.etapa=etapa;
	}

	public Integer getIdPartido() {
		return idPartido;
	}

	public int getNroFecha() {
		return nroFecha;
	}

	public int getNroZona() {
		return nroZona;
	}

	public int getCategoria() {
		return categoria;
	}

	public Club getClubLocal() {
		return clubLocal;
	}

	public Club getClubVisitante() {
		return clubVisitante;
	}

	public Integer getGolesLocal() throws PartidoException {
		Partido aux=PartidoDAO.getInstancia().obtenerPartidoPorID(this.idPartido);
		int cantidadGoles=aux.golesLocal;
		return cantidadGoles;
	}

	public Integer getGolesVisitante() throws PartidoException {
		Partido auxV=PartidoDAO.getInstancia().obtenerPartidoPorID(this.idPartido);
		int cantidadGoles=auxV.golesVisitante;
		return cantidadGoles;
	}

	public String getFechaPartido() {
		return fechaPartido;
	}

	public boolean isConvalidaLocal() {
		return convalidaLocal;
	}

	public boolean isConvalidaVisitante() {
		return convalidaVisitante;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public List<Miembro> getJugadoresLocales() {
		return jugadoresLocales;
	}

	public List<Miembro> getJugadoresVisitantes() {
		return jugadoresVisitantes;
	}

	public void setNroFecha(int nroFecha) {
		this.nroFecha = nroFecha;
	}

	public void setNroZona(int nroZona) {
		this.nroZona = nroZona;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public void setClubLocal(Club clubLocal) {
		this.clubLocal = clubLocal;
	}

	public void setClubVisitante(Club clubVisitante) {
		this.clubVisitante = clubVisitante;
	}

	public void setFechaPartido(String fechaPartido) {
		this.fechaPartido = fechaPartido;
		PartidoDAO.getInstancia().actualizar(this);
	}

	public void setConvalidaLocal() {
		this.convalidaLocal = true;
	}

	public void setConvalidaVisitante() {
		this.convalidaVisitante = true;
	}

	public void agregarJugadoresLocales(Miembro miembro) {
		this.jugadoresLocales.add(miembro);
	}

	public void agregarJugadoresVisitantes(Miembro miembro) {
		this.jugadoresVisitantes.add(miembro);
	}
	
	public void setGolesLocal(int golesActual) throws PartidoException {
		this.golesLocal =golesActual+1;
		System.out.println(golesLocal);
		PartidoDAO.getInstancia().actualizar(this);
	}
	
	public void setGolesVisitante(int golesActual) throws PartidoException {
		this.golesVisitante =golesActual+1;
		PartidoDAO.getInstancia().actualizar(this);
	}
	
	public void grabar() {
        PartidoDAO.getInstancia().grabar(this);
    }



	public void eliminar() {
		PartidoDAO.getInstancia().eliminar(this);
		
	}
	
	public PartidoVO toVO() {
		return new PartidoVO(idPartido,nroFecha, nroZona, categoria, golesLocal, golesVisitante, fechaPartido, convalidaLocal, convalidaVisitante,clubLocal.toVO() ,clubVisitante.toVO() , campeonato.toVO(),this.etapa);
		
	}
}
