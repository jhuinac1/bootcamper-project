'use strict';

angular.module('MGL_Task1_app').controller('MGL_Task1_Controller',
		[ 'MGL_Task1_Service','$scope', function(MGL_Task1_Service, $scope) {
			var self = this;
			self.game = {
				game_id : '',
				game_name : '',
				game_genre : ''
			};
			self.games = [];

			self.fetchAllGames = function(){
				MGL_Task1_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task1_Service.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			self.removeGame = function () {
				console.log("Finish the remove functionality");
			
			}
			$scope.$on("submit-game-update", function (event, data) {
			 MGL_Task1_Service.updateGame(data) 
		  		.then( () => {
			  		self.fetchAllGames();
			  	})
			});

			self.fetchAllGames();
		} ]);
