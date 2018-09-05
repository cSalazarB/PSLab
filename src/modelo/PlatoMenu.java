package modelo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PlatoMenu{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key idPlatoMenu;
	@Persistent
	private String plato;
	@Persistent
	private int cantidad;
	@Persistent
	private String tipo;

	public PlatoMenu(String idPlato,int cantidad,String t) {
		super();
		plato = idPlato;
		this.cantidad = cantidad;
		this.tipo = t;
	}
	
	public PlatoMenu(Plato p,int cantidad,String t) {
		super();
		plato = p.getIdPlato();
		this.cantidad = cantidad;
		this.tipo = t;
	}
	public void setIdPlatoMenu(String id){
		Key keyPlatoMenu = KeyFactory.stringToKey(id);
		this.idPlatoMenu = KeyFactory.createKey(keyPlatoMenu,PlatoMenu.class.getSimpleName(),java.util.UUID.randomUUID().toString());
	}
	public String getIdPlatoMenu(){
		return KeyFactory.keyToString(idPlatoMenu);
	}
	public void setPlato(String p){
		this.plato = p;
	}
	public String getPlato() {
		return this.plato;
	}
	public void setCantidad(int cant){
		this.cantidad = cant;
	}
	public int getCantidad(){
		return cantidad;
	}
	public void setTipo(String cant){
		this.tipo = cant;
	}
	public String getTipo(){
		return tipo;
	}
}
