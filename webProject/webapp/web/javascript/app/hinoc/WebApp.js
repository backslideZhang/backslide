goog.provide('pku.hinoc.WebApp');

goog.require('goog.ui.Control');

pku.WebApp = function(opt_domHelper) {
    goog.base(this, opt_domHelper);
};
goog.inherits(pku.WebApp, goog.ui.Control);

/** @override */
pku.WebApp.prototype.createDom = function() {
    goog.base(this, 'createDom');
    var ele = goog.dom.createDom('div');
    goog.dom.classlist.add(ele, 'hinoc_app');
    this.setElementInternal(ele);
};

pku.WebApp.prototype.enterDocument = function() {
    goog.base(this, 'enterDocument');
};