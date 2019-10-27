var app = angular.module("myApp", []);

app.controller("LoginController", [ '$scope', '$http','$window', function($scope, $http,$window) {
    
    
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	$scope.sendData = function() {
       // $window.alert("Calling Username"+$scope.username+ " Password" +$scope.password);
        $http({
            url : 'loginServlet',
            method : "GET",
            params : {
              "username":$scope.username,
              "password":$scope.password  }
        }).then(function(response){
             // $window.alert("Result Success"+response.data);

             if (response.data=="Admin_Role")
            {
                $window.location.href='admin.html'
            }
           else if (response.data=="Doctor_Role")
            {
                $window.location.href='doctor.html'
            }
             else if (response.data=="Patient_Role")
            {
                $window.location.href='patient.html'
            }
           else{
               $scope.message="Invalid Credentials"
           } 

        },(function (response){
             //fail case
           $window.alert("Result Failure"+response);
            $scope.message = response;
        }));
 
    }
}
]);