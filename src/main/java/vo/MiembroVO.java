package vo;



import java.io.Serializable;




public class MiembroVO implements Serializable{




private static final long serialVersionUID = -1428749045311742589L;

private Integer idLista;
private ClubVO club;
private JugadorVO jugador;
private Integer ingreso;
private Integer egreso;
private String estadoJugadorPartido;
public MiembroVO() {}

public MiembroVO(Integer idLista, ClubVO club, JugadorVO jugador, Integer ingreso, Integer egreso, String estadoJugadorPartido) {
this.setIdLista(idLista);
this.setClub(club);
this.setJugador(jugador);
this.setIngreso(ingreso);
this.setEgreso(egreso);
this.setEstadoJugadorPartido(estadoJugadorPartido);
}



public void toModelo() {
}





public Integer getIdLista() {
return idLista;
}



public void setIdLista(Integer idLista) {
this.idLista = idLista;
}



public ClubVO getClub() {
return club;
}



public void setClub(ClubVO club) {
this.club = club;
}



public JugadorVO getJugador() {
return jugador;
}



public void setJugador(JugadorVO jugador) {
this.jugador = jugador;
}



public Integer getIngreso() {
return ingreso;
}



public void setIngreso(Integer ingreso) {
this.ingreso = ingreso;
}



public Integer getEgreso() {
return egreso;
}



public void setEgreso(Integer egreso) {
this.egreso = egreso;
}

public String getEstadoJugadorPartido() {
	return estadoJugadorPartido;
}

public void setEstadoJugadorPartido(String estadoJugadorPartido) {
	this.estadoJugadorPartido = estadoJugadorPartido;
}



}