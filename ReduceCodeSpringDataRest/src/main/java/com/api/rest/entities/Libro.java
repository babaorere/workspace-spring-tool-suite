// Generated with g9.

package com.api.rest.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name = "libros", indexes = { @Index(name = "libros_nombre_IX", columnList = "nombre", unique = true) })
public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "libroId";

	/**
	 * The optimistic lock. Available via standard bean get/set operations.
	 */
	@Version
	@Column(name = "LOCK_FLAG")
	private Integer lockFlag;

	/**
	 * Access method for the lockFlag property.
	 *
	 * @return the current value of the lockFlag property
	 */
	public Integer getLockFlag() {
		return lockFlag;
	}

	/**
	 * Sets the value of the lockFlag property.
	 *
	 * @param aLockFlag the new value of the lockFlag property
	 */
	public void setLockFlag(Integer aLockFlag) {
		lockFlag = aLockFlag;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "libro_id", unique = true, nullable = false, precision = 19)
	private long libroId;

	@Column(unique = true, nullable = false, length = 255)
	private String nombre;

	@ManyToOne(optional = false)
	@JoinColumn(name = "biblioteca_id", nullable = false)
	private Biblioteca biblioteca;

	/** Default constructor. */
	public Libro() {
		super();
	}

	/**
	 * Access method for libroId.
	 *
	 * @return the current value of libroId
	 */
	public long getLibroId() {
		return libroId;
	}

	/**
	 * Setter method for libroId.
	 *
	 * @param aLibroId the new value for libroId
	 */
	public void setLibroId(long aLibroId) {
		libroId = aLibroId;
	}

	/**
	 * Access method for nombre.
	 *
	 * @return the current value of nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter method for nombre.
	 *
	 * @param aNombre the new value for nombre
	 */
	public void setNombre(String aNombre) {
		nombre = aNombre;
	}

	/**
	 * Access method for biblioteca.
	 *
	 * @return the current value of biblioteca
	 */
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}

	/**
	 * Setter method for biblioteca.
	 *
	 * @param aBiblioteca the new value for biblioteca
	 */
	public void setBiblioteca(Biblioteca aBiblioteca) {
		biblioteca = aBiblioteca;
	}

	/**
	 * Compares the key for this instance with another Libros.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Libros and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Libro)) {
			return false;
		}
		Libro that = (Libro) other;
		if (this.getLibroId() != that.getLibroId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another Libros.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Libro))
			return false;
		return this.equalKeys(other) && ((Libro) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = (int) (getLibroId() ^ (getLibroId() >>> 32));
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[Libros |");
		sb.append(" libroId=").append(getLibroId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("libroId", Long.valueOf(getLibroId()));
		return ret;
	}

}
