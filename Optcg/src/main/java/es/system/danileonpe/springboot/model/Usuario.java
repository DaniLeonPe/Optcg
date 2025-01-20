package es.system.danileonpe.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(nullable = false, unique = true)
	private String nombreUsuario;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String contraseña;

	@Column(name = "fecha_registro", columnDefinition = "TIMESTAMP")
	private LocalDateTime fechaRegistro = LocalDateTime.now();

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario user = (Usuario) o;
		return Objects.equals(idUsuario, user.idUsuario);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(idUsuario);
	}

	@Override
	public String toString() {
		return "User [id=" + idUsuario + ", name=" + nombreUsuario + "email= " + email + "]";
	}
	
}
