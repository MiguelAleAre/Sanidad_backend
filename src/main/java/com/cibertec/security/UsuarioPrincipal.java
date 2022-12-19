package com.cibertec.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cibertec.entity.Opcion;
import com.cibertec.entity.Rol;
import com.cibertec.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.apachecommons.CommonsLog;

@AllArgsConstructor
@CommonsLog
@ToString
public class UsuarioPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String login;
	private String password;
	private String nombreUsuario;
	private static String nombreCompleto;
	private Collection<? extends GrantedAuthority> authorities;
	private List<Opcion> opciones;
	
	
	
	
	
	public static UsuarioPrincipal build(Usuario usuario, List<Rol> roles, List<Opcion> opciones) {
		log.info(">>>UsuarioPrincipal >> " + usuario);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Rol x : roles) {
			authorities.add(new SimpleGrantedAuthority(x.getNombre()));
		}
		nombreCompleto = usuario.getNombreCompleto();
		return new UsuarioPrincipal(usuario.getIdUsuario(), usuario.getLogin(), usuario.getPassword(), usuario.getNombreCompleto(), authorities, opciones);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

	public String getNombreCompleto() {
		return nombreCompleto;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public List<Opcion> getOpciones() {
		return opciones;
	}

	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}

	public static org.apache.commons.logging.Log getLog() {
		return log;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void setNombreCompleto(String nombreCompleto) {
		UsuarioPrincipal.nombreCompleto = nombreCompleto;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

}
