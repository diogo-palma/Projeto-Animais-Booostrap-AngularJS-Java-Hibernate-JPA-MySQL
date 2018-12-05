var fichasModulo = angular.module('fichasModulo', []);

fichasModulo.controller("fichasController", function ($scope, $http) {
	urlAnimais = 'http://localhost:8080/Animais/rest/animais';
	urlFichas = 'http://localhost:8080/Animais/rest/fichas';
	
	
	
	$scope.listarFichas = function() {
		$http({
			method : 'GET',
			url : urlFichas
		}).then(function successCallback(response) {
			$scope.fichas = response.data;
		}, function errorCallback(error) {
			console.log(error, 'Falha no consumo do serviço')
		});
	}
	
	$scope.listarAnimais = function() {
		$http({
			method : 'GET',
			url : urlAnimais
		}).then(function successCallback(response) {
			$scope.animais = response.data;
		}, function errorCallback(error) {
			console.log(error, 'Falha no consumo do serviço')
		});
	}
	
	$scope.salvar = function() {
		headers: 'Content-Type:application/json';
		if ($scope.ficha.codigo == null) {
			$http({
				method : 'POST',
				url : urlFichas,
				data : $scope.ficha
			}).then(function sucessCallback(response) {
				$scope.fichas = response.data.ficha;
				$scope.limparCampos();
				$scope.listarFichas();
			}, function errorCallback(response) {
				console.log(response.data);
			});
		} else {
			$http({
				method : 'PUT',
				url : urlFichas,
				data : $scope.ficha
			}).then(function sucessCallback(response) {
				$scope.fichas = response.data.ficha;
				$scope.limparCampos();
				$scope.listarFichas();
			}, function errorCallback(response) {
				console.log(response.data);
			});
		}
	}

	$scope.listarAnimais();
	
	$scope.listarFichas();
	
	
	$scope.excluir = function(animalSelecionado) {
		$scope.animal = animalSelecionado;
		$http({
			method : 'DELETE',
			url : urlFichas+'/'+$scope.ficha.codigo,
			headers: {
		        'Content-type': 'application/json;charset=utf-8'
		    }
		}).then(function sucessCallback(response) {
			$scope.listarFichas();
		     $scope.limparCampos();
		}, function errorCallback(response) {
			$scope.limparCampos();
			$(window).scrollTop(0);
		});
	}
	

   $scope.selecionaFicha = function (fichaSelecionado) {
	   $(window).scrollTop(0);
      $scope.ficha = fichaSelecionado;
      
    	
   }

   $scope.limparCampos = function () {
      $scope.ficha = null;
   }
});
