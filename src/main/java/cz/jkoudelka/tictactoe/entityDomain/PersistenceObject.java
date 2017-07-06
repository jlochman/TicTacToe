package cz.jkoudelka.tictactoe.entityDomain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Zakladni trida pro entity. Kazda entita (jakykoliv radek v DB) bude mit id;
 * 
 * @author jlochman
 *
 */
@MappedSuperclass
public class PersistenceObject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id = null;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}