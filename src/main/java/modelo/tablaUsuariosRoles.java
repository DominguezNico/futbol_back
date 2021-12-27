package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import daos.tablaUsuariosRolesDAO;
import vo.tablaUsuariosRolesVO;


@Entity
@Table(name="usuarios")
public class tablaUsuariosRoles implements  Serializable{

	private static final long serialVersionUID = -5404925459684653162L;

	@Id
	@Column (name="documento")
	private String documento;
	@Column (name="contraseña")
	private String contraseña;
	@Column (name="rol")
	private String rol;
	
	
	
	public tablaUsuariosRoles() {}
	@Override
	public String toString() {
		return "tablaUsuariosRoles  [usuario=" + documento + "  ,rol " + rol;
	}
	public tablaUsuariosRoles( String doc, String contraseña, String rol) {
		this.documento=doc;
		this.contraseña=contraseña;
		this.rol=rol;
	}
	
	public String getRol() {
		return this.rol;
	}
	
	public void setRol(String nuevoRol) {
		this.rol=nuevoRol;
	}


	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getcontraseña() {
		return contraseña;
	}

	public void setcontraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
	public String getcontraseñaPorDocumento(String doc) {
		return this.contraseña;
	}
	
	public void grabar() {
		tablaUsuariosRolesDAO.getInstancia().grabar(this);
	}
	
	public tablaUsuariosRolesVO  toVO() {
		return new tablaUsuariosRolesVO( documento, contraseña, rol);
	}
}



