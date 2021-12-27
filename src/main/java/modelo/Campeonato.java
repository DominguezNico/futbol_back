package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import daos.CampeonatoDAO;
import vo.CampeonatoVO;


@Entity
@Table(name="Campeonatos")
public class Campeonato implements Comparable<Campeonato> ,Serializable{
	
	private static final long serialVersionUID = 7856363182935054772L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCampeonato;
	
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
    @Column
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    @Column
    private Date fechaFin;
    
	private String estado;
	
	@ManyToMany(mappedBy= "participanciones",fetch = FetchType.EAGER)
	private List<Club> inscriptos;
	
	
	
	
	public Campeonato() {}
	
	public Campeonato(String descripcion, Date fechaInicio, Date fechaFin, String estado) {
		this.idCampeonato = null;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.inscriptos=new ArrayList<Club>();
	}

	public Integer getIdCampeonato() {
		return idCampeonato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public List<Club> getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(List<Club> inscriptos) {
		this.inscriptos = inscriptos;
	}

	@Override
	public int compareTo(Campeonato o) {
		return this.getIdCampeonato().compareTo(o.getIdCampeonato());
	}
	
	
	public void inscribirClub(Club club) {
		this.inscriptos.add(club);
		CampeonatoDAO.getInstancia().actualizar(this);
		System.out.println("metodo inscribirClub del campeoanto :"+inscriptos.size());
		if(club.participa(this)==false) {
			club.participa(this);
			
			}
	}
	
	public void eliminarClub(Club club) {
		inscriptos.remove(club);
		
	}
	
	public void grabar() {
		CampeonatoDAO.getInstancia().grabar(this);
	}

	
	public CampeonatoVO toVO() {
		return new CampeonatoVO( idCampeonato,descripcion, fechaInicio, fechaFin,  estado);

	}
	
	
	
	
	//public List<Integer> getInscriptos2(int id ) {
       // return CampeonatoDAO.getInstancia().getInscriptos(id);
    //}
	
}
