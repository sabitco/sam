App.controller('ModalInstanceCtrl', function($scope, $window, $location,
    $uibModalInstance, msn, urlsuccess) {

  /** Url Success * */
  var landingUrl = "http://" + $window.location.host + urlsuccess;

  $scope.message = msn;
  $scope.validar = function() {
    $uibModalInstance.close();
    console.log('se cierra el poput');
  };

  $scope.continuar = function() {
    console.log('Se debe loguiar');
    $window.location.href = landingUrl;
  };
});