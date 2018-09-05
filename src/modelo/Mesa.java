package modelo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Mesa {
    
    @PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key idMesa;
    @Persistent
    private String nombre;
    @Persistent
    private int numSillas;
    @Persistent
    private String imagen;
    @Persistent
    private boolean disponible;
    
    public Mesa() {
    }

    public Mesa(String nombre,int numSillas,String img,boolean dispo) {
        super();
        this.nombre = nombre;
        this.numSillas = numSillas;
        this.imagen = img;
        this.disponible=dispo;
    }

    public String getIdMesa() {
        return KeyFactory.keyToString(idMesa);
    }

    public void setIdMesa(String idMesa) {
    	Key keyMesa = KeyFactory.stringToKey(idMesa);
		this.idMesa= KeyFactory.createKey(keyMesa,Mesa.class.getSimpleName(), java.util.UUID.randomUUID().toString());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(int num) {
        this.numSillas = num;
    }
    
    public String getImagen(){
		return imagen;
	}
	public void setImagen(String img){
		imagen=img;
	}
	public boolean getDisponible(){
		return disponible;
	}
	public void setDisponible(boolean disp){
		disponible=disp;
	}
}
