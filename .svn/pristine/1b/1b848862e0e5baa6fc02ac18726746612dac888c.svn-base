'use strict';

var mapp = angular.module('mapp');
    mapp.factory('loginService',function($scope,$rootScope,$http){
        var model = {};

        model.login = function(user,success,error){
            $http.post('../frontLogin.do').success(function(data){
                console.log(data);
            });
        };
        return model;
});