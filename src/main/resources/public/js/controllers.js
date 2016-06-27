angular.module('app.controllers', []).controller('RouteListController', function($scope, $state, popupService, $window, Route) {
  $scope.routes = Route.query(); //fetch all routes. Issues a GET to /api/vi/routes

  $scope.deleteRoute = function(route) { // Delete a Route. Issues a DELETE to /api/v1/routes/:id
    if (popupService.showPopup('Really delete this?')) {
      route.$delete(function() {
        $scope.routes = Route.query();
        $state.go('routes');
      });
    }
  };
}).controller('RouteViewController', function($scope, $stateParams, Route) {
  $scope.route = Route.get({ id: $stateParams.id }); //Get a single route.Issues a GET to /api/v1/routes/:id
}).controller('RouteCreateController', function($scope, $state, $stateParams, Route) {
  $scope.route = new Route();  //create new route instance. Properties will be set via ng-model on UI

  $scope.addRoute = function() { //create a new route. Issues a POST to /api/v1/routes
    $scope.route.$save(function() {
      $state.go('routes'); // on success go back to the list i.e. routes state.
    });
  };
}).controller('RouteEditController', function($scope, $state, $stateParams, Route) {
  $scope.updateRoute = function() { //Update the edited route. Issues a PUT to /api/v1/routes/:id
    $scope.route.$update(function() {
      $state.go('routes'); // on success go back to the list i.e. routes state.
    });
  };

  $scope.loadRoute = function() { //Issues a GET request to /api/v1/routes/:id to get a route to update
    $scope.route = Route.get({ id: $stateParams.id });
  };

  $scope.loadRoute(); // Load a route which can be edited on UI
});
