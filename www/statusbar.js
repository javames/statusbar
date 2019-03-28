var exec = require('cordova/exec');

exports.hideStatusNavBar = function (success,error) {
    exec(success, error,'StatusBarNav', 'hideStatusNavBar', []);
};

exports.showStatusNavBar = function (success,error) {
    exec(success, error,'StatusBarNav', 'showStatusNavBar', []);
};
