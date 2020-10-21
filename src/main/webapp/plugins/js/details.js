let DETAILUrl = "http://localhost:8080/api/detail"
$(function () {
    let id = getQueryString("id");
    let typeA = getQueryString("type");
    let type;
    if(typeA === "tropic"){
        type = "热带水果"
    } else if(typeA === "Subtropics") {
        type = "亚热带水果"
    } else {
        type = "温带水果"
    }
    let name = decodeURI(getQueryString("name"));
    let price = getQueryString("price");
    let describe = decodeURI(getQueryString("describe"));
    let place = decodeURI(getQueryString("place"));
    let business = decodeURI(getQueryString("business"));
    let telephone = getQueryString("telephone");
    let image = getQueryString("image");
    $("#head")
        .append(
            $("<span>")
                .append(
                    $("<a href='../index.html'>").text("首页")
                )
        )
        .append(
            $("<span>").text(" > ")
        )
        .append(
            $("<span>").text(type)

        )
        .append(
            $("<span>").text(" > ")
        )
        .append(
            $("<span>").text(name)
        )
    $("#left").append(
        $("<img>")
            .attr("src",image)
            .attr("width","350px")
            .attr("height","350px")
            .css("border","1px solid #b2b2b2")
    )
    $("#right")
        .append(
            $("<p>").text(describe)
        )
        .append(
            $("<p>")
                .text("促 销 价")
                .append(
                    $("<span>").text(" ￥ "+price).css("color","red").css("font-size","20px")
                )
        )
        .append(
            $("<p>").text("产 地 "+place)
        )
        .append(
            $("<p>").text("店 铺 "+business)
        )
        .append(
            $("<p>").text("配 送 至 广东广州")
        )
        .append(
            $("<p>").text("联 系 电 话 "+telephone)
        )
        .append(
            $("<div>").text("加入收藏")
        )
})

//http://localhost:8080/api/detail.html?filmId=f39c979857a4c8c50157a9020fb8001d
//截取=后面的内容
function getQueryString(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
}