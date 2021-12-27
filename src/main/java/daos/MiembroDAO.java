package daos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.MiembroException;

import modelo.Miembro;



public class MiembroDAO implements Serializable {

	private static final long serialVersionUID = 6011519614085028531L;
	private EntityManagerFactory emf;
	
	private static MiembroDAO instancia;
	
	private MiembroDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	public static MiembroDAO getInstancia(){
		if (instancia == null){
			instancia = new MiembroDAO();
		}
		return instancia;
	}
	
	public void grabar(Miembro miembro) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(miembro);
		em.getTransaction().commit();
		em.close();
	}

	public Miembro obtenerMiembroPorId(int idMiembro) throws MiembroException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Miembro aux = (Miembro) em.createQuery("from Miembro e where e.idLista = " + idMiembro).getSingleResult();
		em.getTransaction().commit();
		em.close();
		if (aux != null) {
			return aux;
		}
		throw new MiembroException("No existe un miembro con ID = " + idMiembro);
	}

	public void actualizar(Miembro miembro) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(miembro);;
		em.getTransaction().commit();
		em.close();	
	}

	public void eliminar(Miembro miembro) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(miembro);
		em.getTransaction().commit();
		em.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Miembro> obtenerMiembros() throws MiembroException{
		 ArrayList<Miembro>aux=new ArrayList<Miembro>();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		aux= (ArrayList<Miembro>) em.createQuery("from Miembro " ).getResultList();
		em.getTransaction().commit();
		em.close();
		return aux;
	}

}
