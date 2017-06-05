package cz.jkoudelka.tictactoe.entityDomain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@MappedSuperclass
public class PersistenceUpdatableObject extends PersistenceObject {

	@Column(updatable = false, nullable = false)
	@CreationTimestamp
	private Date created;

	@Column(nullable = false)
	@UpdateTimestamp
	private Date lastUpdated;

	public Date getCreated() {
		return (Date) created.clone();
	}

	public Date getLastUpdated() {
		return (Date) lastUpdated.clone();
	}

}
