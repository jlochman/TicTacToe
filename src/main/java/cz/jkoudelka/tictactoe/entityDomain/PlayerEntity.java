package cz.jkoudelka.tictactoe.entityDomain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Tato entita popisuje hrace. Obsahuje jeho {@link #name}, heslo {@link #pwd},
 * datum posledniho logu {@link #lastLogin} (zatim nepouzito). Dale
 * {@link #games} je vazba 1:N na tabulku se hrami, ktere hrac odehral a
 * {@link #logs} je vazba 1:N na logy, ktere byli k tomuto hraci zaznamenany.
 * 
 * @author jlochman
 *
 */
@Entity
public class PlayerEntity extends PersistenceUpdatableObject {

	@Column
	private String name;

	@Column
	private String pwd;

	@Column
	private Date lastLogin;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<GameEntity> games = new HashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PlayerLogEntity> logs = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getLastLogin() {
		return (Date) lastLogin.clone();
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Set<GameEntity> getGames() {
		return games;
	}

	public void setGames(Set<GameEntity> games) {
		if (games != null) {
			for (GameEntity game : games) {
				game.setPlayer(this);
			}
		}
		this.games = games;
	}

	public void addGames(GameEntity... games) {
		if (games != null) {
			for (GameEntity game : games) {
				game.setPlayer(this);
				this.games.add(game);
			}
		}
	}

	public Set<PlayerLogEntity> getLogs() {
		return logs;
	}

	public void setLogs(Set<PlayerLogEntity> logs) {
		if (logs != null) {
			for (PlayerLogEntity log : logs) {
				log.setPlayer(this);
			}
		}
		this.logs = logs;
	}

	public void addLogs(PlayerLogEntity... logs) {
		if (logs != null) {
			for (PlayerLogEntity log : logs) {
				log.setPlayer(this);
				this.logs.add(log);
			}
		}
	}

}
