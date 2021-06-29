'use strict';

angular.module('MGL_Task1_app').factory('MGL_Task1_Service', ['$http', function($http) {

		var REST_SERVICE_URI = 'http://localhost:8080/';

		var factory = {
			fetchAllGames : fetchAllGames,
			createGame : createGame,
			updateGame: updateGame,
		};

		return factory;

		function fetchAllGames() {
			return $http.get(REST_SERVICE_URI + 'getAll').then(function(response) {
					return response.data;
				}
			);
		}

		function createGame(game) {
			return $http.post(REST_SERVICE_URI + 'createGame', game).then(function(response) {
					return response.data;
				}
			);
		}
		
		function updateGame(game) {
			return $http.post(REST_SERVICE_URI + 'updateGame', game)
				.then( response => {
					return response.data;
				});
		}

}]);
