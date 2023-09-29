let host = "http://localhost:8080/product/pagination/"
var app = angular.module("app",[]);
app.controller("ctrl", function($scope, $http, $location){
    
    $scope.productsList = []

    var id = $location.search().cateId || 'NotValue'
    var pageNo = $location.search().pageNo || 1

    var url = `${host}/${id}/${pageNo}`
    $http.get(url).then(response =>{
        $scope.productsList = response.data.listProductsCate;
       
    })

    console.log($scope.productsList)
    console.log("test js")
})
