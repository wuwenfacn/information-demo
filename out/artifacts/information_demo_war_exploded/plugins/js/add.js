$(function () {
    $("#serializeUrl").click(function () {
        alert("进入到js");
        //序列化
        let formData=new FormData($("test_form"));
       /* var form = document.getElementById("test_form");
        new FormData(form)*/
/*        var name = data.get("name");
        var type = data.get("type");
        var palce = data.get("palce");
        var price = data.get("price");
        var business = data.get("business");
        var telephone = data.get("telephone");
        var telephone1 = data.get("telephone");*/
  /*      data.append("name",name)
   */
        $.ajax({
            url:"http://localhost:8080/api/ServletAdd",
            type:"post",
            data:formData,
            dataType: 'JSON',
            contentType:"application/json;charset=UTF-8",
            processData: false,
            success:function (data) {
                console.log("aa"+data);
            },
            error:function () {
                console.log("bb"+data);
            }
        });
        // 防止事件冒泡
        return false
    })
})