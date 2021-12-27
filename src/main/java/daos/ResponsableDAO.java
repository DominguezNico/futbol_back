package daos;


import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.ResponsableException;
import modelo.Responsable;

public class ResponsableDAO implements Serializable{

	private static final long serialVersionUID = -7806359351640333699L;
	private EntityManagerFactory emf;
	
	private static ResponsableDAO instancia;
	
	private ResponsableDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static ResponsableDAO getInstancia(){
	if (instancia == null){
		instancia = new ResponsableDAO();
	}
	return instancia;
	}
	
	public void grabar(Responsable responsable) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(responsable);
		em.getTransaction().commit();
		em.close();
	}
	
	public Responsable obtenerResponsablePorId(int id) throws ResponsableException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Responsable aux = (Responsable) em.createQuery("from Responsable e where e.legajo = " + id).getSingleResult();
		em.getTransaction().commit();
		em.close();
		if (aux != null) {
			return aux;
		}
		throw new ResponsableException("No existe un responsable con ID = " + id);
	}

	public void eliminar(Responsable responsable) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.detach(responsable);
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Responsable> obtenerResponsables() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
        ArrayList<Responsable>aux= (ArrayList<Responsable>) em.createQuery("from Responsable " ).getResultList();
        em.getTransaction().commit();
		em.close();
		
        return aux;
	}
	public Responsable obtenerResponsablePorDNI(String dni) throws ResponsableException {
        EntityManager em = emf.createEntityManager();
        try {
        em.getTransaction().begin();
        Responsable aux = (Responsable) em.createQuery("from Responsable e where e.documento = " + dni).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return aux;
        }
        catch (Exception e) {
         return null;
        }
    }
}
