package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import daos.JugadorDAO;
import vo.JugadorVO;


@Entity
@Table(name = "jugadores")
public class Jugador implements Comparable<Jugador>, Serializable{


	private static final long serialVersionUID = 4254498499286646208L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idJugador;
	
	@Column (name="numeroDocumento")
	private Integer documento;
	private String nombre;
	private String apellido;
	
	

	@Column (name="fechaNac")
	private String fechaNacimiento;
	
	private int categoria;
	@Column (name="tipoDocumento")
	private String tipoDoc;
	private String direccion;
	private String mail;
	private Integer telefono;
	private String estadoJugador;
	private String permaneceClub;
	
	public String getPermaneceClub() {
		return permaneceClub;
	}

	
	public void setPermaneceClub(String permaneceClub) {
		this.permaneceClub = permaneceClub;
	}


	@ManyToOne
	@JoinColumn(name= "idClub")
	private Club club;
	
	@OneToMany(mappedBy ="jugador",fetch = FetchType.EAGER)
	private List<Gol> goles;
	
	@OneToMany(mappedBy ="jugador",fetch = FetchType.EAGER)
	private List<Falta> faltas;
	
	
	public Jugador() {}
	
	public void cambiarClub(Club club) {
		this.club=club;
		JugadorDAO.getInstancia().actualizar(this);
	}

	public void agregarGol(Gol gol) {
		goles.add(gol);
		JugadorDAO.getInstancia().actualizar(this);
	}
	
	public void agregarFalta(Falta falta) {
		faltas.add(falta);
		JugadorDAO.getInstancia().actualizar(this);
	}
	
	public Jugador(Integer documento, String nombre,String apellido, Club club, String tipoDoc,String fechaNacimiento2) {
		this.idJugador = null;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido=apellido;
		this.club = club;
		this.tipoDoc=tipoDoc;
		this.fechaNacimiento = fechaNacimiento2;
		String[] parts = fechaNacimiento.split("/");
		//String part1 = parts[0]; // 123
		//String part2 = parts[1];
		String part3 = parts[2];
		this.categoria = Integer.parseInt(part3.substring(2));
        this.goles = new ArrayList<Gol>();
        this.faltas = new ArrayList<Falta>();
	}
	

	public Jugador(Integer idJugador, Integer documento, String nombre, String apellido, String fechaNacimiento,
			int categoria, String tipoDoc, String estadoJugador, String permaneceClub, Club club) {
		super();
		this.idJugador = idJugador;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.categoria = categoria;
		this.tipoDoc = tipoDoc;
		this.estadoJugador = estadoJugador;
		this.permaneceClub = permaneceClub;
		this.club = club;
	}

	public Jugador(Integer documento, String nombre, Club club, String fechaNacimiento2) {
		this.idJugador = null;
		this.documento = documento;
		this.nombre = nombre;
		this.club = club;
		this.fechaNacimiento = fechaNacimiento2;
		String[] parts = fechaNacimiento.split("/");
		//String part1 = parts[0]; // 123
		//String part2 = parts[1];
		String part3 = parts[2];
		this.categoria = Integer.parseInt(part3.substring(2));
        this.goles = new ArrayList<Gol>();
        this.faltas = new ArrayList<Falta>();
	}
	

	public Jugador(Integer idJugador, Integer documento, String nombre, Club club, String fechaNacimiento, int categoria,
			List<Gol> goles, List<Falta> faltas) {
		this.idJugador = idJugador;
		this.documento = documento;
		this.nombre = nombre;
		this.club = club;
		this.fechaNacimiento = fechaNacimiento;
		this.categoria = categoria;
		this.goles = goles;
		this.faltas = faltas;
		String[] parts = fechaNacimiento.split("/");
		//String part1 = parts[0]; // 123
		//String part2 = parts[1];
		String part3 = parts[2];
		this.categoria  = Integer.parseInt(part3.substring(2));
        this.goles = new ArrayList<Gol>();
        this.faltas = new ArrayList<Falta>();
	}
	

	public Jugador(Integer documento, String nombre, String apellido, String fechaNacimiento, int categoria,
			String tipoDoc, String direccion, String mail, int telefono, String estadoJugador, Club club,
			List<Gol> goles, List<Falta> faltas) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.categoria = categoria;
		this.tipoDoc = tipoDoc;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.estadoJugador = estadoJugador;
		this.club = club;
		this.goles = goles;
		this.faltas = faltas;
		String[] parts = fechaNacimiento.split("/");
		//String part1 = parts[0];
		//String part2 = parts[1];
		String part3 = parts[2];
		this.categoria = Integer.parseInt(part3.substring(2));
        this.goles = new ArrayList<Gol>();
        this.faltas = new ArrayList<Falta>();
	}

	public Jugador(Integer idJugador, Club club) {
		this.idJugador = idJugador;
		this.club = club;
	}


	public Integer getDocumento() {
		return documento;
	}


	public void setDocumento(Integer documento) {
		this.documento = documento;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Club getClub() {
		return club;
	}


	public void setClub(Club club) {
		this.club = club;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getCategoria() {
		return categoria;
	}


	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}


	public List<Gol> getGoles() {
		return goles;
	}


	public void setGoles(List<Gol> goles) {
		this.goles = goles;
	}


	public List<Falta> getFaltas() {
		return faltas;
	}


	public void setFaltas(List<Falta> faltas) {
		this.faltas = faltas;
	}


	public Integer getIdJugador() {
		return idJugador;
	}
	
	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEstadoJugador() {
		return estadoJugador;
	}

	public void setEstadoJugador(String estadoJugador) {
		this.estadoJugador = estadoJugador;
	}
	
	@Override
	public int compareTo(Jugador o) {
		return this.documento.compareTo(o.getDocumento());
	}
	
	public void grabar() {
		JugadorDAO.getInstancia().grabar(this);
	}

	@Override
	public String toString() {
		return "Jugador [documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", categoria=" + categoria + ", tipoDoc=" + tipoDoc
				+ ", idClub=" + club.getIdClub() + "]";
	}

	public JugadorVO toVO() {
       // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
     //   String fecha = formatter.format(this.fechaNacimiento);
        return new JugadorVO(idJugador,documento, nombre, apellido, fechaNacimiento, tipoDoc, club.toVO(),direccion,mail,telefono,estadoJugador,club.getIdClub(),permaneceClub);
    }
	

	public void eliminar() {
		JugadorDAO.getInstancia().eliminar(this);
		
	}
	
	
	
	
}