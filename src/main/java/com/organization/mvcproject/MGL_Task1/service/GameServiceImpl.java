package com.organization.mvcproject.MGL_Task1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.MGL_Task1.model.GameImpl;
import com.organization.mvcproject.api.service.Game_Service;
import com.organization.mvcproject.dao.MockDAOImpl;

@Service("javaGameService")
public class GameServiceImpl implements Game_Service {

	@Autowired
	private MockDAOImpl gameDAO;
	

	@Override
	public List<GameImpl> retrieveAllGames() {
		return gameDAO.retrieveAllGames();
	}
	
	@Override
	public GameImpl saveGame(GameImpl game) {
		return gameDAO.saveGame(game);
	}
	
	public boolean deleteGame(GameImpl game) {
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