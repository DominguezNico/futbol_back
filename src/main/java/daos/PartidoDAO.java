package daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.PartidoException;
import modelo.Partido;

public class PartidoDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3465174713453310654L;
	private EntityManagerFactory emf;
	
	/* SINGLETON */
	private static PartidoDAO instancia;
	
	private PartidoDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static PartidoDAO getInstancia() {
		if(instancia ==null) {
			instancia = new PartidoDAO();
		}
		return instancia;		
	}
	/* FIN DEL SINGLETON*/
	
	public Partido obtenerPartidoPorID(int id) throws PartidoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	    Partido aux= (Partido) em.createQuery("from Partido e where e.idPartido = "+ id ).getSingleResult();
	    em.getTransaction().commit();
		em.close();
	    
	    if(aux!=null)
	    	return aux;
	    else
	        throw new PartidoException("No existe partido con id="+id);
	    }
	
	
	public void grabar(Partido partido) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(partido);
		em.getTransaction().commit();
		em.close();
	}

	
	@SuppressWarnings("unchecked")
	public List<Partido> obtenerPartidos() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        List<Partido>aux= (List<Partido>) em.createQuery("from Partido " ).getResultList();
        em.getTransaction().commit();
		em.close();
        return aux;
	}

	public void actualizar(Partido partido) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(partido);
		em.getTransaction().commit();
		em.close();
	}

	public void eliminar(Partido partido) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.detach(partido);
		em.getTransaction().commit();
		em.close();
		
	}
	
	
	public Partido obtenerPartidoPorFecha(String fecha) throws PartidoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
	    Partido aux= (Partido) em.createQuery("from Partido e where e.fechaPartido = "+ "'"+fecha+"'").getSingleResult();
	    em.getTransaction().commit();
		em.close();
	    
	    if(aux!=null)
	    	return aux;
	    else
	        throw new PartidoException("No existe partido ");
	    }
	
}
