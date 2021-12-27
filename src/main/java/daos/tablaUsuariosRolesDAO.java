package daos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import modelo.tablaUsuariosRoles;

public class tablaUsuariosRolesDAO implements Serializable {

	private static final long serialVersionUID = -7806359351640333699L;
	private EntityManagerFactory emf;
	
	private static tablaUsuariosRolesDAO instancia;
	
	private tablaUsuariosRolesDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	
	
	
	
	public static tablaUsuariosRolesDAO getInstancia() {
		if(instancia ==null) {
			instancia = new tablaUsuariosRolesDAO();
		}
		return instancia;		
	}
	
	
	//cuando crea un LOG IN por primera vez,crea esa fila.
	public void grabar(tablaUsuariosRoles t) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	
	//me devuelve la fila del rol+doc+contraseña ( el objeto)
	public tablaUsuariosRoles obtenerUsuarioPorDocumento(String doc)  {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		tablaUsuariosRoles aux = (tablaUsuariosRoles) em.createQuery("from tablaUsuariosRoles e where e.documento = " + doc).getSingleResult();
		em.getTransaction().commit();
		em.close();
		if (aux == null) {
			return null;
		}
		else {
		return aux;}
	}
	
	
	public void actualizar(tablaUsuariosRoles t) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();	
	}
	
	 @SuppressWarnings("unchecked")
	 public List<tablaUsuariosRoles> obtenerUsuarios()   {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<tablaUsuariosRoles> t = (List<tablaUsuariosRoles>) em.createQuery("From tablaUsuariosRoles").getResultList();
		em.getTransaction().commit();
		em.close();
		
		
		return t;
					
		}
	 
	 

}


