var animaisModulo = angular.module('animaisModulo', []);

animaisModulo.controller("animaisController", function($scope, $http) {
	urlAnimais = 'http://localhost:8080/Animais/rest/animais';

	
	
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

	$scope.listarAnimais();

	$scope.selecionaAnimais = function(animalSelecionado) {
		$scope.animal = animalSelecionado;
		$("#mensagens").html('');
		$(window).scrollTop(0);
	}

	$scope.limparCampos = function() {
		$scope.animal = null;
		$("#mensagens").html('');
	}

	$scope.salvar = function() {
		headers: 'Content-Type:application/json';
		if ($scope.animal.codigo == null) {
			$http({
				method : 'POST',
				url : urlAnimais,
				data : $scope.animal
			}).then(function sucessCallback(response) {
				$scope.animais = response.data.animal;
				$scope.limparCampos();
				$scope.listarAnimais();
			}, function errorCallback(response) {
				console.log(response.data);
			});
		} else {
			$http({
				method : 'PUT',
				url : urlAnimais,
				data : $scope.animal
			}).then(function sucessCallback(response) {
				$scope.listarAnimais();
				$scope.animais = response.data;
				$scope.limparCampos();
				$scope.listarAnimais();
			}, function errorCallback(response) {
				console.log(response.data);
			});
		}
	}
	
	$scope.excluir = function(animalSelecionado) {
		$scope.animal = animalSelecionado;
		$http({
			method : 'DELETE',
			url : urlAnimais+'/'+$scope.animal.codigo,
			headers: {
		        'Content-type': 'application/json;charset=utf-8'
		    }
		}).then(function sucessCallback(response) {
			
			$scope.limparCampos();
			$scope.listarAnimais();
		}, function errorCallback(response) {
			$scope.limparCampos();
			$(window).scrollTop(0);
			$("#mensagens").html('<div class="alert alert-danger" role="alert"><strong>Erro ao excluir animal!</strong> Verifique se não há uma ficha relacionada a este animal antes de excluí-lo.');
		});
	
	}
	

});