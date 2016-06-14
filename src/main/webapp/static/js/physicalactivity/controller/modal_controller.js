App.controller('ModalInstanceCtrl', function($scope, $window, $location,
    $uibModalInstance, msn) {

  /** Url Success * */
  var landingUrl = "http://" + $window.location.host
      + "/physicalactivity/classify";

  $scope.message = msn;
  $scope.validar = function() {
    $uibModalInstance.close();
    console.log('se cierra el poput');
  };

  $scope.continuar = function() {
    console.log('Se debe loguiar');
    $window.location.href = '/login';
  };
});