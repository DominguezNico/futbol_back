package daos;


import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exeptions.JugadorException;
import modelo.Jugador;



public class JugadorDAO implements Serializable {

	private static final long serialVersionUID = 7240568281685121535L;
	private EntityManagerFactory emf;
	
	/* SINGLETON */
	private static JugadorDAO instancia;
	
	
	private JugadorDAO() {
		emf = Persistence.createEntityManagerFactory("persistencia");
	}
	
	
	public static JugadorDAO getInstancia() {
		if(instancia ==null) {
			instancia = new JugadorDAO();
		}
		return instancia;		
	}
	/* FIN DEL SINGLETON*/

	public void grabar(Jugador jugador) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(jugador);
		em.getTransaction().commit();
		em.close();
	}
		
	@SuppressWarnings("unchecked")
	public List<Jugador> obtenerJugadores() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Jugador> jugadores = (List<Jugador>) em.createQuery("From Jugador").getResultList();
		em.getTransaction().commit();
		em.close();
		return jugadores;
				
	}
	
	public void habilitarJugador() {}
	public Integer crearListaJugadores(int idJugador,int idClub,int idCampeonato) {
		return null;
	}
	public void modificarJugador() {}
	
	public Jugador obtenerJugadorPorID(int id) throws JugadorException  {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Jugador jugador = (Jugador) em.createQuery("from Jugador e where e.idJugador = "+ id ).getSingleResult();
		em.getTransaction().commit();
		em.close();
	    
	    if(jugador!=null)
	    	return jugador;

	        throw new JugadorException("No existe jugador con id="+id);
	    }
	
	public void actualizar(Jugador jugador) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(jugador);
		em.getTransaction().commit();
		em.close();
	}
	
	public void eliminar(Jugador jugador) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.remove(jugador);
		em.getTransaction().commit();
		em.close();
		
	}

	public void eliminar2(Jugador jugador) {
	  EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.createQuery("Delete from Jugador j  where j.idJugador = "+ jugador.getIdJugador()) ;   
		em.getTransaction().commit();
		em.close();
	}
	public Jugador obtenerJugadorPorDNI(int dni) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
        Jugador jugador = (Jugador) em.createQuery("from Jugador e where e.documento = "+ dni).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return jugador;
        }
        catch (Exception e){
            return null;
        }
    }

}


