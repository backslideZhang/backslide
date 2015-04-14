goog.provide('pku.startTheWorld');

goog.require('pku.WebAppChooser');
goog.require('goog.dom');

pku.startTheWorld = function() {
    var webAppChooser = new pku.WebAppChooser();
    webAppChooser.initApp_();
};