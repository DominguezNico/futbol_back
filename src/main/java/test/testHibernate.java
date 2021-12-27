package test;

import controlador.Controlador;
import exeptions.CampeonatoException;
import exeptions.ClubException;
import exeptions.GolException;
import exeptions.JugadorException;
import exeptions.PartidoException;
import exeptions.ResponsableException;






public class testHibernate {

	public static void main(String[] args) throws CampeonatoException, PartidoException, ClubException, JugadorException, GolException, ResponsableException {
	
		//EL SIGUIENTE TEST TIENE METODOS PARA PROBAR LAS FUNCIONALIDADES DEL CONTROLADOR
		
		
		/*
		try {
			Controlador.getInstancia().agregarJugador(17542671, "Nicola", "Dominguez", 16, "D", 16 ,new Date(2000/12/12) );
			
			//Controlador.getInstancia().agregarJugador(documento, nombre, apellido, categoria, tipoDoc, idClub, fechaNacimiento)
		} catch (ClubException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		//List<Jugador> aux=Controlador.getInstancia().obtenerJugadores();
		
		/*
		Controlador.getInstancia().CrearCampeonato("Copa Local 3 ",new Date(2000/11/12) , new Date(2000/12/12) , "activo");
		
		try {
			List<Club> result= Controlador.getInstancia().getInscriptos(1);
	        for(Club c: result)
	            System.out.println(c.getNombre());
		} catch (ClubException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		/*
		Controlador.getInstancia().agregarFalta(3,15,1,10,"Manoplaa"); 
		List<Falta> faltas=Controlador.getInstancia().getFaltas();
		for(Falta u: faltas)
			System.out.println(u.toString());*/
		/*
		List<Falta> faltas=Controlador.getInstancia().getFaltas();
		for(Falta f: faltas) {
			System.out.println(f.toString());
		}*/
		/*
		List<Falta> faltas=Controlador.getInstancia().getFaltasJugador(17);
		for(Falta f: faltas) {
			System.out.println(f.toString());
		}*/
		/*
		List<Falta> faltas=Controlador.getInstancia().getCampeonatoFaltas(1);
		for(Falta f: faltas) {
			System.out.println(f.toString());
		}
		
		*/
		
		//Controlador.getInstancia().agregarJugador(18544671,"Vanina","Vernucci", "D",1, new Date(2000/12/12) );    
		
		
		//Controlador.getInstancia().CrearCampeonato("Copa Local 11 ",new Date(2000/11/12) , new Date(2000/12/12) , "activo");
		//Controlador.getInstancia().crearClub(273,"BocaJuniors","AsA");
		
		
		
		
		
	//	Controlador.getInstancia().eliminarResponsable(13);
		
	//	Controlador.getInstancia().eliminarJugador(68, 2);
		
		//Controlador.getInstancia().deshabilitarJugador(16);
		
		//Controlador.getInstancia().agregarGol(68, 1, 0,"a favor");
		
		//habilitarJugador( 68, 1, 1)
		
		
		//Controlador.getInstancia().agregarResponsable("12456789", "JuanPerez", 16);
		//System.out.println( );
		
		/*
		Date fecha=Controlador.getInstancia().getFechaInicioCampeonato(1);
		Date fecha2=Controlador.getInstancia().getFechaFinCampeonato(1);
		System.out.println("fecha inicio "+fecha+  "  fecha fin  "+fecha2);
		
		String estado= Controlador.getInstancia().getEstadoCampeonato(19);
		System.out.println("Estado  "+estado);
		*/
		
		/*
		String nombreClub=Controlador.getInstancia().getNombreClub(1);
		String direccionClub=Controlador.getInstancia().getDireccionClub(1);
		System.out.println(nombreClub+"   "+direccionClub);
		
		
		//CAMBIAR DIRECCION DE UN CLUB:
		Controlador.getInstancia().setClub(138, "DD");*/
		
		
	
		/*
		List<Club> c= Controlador.getInstancia().obtenerClubesCampeonato(1);
		System.out.println("Clubes que forman parte del Campeonato "+1);
		for(Club club:c)
			System.out.println(club.getNombre());
		
*/
		
		/* Controlador.getInstancia().getInscriptos(1);*/

		
		//Controlador.getInstancia().agregarPartido(1, 2, 1, 1, 16, new Date(2000/12/12), 1);
		//Controlador.getInstancia().obtenerPartidoPorId(1);
		//Controlador.getInstancia().agregarJugadorVisitante(16, 1, 68);
		//List<Miembro> aux= Controlador.getInstancia().obtenerJugadoresVisitantes(1);
		
		
		//Controlador.getInstancia().actualizarGolesLocal(1, 1);
		//System.out.println(Controlador.getInstancia().obtenerGolesLocal(1));
		
		
		//Controlador.getInstancia().obtenerResponsablesClub(1);
		
		/*
		List<Jugador> aux=Controlador.getInstancia().getJugadores();
		
		for(Jugador j: aux) {
			System.out.println(j.toString());
		}*/
		
		/*JugadorVO x=(JugadorVO) Controlador.getInstancia().getObjetoPorDNI("1");*/
        /*System.out.println(x.getId());*/
        
		System.out.println(Controlador.getInstancia().crearUsuario("10", "123"));
	}
}
