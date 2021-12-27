package daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.PartidoException;
import modelo.Falta;




public class FaltaDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1765536931441783569L;
	private EntityManagerFactory emf;
	
	/* SINGLETON */
	private static FaltaDAO instancia;


	private FaltaDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static FaltaDAO getInstancia() {
		if(instancia ==null) {
			instancia = new FaltaDAO();
		}
		return instancia;		
	}
	/* FIN DEL SINGLETON*/
	
	
	@SuppressWarnings("unchecked")
	public List<Falta> getFaltas() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Falta> jugadores = (List<Falta>) em.createQuery("From Falta").getResultList();
		em.getTransaction().commit();
		em.close();
		return jugadores;
		
	}
	public Falta obtenerFaltaPorID(int id) throws PartidoException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
	    Falta aux= (Falta) em.createQuery("from Falta e where e.idFalta = "+ id ).getSingleResult();
	   
	    em.getTransaction().commit();
		em.close();
		
	    if(aux!=null)
	    	return aux;

	        throw new PartidoException("No existe partido con id="+id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Falta> getCampeonatoFalta(int idCampeonato) {
		List<Falta> resultado = new ArrayList<Falta>();
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Falta> aux =(List<Falta>) em.createQuery("from Falta").getResultList(); /* da un 
		warning pero no pasa nada , le podes dar click derecho y "Supressed warning"*/
		List<Falta> aux2=new ArrayList<Falta>();
		for(Falta f:aux) {
			if(idCampeonato==f.getCampeonato().getIdCampeonato()) {
				aux2.add(f);
			}
		}
		em.getTransaction().commit();
		em.close();
	
		return resultado;
	}
	
	@SuppressWarnings("unchecked")
	public List<Falta> getFaltasJugador(int idJugador) {
		List<Falta> resultado = new ArrayList<Falta>();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
	
		List<Falta> aux =(List<Falta>) em.createQuery("from Falta").getResultList(); /* da un 
		warning pero no pasa nada , le podes dar click derecho y "Supressed warning"*/
		
		for(Falta f:aux) {
			if(idJugador==f.getJugador().getIdJugador()) {
				resultado.add(f);
			}
		}
		em.getTransaction().commit();
		em.close();

		return resultado;
	}
	
	public void grabar(Falta falta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(falta);
		em.getTransaction().commit();
		em.close();

	}
}
