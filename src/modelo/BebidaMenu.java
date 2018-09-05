package modelo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class BebidaMenu{
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key idBebidaMenu;
	@Persistent
	private String bebida;
	@Persistent
	private int cantidad;
	@Persistent
	private String tipo;

	public BebidaMenu(String idBebida,int cantidad,String t) {
		super();
		bebida = idBebida;
		this.cantidad = cantidad;
		this.tipo = t;
	}
	
	public BebidaMenu(Bebida p,int cantidad,String t) {
		super();
		bebida = p.getIdBebida();
		this.cantidad = cantidad;
		this.tipo = t;
	}
	public void setIdBebidaMenu(String id){
		Key keyBebidaMenu = KeyFactory.stringToKey(id);
		this.idBebidaMenu = KeyFactory.createKey(keyBebidaMenu,BebidaMenu.class.getSimpleName(),java.util.UUID.randomUUID().toString());
	}
	public String getIdBebidaMenu(){
		return KeyFactory.keyToString(idBebidaMenu);
	}
	public void setBebida(String p){
		this.bebida = p;
	}
	public String getBebida() {
		return this.bebida;
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
