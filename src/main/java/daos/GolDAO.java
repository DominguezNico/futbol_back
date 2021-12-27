package daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.GolException;
import modelo.Gol;


public class GolDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3425496236806861832L;
	private EntityManagerFactory emf;
	/* SINGLETON */
	private static GolDAO instancia;
	
	private GolDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static GolDAO getInstancia() {
		if(instancia ==null) {
			instancia = new GolDAO();
		}
		return instancia;		
	}
	/* FIN DEL SINGLETON*/
	

	public Gol obtenerGolPorID(int id) throws GolException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    Gol aux= (Gol) em.createQuery("from Gol e where e.idGol = "+ id ).getSingleResult();
	    em.getTransaction().commit();
		em.close();
		
	    if(aux!=null)
	    	return aux;

	    throw new GolException("No existe un gol con id ="+id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Gol> getGoles() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Gol> gol = (List<Gol>) em.createQuery("From Gol").getResultList();
		em.getTransaction().commit();
		em.close();
		return gol;
			
	}

	@SuppressWarnings("unchecked")
	public List<Gol> getGolesJugador(int idJugador) {
		List<Gol> resultado = new ArrayList<Gol>();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
		List<Gol> aux =(List<Gol>) em.createQuery("from Gol").getResultList(); /* da un 
		warning pero no pasa nada , le podes dar click derecho y "Supressed warning"*/
		List<Gol> aux2=new ArrayList<Gol>();
		for(Gol f:aux) {
			if(idJugador==f.getJugador().getIdJugador()) {
				aux2.add(f);
			}
		}
		em.getTransaction().commit();
		em.close();
		if(aux2.size() != 0) { //significa que la lista esta vacia 
			for(Gol e: aux2)
				resultado.add(e); //agarra cada elemento de la coleccion y lo guarda
		}
		return resultado;
	}
	
	public void grabar(Gol gol) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(gol);
		em.getTransaction().commit();
		em.close();

	}
}
