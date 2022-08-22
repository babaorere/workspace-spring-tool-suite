// Generated with g9.

package com.api.rest.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "biblioteca", indexes = { @Index(name = "biblioteca_nombre_IX", columnList = "nombre", unique = true) })

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bibliotecaId")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "bibliotecaId")
// https://www.youtube.com/watch?v=Ss2glBu4JfA
// Para evitar el error "spring.jackson.serialization.FAIL_ON_EMPTY_BEANS", 
// generado por la referencia circular de entre Biblioteca y Libro
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer", "FieldHandler" })
public class Biblioteca implements Serializable, Persistable<Long> {

	private static final long serialVersionUID = 1L;

	/** Primary key. */
	protected static final String PK = "bibliotecaId";

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getPk() {
		return PK;
	}

	/**
	 * The optimistic lock. Available via standard bean get/set operations.
	 * 
	 * https://stackoverflow.com/questions/2572566/java-jpa-version-annotation
	 * https://www.baeldung.com/jpa-optimistic-locking
	 */
	@Version
	@Column(name = "LOCK_FLAG", columnDefinition = "integer DEFAULT 0", nullable = false)
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
	@Column(name = "biblioteca_id", unique = true, nullable = false, precision = 19)
	private Long bibliotecaId;

	@Column(unique = true, nullable = false, length = 255)
	private String nombre;

	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JsonProperty(access = Access.WRITE_ONLY)
//	@JsonManagedReference
//	@JsonBackReference
//	@Transient
	private Set<Libro> libros;

	/** Default constructor. */
	public Biblioteca() {
		super();
		bibliotecaId = null;
	}

	/**
	 * Access method for bibliotecaId.
	 *
	 * @return the current value of bibliotecaId
	 */
	public Long getBibliotecaId() {
		return bibliotecaId;
	}

	/**
	 * Setter method for bibliotecaId.
	 *
	 * @param aBibliotecaId the new value for bibliotecaId
	 */
	public void setBibliotecaId(Long aBibliotecaId) {
		bibliotecaId = aBibliotecaId;
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
	 * Access method for libros.
	 *
	 * @return the current value of libros
	 */
	public Set<Libro> getLibros() {
		return libros;
	}

	/**
	 * Setter method for libros.
	 *
	 * @param aLibros the new value for libros
	 */
	public void setLibros(Set<Libro> aLibros) {
		libros = aLibros;
	}

	/**
	 * Compares the key for this instance with another Biblioteca.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class Biblioteca and the key
	 *         objects are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Biblioteca)) {
			return false;
		}
		Biblioteca that = (Biblioteca) other;
		if (this.getBibliotecaId() != that.getBibliotecaId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another Biblioteca.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Biblioteca))
			return false;
		return this.equalKeys(other) && ((Biblioteca) other).equalKeys(this);
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
		i = (int) (getBibliotecaId() ^ (getBibliotecaId() >>> 32));
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
		StringBuffer sb = new StringBuffer("[Biblioteca |");
		sb.append(" bibliotecaId=").append(getBibliotecaId());
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
		ret.put("bibliotecaId", Long.valueOf(getBibliotecaId()));
		return ret;
	}

	/**
	 * https://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference
	 * /html/jpa.repositories.html#jpa.entity-persistence.saving-entites
	 */
	@Override
	public Long getId() {
		return bibliotecaId;
	}

	/**
	 * https://docs.spring.io/spring-data/jpa/docs/1.4.1.RELEASE/reference
	 * /html/jpa.repositories.html#jpa.entity-persistence.saving-entites
	 */
	@Override
	public boolean isNew() {
		return bibliotecaId == null;
	}

}
