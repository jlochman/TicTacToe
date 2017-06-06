package cz.jkoudelka.tictactoe.entityDomain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class PersistenceUpdatableObject extends PersistenceObject {

	@Column
	@CreationTimestamp
	private Timestamp created;

	@Column
	@UpdateTimestamp
	private Timestamp lastUpdated;

	public Timestamp getCreated() {
		return (Timestamp) created.clone();
	}

	public Timestamp getLastUpdated() {
		return (Timestamp) lastUpdated.clone();
	}

}
