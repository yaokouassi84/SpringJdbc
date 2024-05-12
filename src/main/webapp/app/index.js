angular.module('myApp', [])

.controller('MainController', function($scope) {
    $scope.templateUrl = 'views/accueil.html'; // Par défaut, afficher la vue d'accueil

    $scope.changeView = function(view) {
        if (view === 'accueil') {
            $scope.templateUrl = 'views/accueil.html';
        } else if (view === 'about') {
            $scope.templateUrl = 'views/about.html';
        } else if (view === 'service') {
            $scope.templateUrl = 'views/service.html';
        } else if (view === 'team') {
            $scope.templateUrl = 'views/team.html';
        } else if (view === 'portfolio') {
            $scope.templateUrl = 'views/portfolio.html';
        } else if (view === 'blog') {
            $scope.templateUrl = 'views/blog.html';
        } else if (view === 'single') {
            $scope.templateUrl = 'views/single.html';
        } else if (view === 'contact') {
            $scope.templateUrl = 'views/contact.html';
        }
    };
});
