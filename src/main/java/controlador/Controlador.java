package controlador;


import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import daos.CampeonatoDAO;
import daos.ClubDAO;
import daos.FaltaDAO;
import daos.GolDAO;
import daos.JugadorDAO;
import daos.MiembroDAO;
import daos.PartidoDAO;
import daos.ResponsableDAO;
import daos.tablaPosicionesDAO;
import daos.tablaUsuariosRolesDAO;
import exeptions.CampeonatoException;
import exeptions.ClubException;
import exeptions.FaltaException;
import exeptions.GolException;
import exeptions.JugadorException;
import exeptions.MiembroException;
import exeptions.PartidoException;
import exeptions.ResponsableException;
import exeptions.tablaPosicionesException;
import modelo.Campeonato;
import modelo.Club;
import modelo.Falta;
import modelo.Gol;
import modelo.Jugador;
import modelo.Miembro;
import modelo.Partido;
import modelo.Responsable;
import modelo.tablaPosiciones;
import modelo.tablaUsuariosRoles;
import vo.CampeonatoVO;
import vo.ClubVO;
import vo.FaltaVO;
import vo.GolVO;
import vo.JugadorVO;
import vo.MiembroVO;
import vo.PartidoVO;
import vo.ResponsableVO;
import vo.tablaPosicionesVO;

public class Controlador {
 
	/*
	 * Notas:
	 * 
	 * -Pueden si lo desean convertir el controlador en un Singleton
	 * 
	 * -Deberan completar los metodos del controlador para que cumplan con los requerimientos
	 *  del trabajo, Recuerden siempre aplicar los patrones GRASP para verificar la correcta 
	 *  asignacion de lasresponsabilidades
	 *  
	 * -En la segunda parate del trabajo deber'an agragar los metodos y controles que 
	 *  considen necesarios. */

	
	/* INICIO DEL SINGLETON */
	private static Controlador instancia;
	
	private Controlador() {}
	
	public static Controlador getInstancia() {
		if(instancia == null) {
			instancia = new Controlador ();
		}
		return instancia;
	}
	/* FIN DEL SINGLETON */	

	
	
	
	
	/*INICIO METODOS DE FALTA */
	public void agregarFalta(int idPartido,int idJugador,int idCampeonato,int minuto,String tipo) throws CampeonatoException, JugadorException, PartidoException {
		Jugador j=obtenerJugadorPorID(idJugador);
		if(j!=null) {
		Falta falta=new Falta(j,obtenerPartidoPorID(idPartido),obtenerCampeonatoPorId(idCampeonato),minuto,tipo);
		falta.grabar();
		j.agregarFalta(falta);
		}
	}
	public List<Falta> getFaltas() {
		return FaltaDAO.getInstancia().getFaltas();
		
	}
	public Falta getFaltaPorID(int id) throws FaltaException, PartidoException  {
		return FaltaDAO.getInstancia().obtenerFaltaPorID(id);
	}
	public List<Falta> getCampeonatoFaltas(int idCampeonato) {
		return FaltaDAO.getInstancia().getCampeonatoFalta(idCampeonato);
	}
	public List<Falta> getFaltasJugador(int idJugador) {
		
		return FaltaDAO.getInstancia().getFaltasJugador(idJugador);
	}
	
	public FaltaVO getFaltaVOPorID(int id) throws FaltaException, PartidoException {
		return FaltaDAO.getInstancia().obtenerFaltaPorID(id).toVO();
	}
	
	public List<FaltaVO> getFaltasVP()  {
		List<Falta> aux=FaltaDAO.getInstancia().getFaltas();
		List<FaltaVO> resultado=new ArrayList<FaltaVO>();
		
		for(Falta j: aux) {
			resultado.add(j.toVO());
		}
		
		return resultado;
	}
	
	public List<FaltaVO> getFaltasVOCampeoanto(Integer id)  {
		List<Falta> aux=FaltaDAO.getInstancia().getCampeonatoFalta(id);
		List<FaltaVO> resultado=new ArrayList<FaltaVO>();
		
		for(Falta j: aux) {
			resultado.add(j.toVO());
		}
		
		return resultado;
	}
	
	public List<FaltaVO> getFaltasVOJugador(int id)  {
		List<Falta> aux=FaltaDAO.getInstancia().getFaltasJugador(id);
		List<FaltaVO> resultado=new ArrayList<FaltaVO>();
		
		for(Falta j: aux) {
			resultado.add(j.toVO());
		}
		
		return resultado;
	}
	/*FIN METODOS DE FALTA */
	
	
	
	
	
	
	/*INICIO METODOS DE GOL */
	
	public void agregarGol(Integer idJugador, Integer idPartido,int minuto,String tipo) throws JugadorException, PartidoException {
		Jugador j=obtenerJugadorPorID(idJugador);
		Partido p= obtenerPartidoPorId(idPartido);
		if(j!=null && p!=null) {
		Gol gol=new Gol(j,p , minuto, tipo);
		gol.grabar();
		j.agregarGol(gol);
		}
	}
	public Gol getGolPorID(int id) throws GolException {
		return GolDAO.getInstancia().obtenerGolPorID(id);
	}
	public List<Gol> getGoles() {
		return GolDAO.getInstancia().getGoles();
	}
	public Integer getMinutoGol(int idGol) throws GolException {
		return GolDAO.getInstancia().obtenerGolPorID(idGol).getMinuto();
	}
	public String getTipoGol(int idGol) throws GolException {
		return GolDAO.getInstancia().obtenerGolPorID(idGol).getTipo();
	}
	public Partido getPartidoGol(int idGol) throws GolException {
		return GolDAO.getInstancia().obtenerGolPorID(idGol).getPartido();
	}
	public List<Gol> getGolesJugador(int idJugador) {
		return GolDAO.getInstancia().getGolesJugador(idJugador);
	}
	
	
	
	public GolVO getGolVOPorID(int id) throws GolException {
		return GolDAO.getInstancia().obtenerGolPorID(id).toVO();
	}
	
	public List<GolVO> getGolesVO()  {
		List<Gol> aux=GolDAO.getInstancia().getGoles();
		List<GolVO> resultado=new ArrayList<GolVO>();
		
		for(Gol j: aux) { 
			resultado.add(j.toVO());
		}
		
		return resultado;
	}
	
	public List<GolVO> getGolesVOJugador(int id)  {
		List<Gol> aux=GolDAO.getInstancia().getGolesJugador(id);
		List<GolVO> resultado=new ArrayList<GolVO>();
		
		for(Gol j: aux) {
			resultado.add(j.toVO());
		}
		
		return resultado;
	}
	
	public int obtenerGolesLocal(int idPartido) throws PartidoException {
		Partido p = obtenerPartidoPorId(idPartido);
		return p.getGolesLocal();
	}
	
	
	
	public int obtenerGolesVisitante(int idPartido) throws PartidoException {
		Partido p = obtenerPartidoPorId(idPartido);
		return p.getGolesVisitante();
	}
	
	/*FIN METODOS DE GOL */
	
	
	
	
	/*INICIO METODOS DE JUGADOR */
	
	public void agregarJugador(Integer documento, String nombre,String apellido,String tipoDoc, int idClub, String fechaNacimiento) throws ClubException, JugadorException {
		Club cl=obtenerClub(idClub);
		if(cl!=null) {
		Jugador jugador = new Jugador(documento, nombre, apellido,cl,tipoDoc, fechaNacimiento);
		jugador.setPermaneceClub("SI");
		jugador.setEstadoJugador("activo");
		jugador.grabar();
		cl.agregarJugador(jugador);	
		
		}
	}
	
	 public void permanecerJugadorClub(int idJugador,int idClub) throws JugadorException {
		 Jugador j= JugadorDAO.getInstancia().obtenerJugadorPorID(idJugador);
	      j.setPermaneceClub("SI");
	      JugadorDAO.getInstancia().actualizar(j);
	    }
	 
	 public void quitarJugadorClub(int idJugador,int idClub) throws JugadorException {
	        Jugador j= JugadorDAO.getInstancia().obtenerJugadorPorID(idJugador);
	        j.setPermaneceClub("NO");
	        j.setEstadoJugador("inactivo");
	        JugadorDAO.getInstancia().actualizar(j);
	    }

	public List<Jugador> getJugadores(){
		return JugadorDAO.getInstancia().obtenerJugadores();
	}
	
	
	
	public List<JugadorVO> getJugadoresVOHabilitadosClub(int idClub) throws ClubException{
		List<Jugador> jugadores = getJugadores();
		List<JugadorVO> jugadoresClub = new ArrayList<JugadorVO>();
		for (Jugador j: jugadores) {
			if (j.getClub().getIdClub() == idClub && j.getEstadoJugador().equals("activo")) {
				jugadoresClub.add(j.toVO());
			}
		}
		return jugadoresClub;
	}
	
	public Jugador obtenerJugadorPorID(int id) throws JugadorException {
		return JugadorDAO.getInstancia().obtenerJugadorPorID(id);
	}
	
	public List<JugadorVO> getJugadoresVOClub(int idClub) throws ClubException{
        List<Jugador> jugadores = getJugadores();
        List<JugadorVO> jugadoresClub = new ArrayList<JugadorVO>();
        String si="SI";
        for (Jugador j: jugadores) {
            if ((j.getClub().getIdClub() == idClub) && (j.getPermaneceClub().equals(si)) ) {
                jugadoresClub.add(j.toVO());
                System.out.println(j.toVO().toString());

            }
        }
        return jugadoresClub;
    }
	
	
	
	public void eliminarJugador(int idJugador, int idClub) throws JugadorException, ClubException {
		Jugador jugador=obtenerJugadorPorID(idJugador);
		Club club=obtenerClub(idClub);
		if(jugador!=null && club!=null) {
		jugador.eliminar();
		club.eliminarJugador(jugador);
		}
	}
	
	
	
	public void cambiarClubJugador(int idJugador,int idClub) throws ClubException, JugadorException {
		Jugador j=obtenerJugadorPorID(idJugador);
		Club c=obtenerClub(idClub);
		if(j!=null && c!=null) {
		j.cambiarClub(obtenerClub(idClub));}
		
	}
	
	//agrega jugador al club
	 public void habilitarJugador(int idJugador, int idClub, int idCampeonato) throws ClubException, CampeonatoException, JugadorException {
			Jugador jugador=obtenerJugadorPorID(idJugador);
			Club club=obtenerClub(idClub);
			Campeonato camp=obtenerCampeonatoPorId(idCampeonato);
			if(jugador!=null && club!=null &&camp!=null) {
			List<Club> clubesCampeonato=obtenerClubesCampeonato(idCampeonato);
			for(Club c: clubesCampeonato)
				if(c.getIdClub()==idClub)
					club.agregarJugador(jugador);// me agrega y me actualiza 
			}		
	    }
	
	 
	 
	 
	
	//agrego un miembro: agregar jugador a partido 
	 //antes debo ver que no tenga falta roja en ese campeonato
	 public int agregarJugadoresEnLista(int idClub, int idPartido, int idJugador) throws ClubException, JugadorException, PartidoException, MiembroException {
	        int check = 0;
	        Partido p = obtenerPartidoPorId(idPartido);
	        Club c = obtenerClub(idClub);
	        Jugador j = obtenerJugadorPorID(idJugador);
	        if(p!=null && c!=null && j!=null) {
	        boolean control=estoyHabilitado(idJugador, idPartido);
	        boolean controlFecha=verificarFechaPartido( idJugador, idPartido);
	        if (control==true && controlFecha==true)
	            check = c.agregarJugadoresLista(p, j);
	        else 
	            check=1;
	        }
	        else {
	            check=1;
	        }
	        return check;
	    }
	
	//tomo las faltas del jugador 
	//veo si es roja y obtengo el campeonato asociado a la falta. Si ese campeonato es el mismo que el del partido parametro, lo deshabilito
	public boolean estoyHabilitado(int idJugador,int idPartido) throws PartidoException {
		boolean habilitado=true;
		Partido p = obtenerPartidoPorId(idPartido);
		List<Falta> faltasJugador=getFaltasJugador( idJugador) ;
		for(Falta f: faltasJugador) {
			if (  (f.getTipo()=="roja") && (f.getCampeonato().getIdCampeonato()==p.getCampeonato().getIdCampeonato() ) )
				habilitado=false;	
		}
		return habilitado;
		 
	}
	
	//cuando inscribo un jugador  a un partido, debo ver que la fecha de este nuevo partido no coincida con las fechas de partidos donde esta este jugador
	
	public boolean verificarFechaPartido(int idJugador,int idPartido) throws PartidoException, MiembroException {
		boolean check=true;
		Partido p = obtenerPartidoPorId(idPartido);
		String fechaPartido=p.getFechaPartido();
		
		List<Miembro> miembros=MiembroDAO.getInstancia().obtenerMiembros();
		if(miembros.size()!=0) {
		for(Miembro m :miembros) {
			Partido partidoLista=m.getPartido();
			Jugador j=m.getJugador();
			if( (  j.getIdJugador()==idJugador)  && (partidoLista.getFechaPartido().equals(fechaPartido))) {
				check=false;
				System.out.println("NO PUEDE AGREGARSE");}
		}
		}
			
		return check;
		 
		 
	}
	
	//DEL FRONT SE PUEDE TRAER LISTA D ESTRING
	//estadisticas de jugadores por  club o campeonato
	public List<String> confeccionarEstadisticasJugador(int idClub) throws ClubException, tablaPosicionesException {
		//obtener lista de jugadores de ese club con goles, lista de faltas,
		Club club= this.obtenerClub(idClub);
		List<String> resultado= new ArrayList<String>();
		if(club !=null) {
			List<Jugador> jugadores= club.getJugadores();
			for(Jugador j:jugadores) {
				List<Falta> faltasJugador=j.getFaltas();
				List<Gol> golesJugador=j.getGoles();
				String datos="FALTAS = "+faltasJugador.size()+" GOLES = "+golesJugador.size()+ "PARTIDOS GANADOS = "+obtenerCantidadPartidosGanados(idClub) +" PARTIDOS PERDIDOS = "+obtenerCantidadPartidosPerdidos(idClub);
				resultado.add(datos);		
			}
		}
		return resultado;
	}
	
	
	public int obtenerCantidadPartidosGanados(int idClub) throws ClubException, tablaPosicionesException {
		Club c= this.obtenerClub(idClub);
		int cantidadGanados=0;
		if(c!=null) {
			List<tablaPosiciones> aux=this.consultarAvanceClub2(idClub);
			if(aux!=null) {
				for(tablaPosiciones t:aux )
					cantidadGanados=cantidadGanados+t.getCantidadganados();
			}
		}
		return cantidadGanados;
	}
	
	
	
	public int obtenerCantidadPartidosPerdidos(int idClub) throws ClubException, tablaPosicionesException {
		Club clubAux= this.obtenerClub(idClub);
		int c=0;
		if(clubAux!=null) {
			List<tablaPosiciones> aux=this.consultarAvanceClub2(idClub);
			if(aux!=null) {
					for(tablaPosiciones t:aux )
						c=c+t.getCantidadperdidos();
			}
		}
		return c;
	}
	
	
	private List<tablaPosiciones> consultarAvanceClub2(int idClub) throws ClubException, tablaPosicionesException{
		Club clubAux= this.obtenerClub(idClub);
		List<tablaPosiciones> aux=new ArrayList<tablaPosiciones>();
		if(clubAux!=null) {
		 aux= tablaPosicionesDAO.getInstancia().buscarTablaDeMiClub(idClub);
		 return aux;
		}
		else
			return aux;
	}
	
	public JugadorVO getJugadorVOByID(int id) throws JugadorException  {
		return JugadorDAO.getInstancia().obtenerJugadorPorID(id).toVO();
	}
	
	public List<JugadorVO> getJugadoresVO()  {
		List<Jugador> aux=JugadorDAO.getInstancia().obtenerJugadores();
		List<JugadorVO> resultado=new ArrayList<JugadorVO>();
		
		for(Jugador j: aux) {
			resultado.add(j.toVO());
		}
		
		return resultado;
	}
	
	public void habilitarJugador(int id) throws JugadorException {
		Jugador j=obtenerJugadorPorID(id);
		if(j!=null) {
		j.setEstadoJugador("activo");
		JugadorDAO.getInstancia().actualizar(j);
		}
		List<Partido> partidos = this.obtenerPartidosClubModelo(j.getClub().getIdClub());
		Calendar hoy = Calendar.getInstance();
		Calendar partido = Calendar.getInstance();
		for (Partido p: partidos) {
			String[] fecha = p.getFechaPartido().split("/");
			partido.set(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1])-1, Integer.parseInt(fecha[0]), 0, 0);
			if (partido.after(hoy)) {
				System.out.println(partido.getTime());
				System.out.println(hoy.getTime());
				List<Miembro> locales = p.getJugadoresLocales();
				List<Miembro> visitantes = p.getJugadoresVisitantes();
				for (Miembro m: locales) {
					if (m.getJugador().getIdJugador().equals(id)) {
						m.setEstadoJugadorPartido("activo");
						MiembroDAO.getInstancia().actualizar(m);
					}
				}
				for (Miembro m: visitantes) {
					if (m.getJugador().getIdJugador().equals(id)) {
						m.setEstadoJugadorPartido("activo");
						MiembroDAO.getInstancia().actualizar(m);
					}
				}
			}
		}
	}
	
	public void deshabilitarJugador(int id) throws JugadorException {
		Jugador j=obtenerJugadorPorID(id);
		if(j!=null) {
		j.setEstadoJugador("inactivo");
		JugadorDAO.getInstancia().actualizar(j);
		}
		List<Partido> partidos = this.obtenerPartidosClubModelo(j.getClub().getIdClub());
		Calendar hoy = Calendar.getInstance();
		Calendar partido = Calendar.getInstance();
		for (Partido p: partidos) {
			String[] fecha = p.getFechaPartido().split("/");
			partido.set(Integer.parseInt(fecha[2]), Integer.parseInt(fecha[1])-1, Integer.parseInt(fecha[0]), 0, 0);
			if (partido.after(hoy)) {
				System.out.println(partido.getTime());
				System.out.println(hoy.getTime());
				List<Miembro> locales = p.getJugadoresLocales();
				List<Miembro> visitantes = p.getJugadoresVisitantes();
				for (Miembro m: locales) {
					if (m.getJugador().getIdJugador().equals(id)) {
						m.setEstadoJugadorPartido("inactivo");
						MiembroDAO.getInstancia().actualizar(m);
					}
				}
				for (Miembro m: visitantes) {
					if (m.getJugador().getIdJugador().equals(id)) {
						m.setEstadoJugadorPartido("inactivo");
						MiembroDAO.getInstancia().actualizar(m);
					}
				}
			}
		}
	}
	
	private List<Partido> obtenerPartidosClubModelo(int idClub){
        List<Partido> lista = PartidoDAO.getInstancia().obtenerPartidos();
        List<Partido> resultado = new ArrayList<Partido>();
		for (Partido p: lista) {
        	if (p.getClubLocal().getIdClub().equals(idClub)) 
        		resultado.add(p);
        	else if(p.getClubVisitante().getIdClub().equals(idClub))
        		resultado.add(p);
        	//System.out.println(p.toVO().toString());
        }
       return resultado;
	}
	public void cambiarTelefonoJugador(int id,Integer telefono) throws JugadorException {
		Jugador j=obtenerJugadorPorID(id);
		if(j!=null) {
		j.setTelefono(telefono);
		JugadorDAO.getInstancia().actualizar(j);}
	}
	
	public void cambiarMailJugador(int id,String mail) throws JugadorException {
		Jugador j=obtenerJugadorPorID(id);
		j.setMail(mail);
		JugadorDAO.getInstancia().actualizar(j);
	}
	
	public void cambiarDireccionJugador(int id,String direc) throws JugadorException {
		Jugador j=obtenerJugadorPorID(id);
		j.setDireccion(direc);
		JugadorDAO.getInstancia().actualizar(j);
	}
	
	
	
	/* FIN METODOS JUGADOR*/
	
	
	
	
		
	
	
	
	
	/* INICIO METODOS DEL CAMPEONATO*/
	
	public Campeonato CrearCampeonato(String descripcion, Date fechaInicio, Date fechaFin, String estado) {
		Campeonato nuevo= new Campeonato(descripcion,fechaInicio,fechaFin,estado);
		nuevo.grabar();
		return nuevo;
	}
	
	 private List<Campeonato> obtenerCampeonatos(){
			List<Campeonato> aux=CampeonatoDAO.getInstancia().obtenerCampeonatos();
			return aux;
		}
	
	 public List<CampeonatoVO> getCampeonatos(){
		 List<Campeonato> aux=CampeonatoDAO.getInstancia().obtenerCampeonatos();
		 List<CampeonatoVO> result=new ArrayList<CampeonatoVO>();
		 for (Campeonato c: aux)
			 result.add(c.toVO());
		 return result;
	 }
	 
	public Date getFechaInicioCampeonato(int id) throws CampeonatoException
	{
	Campeonato actual=obtenerCampeonatoPorId(id);	
	if(actual!=null)
		return  actual.getFechaInicio();
	else 
		return null;
	
	}
	
	
	public Date getFechaFinCampeonato(int id) throws CampeonatoException
	{
	Campeonato actual=obtenerCampeonatoPorId(id);	
	if(actual!=null)
		return (Date) actual.getFechaFin();
	else 
		return null;
	
	}
	
	private Campeonato obtenerCampeonatoPorId(int id) throws CampeonatoException {
		Campeonato camp=CampeonatoDAO.getInstancia().obtenerCampeonatoPorID(id);
		
		return camp;
	}
	
	public CampeonatoVO obtenerCampeonatoVOPorId(int id) throws CampeonatoException {
		Campeonato camp=CampeonatoDAO.getInstancia().obtenerCampeonatoPorID(id);
		CampeonatoVO campVO=camp.toVO();
		return campVO;
	}
	
	public String getEstadoCampeonato(int id) throws CampeonatoException {
		Campeonato actual=obtenerCampeonatoPorId(id);	
		//System.out.println(actual.getIdCampeonato());
		if(actual!=null)
			return actual.getEstado();
		else 
			return null;
		
	}
	
	public String getDescripcionCampeonato(int id) throws CampeonatoException {
		Campeonato actual=obtenerCampeonatoPorId(id);	
		if(actual!=null)
			return actual.getDescripcion();
		else 
			return null;
		
	}
	
	
	public List<tablaPosicionesVO> obtenerTablaPosicionCampeonato(int idCampeonato) throws CampeonatoException, tablaPosicionesException {
		Campeonato campe=this.obtenerCampeonatoPorId(idCampeonato);
		List<tablaPosicionesVO> resultado=new ArrayList<tablaPosicionesVO>();
		if(campe!=null) {
		List<tablaPosiciones> tablas= tablaPosicionesDAO.getInstancia().buscarTablaCampeonatos(idCampeonato);
		tablaPosicionesVO actual;
		for(tablaPosiciones t:tablas) {
			 actual=t.toVO();
			 resultado.add(actual);
		}
		
		return resultado;
		}
		else
			return resultado;
	}
	

	public void iniciarTablaPosicionesCampeonato(int idCampeonato) throws CampeonatoException, ClubException {
		Campeonato c= obtenerCampeonatoPorId(idCampeonato);
		if(c!=null) {
		List<Club> aux= c.getInscriptos();
		for(Club clubAux:aux) {
			tablaPosiciones tablaNueva= new tablaPosiciones( c,0, 0, 0, 0, 0, 0,0,0,(float) 0);
			tablaNueva.grabar();
			//System.out.println(clubAux.toString());
			try {
				tablaNueva.insertarClube(clubAux);
			} catch (tablaPosicionesException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	}
	
	//Cuando se termina de jugar  un nuevo partido, se actualiza tablaPosiciones
	public void actualizarTablaPosiciones(int idPartido) throws PartidoException, tablaPosicionesException {
		Partido partido=obtenerPartidoPorID(idPartido);
		if(partido!=null) {
		int campeonatoAsociadoAlPartido=partido.getCampeonato().getIdCampeonato();
		
		int idClubLocal= partido.getClubLocal().getIdClub();
		int idClubVisitante=partido.getClubVisitante().getIdClub();
				
		//System.out.println("CLUBES  "+idClubLocal+"   "+idClubVisitante);
				
		int golesLocal=partido.getGolesLocal();
		int golesVisitante=partido.getGolesVisitante();
				
		//System.out.println("GOLES   "+partido.getGolesVisitante()+"   "+partido.getGolesLocal());
		//System.out.println("CAMPEONATO  "+campeonatoAsociadoAlPartido+"  CLUB  "+idClubVisitante);
				
		//DAO ME TRAE TABLA POSICIONESde cada club
		System.out.println("CLUB:"+idClubLocal+"  "+idClubVisitante+"  CAMP "+campeonatoAsociadoAlPartido);
		tablaPosiciones local= tablaPosicionesDAO.getInstancia().buscarTabla(idClubLocal,campeonatoAsociadoAlPartido);
		tablaPosiciones visitante = tablaPosicionesDAO.getInstancia().buscarTabla(idClubVisitante,campeonatoAsociadoAlPartido);
		
		
		
		
		//-->CANTIDADES 	si gana --> cantidad ganados+1,   si empata-->cantidad empatados+1,   cantidadperdidos +1
				
		//System.out.println("TODO OK");
		if (golesLocal>golesVisitante) {
			local.setCantidadganados(local.getCantidadganados()+1);//local suma uno de ganados
			visitante.setCantidadperdidos(visitante.getCantidadperdidos()+1);//visitante  suma uno de perdidos
		}
				
		if (golesLocal<golesVisitante) {
			visitante.setCantidadganados(visitante.getCantidadganados()+1); // visitante suma uno de ganado
			local.setCantidadperdidos(local.getCantidadperdidos()+1);	//local suma uno de perdido
		}
				
		if (golesLocal==golesVisitante) {
			local.setCantidadempatados(local.getCantidadempatados()+1);
			visitante.setCantidadempatados(visitante.getCantidadempatados()+1);
		}
				
		local.setCantidadJugados(local.getCantidadJugados()+1);
		visitante.setCantidadJugados(visitante.getCantidadJugados()+1);
				
		//GOLES FAVOR, CONTRA
		//si este club es local, --> goles favor+goles local
							//   --> goles contra +goles visitante
				
				
		local.setGolesFavor(local.getGolesFavor()+ golesLocal);
		local.setGolesContra(local.getGolesContra()+ golesVisitante);
				
				
		//si este club es visitante, --> goles favor+goles visitante
	   	//       					--> goles contra +goles local
		visitante.setGolesFavor(visitante.getGolesFavor()+ golesVisitante);
		visitante.setGolesContra(visitante.getGolesContra()+ golesLocal);
				
			//DIFERENCIA:	//--> goles favor- contra
				local.setDiferenciaGoles(local.getGolesFavor()-local.getGolesContra());
				visitante.setDiferenciaGoles(visitante.getGolesFavor()-visitante.getGolesContra());
				
			//PUNTOS-->
				// si este club gana ( es local y gol local> visitante
								//	   es visitante y gol visit>local) --> puntos+3
				
				if(golesLocal>golesVisitante)
					local.setPuntos(local.getPuntos()+3);
				
				if(golesLocal<golesVisitante)
					visitante.setPuntos(visitante.getPuntos()+3);
				
				
				// si este club empata (=) +1
				if(golesLocal==golesVisitante)
					local.setPuntos(local.getPuntos()+1);
				
				if(golesLocal==golesVisitante)
					visitante.setPuntos(visitante.getPuntos()+1);
				
				
				//PROMEDIO: -->sumo puntos / suma cantidades de partidos
				float cantidadPartidosLocal= local.getCantidadempatados()+local.getCantidadganados()+local.getCantidadperdidos();
				float promedioLocal= local.getPuntos()/(cantidadPartidosLocal);
				
				local.setPromedio(promedioLocal);
				
				float cantidadPartidosVisitante= visitante.getCantidadempatados()+visitante.getCantidadganados()+visitante.getCantidadperdidos();
				float promediovisitante= visitante.getPuntos()/(cantidadPartidosVisitante);
				
				visitante.setPromedio(promediovisitante);
				
				tablaPosicionesDAO.getInstancia().actualizar(local);
				tablaPosicionesDAO.getInstancia().actualizar(visitante);
			
		
		}	
	}
	
	/*FIN METODOS CAMPEONATO*/
	
	
	
	/*INICIO METODOS PARTIDO*/
	 public Partido obtenerPartidoPorID(int id) throws PartidoException{
			Partido part=PartidoDAO.getInstancia().obtenerPartidoPorID(id);
			return part;
		}
	 
	//AMBOS REPR DEBEN VALIDAR EL PARTIDO, DESPUES SI ESTAN LOS DOS VALIDADOS SE ACTUALIZA TABLA POSICIONES 
	public void validarPartido(int idPartido,int idRepresentante) throws ResponsableException, PartidoException, tablaPosicionesException {
		Responsable r=this.obtenerResponsablePorId(idRepresentante);
		Club  clubDelRepresentante= r.getClub();
		System.out.println(clubDelRepresentante.getIdClub());
		Partido p=this.obtenerPartidoPorId(idPartido);
		System.out.println(p.getIdPartido());
		Club clubLocal=p.getClubLocal();
		Club clubVisitante=p.getClubVisitante();
		
		
		if(clubDelRepresentante.getIdClub().equals(clubLocal.getIdClub())) {
			p.setConvalidaLocal();
			PartidoDAO.getInstancia().actualizar(p);
			
		}
		if(clubDelRepresentante.getIdClub().equals(clubVisitante.getIdClub())) {
				p.setConvalidaVisitante();
				System.out.println("ENTRA");
				PartidoDAO.getInstancia().actualizar(p);
		}
		if(p.isConvalidaLocal()==true && p.isConvalidaVisitante()==true)
			this.actualizarTablaPosiciones(p.getIdPartido());
	}
	
	

	/*FIN METODOS PARTIDO*/
	
	
	
	
	
	
	
	/* INICIO METODOS CLUB*/
	
	public Club obtenerClub(int id) throws ClubException {
		return ClubDAO.getInstancia().obtenerClubPorID(id);
	}
	
	public ClubVO obtenerClubVOPorId(int id) throws ClubException{
		return ClubDAO.getInstancia().obtenerClubPorID(id).toVO();
	}
	
	public void inscribirClub(int idClub, int idCampeonato) throws ClubException, CampeonatoException {
		Club c=obtenerClub(idClub);
		Campeonato camp=obtenerCampeonatoPorId(idCampeonato);
	
		if (c!=null && camp!= null) {
			camp.inscribirClub(c); 
			c.participar(camp);
			
			
		}
	}
	
	
	public void crearClub(int id,String nombre, String direccion) {
		 Club club= new Club(id,nombre,direccion);
		 club.grabar();
	 }
	
	 public void setClub(int idClub, String direccion2) throws ClubException { 
		 Club club=obtenerClub(idClub);
		 if(club!=null)
			 club.cambiarDireccion(direccion2);
	 }
	 
	 public String getNombreClub(int idClub) throws ClubException {
		 String nombre="";
		 Club c=obtenerClub(idClub);
		 if(c!=null)
			 nombre=c.getNombre();
		 return nombre;
	 }
	
	 
	 public String getDireccionClub(int idClub) throws ClubException {
		 String direccion="";
		 Club c=obtenerClub(idClub);
		 if(c!=null)
		 direccion=c.getDireccion();
		 return direccion;
		 
		
	 }
	
	 public List<ClubVO> obtenerClubesVOCampeonato(int idCampeonato) throws CampeonatoException{
			Campeonato aux = CampeonatoDAO.getInstancia().obtenerCampeonatoPorID(idCampeonato);
			List<ClubVO> clubesVO=new ArrayList<ClubVO>();
			if(aux!=null) {
				List<Club> clubesEnCampeonato= aux.getInscriptos();
				if(clubesEnCampeonato!=null) {
					
					for(Club c:clubesEnCampeonato)
						clubesVO.add(c.toVO());

					return clubesVO;
				}
				else return clubesVO;
			}
			else	
				return clubesVO;
			
		}
	 
	 //es igual a getInscriptos pero sin VO
	 public List<Club> obtenerClubesCampeonato(int idCampeonato) throws CampeonatoException{
			Campeonato aux = CampeonatoDAO.getInstancia().obtenerCampeonatoPorID(idCampeonato);
			List<Club> clubesEnCampeonato=new ArrayList<Club>();
			if(aux!=null) {
				 clubesEnCampeonato= aux.getInscriptos();
				return clubesEnCampeonato;
			}
			else
				return clubesEnCampeonato;
		}
		
	 public List<ClubVO> getInscriptos(int idCampeonato) throws CampeonatoException, ClubException{
			Campeonato actual=obtenerCampeonatoPorId(idCampeonato);
			List<ClubVO> clubesVO=new ArrayList<ClubVO>();
			if(actual!=null) {
				List<Club> clubesNegocio= new ArrayList<Club>();
				clubesNegocio=actual.getInscriptos();
				clubesVO=new ArrayList<ClubVO>();
			
				for(Club c:clubesNegocio)
					clubesVO.add(c.toVO());
				return clubesVO;
			}
			return clubesVO;
		}
	
	
	 
	 
	 public List<ClubVO> obtenerClubes(){
			List<Club> aux=ClubDAO.getInstancia().obtenerClubes();
			List<ClubVO> resultado=new ArrayList<ClubVO>();
			
			for(Club j: aux) {
				resultado.add(j.toVO());
			}
			
			return resultado;
		}
		
	 
	 
	 
	 
	 public List<CampeonatoVO> obtenerCampeonatosDeClub(int idClub) throws ClubException{
		 List<Campeonato> allCampeonatos=this.obtenerCampeonatos();
		 List<CampeonatoVO> resultado=new ArrayList<CampeonatoVO>();
		 for(Campeonato camp:allCampeonatos) {
			 List<Club> clubesCamp=camp.getInscriptos();
			 for(Club clubAux:clubesCamp) {
				 if (clubAux.getIdClub()==idClub)
					 resultado.add(camp.toVO());
			 }
		 }
		 return resultado;
	 }
	
	 /*FIN METODOS CLUB*/
	 
	
	 
	 
	
		
	/*INICIO METODOS  MIEMBROS*/
	 
	// SI DEL FRONT LE MANDO ID JUGAODR, PARTIDO Y MINUTO-->
		public void aztualizarMinutoIngreso(int idJugador,int idPartido, int ingreso) throws MiembroException, JugadorException {
			List<Miembro> miembros=MiembroDAO.getInstancia().obtenerMiembros();
			for(Miembro m:miembros) {
				if( (m.getJugador().getIdJugador()==idJugador) && (m.getPartido().getIdPartido()==idPartido)  )
					this.actualizarIngreso(m.getIdLista(), ingreso);
			}
		}
		
		
		public void aztualizarMinutoEgreso(int idJugador,int idPartido, int egreso) throws MiembroException, JugadorException {
			List<Miembro> miembros=MiembroDAO.getInstancia().obtenerMiembros();
			for(Miembro m:miembros) {
				if( (m.getJugador().getIdJugador()==idJugador) && (m.getPartido().getIdPartido()==idPartido)  )
					this.actualizarEgreso(m.getIdLista(), egreso);
			}
		}
		
		
	//SI LE MANDO DEL FRONT DIRECTO EL MIEMBRO-->
		public void actualizarIngreso(int idMiembro, int ingreso) throws MiembroException {
			Miembro miembro = obtenerMiembroPorId(idMiembro);
			if(miembro!=null) {
				if (ingreso >= 0 && ingreso <=90) {
					miembro.setIngreso(ingreso);
				}
			else {
				System.out.println("El minuto de ingreso dado no es v�lido");
				}
			}
		}
		
		public void actualizarEgreso(int idMiembro, int egreso) throws MiembroException {
			Miembro miembro = obtenerMiembroPorId(idMiembro);
			if(miembro!=null)
				miembro.setEgreso(egreso);
			}
		

		//Es eliminar Mimebro logicamente
		public void BajaJugadorPartido(int clubAux, int partidoAux, int jugadorAux) throws MiembroException {
			List<Miembro> jugadoresPartido= MiembroDAO.getInstancia().obtenerMiembros();
			if(jugadoresPartido.size()!=0) {
				for(Miembro miembro: jugadoresPartido) {
					if( (miembro.getClub().getIdClub()==clubAux) && (miembro.getPartido().getIdPartido()==partidoAux) &&
							(miembro.getJugador().getIdJugador()==jugadorAux) ) {
						miembro.BajaJugadorPartido();
						MiembroDAO.getInstancia().actualizar(miembro);
					}
				}
			}
		}

		//Es agregar denuevo Mimebro logicamente
		public void AltaJugadorPartido(int clubAux, int partidoAux, int jugadorAux) throws MiembroException {
			List<Miembro> jugadoresPartido= MiembroDAO.getInstancia().obtenerMiembros();
			if(jugadoresPartido.size()!=0) {
				for(Miembro miembro: jugadoresPartido) {
					if( (miembro.getClub().getIdClub()==clubAux) && (miembro.getPartido().getIdPartido()==partidoAux) &&
							(miembro.getJugador().getIdJugador()==jugadorAux) ) {
						miembro.AltaJugadorPartido();
						MiembroDAO.getInstancia().actualizar(miembro);
					}
				}
			}
		}
		
		public void eliminarMiembro(int idMiembro) throws MiembroException {
			Miembro miembro = obtenerMiembroPorId(idMiembro);
			if(miembro!=null)
				miembro.eliminar();
		}
		
		//porque lo usan los m�todos de partido
		private Miembro obtenerMiembroPorId(int idMiembro) throws MiembroException {
			return MiembroDAO.getInstancia().obtenerMiembroPorId(idMiembro);
				}
				
		public MiembroVO obtenerMiembroVoPorId (int idMiembro) throws MiembroException {
			Miembro miembro = obtenerMiembroPorId(idMiembro);
				return miembro.toVO();
				}
		
		
		

		public java.util.List<MiembroVO> obtenerJugadoresLocales(int idPartido) throws PartidoException{
			Partido p = obtenerPartidoPorId(idPartido);
			List<Miembro> lista = p.getJugadoresLocales();
			List<MiembroVO> resultado = new ArrayList<MiembroVO>();
			for (Miembro m: lista) {
				if(m.getEstadoJugadorPartido().equals("activo"))
				resultado.add(m.toVO());
			}
			return resultado;
		}

		public List<MiembroVO> obtenerJugadoresVisitantes(int idPartido) throws PartidoException{
			Partido p = obtenerPartidoPorId(idPartido);
			List<Miembro> lista = p.getJugadoresVisitantes();
			System.out.print(p);
			List<MiembroVO> resultado = new ArrayList<MiembroVO>();
			for (Miembro m: lista) {
				if(m.getEstadoJugadorPartido().equals("activo"))
				resultado.add(m.toVO());
			}
			return resultado;
			}
	
		public List<MiembroVO> obtenerJugadoresPartido(int idPartido) throws PartidoException{
			Partido p = obtenerPartidoPorId(idPartido);
			List<Miembro> lista = p.getJugadoresVisitantes();
			List<Miembro> lista2 = p.getJugadoresLocales();
			List<MiembroVO> resultado = new ArrayList<MiembroVO>();
			for (Miembro m: lista) {
				resultado.add(m.toVO());
			}
			for (Miembro m: lista2) {
				resultado.add(m.toVO());
			}
			return resultado;
			}
		
		public java.util.List<Miembro> obtenerJugadoresVisitantes2(int idPartido) throws PartidoException{
			Partido p = obtenerPartidoPorId(idPartido);
			return p.getJugadoresVisitantes();
		}
		
		/* FIN METODOS MIEMBROS*/
		
		
		
		/*INICIO METODOS PARTIDO*/
	
		
		public void agregarPartido(int nroFecha, int nroZona, int categoria, int idClubLocal, int idClubVisitante, String fechaPartido, int idCampeonato,String etapa) throws ClubException, CampeonatoException {
			Club clubLocal = obtenerClub(idClubLocal);
			Club clubVisitante = obtenerClub(idClubVisitante);
			Campeonato campeonato = obtenerCampeonatoPorId(idCampeonato);
			Partido partido = new Partido(nroFecha, nroZona, categoria, clubLocal, clubVisitante, fechaPartido, campeonato,etapa);
			partido.grabar();
		}
		
	
		private Partido obtenerPartidoPorId(int id) throws PartidoException {
			return PartidoDAO.getInstancia().obtenerPartidoPorID(id);
		}
		
		public PartidoVO obtenerPartidoVoPorId(int id) throws PartidoException {
			Partido partido = obtenerPartidoPorID(id);
			return partido.toVO();
		}
		
		
		
		public List<PartidoVO> obtenerPartidos(){
			List<PartidoVO> resultado = new ArrayList<PartidoVO>();
	        List<Partido> lista = PartidoDAO.getInstancia().obtenerPartidos();
	        for (Partido p: lista) {
	        	resultado.add(p.toVO());
	        	//System.out.println(p.toVO().toString());
	        }
	       return resultado;
		}

		public List<PartidoVO> obtenerPartidosPendientes(){
			List<PartidoVO> resultado = new ArrayList<PartidoVO>();
	        List<Partido> lista = PartidoDAO.getInstancia().obtenerPartidos();
	        for (Partido p: lista) {
	        	if(p.isConvalidaLocal()!=true || p.isConvalidaVisitante()!=true)
	        		resultado.add(p.toVO());
	        	//System.out.println(p.toVO().toString());
	        }
	       return resultado;
		}
		
		public List<PartidoVO> obtenerPartidosPendientesClub(int idClub){
			List<PartidoVO> resultado = new ArrayList<PartidoVO>();
	        List<Partido> lista = PartidoDAO.getInstancia().obtenerPartidos();
	        for (Partido p: lista) {
	        	if (p.getClubLocal().getIdClub().equals(idClub) &&  p.isConvalidaLocal()!=true) 
	        		resultado.add(p.toVO());
	        	else if(p.getClubVisitante().getIdClub().equals(idClub) && p.isConvalidaVisitante()!=true)
	        		resultado.add(p.toVO());
	        	//System.out.println(p.toVO().toString());
	        }
	       return resultado;
		}
		
		
		public List<PartidoVO> obtenerPartidosClub(int idClub){
			List<PartidoVO> resultado = new ArrayList<PartidoVO>();
	        List<Partido> lista = PartidoDAO.getInstancia().obtenerPartidos();
	        for (Partido p: lista) {
	        	if (p.getClubLocal().getIdClub().equals(idClub)) 
	        		resultado.add(p.toVO());
	        	else if(p.getClubVisitante().getIdClub().equals(idClub))
	        		resultado.add(p.toVO());
	        	//System.out.println(p.toVO().toString());
	        }
	       return resultado;
		}
		
		
		public void modificarFechaPartido(String fecha, int idPartido) throws PartidoException {
			Partido p = obtenerPartidoPorId(idPartido);
			if(p!=null)
			p.setFechaPartido(fecha);
		}
		
		public void actualizarGolesLocal(int idPartido) throws PartidoException {
			Partido p = obtenerPartidoPorId(idPartido);
			System.out.println(p.getCategoria());
			if(p!=null) {
				int actual=p.getGolesLocal();
				p.setGolesLocal(actual);
			}
		}
		
		public void actualizarGolesVisitante (int idPartido) throws PartidoException {
			Partido p = obtenerPartidoPorId(idPartido);
			if(p!=null)
			p.setGolesVisitante(p.getGolesVisitante());
		}
		
		public void eliminarPartido(int idPartido) throws PartidoException {
			Partido p = obtenerPartidoPorId(idPartido);
			if(p!=null)
			p.eliminar();
		}
	
		
	
		/*FIN METODOS PARTIDO*/
		
		/*INICIO METODOS RESPONSABLE*/
		
		public void agregarResponsable(String documento, String nombre, int idClub) throws ClubException {
			Club c = obtenerClub(idClub);
			if(c!=null) {
			Responsable r = new Responsable(documento, nombre, c);
			r.grabar();
			c.asignarResponsable(r);
		}
		}
		
		
	
		public void eliminarResponsable(int id) throws ResponsableException {
			Responsable r = obtenerResponsablePorId(id);
			r.eliminar();
		}
		
		
	
		public List<ResponsableVO> obtenerResponsablesClub(int idClub) throws ClubException{
			Club c = obtenerClub(idClub);
			List<ResponsableVO> resultado = new ArrayList<ResponsableVO>();
			if(c!=null) {
				List<Responsable> lista = c.getResponsable();
				for (Responsable r: lista) {
					resultado.add(r.toVO());
				}
				return resultado;
			}
			return resultado;
		}

		public List<ResponsableVO> obtenerResponsables(){
			List<Responsable> lista = ResponsableDAO.getInstancia().obtenerResponsables();
			List<ResponsableVO> resultado = new ArrayList<ResponsableVO>();
			for (Responsable r: lista) {
				resultado.add(r.toVO());
			}
			return resultado;
		}
		
		public ResponsableVO obtenerResponsableVOPorId(int id) throws ResponsableException {
			Responsable r = obtenerResponsablePorId(id);
			return r.toVO();
		}
		
		private Responsable obtenerResponsablePorId(int id) throws ResponsableException {
			return ResponsableDAO.getInstancia().obtenerResponsablePorId(id);
		}
	
		//AGREGADOS:
		
	//Consultar el avance de su equipo y su perfil en los campeonatos en los que participa. 
		
		public List<CampeonatoVO> consultarAvanceClubEnCampeonatos(int idClub) throws ClubException, CampeonatoException {
			Club club=obtenerClub(idClub);
			List<CampeonatoVO> listaRetornable=new ArrayList<CampeonatoVO>();
			if(club!=null) {
			List<Campeonato> lista= club.getParticipanciones();
			
			
			for(Campeonato c: lista)
				listaRetornable.add(c.toVO());
			return listaRetornable;
			}
			else return listaRetornable;
		}
		
		
		public List<tablaPosicionesVO> consultarAvanceClub(int idClub) throws tablaPosicionesException, ClubException{
			Club c=this.obtenerClub(idClub);
			List<tablaPosicionesVO> resultado=new ArrayList<tablaPosicionesVO>();
			if(c!=null) {
				List<tablaPosiciones> aux= tablaPosicionesDAO.getInstancia().buscarTablaDeMiClub(idClub);
				tablaPosicionesVO actual;
			
				for(tablaPosiciones t:aux) {
					actual=t.toVO();
					// System.out.println(actual.getC().getNombre());
					resultado.add(actual);
				}
			return resultado;
			}
			else
				return resultado;
		}
			
		
		
		public List<String> obtenerUsuarios(){
			List<String> usuarios= new ArrayList<String>();
			List <tablaUsuariosRoles> aux= tablaUsuariosRolesDAO.getInstancia().obtenerUsuarios();
			
			for( tablaUsuariosRoles c: aux)
				usuarios.add(c.getDocumento());
			return usuarios;
		}
		
		
		
		
		public int chequearUsuariocontraseña(String doc, String contra) {
			int flag=0;
			tablaUsuariosRoles aux= tablaUsuariosRolesDAO.getInstancia().obtenerUsuarioPorDocumento(doc);
			
			System.out.println(aux.getcontraseña());
			
			if (aux.getcontraseña().equals(contra)) {
				flag=1;}
			
			return flag;
		}
		
		public tablaUsuariosRoles obtenerRolUsuario( String doc) {
			tablaUsuariosRoles aux= tablaUsuariosRolesDAO.getInstancia().obtenerUsuarioPorDocumento(doc);
			 return aux;
		}
		public void crearUsuariosRoles(String doc, String contra, String rol) {
            tablaUsuariosRoles aux= new tablaUsuariosRoles(doc,contra,rol);
            System.out.println("CREADO");
            aux.grabar();
        }
		
		public Object getObjetoPorDNI(String dni) throws NumberFormatException, JugadorException, ResponsableException {
            Jugador j = JugadorDAO.getInstancia().obtenerJugadorPorDNI(Integer.parseInt(dni));
            if (j != null){
                return j.toVO();
            }
            else {
                Responsable r = ResponsableDAO.getInstancia().obtenerResponsablePorDNI(dni);
                if (r!=null) {
                    return r.toVO();
                }
            }
            return null;
        }
		
		
		
		public String crearUsuario(String doc,String contra) {
            List<Jugador> j=getJugadores();
            List<Responsable> r = ResponsableDAO.getInstancia().obtenerResponsables();
            String tipo = null;



            for(Jugador jug: j) {
                Integer aux=jug.getDocumento();

                if(doc.equals(""+aux)) {
                    tipo="JUGADOR";
                }
            }

            if(tipo==null) {
                for(Responsable rep: r) {
                    if(doc.equals(rep.getDocumento())) {
                        tipo="REPRESENTANTE";
                    }
                }
            }

            if(tipo==null) {
                return "NotFound";
            }else {
                crearUsuariosRoles(doc, contra, tipo);
                return tipo;
            }

            }

		public List<tablaPosicionesVO> obtenerTodaLaTablaPosiciones() throws tablaPosicionesException{
        List<tablaPosiciones> aux=new ArrayList<tablaPosiciones>();
        List<tablaPosicionesVO> aux2=new ArrayList<tablaPosicionesVO>();
        aux=tablaPosicionesDAO.getInstancia().obtenerTodo();
        for(tablaPosiciones t: aux) {
            aux2.add(t.toVO());
        }

        return aux2;
    }
}

