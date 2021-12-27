package test;



import controlador.Controlador;
import exeptions.CampeonatoException;
import exeptions.ClubException;
import exeptions.JugadorException;
import exeptions.PartidoException;

public class testControladorSpring {

	public static void main(String[] args) throws JugadorException, ClubException, CampeonatoException, PartidoException {
		
		Controlador.getInstancia().inscribirClub(13,1);
		
		//test  en postman:
		
		/*localhost:8080/getFechaInicioCampeonato?idCampeonato=1
		localhost:8080/crearCampeonato?descripcion =camp&fechaInicio =10/05/2020&fechaFin =10/06/2020&estado=activo
		localhost:8080/getCampeonatobyID?id=1
		
		localhost:8080/getClub?idClub=16
		localhost:8080/modificarDireccionClub?idClub=1&direccion=Lomas
		localhost:8080/inscribirClubEnCampeonato?id=34&idCampeonato=5
		localhost:8080/getNombreClub?id=1
		localhost:8080/getInscriptos?idCampeonato=1
		localhost:8080/obtenerClubes
		
		localhost:8080/getFaltasJugador?idJugador=1
		localhost:8080/addFalta?minuto=1&tipo=a favor&idJugador=1&idPartido=1&idCampeonato=1
		
		localhost:8080/getGol?idGol=6
		localhost:8080/getGoles
		localhost:8080/getGolesJugador?idJugador=68
		localhost:8080/getTipoGol?idGol=6
		localhost:8080/getGolesJugador?idJugador=68
		localhost:8080/addGol?minuto=1&tipo=a favor&idJugador=68&idPartido=1
		
		
		localhost:8080/getJugador?idJugador=68
		localhost:8080/getJugadores
		localhost:8080/cambiarClubJugador?idJugador=68&idClub=1
		localhost:8080/addJugador?documento=123456&nombre=Andres&apellido=Torres&fechaNacimiento=10/05/1990&tipoDoc=D&idClub=1
	
		localhost:8080/getPartido?idPartido=1
		localhost:8080/getPartidos
		localhost:8080/modificarFechaPartido?fecha=07/10/2010&idPartido=2
		
		localhost:8080/agregarJugadorPartido?idClub=1&idPartido=1&idJugador=70
		localhost:8080/getJugadoresLocales?idPartido=1
		localhost:8080/actualizarIngresoJugador?idMiembro=1&ingreso=2
		localhost:8080/getMiembro?idMiembro=1
		
		localhost:8080/getGolesLocal?idPartido=1
		localhost:8080/getGolesVisitantel?idPartido=1
		localhost:8080/actualizarGolesLocal?idPartido=1&goles=4
		localhost:8080/actualizarGolesVisitante?idPartido=1&goles=6
		localhost:8080/agregarResponsable?documento=15469&nombre=JulioPerez&idClub=2
		localhost:8080/getResponsables
		localhost:8080/getResponsablesClub?idClub=1
		
		localhost:8080/obtenerTablaPosicionClub?idClub=1
		
			*/
		
		
		
		
		
}}
