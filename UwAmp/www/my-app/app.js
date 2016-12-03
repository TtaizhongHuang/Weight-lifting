

angular.module('myApp', ['ngRoute']) //ngRoute is an angular service
.config(function ($routeProvider) {
    $routeProvider.when("/view1", {
        controller: "view1Controller",
        templateUrl: "view1.html"
    });

    $routeProvider.when("/view2", {
        controller: "view2Controller",
        templateUrl: "view2.html"
    });
    $routeProvider.when("/", {
        controller: "loginController",
        templateUrl: "login.html"
    })
    $routeProvider.when("/librarian",{
        controller: "librarianController",
        templateUrl: "librarian.html"
    })
    $routeProvider.when("/student", {
        controller: "studentController",
        templateUrl: "student.html"
    });
})
.controller('clientController', function($scope) {
})
.controller('loginController', ['$scope', '$location',function($scope, $location){

    $scope.login = function() {
        if($scope.username == "admin" && $scope.password == "admin"){
            $location.path('/librarian');
        }
        else if($scope.username.charAt(0) == 'U' && $scope.password != ""){
            $location.path('/student');
        }
        else{
            alert("invalid username and password");
        };
    };
}])
.controller('librarianController', function($scope, $http){
    $scope.books = [];
    //My Post Call
    // Internet said to add this to convert it to similar to ajax calls
    $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
    //The Actual call that happens but does not appear to send data.
    $scope.addBook = function(){
        $scope.books.push(new user($scope.bookName, $scope.shelf, $scope.reference));
        //var bookString = angular.toJson($scope.books);
        $http({
         url: "writeLib.php",
        method: "POST",
        data: {"books": "bookString"}
        }).success(function(data, status, headers, config) {
            $scope.data = data;
            alert(data);
        }).error(function(data, status, headers, config) {
            alert(data);
        });
    }
    
})

.controller('studentController',function($scope){

});


function user(name, shelf, reference)
{
 this.name = name;
 this.reference = reference;
 this.barrowedBy = "";
 this.presence = 1;
 this.shelf = shelf;
}
