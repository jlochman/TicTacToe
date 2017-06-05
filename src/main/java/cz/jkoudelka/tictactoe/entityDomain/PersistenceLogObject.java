package cz.jkoudelka.tictactoe.entityDomain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import cz.jkoudelka.tictactoe.entityDomain.enums.LogLevel;

@MappedSuperclass
public class PersistenceLogObject extends PersistenceObject {

	@Column
	@Enumerated(EnumType.STRING)
	private LogLevel logLevel;

	@Column
	private Date loggedDate;

	@Column(length = 1000)
	private String msg;

	public LogLevel getLogLevel() {
		return logLevel;
	}

	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

	public Date getLoggedDate() {
		return loggedDate;
	}

	public void setLoggedDate(Date loggedDate) {
		this.loggedDate = loggedDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
