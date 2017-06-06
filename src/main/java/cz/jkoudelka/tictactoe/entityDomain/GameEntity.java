package cz.jkoudelka.tictactoe.entityDomain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cz.jkoudelka.tictactoe.entityDomain.enums.BoardSymbol;
import cz.jkoudelka.tictactoe.entityDomain.enums.CPULogic;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameInitiator;
import cz.jkoudelka.tictactoe.entityDomain.enums.GameResult;

@Entity
public class GameEntity extends PersistenceUpdatableObject {

	@Column
	@Enumerated(EnumType.STRING)
	private BoardSymbol playerSymbol = BoardSymbol.CROSS;

	@Column
	@Enumerated(EnumType.STRING)
	private BoardSymbol cpuSymbol = BoardSymbol.NOUGHT;

	@Column
	@Enumerated(EnumType.STRING)
	private GameResult result = GameResult.DNF;

	@Column
	@Enumerated(EnumType.STRING)
	private GameInitiator initiator = GameInitiator.PLAYER;

	@Column
	@Enumerated(EnumType.STRING)
	private CPULogic cpuLogic = CPULogic.RANDOMIZER;

	@Column(length = 1000)
	private String history;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<GameLogEntity> logs = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	private PlayerEntity player;

	public BoardSymbol getPlayerSymbol() {
		return playerSymbol;
	}

	public void setPlayerSymbol(BoardSymbol playerSymbol) {
		this.playerSymbol = playerSymbol;
	}

	public BoardSymbol getCpuSymbol() {
		return cpuSymbol;
	}

	public void setCpuSymbol(BoardSymbol cpuSymbol) {
		this.cpuSymbol = cpuSymbol;
	}

	public GameResult getResult() {
		return result;
	}

	public void setResult(GameResult result) {
		this.result = result;
	}

	public GameInitiator getInitiator() {
		return initiator;
	}

	public void setInitiator(GameInitiator initiator) {
		this.initiator = initiator;
	}

	public CPULogic getCpuLogic() {
		return cpuLogic;
	}

	public void setCpuLogic(CPULogic cpuLogic) {
		this.cpuLogic = cpuLogic;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public Set<GameLogEntity> getLogs() {
		return logs;
	}

	public void setLogs(Set<GameLogEntity> logs) {
		if (logs != null) {
			for (GameLogEntity log : logs) {
				log.setGame(this);
			}
		}
		this.logs = logs;
	}

	public void addLogs(GameLogEntity... logs) {
		if (logs != null) {
			for (GameLogEntity log : logs) {
				log.setGame(this);
				this.logs.add(log);
			}
		}
	}

	public PlayerEntity getPlayer() {
		return player;
	}

	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}

}
