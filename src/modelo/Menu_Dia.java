package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Menu_Dia {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key idMenu;
	@Persistent
	private ArrayList<String> platos;
	@Persistent
	private ArrayList<String> bebidas;
	@Persistent
	private int anio;
	@Persistent
	private int mes;
	@Persistent
	private int dia;
	@Persistent
	private int hora;
	@Persistent
	private int minuto;

	public Menu_Dia(){
		super();	    
	    Date d1 = new Date();
	    Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
	    calendar.setTime(d1);   // assigns calendar to given date 
	       
		this.anio = (int)calendar.get(Calendar.YEAR);
		this.mes = (int) calendar.get(Calendar.MONTH);
		this.dia = (int)calendar.get(Calendar.DAY_OF_MONTH);
		this.hora = (int)calendar.get(Calendar.HOUR);
		this.minuto = (int)calendar.get(Calendar.MINUTE);
		platos = new ArrayList<String>();
		bebidas = new ArrayList<String>();
		
	}
	public String getIdMenu() {
		return KeyFactory.keyToString(idMenu);
	}
	public void setIdMenu(String idMenu){
		Key keyMenu = KeyFactory.stringToKey(idMenu);
		this.idMenu = KeyFactory.createKey(keyMenu,Menu_Dia.class.getSimpleName(), java.util.UUID.randomUUID().toString());
	}
	public int getAnio(){
		return anio;
	}
	public void setAnio(int anio){
		this.anio = anio;
	}
	public int getMes(){
		return mes;
	}
	public void setMes(int mes){
		this.mes = mes;
	}
	public int getDia(){
		return dia;
	}
	public void setDia(int dia){
		this.dia = dia;
	}
	public int getHora(){
		return hora;
	}
	public void setHora(int hora){
		this.hora = hora;
	}
	public int getMinuto(){
		return minuto;
	}
	public void setMinuto(int minuto){
		this.minuto = minuto;
	}
	public ArrayList<String> getPlatos(){
		return platos;
	}
	public void setPlatos(ArrayList<String> p){
		this.platos = p;
	}
	public ArrayList<String> getBebidas(){
		return bebidas;
	}
	public void setBebidas(ArrayList<String> b){
		this.bebidas = b;
	}
}