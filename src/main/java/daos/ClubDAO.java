package daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.ClubException;
import modelo.Club;
import modelo.Jugador;
import modelo.Responsable;

public class ClubDAO implements Serializable {


	private static final long serialVersionUID = -1464534014284029993L;
	private EntityManagerFactory emf;
	
	/* SINGLETON */
	private static ClubDAO instancia;

	
	private ClubDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static ClubDAO getInstancia() {
		if(instancia ==null) {
			instancia = new ClubDAO();
		}
		return instancia;		
	}
	/* FIN DEL SINGLETON*/
	
	public void grabar(Club club) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(club);
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	public Club obtenerClubPorID(Integer id) throws ClubException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Club club = (Club) em.createQuery("from Club e where e.idClub = "+ id ).getSingleResult();
		em.getTransaction().commit();
		em.close();
	    
	    if(club!=null)
	    	return club;

	        throw new ClubException("No existe club con id="+id);
	    }

	
	 @SuppressWarnings("unchecked")
	 public List<Club> obtenerClubes()   {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Club> club = (List<Club>) em.createQuery("From Club").getResultList();
		em.getTransaction().commit();
		em.close();
		
		List<Club> resultado= new ArrayList<Club>();
		if(club.size()!=0) {
			for(Club e:club)
				resultado.add(toModelo(e));
		}
		return resultado;
					
		}

	Club toModelo(Club entity) {
		return new Club(entity.getIdClub(),entity.getNombre(),entity.getDireccion());
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Club> obtenerClubPorNombre(String nombre) throws ClubException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Club> club = (List<Club>) em.createQuery("from Club e where e.nombre = "+ nombre ).getResultList();
		em.getTransaction().commit();
		em.close();
	    
	    if(club!=null)
	    	return club;

	        throw new ClubException("No existe club con el nombre = "+nombre);
	}

	
	
	@SuppressWarnings("unchecked")
	public List<Jugador> obtenerJugadores(int idClub2) {
		List<Jugador> aux= new ArrayList<Jugador>();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		aux= (List<Jugador>) em.createQuery("from Jugador c where c.idClub = "+ idClub2 ).getResultList();
		
		em.getTransaction().commit();
		em.close();
		return aux;
	}

	@SuppressWarnings("unchecked")
	public List<Responsable> obtenerResponsables(Integer idClub2) {
		List<Responsable> aux= new ArrayList<Responsable>();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		aux= (List<Responsable>) em.createQuery(" from Responsable c where c.idClub = "+ idClub2 ).getResultList();
		
		em.getTransaction().commit();
		em.close();
		return aux;
	}
	
	
	
	public void actualizar(Club club) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(club);
		em.getTransaction().commit();
		em.close();
		
	}





}
