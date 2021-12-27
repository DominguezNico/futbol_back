package daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import exeptions.CampeonatoException;
import modelo.Campeonato;

public class CampeonatoDAO implements Serializable {

	private static final long serialVersionUID = 7416167159369648743L;
	private EntityManagerFactory emf;
	
	/* SINGLETON */
	private static CampeonatoDAO instancia;
	
	
	private CampeonatoDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static CampeonatoDAO getInstancia() {
		if(instancia ==null) {
			instancia = new CampeonatoDAO();
		}
		return instancia;		
	}
	/* FIN DEL SINGLETON*/
	
	public void grabar(Campeonato campeonato) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(campeonato);
		em.getTransaction().commit();
		em.close();
	}
	

	
	public void actualizar(Campeonato campeonato) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(campeonato);
		em.getTransaction().commit();
		em.close();
	}
	
	
	 public Campeonato obtenerCampeonatoPorID(Integer id) throws CampeonatoException {
		 try{
			 EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				
				Campeonato campeonato = (Campeonato) em.createQuery("from Campeonato e where e.idCampeonato = "+ id ).getSingleResult();
				em.getTransaction().commit();
				em.close();
				return campeonato;
			  } catch(NoResultException e) {
			    return null;
			  }
	}
	 
	 
	 @SuppressWarnings("unchecked")
	public List<Campeonato> obtenerCampeonatos()  {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Campeonato> campeonato = (List<Campeonato>) em.createQuery("From Campeonato").getResultList();
		em.getTransaction().commit();
		em.close();
		return campeonato;
		
	}
	 
	
	 @SuppressWarnings("unchecked")
	public List<Campeonato> getInscriptos(int id )  {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Campeonato> resultados = (List<Campeonato>) em.createQuery("from  Campeonato  c  where c.idCampeonato = "+id).getResultList();
		em.getTransaction().commit();
		em.close();
		return resultados;	
			
		}
	
}
