package modelo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;

//import org.apache.tools.ant.taskdefs.Java;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Bebida {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key idBebida;
	@Persistent
	private String nombre;
	@Persistent
	private double precio;
	@Persistent
	private String categoria;
	@Persistent
	private String keyoutsideImage;
	@Persistent
	private Blob outsideImage;
	
	public Bebida(){}

	public Bebida(String name,double prec,String cat,String img){
		super();
		nombre=name;
		precio=prec;
		categoria=cat;
		keyoutsideImage=img;
	}
	public String getIdBebida() {
		return KeyFactory.keyToString(idBebida);
	}
	public void setIdBebida(String idBebida){
		Key keyBebida = KeyFactory.stringToKey(idBebida);
		this.idBebida= KeyFactory.createKey(keyBebida,Bebida.class.getSimpleName(), java.util.UUID.randomUUID().toString());
	}
	
	public void setIdBebida(Key idBebida) {
		this.idBebida = idBebida;
	}

	public String getNombre(){
		return nombre;
	}
	public void setNombre(String name){
		nombre=name;
	}
	public double getPrecio(){
		return precio;
	}
	public void setPrecio(double prec){
		this.precio=prec;
	}
	public String getCategoria(){
		return categoria;
	}
	public void setCategoria(String cat){
		this.categoria=cat;
	}

	public String getKeyoutsideImage() {
		return keyoutsideImage;
	}

	public void setKeyoutsideImage(String keyoutsideImage) {
		this.keyoutsideImage = keyoutsideImage;
	}

}
