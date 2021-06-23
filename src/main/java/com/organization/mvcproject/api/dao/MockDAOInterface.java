package com.organization.mvcproject.api.dao;

import java.util.List;

import com.organization.mvcproject.MGL_Task1.model.GameImpl;

public interface MockDAOInterface {
		
	List<GameImpl> retrieveAllGames();

	GameImpl saveGame(GameImpl game);	

	GameImpl findGameById(Long gameId);
	
	boolean deleteGame(GameImpl game);
}
