package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import daos.ClubDAO;
import vo.ClubVO;




@Entity
@Table(name="clubes")
public class Club implements Comparable<Club>, Serializable{

	private static final long serialVersionUID = 5909575668332288560L;
	

	@Id
	private Integer idClub;
	
	private String nombre;
	private String direccion;
	
	
	
	@OneToMany(mappedBy="club",cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Responsable> responsables;
	
	@OneToMany(mappedBy="club",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Jugador> jugadores;
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	@JoinTable(name="clubesCampeonato",
	   joinColumns= {@JoinColumn(name="idClub")},
	   inverseJoinColumns= {@JoinColumn(name ="idCampeonato")})
	private List<Campeonato> participanciones;
	
	
	
	public void eliminarJugador(Jugador jugador) {
		this.jugadores.remove(jugador);
		
	}
	
	
	

	
	
	public Club() {}
	
	public Club(int idClub, String nombre, String direccion) {
		this.idClub = idClub;
		this.nombre = nombre;
		this.direccion = direccion;
		jugadores = new ArrayList<Jugador>();
		participanciones= new ArrayList<Campeonato>();
		responsables=new ArrayList<Responsable>();
	}
	
	/*
	public Club(Integer idClub, String nombre, String direccion) {
		this.idClub = idClub;
		this.nombre = nombre;
		this.direccion = direccion;
	}*/

	public void asignarResponsable(Responsable responsable) {
		responsables.add(responsable);
		//ClubDAO.getInstancia().actualizar(this);
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
		ClubDAO.getInstancia().actualizar(this);
	}


	public Integer getIdClub() {
		return idClub;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public List<Responsable> getResponsable() {
		return responsables;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	@Override
	public int compareTo(Club o) {
		return this.getIdClub().compareTo(o.getIdClub());
	}
	
	
	public List<Campeonato> getParticipanciones(){
		return this.participanciones;
		
	}
	
	
	
	public boolean participa(Campeonato campeonato) {
		if(this.participanciones.contains(campeonato)) 
			return true;
		else
			return false;
		
	}
	public void participar(Campeonato campeonato) {
		participanciones.add(campeonato);
		ClubDAO.getInstancia().actualizar(this);
	}
	
	public void dejarDeParticipar(Campeonato campeonato) {
		participanciones.remove(campeonato);
	}
	
	/*
	public void agregarJugadoresToListaLocal(Jugador jugador, Partido partido) {
		partido.agregarJugadoresLocales(new Miembro(this, partido, jugador));
	}
	
	public void agregarJugadoresToListaVisitante(Jugador jugador, Partido partido) {
		partido.agregarJugadoresVisitantes(new Miembro(this, partido, jugador));
	}
	*/
	public void grabar() {
		ClubDAO.getInstancia().grabar(this);
	}
	
	public void cambiarDireccion(String direccion2) {
		this.direccion=direccion2;
		ClubDAO.getInstancia().actualizar(this);
	}
	
	public int agregarJugadoresLista(Partido p, Jugador j) {
		int check = 0;
		boolean clubLocal = false;
		boolean clubVisitante = false;
		if (p.getClubLocal().getIdClub().equals(this.idClub))
			clubLocal = true;
		if (p.getClubVisitante().getIdClub().equals(this.idClub))
			clubVisitante = true;
		if (clubLocal || clubVisitante) {
			int cantJugadores;
			if (clubLocal) 
				cantJugadores = p.getJugadoresLocales().size();
			else 
				cantJugadores = p.getJugadoresVisitantes().size();
			int categoriaJugador;
			int categoriaPartido;
			if (j.getCategoria()>=60) {
				categoriaJugador= j.getCategoria() + 1900;
			}
			else {
				categoriaJugador= j.getCategoria() + 2000;
			}
			if(p.getCategoria()>=60) {
				categoriaPartido = p.getCategoria() + 1900;
			}
			else {
				categoriaPartido = p.getCategoria() + 2000;
			}
			if (j.getClub().getIdClub().equals(this.idClub) && categoriaJugador >= categoriaPartido && cantJugadores < 17) {
				System.out.println("JUGADOR "+j.getIdJugador()+"  partido "+p.getIdPartido()+" Club "+this.idClub);
				Miembro m = new Miembro(this, p, j);
				m.grabar();
				if (clubLocal)
					p.agregarJugadoresLocales(m);
				else
					p.agregarJugadoresVisitantes(m);
			}	
			else {
				System.out.println("No se puede agregar el nuevo jugador");
				check = 1;
			}
		}
		else {
			System.out.println("El jugador dado no pertenece a un club de este partido");
			check = 1;
		}
		return check;
	}
	
	public ClubVO toVO() {
		return new ClubVO(idClub, nombre, direccion);
	}






	@Override
	public String toString() {
		return "Club [idClub=" + idClub + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
