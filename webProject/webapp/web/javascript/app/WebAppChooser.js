goog.provide('pku.WebAppChooser');

goog.require('pku.nms.WebApp');

pku.WebAppChooser = function() {};

pku.WebAppChooser.prototype.initApp_ = function() {
    var webApp = new pku.WebApp();
    webApp.render();
};