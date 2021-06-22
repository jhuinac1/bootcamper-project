package com.organization.mvcproject.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.organization.mvcproject.MGL_Task1.model.Game;


@Repository
public class MockDAO {
	private static Long gameId = new Long(0);
	private static Long companyId = new Long(0);
	private static List<Game> games = new ArrayList<Game>();

	static {
		games = populateGames();
	}

	private static List<Game> populateGames() {

		Game game1 = new Game();
		game1.setGameId(++gameId);
		game1.setGameGenre("Sport");
		game1.setGameName("Rocket League");

		Game game2 = new Game();
		game2.setGameId(++gameId);
		game2.setGameGenre("Shooter");
		game2.setGameName("Halo 3");

		Game game3 = new Game();
		game3.setGameId(++gameId);
		game3.setGameGenre("MMORPG");
		game3.setGameName("Runescape");

		games.add(game1);
		games.add(game2);
		games.add(game3);

		return games;
	}

	//Read
	public List<Game> retrieveAllGames() {
		return games;
	}

	//Update Or Create
	public Game saveGame(Game game) {		
		
		if(game.getGameId() != null) {
			updateGame(game.getGameId());
		}
		
		game.setGameId(++gameId);
		games.add(game);
		return game;
	}
	
	private Game updateGame(Long gameId) {
		Game gameIsFound = findGameById(gameId);
		if(gameIsFound != null) {
			for(int i = 0; i < games.size(); i++) {
				if(gameIsFound.getGameId().equals(games.get(i).getGameId())) {
					games.set(i, gameIsFound);
				}
			}
		}
		return gameIsFound;
	}
	
	
	

	public Game findGameById(Long gameId) {
		for(Game game: games) {
			if(game.getGameId().equals(gameId)) {
				return game;
			}
		}
		return null;
	}
	
	public boolean deleteGame(Game game) {
		Game gameIsFound = findGameById(game.getGameId());
		
		
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
