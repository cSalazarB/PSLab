package modelo;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Tipo {
	static Long key = 1L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long idTipo;
	@Persistent
	private String nombre;
	
	public Tipo(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre(){
		return nombre;
	}
	public Long getId(){
		return idTipo;
	}
}
