angular.module('myApp', [])

.controller('MainController', function($scope, $http) {
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

    // Fonction pour récupérer la liste des villages depuis l'API REST
    $scope.getAllVillages = function() {
        $http.get('http://localhost:4000/Mangre-Dan/villages/liste')
            .then(function(response) {
                // Succès : assigner les villages récupérés à la variable $scope.villages
                $scope.villages = response.data;
            })
            .catch(function(error) {
                // Erreur : afficher un message d'erreur ou effectuer un traitement approprié
                console.error('Erreur lors de la récupération des villages :', error);
            });
    };

    // Appeler la fonction pour récupérer la liste des villages au chargement du contrôleur
    $scope.getAllVillages();
});
