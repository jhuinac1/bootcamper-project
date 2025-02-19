package com.organization.mvcproject.MGL_Task1.model;

import org.springframework.stereotype.Component;

import com.organization.mvcproject.api.model.GameInterface;

@Component
public class GameImpl implements GameInterface{

	private Long gameId;
	private String gameName;
	private String gameGenre;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}

}
