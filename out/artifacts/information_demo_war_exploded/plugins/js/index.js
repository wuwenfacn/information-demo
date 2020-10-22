let INDEX_URL = "http://localhost:8080/api/index";
let TROPIC_URL = "http://localhost:8080/api/tropic";
$(function () {
    $("#btnOne").click(function () {
        $(".aaa:lt(8)").show()
        $(".aaa:gt(7)").hide()
    })
    $("#btnTwo").click(function () {
        $(".aaa:lt(8)").hide()
        $(".aaa:gt(7)").show()
    })
    let userType = getQueryString("userType");
    let username = getQueryString("username");
    $("#logo").append(
        $("<a>")
            .attr("href","index.html?username="+username+"&userType="+userType)
            .append(
                $("<img>")
                    .attr("src","plugins/images/logo.png")
                    .attr("width","80")
                    .attr("height","80")
            )
    )
    if(userType === "administor"){
        $("#login")
            .append(
                $("<a href='pages/AdminIndex.html'>").text(">>去后台")
            )
            .append(
                $("<span>").text("欢迎管理员，"+username)
            )
    }else if(userType === "store"){
        $("#login")
            .append(
                $("<a href='pages/AdminIndex.html'>").text(">>去后台")
            )
            .append(
                $("<span>").text("欢迎销售商，"+username)
            )
    }else  if(userType === "customer"){
        $("#login")
            .append(
                $("<span>").text("欢迎您，"+username)
            )
            .append(
                $("<span>").append(
                    $("<a>")
                        .attr("href","pages/collection.html?username="+username)
                        .text("查看收藏")
                )
            )
    }else {
        $("#login")
            .append(
                $("<a href='pages/login.html'>").text("请登录")
            )
    }
    function getQueryString(name) {
        let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        let r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }
    $("#logout").click(function () {
        window.location.href="pages/login.html?code=null";
    })
    $("#navbar>li").each(function () {
        $(this).click(function () {
            $(".aaa").remove();
            $("#navbar>li").removeClass("active");
            $(this).addClass("active");
            let data = JSON.stringify($(this).attr("title"));
            $.ajax({
                url: INDEX_URL,
                contentType: "application/json;charset=UTF-8",
                data: data,
                type: "post",
                dataType: "text",
                success: function (data) {
                    if (JSON.parse(data).code === "200") {
                        showIndexData(JSON.parse(data).data);
                        $(".aaa:gt(7)").hide()
                    } else {
                        alert("系统繁忙，请稍后再试！")
                    }
                },
                error: function () {
                    alert("网络异常，请稍后再试！");
                    window.location.href = "#";
                }
            });
        });
    });
    $.get(TROPIC_URL, function (result) {
        if (JSON.parse(result).code === "200") {
            showIndexData(JSON.parse(result).data);
            $(".aaa:gt(7)").hide()
        } else {
            alert("系统繁忙，请稍后再试！")
        }
    });
    function showIndexData(List) {
        for (const list of List) {
            $("#content")
                .append(
                    $("<a class='aaa'>")
                        .attr("href","pages/details.html?id="+list.id+"&type="+list.types+"&name="+
                            encodeURI(encodeURI(list.namese))+"&price="+list.prices+"&describe="+
                            encodeURI(encodeURI(list.describes))+"&place="+encodeURI(encodeURI(list.place))+
                            "&business="+encodeURI(encodeURI(list.business))+"&telephone="+list.telephone+
                            "&image="+list.images+"&username="+username+"&userType="+userType)
                        .append(
                            $("<li>")
                                .addClass("fruits")
                                .append(
                                    $("<img>")
                                        .attr("src", list.images)
                                        .attr("width", "200")
                                        .attr("height", "200")
                                        .css("border", "1px solid #b2b2b2")
                                )
                                .append(
                                    $("<div>")
                                        .addClass("li-news")
                                        .append($("<p>"))
                                        .append(
                                            $("<p>")
                                                .text("￥"+list.prices)
                                                .css("font-size","20px")
                                                .css("color","red")
                                        )
                                        .append(
                                            $("<p>")
                                                .text(list.describes)
                                                .css("width","200px")
                                                .css("word-break","break-all")
                                                .css("display","-webkit-box")
                                                .css("-webkit-line-clamp","2")
                                                .css("-webkit-box-orient","vertical")
                                                .css("overflow","hidden")
                                        )
                                        .append(
                                            $("<p>")
                                                .text(list.business)
                                                .css("color","#b2b2b2")
                                        )
                                )
                        )
                )
        }
    }
})