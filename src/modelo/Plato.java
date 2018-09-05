package modelo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Blob;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Plato {
    
    @PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key idPlato;
    @Persistent
    private String nombre;
    @Persistent
    private String descripcion;
    @Persistent
    private String categoria;
    @Persistent
    private double precio;
    @Persistent
	private String keyoutsideImage;
	@Persistent
	private Blob outsideImage;
    

    public Plato(String nombre,String descrip,String categoria,double costo, String img) {
        super();
        this.nombre = nombre;
        this.descripcion = descrip;
        this.precio = costo;
        this.categoria=categoria;
        this.keyoutsideImage=img;
    }

    public String getIdPlato() {
        return KeyFactory.keyToString(idPlato);
    }

    public void setIdPlato(String idPlato) {
    	Key keyPlato = KeyFactory.stringToKey(idPlato);
		this.idPlato= KeyFactory.createKey(keyPlato,Plato.class.getSimpleName(), java.util.UUID.randomUUID().toString());
    }
    
    public void setIdPlato(Key idPlato) {
		this.idPlato = idPlato;
	}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

	public String getKeyoutsideImage() {
		return keyoutsideImage;
	}

	public void setKeyoutsideImage(String keyoutsideImage) {
		this.keyoutsideImage = keyoutsideImage;
	}

}