var exec = require('cordova/exec');

exports.hideStatusBar = function (success,error) {
    exec(success, error,'StatusBar', 'hideStatusBar', []);
};

exports.showStatusBar = function (success,error) {
    exec(success, error,'StatusBar', 'showStatusBar', []);
};
