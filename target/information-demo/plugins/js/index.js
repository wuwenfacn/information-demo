let INDEX_URL = "http://localhost:8080/api/index";
let TROPIC_URL = "http://localhost:8080/api/tropic";
$(function () {
    $("#navbar>li").each(function () {
        $(this).click(function () {
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
        } else {
            alert("系统繁忙，请稍后再试！")
        }
    });
    function showIndexData(List) {
        for (const list of List) {
            $("#content").append(
                $("<li>")
                    .append(
                        $("<img>")
                            .attr("src", list.image)
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
                                    .text("￥"+list.price)
                                    .css("font-size","20px")
                                    .css("color","red")
                            )
                            .append(
                                $("<p>")
                                    .text(list.describe)
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
        }
    }
})