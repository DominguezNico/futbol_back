package ar.com.TP_APIS;


import java.util.Date;
import java.util.List;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import controlador.Controlador;
import exeptions.CampeonatoException;
import exeptions.ClubException;
import exeptions.FaltaException;
import exeptions.GolException;
import exeptions.JugadorException;
import exeptions.MiembroException;
import exeptions.PartidoException;
import exeptions.ResponsableException;
import exeptions.tablaPosicionesException;
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



@org.springframework.web.bind.annotation.RestController
public class RestController {


	@RequestMapping("/hello")
	public String hello(@RequestParam(name="name",defaultValue = "Extraño" ) String name) {
		return "Hola " + name + " Bievenido al Mundo Rest";
	}
	 

	//CAMPEONATO
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/obtenerCampeonatos")
	public List<CampeonatoVO> obtenerCampeonatos() {
		return Controlador.getInstancia().getCampeonatos();
	}
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/crearCampeonato")
	public void crearCampeonato(@RequestParam(name="descripcion") String descripcion,@RequestParam(name="fechaInicio") Date fechaInicio ,@RequestParam(name="fechaFin") Date fechaFin , @RequestParam(name="estado") String  estado) {
		Controlador.getInstancia().CrearCampeonato( descripcion,  fechaInicio,  fechaFin,  estado);
	}
	
	//crearCampeonato?descripcion="camp"&fechaInicio="20/10/2020"&fechaFin="20/11/2020"&estado="activo"
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getFechaInicioCampeonato")
	public Date getFechaInicioCampeonato(@RequestParam(name="idCampeonato") Integer idCampeonato) throws CampeonatoException {
		return Controlador.getInstancia().getFechaInicioCampeonato(idCampeonato);
	}
	
	//crearCampeonato?getFechaInicioCampeonato=""
	
	
	@CrossOrigin(origins="")
	@RequestMapping("/getFechaFinCampeonato")
	public Date getFechaFinCampeonato(@RequestParam(name="idCampeonato") Integer idCampeonato) throws CampeonatoException {
		return Controlador.getInstancia().getFechaFinCampeonato(idCampeonato);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getCampeonatobyID")
	public CampeonatoVO getCampeonatobyID(@RequestParam(name="id") Integer id) throws CampeonatoException {
		CampeonatoVO aux=Controlador.getInstancia().obtenerCampeonatoVOPorId(id);
		return aux;
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getEstadoCampeonato")
	public String getEstadoCampeonato(@RequestParam(name="idCampeonato") Integer id) throws CampeonatoException {
		return Controlador.getInstancia().getEstadoCampeonato(id);
	}
	
	@CrossOrigin(origins="")
	@RequestMapping("/getDescripcionCampeonato")
	public String getDescripcionCampeonato(@RequestParam(name="idCampeonato") Integer id) throws CampeonatoException {
		return Controlador.getInstancia().getDescripcionCampeonato(id);
	}
	
	/*
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/iniciarTablaPosicionesCampeonato")
	public void iniciarTablaPosicionesCampeonato(@RequestParam(name="idCampeonato") Integer idCampeonato) throws CampeonatoException, ClubException {
		 Controlador.getInstancia().iniciarTablaPosicionesCampeonato(idCampeonato);
	}
	*/
	
	
	
	//CLUB
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getClub")
	public ClubVO getClubVO(@RequestParam(name="idClub") Integer id) throws ClubException  {
		return Controlador.getInstancia().obtenerClubVOPorId(id);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/inscribirClubEnCampeonato")
	public void inscribirClubEnCampeonato(@RequestParam(name="id") Integer id,@RequestParam(name="idCampeonato") Integer idCampeonato) throws ClubException, CampeonatoException {
		Controlador.getInstancia().inscribirClub(id,idCampeonato);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/addClub")
	public void addClub(@RequestParam(name="idClub") Integer id,@RequestParam(name="nombreClub") String nombre,@RequestParam(name="DireccionClub") String direccion) {
		Controlador.getInstancia().crearClub( id, nombre,  direccion);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/modificarDireccionClub")
	public void modificarDireccionClub(@RequestParam(name="idClub") Integer id,@RequestParam(name="direccion") String direc) throws ClubException {
		Controlador.getInstancia().setClub(id,direc);
	}
	
	@CrossOrigin(origins="")
	@RequestMapping("/getNombreClub")
	public String getNombreClub(@RequestParam(name="id") Integer id) throws ClubException {
		return Controlador.getInstancia().getNombreClub(id);
	}
	
	@CrossOrigin(origins="")
	@RequestMapping("/getInscriptos")
	public List<ClubVO> getInscriptos(@RequestParam(name="idCampeonato") Integer id) throws ClubException, CampeonatoException {
		return Controlador.getInstancia().getInscriptos(id);
	}
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/obtenerClubes")
	public List<ClubVO> obtenerClubes() throws ClubException, CampeonatoException {
		return Controlador.getInstancia().obtenerClubes();
	}
	
	/* FIN REST CLUB */
	
	
	
	
	
	
	/* INICIO REST FALTA */
	@CrossOrigin(origins="")
	@RequestMapping("/getFalta")
	public FaltaVO getFalta(@RequestParam(name="idFalta") Integer id) throws FaltaException, PartidoException{
		return Controlador.getInstancia().getFaltaVOPorID(id);
	}

	@CrossOrigin(origins="")
	@RequestMapping("/getFaltas")
	public List<FaltaVO> getFaltas(){
		return Controlador.getInstancia().getFaltasVP();
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getFaltasCampeonato")
	public List<FaltaVO> getFaltasCampeonato(@RequestParam(name="idCampeonato") Integer id) {
		return Controlador.getInstancia().getFaltasVOCampeoanto(id);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getFaltasJugador")
	public List<FaltaVO> getFaltasJugador(@RequestParam(name="idJugador") Integer id)  {
		return Controlador.getInstancia().getFaltasVOJugador(id);
	} 
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/addFalta")
	public void addFalta(@RequestParam int minuto,@RequestParam String tipo,@RequestParam int idJugador,@RequestParam int idPartido,@RequestParam int idCampeonato  ) throws ClubException, JugadorException, PartidoException, CampeonatoException {
		Controlador.getInstancia().agregarFalta(idPartido, idJugador, idCampeonato, minuto, tipo);
	}
	
	
	/* FIN REST FALTA */	
	
	
	
	
	
	/* INICIO REST GOL */
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getGol")
	public GolVO getGolPorID(@RequestParam(name="idGol") Integer id) throws GolException {
		return Controlador.getInstancia().getGolVOPorID(id);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getGoles")
	public List<GolVO> getGoles() {
		return Controlador.getInstancia().getGolesVO();
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getMinutoGol")
	public Integer getMinutoGol(@RequestParam(name="idGol") int idGol) throws GolException {
		return getGolPorID(idGol).getMinuto();
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getTipoGol")
	public String getTipoGol(@RequestParam(name="idGol") int idGol) throws GolException {
		return getGolPorID(idGol).getTipo();
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getPartidoGol")
	public PartidoVO getPartidoGol(@RequestParam(name="idGol") int idGol) throws GolException {
		return getGolPorID(idGol).getPartido();
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getGolesJugador")
	public List<GolVO> getGolesJugador(@RequestParam(name="idJugador") int idJugador) {
		return Controlador.getInstancia().getGolesVOJugador(idJugador);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/addGol")
	public void addGol(@RequestParam(name="minuto") int minuto,@RequestParam(name="tipo") String tipo,@RequestParam(name="idJugador") int idJugador,@RequestParam(name="idPartido") int idPartido) throws JugadorException, PartidoException {
		Controlador.getInstancia().agregarGol(idJugador, idPartido, minuto, tipo);
		
	}
	
	/* FIN REST GOL */
	
	
	
	
	/* INICIO REST JUGADOR */
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getJugador")
	public JugadorVO getJugador(@RequestParam(name="idJugador") Integer id) throws JugadorException  {
		return Controlador.getInstancia().getJugadorVOByID(id);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getJugadores")
	public List<JugadorVO> getJugadores(){
		return Controlador.getInstancia().getJugadoresVO();
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getJugadoresClub")
	public List<JugadorVO> getJugadoresClub(@RequestParam int idClub) throws ClubException{
		return Controlador.getInstancia().getJugadoresVOClub(idClub);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/cambiarClubJugador")
	public  void cambiarClubJugador(@RequestParam int idJugador,@RequestParam int idClub) throws ClubException, JugadorException {
		Controlador.getInstancia().cambiarClubJugador(idJugador, idClub);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/eliminarJugador")
	public void eliminarJugador(@RequestParam int idJugador,@RequestParam int idClub) throws JugadorException, ClubException {
		Controlador.getInstancia().eliminarJugador(idJugador, idJugador);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/addJugador")
	public void addJugador(@RequestParam Integer documento,@RequestParam String nombre,@RequestParam String apellido,@RequestParam String fechaNacimiento,
							@RequestParam String tipoDoc,@RequestParam int idClub) throws ClubException, JugadorException {
	Controlador.getInstancia().agregarJugador(documento, nombre, apellido, tipoDoc, idClub, fechaNacimiento);
	}	
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/quitarJugadorClub")
	public void quitarJugadorClub(@RequestParam int idJugador, @RequestParam int idClub) throws ClubException, JugadorException {
		Controlador.getInstancia().quitarJugadorClub(idJugador, idClub);
	}
	
	//AGREGA EL JUGADOR AL CLUB
    /*@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
    @PostMapping("/agregarJugador")
    public void agregarJugador(@RequestParam int idJugador, @RequestParam int idClub, @RequestParam int idCampeonato) throws ClubException, CampeonatoException, JugadorException {
        Controlador.getInstancia().agregarJugador(idJugador, idClub, idCampeonato);
    }*/

    //SETEA EL ESTADO ACTIVO
    @CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
    @PostMapping("/habilitarJugador")
    public void habilitarJugador(@RequestParam int idJugador) throws ClubException, CampeonatoException, JugadorException {
           Controlador.getInstancia().habilitarJugador(idJugador);
            }
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/deshabilitarJugador")
	public void deshabilitarJugador(@RequestParam int idJugador) throws ClubException, CampeonatoException, JugadorException {
		Controlador.getInstancia().deshabilitarJugador(idJugador);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/cambiarTelefonoJugador")
	public void cambiarTelefonoJugador(@RequestParam int id,@RequestParam Integer telefono) throws ClubException, CampeonatoException, JugadorException {
		Controlador.getInstancia().cambiarTelefonoJugador(id, telefono);
    }
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/cambiarMailJugador")
	public void cambiarMailJugador(@RequestParam int id,@RequestParam String mail) throws ClubException, CampeonatoException, JugadorException {
		Controlador.getInstancia().cambiarMailJugador(id, mail);
    }
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
    @RequestMapping("/cambiarDireccionJugador")
    public void cambiarDireccionJugador(@RequestParam int idJugador, @RequestParam String direc) throws JugadorException{
         Controlador.getInstancia().cambiarDireccionJugador(idJugador,direc);
    }
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/agregarJugadoresEnLista")
	public void agregarJugadoresEnLista(int idClub, int idPartido, int idJugador) throws ClubException, JugadorException, PartidoException, MiembroException {
		Controlador.getInstancia().agregarJugadoresEnLista(idClub, idPartido, idJugador);
		
	}
	/* FIN REST JUGADOR */
	
	
	
	
	
	/*INICIO PARTIDO REST*/
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/agregarPartido")
	public void agregarPartido(@RequestParam int nroFecha, @RequestParam int nroZona, @RequestParam int categoria, @RequestParam int idClubLocal, @RequestParam int idClubVisitante, @RequestParam String fechaPartido, @RequestParam int idCampeonato, @RequestParam String etapa) throws ClubException, CampeonatoException {
		Controlador.getInstancia().agregarPartido(nroFecha, nroZona, categoria, idClubLocal, idClubVisitante, fechaPartido, idCampeonato,etapa);
	}

	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getPartido")
	public PartidoVO getPartido(@RequestParam int idPartido) throws PartidoException {
		return Controlador.getInstancia().obtenerPartidoVoPorId(idPartido);
	}
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getPartidos")
	public List<PartidoVO> getPartidos(){
		return Controlador.getInstancia().obtenerPartidos();
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getPartidosPendientes")
	public List<PartidoVO> getPartidosPendientes(){
		return Controlador.getInstancia().obtenerPartidosPendientes();
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getPartidosPendientesClub")
	public List<PartidoVO> getPartidosPendientes( @RequestParam int idClub){
		return Controlador.getInstancia().obtenerPartidosPendientesClub(idClub);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getPartidosClub")
	public List<PartidoVO> getPartidosClub( @RequestParam int idClub){
		return Controlador.getInstancia().obtenerPartidosClub(idClub);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/validarPartido")
	public void validarPartido( @RequestParam int idPartido, @RequestParam int idRepresentante ) throws ResponsableException, PartidoException, tablaPosicionesException{
		Controlador.getInstancia().validarPartido(idPartido, idRepresentante);
	}

	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/modificarFechaPartido")
	public void modificarFechaPartido(@RequestParam String fecha, @RequestParam int idPartido) throws PartidoException {
		Controlador.getInstancia().modificarFechaPartido(fecha, idPartido);
	}
	/*FIN PARTIDO*/
	
	
	
	
	
	/*INICIO MIEMBRO*/
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
    @PostMapping("/agregarJugadorPartido")
    public int agregarJugadorPartido(@RequestParam int idClub, @RequestParam int idPartido, @RequestParam int idJugador) throws PartidoException, ClubException, JugadorException, MiembroException{
        return Controlador.getInstancia().agregarJugadoresEnLista(idClub, idPartido, idJugador);
    }
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getJugadoresLocales")
	public List<MiembroVO> getJugadoresLocales(@RequestParam int idPartido) throws PartidoException{
		return Controlador.getInstancia().obtenerJugadoresLocales(idPartido);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getJugadoresVisitantes")
	public List<MiembroVO> getJugadoresVisitantes(@RequestParam int idPartido) throws PartidoException{
		return Controlador.getInstancia().obtenerJugadoresVisitantes(idPartido);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getJugadoresPartido")
	public List<MiembroVO> getJugadoresPartido(@RequestParam int idPartido) throws PartidoException{
		return Controlador.getInstancia().obtenerJugadoresPartido(idPartido);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getJugadoresHabilitadosClub")
	public List<JugadorVO> getJugadoresHabilitadosClub(@RequestParam int idClub) throws ClubException{
		return Controlador.getInstancia().getJugadoresVOHabilitadosClub(idClub);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/actualizarIngresoJugador")
	public void actualizarIngresoJugador(@RequestParam int idMiembro, @RequestParam int ingreso) throws MiembroException {
		Controlador.getInstancia().actualizarIngreso(idMiembro, ingreso);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/actualizarEgresoJugador")
	public void actualizarEgresoJugador(@RequestParam int idMiembro, @RequestParam int egreso) throws MiembroException {
		Controlador.getInstancia().actualizarEgreso(idMiembro, egreso);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getMiembro")
	public MiembroVO getMiembro(@RequestParam int idMiembro) throws MiembroException {
		return Controlador.getInstancia().obtenerMiembroVoPorId(idMiembro);
	}
	
	
	/*FIN MIEMBRO*/
	
	
	
	
	/*INICIO */
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getGolesLocal")
	public int getGolesLocal(@RequestParam int idPartido) throws PartidoException {
		return Controlador.getInstancia().obtenerGolesLocal(idPartido);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getGolesVisitante")
	public int getGolesVisitante(@RequestParam int idPartido) throws PartidoException {
		return Controlador.getInstancia().obtenerGolesVisitante(idPartido);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/actualizarGolesLocal")
	public void actualizarGolesLocal(@RequestParam int idPartido) throws PartidoException {
		Controlador.getInstancia().actualizarGolesLocal(idPartido);
	}
	
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/actualizarGolesVisitante")
	public void actualizarGolesVisitante(@RequestParam int idPartido) throws PartidoException {
		Controlador.getInstancia().actualizarGolesVisitante(idPartido);
	}
	
	
	/*INICIO RESPONSBALE*/
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/agregarResponsable")
	public void agregarResponsable(@RequestParam String documento, @RequestParam String nombre, @RequestParam int idClub) throws ClubException {
		Controlador.getInstancia().agregarResponsable(documento, nombre, idClub);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getResponsablesClub")
	public List<ResponsableVO> getResponsablesClub(@RequestParam int idClub) throws PartidoException, ClubException{
		return Controlador.getInstancia().obtenerResponsablesClub(idClub);
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getResponsables")
	public List<ResponsableVO> getResponsables() throws PartidoException, ClubException{
		return Controlador.getInstancia().obtenerResponsables();
	}
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getResponsable")
	public ResponsableVO getResponsable(@RequestParam int idResponsable) throws ResponsableException{
		return Controlador.getInstancia().obtenerResponsableVOPorId(idResponsable);
	}

	
	
//EXTRAS
	
	//NO VA ESTE
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/consultarAvanceClubEnCampeonatos")
	public List<CampeonatoVO> consultarAvanceClubEnCampeonatos(@RequestParam(name="idClub") int idClub) throws ClubException, CampeonatoException{
		return Controlador.getInstancia().consultarAvanceClubEnCampeonatos(idClub);
	}
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/consultarAvanceClub")
	public List<tablaPosicionesVO> consultarAvanceClub(@RequestParam(name="idClub") int idClub) throws tablaPosicionesException, ClubException{
		return Controlador.getInstancia().consultarAvanceClub(idClub);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/obtenerTablaPosiciones")
	public List<tablaPosicionesVO> obtenerTablaPosiciones(@RequestParam(name="idCampeonato") int idCampeonato) throws ClubException, CampeonatoException, tablaPosicionesException{
		return Controlador.getInstancia().obtenerTablaPosicionCampeonato(idCampeonato);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/confeccionEsta")
	public List<String> confeccionEsta(@RequestParam(name="idClub") int idClub) throws ClubException, tablaPosicionesException{
		return Controlador.getInstancia().confeccionarEstadisticasJugador(idClub);
	}
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/crearUsuariosRoles")
	public void crearUsuariosRoles(@RequestParam String doc, @RequestParam String contra,@RequestParam String rol) {
	 Controlador.getInstancia().crearUsuariosRoles(doc,contra,rol);
			}
	
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/obtenerUsuariosRoles")	
	public List<String> obtenerUsuariosRoles(){
	List<String> aux = Controlador.getInstancia().obtenerUsuarios();
	return aux;
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/chequearUsuarioContraseña")	
	public int chequearUsuarioContraseña(@RequestParam String doc,@RequestParam  String contra) {
	return Controlador.getInstancia().chequearUsuariocontraseña(doc,contra);
	}
	
	  @CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	  @RequestMapping("/obtenerRolUsuario")
	  public tablaUsuariosRoles obtenerRolUsuario(@RequestParam String doc) {
	  return Controlador.getInstancia().obtenerRolUsuario(doc);
	                }
	
	
	
	//TABLA POSICIONES
	
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/obtenerTablaPosicionCampeonato")	
	public List<tablaPosicionesVO> obtenerTablaPosicionCampeonato(@RequestParam int idCampeonato) throws CampeonatoException, tablaPosicionesException{
		return Controlador.getInstancia().obtenerTablaPosicionCampeonato(idCampeonato);
	}
	//localhost:8080/obtenerTablaPosicionCampeonato?idCampeonato=1
	
	
	
	
	
	//1. Se crea el campeonato
	//2. inscribirClub(idClub, idCampeonato)
	//2. Se crea un partido, donde el idCampeonato es el que arme antes y los clubes son los que inscribi	-->FALTAN LOS CHEQUEOS DE QUE EXISTAN CUANDO LO BUSCA
	
	//Se inicia la tabla con el campeonato y los clubes que tenga ese campeoanto
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/iniciarTablaPosicionesCampeonato")	
	public void iniciarTablaPosicionesCampeonato(@RequestParam int idCampeonato) throws CampeonatoException, ClubException{
		 Controlador.getInstancia().iniciarTablaPosicionesCampeonato(idCampeonato);
	}
	
	//localhost:8080/iniciarTablaPosicionesCampeonato?idCampeonato=9
	
	
	
	//Le mando un partido que este en el campeonato que le mande arriba y Los idClub son los que estan en el campeonato 
	//por cada partido que se termina, se actualiza la tabla
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/actualizarTablaPosiciones")	
	public void actualizarTablaPosiciones(@RequestParam int idPartido) throws CampeonatoException, ClubException, PartidoException, tablaPosicionesException{
		 Controlador.getInstancia().actualizarTablaPosiciones(idPartido);
	}
	//http://fulbito-back.azurewebsites.net:8080/actualizarTablaPosiciones?idPartido=1019
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/getObjetoDNI")
	public Object getObjetoDNI(@RequestParam String dni) throws ResponsableException, JugadorException{
		       return Controlador.getInstancia().getObjetoPorDNI(dni);
		    }
	
	
	
	
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
    @PostMapping("/crearUsuario")
    public String crearUsuario(@RequestParam String doc, @RequestParam String contra) {
		         return Controlador.getInstancia().crearUsuario(doc,contra);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/obtenerCampeonatosDelClub")
	public List<CampeonatoVO> obtenerCampeonatosDelClub(@RequestParam int idClub) throws ClubException {
		       return Controlador.getInstancia().obtenerCampeonatosDeClub(idClub);
		    }
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/clubesCampeonato")
	public List<ClubVO> obtenerClubesCampeonato(@RequestParam int idCampeonato) throws ClubException, CampeonatoException {
	   return Controlador.getInstancia().getInscriptos(idCampeonato);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/obtenerTodaLaTablaPosiciones")
	public List<tablaPosicionesVO> obtenerTodaLaTablaPosiciones() throws ClubException, CampeonatoException, tablaPosicionesException{
		return Controlador.getInstancia().obtenerTodaLaTablaPosiciones();
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/BajaJugadorPartido")
	public void BajaJugadorPartido(@RequestParam int clubAux, @RequestParam int partidoAux,@RequestParam int jugadorAux ) throws MiembroException {
	Controlador.getInstancia().BajaJugadorPartido( clubAux, partidoAux, jugadorAux);
	}

	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@PostMapping("/AltaJugadorPartido")
	public void AltaJugadorPartido(@RequestParam int clubAux, @RequestParam int partidoAux,@RequestParam int jugadorAux ) throws MiembroException {
	Controlador.getInstancia().BajaJugadorPartido( clubAux, partidoAux, jugadorAux);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/partidosGanados")
	public int partidosGanados(@RequestParam int idClub) throws  ClubException, tablaPosicionesException {
		  return  Controlador.getInstancia().obtenerCantidadPartidosGanados(idClub);
	}
	
	@CrossOrigin(origins="http://fulbito-back.azurewebsites.net")
	@RequestMapping("/partidosPerdidos")
	public int partidosPerdidos(@RequestParam int idClub) throws  ClubException, tablaPosicionesException {
		  return  Controlador.getInstancia().obtenerCantidadPartidosPerdidos(idClub);
	}
}

