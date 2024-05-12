angular.module('myApp', [])

.controller('MainController', function($scope) {
    $scope.templateUrl = 'views/view-one.html'; // Par défaut, afficher la vue d'accueil

    $scope.changeView = function(view) {
        if (view === 'accueil') {
            $scope.templateUrl = 'views/view-one.html';
        } else if (view === 'page1') {
            $scope.templateUrl = 'views/view-two.html';
        } else if (view === 'page2') {
            $scope.templateUrl = 'views/view-three.html';
        }
    };
});