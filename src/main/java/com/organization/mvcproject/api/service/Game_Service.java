package com.organization.mvcproject.api.service;

import java.util.List;

import com.organization.mvcproject.MGL_Task1.model.GameImpl;

public interface Game_Service {

	List<GameImpl> retrieveAllGames();

	GameImpl saveGame(GameImpl game);

}
