package daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.tablaPosicionesException;
import modelo.tablaPosiciones;

public class tablaPosicionesDAO implements Serializable {

	private static final long serialVersionUID = 897987271013183042L;
	private EntityManagerFactory emf;
	
	/* SINGLETON */
	private static tablaPosicionesDAO instancia;
	
	private tablaPosicionesDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static tablaPosicionesDAO getInstancia() {
		if(instancia ==null) {
			instancia = new tablaPosicionesDAO();
		}
		return instancia;		
	}
	
	
	public void grabar(tablaPosiciones tabla) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(tabla);
		em.getTransaction().commit();
		em.close();
	}

	public tablaPosiciones buscarTabla(Integer idClubAux, Integer idCampeonato)throws tablaPosicionesException  {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		tablaPosiciones aux=(tablaPosiciones) em.createQuery(" from tablaPosiciones t where t.c = "+ idClubAux+" and t.camp = "+idCampeonato).getSingleResult();
		em.getTransaction().commit();
		em.close();
	    
		 if(aux!=null)
		    	return aux;
		 else
		    throw new tablaPosicionesException("No existe la tabla");
	
	}
	
	public void actualizar(tablaPosiciones tabla) throws tablaPosicionesException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(tabla);
		em.getTransaction().commit();
		em.close();
	
	}

	public List<tablaPosiciones> buscarTablaCampeonatos(Integer id)throws tablaPosicionesException  {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<tablaPosiciones> aux=(List<tablaPosiciones>) em.createQuery(" from tablaPosiciones t where t.camp = "+ id).getResultList();
		em.getTransaction().commit();
		em.close();
	    
		if(aux!=null)
	    	return aux;
	 else
	    throw new tablaPosicionesException("No existe la tabla");
	}
	
	@SuppressWarnings("unchecked")
	public List<tablaPosiciones> buscarTablaDeMiClub(int id)throws tablaPosicionesException{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<tablaPosiciones> aux=(List<tablaPosiciones>) em.createQuery(" from tablaPosiciones t where t.c = "+ id).getResultList();
		em.getTransaction().commit();
		em.close();
	    
		if(aux!=null)
	    	return aux;
	 else
	    throw new tablaPosicionesException("No existe la tabla");
	}
	
		public List<tablaPosiciones> obtenerTodo()throws tablaPosicionesException{
	        EntityManager em = emf.createEntityManager();
	        em.getTransaction().begin();
	        @SuppressWarnings("unchecked")
			List<tablaPosiciones> aux=(List<tablaPosiciones>) em.createQuery(" from tablaPosiciones ").getResultList();
	        em.getTransaction().commit();
	        em.close();

	        if(aux!=null)
	            return aux;
	     else {
	        return null;
	     }
	}
	
	 
	
}
