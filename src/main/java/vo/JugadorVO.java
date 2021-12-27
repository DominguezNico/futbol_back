package vo;

import java.io.Serializable;

import modelo.Jugador;

public class JugadorVO implements Serializable {

    private static final long serialVersionUID = 5630047463431371436L;

    private int documento;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String tipoDoc;
    private ClubVO clubVO;
    private int idJugador;
    private int idClub;
    private String direccion;
    private String mail;
    private Integer telefono;
    private String estadoJugador;
    private String permaneceClub;
  

    public JugadorVO(int idJugador,Integer documento, String nombre, String apellido, String fecha,
            String tipoDoc, ClubVO clubVO,String direccion,String mail,Integer telefono,String estado,Integer idClub,String permaneceClub) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fecha;
        this.tipoDoc = tipoDoc;
        this.clubVO = clubVO;
        this.idJugador=idJugador;
        this.direccion=direccion;
        this.mail=mail;
        this.telefono=telefono;
        this.estadoJugador=estado;
        this.idClub=idClub;
        this.setPermaneceClub(permaneceClub);
        }



    public int getIdClub() {
        return idClub;
    }



    public void setIdClub(int idClub) {
        this.idClub = idClub;
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



    public Integer getTelefono() {
        return telefono;
    }



    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }



    public String getEstadoJugador() {
        return estadoJugador;
    }



    public void setEstadoJugador(String estadoJugador) {
        this.estadoJugador = estadoJugador;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public int getId() {
        return this.idJugador;
    }
    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Jugador toModelo() {
        return new Jugador(documento, nombre,apellido, clubVO.toModelo(), tipoDoc,fechaNacimiento);
    }



	public String getPermaneceClub() {
		return permaneceClub;
	}



	public void setPermaneceClub(String permaneceClub) {
		this.permaneceClub = permaneceClub;
	}


}