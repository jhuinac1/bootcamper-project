package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.MGL_Task1.model.GameImpl;
import com.organization.mvcproject.api.dao.MockDAOInterface;

@Repository
public class MockDAOImpl implements MockDAOInterface {
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<GameImpl> games = new ArrayList<GameImpl>();

	static {
		games = populateGames();
	}
	public static List<GameImpl> populateGames() {

		GameImpl game1 = new GameImpl();
		game1.setGameId(++gameId);
		game1.setGameGenre("Sport");
		game1.setGameName("Rocket League");

		GameImpl game2 = new GameImpl();
		game2.setGameId(++gameId);
		game2.setGameGenre("Shooter");
		game2.setGameName("Halo 3");

		GameImpl game3 = new GameImpl();
		game3.setGameId(++gameId);
		game3.setGameGenre("MMORPG");
		game3.setGameName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	//Read
	public List<GameImpl> retrieveAllGames() {
		return games;
	}

	//Update Or Create
	public GameImpl saveGame(GameImpl game) {
		if(game.getGameId() != null) {
			return updateGame(game);
			
		}
		
		game.setGameId(++gameId);
		games.add(game);
		return game;
	}
	
	private GameImpl updateGame(GameImpl game) {
		GameImpl gameIsFound = findGameById(game.getGameId());
		if(gameIsFound != null) {
			gameIsFound.setGameName(game.getGameName().length() > 0 ? game.getGameName(): gameIsFound.getGameName());
			gameIsFound.setGameGenre(game.getGameGenre().length() > 0 ? game.getGameGenre(): gameIsFound.getGameGenre());
		}
		return gameIsFound;
	}
	
	
	

	public GameImpl findGameById(Long gameId) {
		for(GameImpl game: games) {
			if(game.getGameId().equals(gameId)) {
				return game;
			}
		}
		return null;
	}
	
	public boolean deleteGame(GameImpl game) {
		GameImpl gameIsFound = findGameById(game.getGameId());
		
		if(gameIsFound != null) {
			for(int i = 0; i < games.size(); i++) {
				if(gameIsFound.getGameId().equals(games.get(i).getGameId())) {
					games.remove(i);
					return true;
				}
			}
		}
				
		return false;
	}

}
