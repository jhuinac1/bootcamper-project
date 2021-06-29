<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <html>

    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
        <script src="resources/static/js/app.js" /></script>
        <script src="resources/static/js/service/MGL_Task1.service.js"></script>
        <script src="resources/static/js/controller/MGL_Task1.controller.js"></script>

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Mist Library Task 1-Games</title>
        <style type="text/css">
            body {
            	background-image:
            		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
            	background-repeat: no-repeat;
            	background-size: cover;
            }
            
            #popUpWindowContainer {
            	position: absolute;
            	background-color: rgb(50,50,50, .7);
            	color: white;
            	top: 0px;
            	bottom: 0px;
            	left: 0px;
            	right: 0px;
            	display: flex;
            	justify-content: center;
            	align-items: center;            
            }
            
            #popUpWindowContainer > div {
            	border: 1px solid grey;
            	border-radius: 10px;
            	padding: 3em;
            	background-color: black;
            }
            
            #popUpWindowContainer > div form {
//             	border: 1px solid white;
            	border-radius: 10px;
            	padding: 3em;
            	display: flex;
            	flex-flow: column wrap;    
            }
            
            #popUpWindowContainer div form input[type=submit]{
            	background-color: yellow;
            	color: black;
            	border: 1px solid grey;
            	border-radius: 5px;
            	margin-top: 20px;
            }
            
            
        </style>
        <link rel="apple-touch-icon" sizes="180x180" href="/android-chrome-192x192.png">
    	<link rel="icon" type="image/png" sizes="32x32" href="resources/static/images/favicon-32x32.png">
    	<link rel="icon" type="image/png" sizes="16x16" href="resources/static/images/favicon-16x16.png">
    </head>

    <body ng-app="MGL_Task1_app" class="ng-cloak">
        <nav id="MistLibrary-navbar" class="navbar navbar-expand-md navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">
			<img src="resources/static/images/MGLlogo.png" width="90" height="60" alt="">
		</a>
            <a class="nav-item nav-link" href="games">Games</a>
            <a class="nav-item nav-link" href="review">Review</a>
        </nav>
        <br>
        <div class="container "  ng-controller="MGL_Task1_Controller as MGL_T1_ctrl">
            <div class="panel panel-default" id="games-controller">
                <div class="panel-heading text-light"><span class="lead">Game Registration Form </span></div>
                <div class="formcontainer">
                    <form ng-submit="MGL_T1_ctrl.addGame()" name="gameForm" class="form-horizontal">
                        <input type="hidden" ng-model="MGL_T1_ctrl.game.gameId" />
                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="gameName">Name*</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.gameName" id="gameName" class="gameName form-control input-sm" placeholder="Enter the name of the new game [required]" required ng-minlength="3" />
                                    <div class="has-error" ng-show="gameForm.$dirty">
                                        <span ng-show="gameForm.gameName.$error.required">This is a required field</span>
                                        <span ng-show="gameForm.gameName.$error.minlength">Minimum length required is 3</span>
                                        <span ng-show="gameForm.gameName.$invalid">This field is invalid </span>
                                    </div>
                                </div>
                            </div>
                        </div>


                        <div class="row">
                            <div class="form-group col-md-12">
                                <label class="col-md-2 control-lable text-light" for="gameGenre">Game Genre</label>
                                <div class="col-md-7">
                                    <input type="text" ng-model="MGL_T1_ctrl.game.gameGenre" id="gameGenre" class="form-control input-sm" placeholder="Enter the genre of the new game" />
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-actions floatRight">
                                <input type="submit" value="Add" class="btn btn-primary btn-sm">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel panel-default all-games-container">
                <!-- Default panel contents -->
                <div class="panel-heading text-light"><span class="lead">List of all current games</span></div>
                <div class="">
                    <table class="table table-dark table-striped text-light">
                        <thead>
                            <tr>
                                <th>Game Name</th>
                                <th>Game Genre</th>
                                <th class="text-center">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="currentGame in MGL_T1_ctrl.games">
                                <td><span ng-bind="currentGame.gameName"></span></td>
                                <td><span ng-bind="currentGame.gameGenre"></span></td>
                                <td class="row justify-content-center" > 
                                	<button class="btn btn-warning" id={{currentGame.gameId}} onClick="renderUpdateGameForm(this.id)" > Edit </button>
                                	<button class="btn btn-danger ml-3" ng-click="MGL_T1_ctrl.removeGame()" > Delete </button>
                                </td>
                            </tr>
                        </tbody>x
                    </table>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript" defer >
    
    //event to submit the form
    const submitUpdateForm = (gameId, nameInput, genreInput) =>{

    	const updatedGame = {
    		gameId: +gameId,
    		gameName: nameInput.value,
    		gameGenre: genreInput.value,    	
    	}
    	
    	const controllerElement = document.getElementById("games-controller");
    	const element = angular.element(controllerElement);
  		const scope = element.scope();
  		scope.$root.$broadcast("submit-game-update", updatedGame );    	
    }
    
    // Pop Up window to update to the new game
    
    
    
    const createPopUpWindow =  (gameId) => {
    
    	const popUpWindowContainer = document.createElement("div");
    	popUpWindowContainer.setAttribute("id", "popUpWindowContainer");
    	const innerContainer = document.createElement("div");
    	innerContainer.setAttribute("id", "innerContainer");
    	popUpWindowContainer.append(innerContainer);
    	
    	//Event listener to remove when click outside of the pop up window
    	popUpWindowContainer.addEventListener("click", (e) => {
    		const elementAttribute  = e.target.getAttribute("id");
    		if( elementAttribute === "popUpWindowContainer"){
    			e.target.remove();
    		}
    	})
    	
    	//Form and Data Fields
    	const form = document.createElement("form");
    	innerContainer.append(form);    	
    	const nameLabel = document.createElement("label");
    	nameLabel.innerText = "Game Name ";    	
    	const nameInput = document.createElement("input");
    	const genreLabel = document.createElement("label");
    	genreLabel.innerText = "Game Genre ";
    	const genreInput = document.createElement("input");
    	const sendUpdateButton = document.createElement("input");
    	sendUpdateButton.setAttribute("type", "submit");
    	sendUpdateButton.value = "Update";    	
    	
    	form.append(nameLabel);
    	form.append(nameInput);
    	form.append(genreLabel);
    	form.append(genreInput);
    	form.append(sendUpdateButton);
    	
    	const parentContainer = document.getElementsByClassName("all-games-container");
    	//console.log(parentContainer[0]);
    	parentContainer[0].appendChild(popUpWindowContainer);  
    	
    	
    	
    	sendUpdateButton.addEventListener("click", (e) => {
    		e.preventDefault();
    		submitUpdateForm(gameId, nameInput, genreInput);
    		popUpWindowContainer.remove();
    	});
    }
    
    
    const renderUpdateGameForm = (gameId) => {
	    createPopUpWindow(gameId);    		    		
	 }
    	
    </script>

    </html>