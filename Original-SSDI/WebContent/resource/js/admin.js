var app = angular.module("myApp", []);

app.controller("AdminController", [ '$scope', '$http','$window', function($scope, $http,$window) {
	
	$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=utf-8";
	$scope.getPatienData = function() {
		
		//$window.alert("Calling speciality");

		$http({
			url : 'PatientDetailsServlet',
			method : "GET",			
		}).then(function(response) {
			if(response.data.myArrayList.length == 0) {
				$scope.noEmpRecord = "Yes";
			} else {
				$scope.patientList = response.data.myArrayList;
			}
		}, function(response) {
			console.log("Failure -> " + response.data);
			$scope.empList = response.data.myArrayList;
		});
	};
	
$scope.getDoctorData = function() {
		
		//$window.alert("Calling Doctor Data");

		$http({
			url : 'GetDoctorDetailsServlet',
			method : "GET",			
		}).then(function(response) {
			$window.alert(response.data.myArrayList);
			if(response.data.myArrayList.length == 0) {
				$scope.noEmpRecord = "Yes";
			} else {
				$scope.doctorList = response.data.myArrayList;
			}
		}, function(response) {
			console.log("Failure -> " + response.data);
			$scope.empList = response.data.myArrayList;
		});
	};
	
	
$scope.updateSlot = function() {
		
	//$window.alert("Calling slot times doctor"+$scope.selectDoctor+"Appointment_Date"+$scope.Appointment_Date+"slot"+$scope.slot);
		$http({
			url : 'DoctorManageTimings',
			method : "GET",
			params : {"Appointment_Date":$scope.Appointment_Date,"slot":$scope.slot}
		}).then(function(response) {
     		//$window.alert(response.data);
     		console.log(response);
			if (response.data=="Success")
			{
				//$window.location.href='login.html';
	            $scope.message="Slot Timings Have Been Updated Successfully";
			} else
				{
				$scope.message="Please check the details you have entered and Try Again !!";
				}
		}, function(response) {
			// $window.alert("Result Failure"+response);
	            $scope.message = response;
		});
	};
	
	

}
]);