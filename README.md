
状态栏插件

set fullscreen,both stausbar and navigation.

Using the Cordova CLI to fetch the latest version from GitHub:
cordova plugin add https://github.com/javames/statusbar.git

用于设置状态栏虚拟键全屏与否

 1.设置全屏
 cordova.plugins.StatusBarNav.hideStatusNavBar(function () {
 console.log("set full screen success")
 },function (error) {
 console.log("set full screen success error")
 })
 
 2.设置非全屏
   cordova.plugins.StatusBarNav.showStatusNavBar(function () {
   console.log("恢复状态成功")
   },function (error) {
   console.log("恢复状态失败"+error)
   })



