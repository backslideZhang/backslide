goog.provide('pku.nms.WebApp');

goog.require('goog.ui.Control');

pku.WebApp = function(opt_domHelper) {
    goog.base(this, opt_domHelper);

    this.menuBar_ = null;

    this.nodeTree_ = null;

    this.nodeAttributeTable_ = null;

    this.alarmTable_ = null;
};
goog.inherits(pku.WebApp, goog.ui.Control);

/** @override */
pku.WebApp.prototype.createDom = function() {
    goog.base(this, 'createDom');
    var ele = goog.dom.createDom('div');
    goog.dom.classlist.add(ele, 'nms_app');
    goog.dom.setTextContent(ele, 'test');
    this.setElementInternal(ele);
};

pku.WebApp.prototype.enterDocument = function() {
    goog.base(this, 'enterDocument');
};