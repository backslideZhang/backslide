all.map = {};

 all.map.mapInit = function(center, markers) {
    var mapObj = new AMap.Map("mapContainer",{
        rotateEnable:false,
        dragEnable:true,
        zoomEnable:true,
        zooms:[10,18],
        view: new AMap.View2D({
            center:new AMap.LngLat(center.longitude, center.latitude),
            zoom:center.zoom
        })
    });
    mapObj.plugin(["AMap.ToolBar"],function(){
        toolBar = new AMap.ToolBar();
        mapObj.addControl(toolBar);
    });
    for (var i = 0;i<markers.length; i++) {
        var marker = new AMap.Marker({
            position:new AMap.LngLat(markers[i].longitude, markers[i].latitude)
        });
        marker.setMap(mapObj);
        marker.setTitle(markers[i].title);
        marker.twaverId=markers[i].id;
        AMap.event.addListener(marker, 'dblclick', function(e) {
            var xmlhttp;
            if (window.XMLHttpRequest) {
                xmlhttp=new XMLHttpRequest();
            } else {
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function() {
            };
            xmlhttp.open("POST","dbclickMarker?id=" + e.target.twaverId ,true);
            xmlhttp.send();
        });
        AMap.event.addListener(marker, 'click', function(e) {
            var xmlhttp;
            if (window.XMLHttpRequest) {
                xmlhttp=new XMLHttpRequest();
            } else {
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=function() {
            };
            xmlhttp.open("POST","clickMarker?id=" + e.target.twaverId ,true);
            xmlhttp.send();
        });
    }
};