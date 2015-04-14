var pku = {
    initBackGround : function() {
        pku.background = $("<div id='background'></div>");
        $('body').append(pku.background);
    },
    initBanner : function() {
        pku.banner = $("<div id='banner'></div>");
        $('body').append(pku.banner);
        pku.loadUserData();
    },
    initMainBody : function() {
        pku.mainBody = $("<div id='mainBody'></div>");
        $('body').append(pku.mainBody);
        pku.showHomePage();
    },
    showHomePage : function() {
        $('#mainBody').empty();
        if (!pku.homePage) {
            pku.homePage = $("<div id='homePage'></div>");
        }
        $('#mainBody').append(pku.homePage);
        pku.selectPosition();
    },


    selectPosition : function() {
        if (!document.getElementById("mapContainer")) {
            var map = $("<div id='mapContainer'></div>");
            pku.homePage.append(map);
            var center={longitude:116.40701, latitude:39.902363, zoom:10};
            var markers=[];
            markers[0] = {id:'1',longitude:116.40701,latitude:39.902363,title:"北京"};
            all.map.mapInit(center, markers);
        }
    },


    loadUserData : function() {
        var title = $("<div id='title'>开始</div>");
        var userInfo = $("<div id='userInfo'>管理员</div>");
        var banner = pku.banner;
        banner.append(title);
        banner.append(userInfo);
    }
};

all.pku = pku;

$(document).ready(function() {
    startTheWorld_();
});

var startTheWorld_ = function() {
    pku.initBackGround();
    pku.initBanner();
    pku.initMainBody();
};