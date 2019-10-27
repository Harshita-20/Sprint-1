var app = angular.module("myApp", []);

app.controller("BookingController", [ '$scope', '$http','$window', function($scope, $http,$window) {
    
    $http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	$scope.submitAppointment = function()
	 {
        $window.alert("Calling speciality"+$scope.speciality+ "Appointment_Date" +$scope.Appointment_Date +"Appointment_Time"+$scope.Appointment_Time);
         $http({
			    url: "BookAppointmentServlet",
				method:"GET",
				params : {"speciality": $scope.speciality,"Appointment_Date": $scope.Appointment_Date,"Appointment_Time": $scope.Appointment_Time,
				"Problem_Description": $scope.Problem_Description,"Comments": $scope.Comments}
	  }).then(function(response){
             $window.alert("Result Success"+response.data);
            $window.alert(response.data);
		if (response.data="Success")
		{
			$scope.message="Your Booking has been confirmed";
			$window.location.href='index.html'
		}  
  $window.alert(response.status);
          console.log(response.data);
        },(function (response){
             //fail case
           $window.alert("Result Failure"+response);
            $scope.message = response;
        }));
 
    }
}
]);