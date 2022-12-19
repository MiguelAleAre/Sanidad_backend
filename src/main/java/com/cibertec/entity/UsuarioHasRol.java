package com.cibertec.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuario_has_rol")
public class UsuarioHasRol {

	@EmbeddedId
	private UsuarioHasRolPK usuarioHasRolPk;

	@ManyToOne
	@JoinColumn(name = "idUsuario", nullable = false, insertable = false, updatable = false)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idRol", nullable = false, insertable = false, updatable = false)
	private Rol rol;

	public UsuarioHasRolPK getUsuarioHasRolPk() {
		return usuarioHasRolPk;
	}

	public void setUsuarioHasRolPk(UsuarioHasRolPK usuarioHasRolPk) {
		this.usuarioHasRolPk = usuarioHasRolPk;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

}
