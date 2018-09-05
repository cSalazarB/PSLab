package modelo;
import javax.jdo.annotations.IdentityType;

//import java.util.ArrayList;


//import java.util.List;
//import javax.jdo.PersistenceManager;
//import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Permiso {
	static Long key = 1L;
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.SEQUENCE)
	private Long idPermiso;
	@Persistent
	private Long idTipo;
	@Persistent
	private Long idRecurso;
	@Persistent
	private boolean enable;
	
	public Permiso(Long idTipo, Long idRecurso) {
		super();
		this.idTipo = idTipo;
		this.idRecurso = idRecurso;
		this.enable = false;	
	}
	public Long getId(){
		return idPermiso;
	}
	public boolean getEnable(){
		return enable;
	}
	public void setEnable(boolean enable){
		this.enable = enable;
	}
	public Long getIdRec(){
		return this.idRecurso;
	}
	public Long getIdTip(){
		return this.idTipo;
	}
}
