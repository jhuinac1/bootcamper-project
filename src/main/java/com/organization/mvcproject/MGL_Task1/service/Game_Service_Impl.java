package com.organization.mvcproject.MGL_Task1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGL_Task1.model.Game;
import com.organization.mvcproject.dao.MockDAO;

@Service("javaGameService")
public class Game_Service_Impl implements Game_Service {

	@Autowired
	private MockDAO gameDAO;
	

	@Override
	public List<Game> retrieveAllGames() {
		return gameDAO.retrieveAllGames();
	}
	
	@Override
	public Game saveGame(Game game) {
		return gameDAO.saveGame(game);
	}
	
	public boolean deleteGame(Game game) {
		return gameDAO.deleteGame(game);
	}

}




//
//public static Long getGameId() {
//	return gameId;
//}
//
//public static void setGameId(Long gameId) {
//	Game_Service_Impl.gameId = gameId;
//}

//public static Long getCompanyId() {
//	return companyId;
//}

//public static void setCompanyId(Long companyId) {
//	Game_Service_Impl.companyId = companyId;
//}