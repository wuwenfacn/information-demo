/*
let INDEX_URL = "http://localhost:8080/api/collections";
$(function () {
    alert("aaa")
    let username = getQueryString("username");
    let name = getQueryString("name");
    alert(username)
    alert(name)
    let data = {};
    data.namese = name;
    data.username = username;
    let params = {
        name:JSON.stringify(data)
    }
    $.ajax({
        url: INDEX_URL,
        data: params,
        type: "post",
        success: function (data) {
            if (JSON.parse(data).code === "200") {
                alert("成功！")
                showIndexData(JSON.parse(data).data);
            } else {
                alert("系统繁忙，请稍后再试！")
            }
        },
        error: function () {
            alert("网络异常，请稍后再试！");
        }
    });
    function showIndexData(List) {
        for (const list of List) {
            $("#head")
                .append(
                    $("<span>")
                        .append(
                            $("<a>").attr("href","../index.html?username="+username+"&userType="+userType).text("< < 返回首页")
                        )
                )
            $("#left").append(
                $("<img>")
                    .attr("src",list.image)
                    .attr("width","120px")
                    .attr("height","120px")
                    .css("border","1px solid #b2b2b2")
            )
            $("#right")
                .append(
                    $("<p>").text("水 果 名 "+list.name)
                )
                .append(
                    $("<p>").text("店 铺 "+list.business)
                )
                .append(
                    $("<a href='#' id='escCollection'>").text("取消收藏")
                )
            $("#escCollection").click(function () {
                let data = {
                    username:username,
                    namese:name
                }
                $.ajax({
                    url: INDEX_URL,
                    contentType: "application/json;charset=UTF-8",
                    data: data,
                    type: "post",
                    dataType: "text",
                    success: function (data) {
                        if (JSON.parse(data).code === "200") {
                            alert("取消收藏成功！")
                            window.location.href = "collection.html?username="+username+"&name="+name;
                        } else {
                            alert("取消收藏失败！")
                            window.location.href = "collection.html?username="+username+"&name="+name;
                        }
                    },
                    error: function () {
                        alert("网络异常，请稍后再试！");
                    }
                });
            });
        }
    }
    function getQueryString(name) {
        let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        let r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }
})*/
