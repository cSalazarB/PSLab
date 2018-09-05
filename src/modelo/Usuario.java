/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.annotations.Unowned;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Usuario {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key idUsuario;
	@Persistent
	private String email;
	@Persistent
	private String nombre;
	@Persistent
	private boolean sexo;
	@Persistent
	@Unowned
	private Tipo tipo;
	
	public Usuario(String email,String nombre, boolean sexo) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.sexo = sexo;
		tipo = null;
	}
	public void setTipo(Tipo tipo){
		this.tipo = tipo;
	}
	public String getNomber(){
		return this.nombre;
	}
	public String getEmail(){
		return this.email;
	}
	public String getTipoNombre(){
		return tipo.getNombre();
	}
	public Long getTipo(){
		return tipo.getId();
	}
}
