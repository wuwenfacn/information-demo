$(function () {
    let code = getQueryString("code");
    if(code === "null"){
        $.cookie("code",null);
    }
    if($.cookie("code") === "200"){
        window.location.href="../index.html";
    }else {
        window.location.href="#";
    }
    function getQueryString(name) {
        let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        let r = window.location.search.substr(1).match(reg);
        if (r != null) {
            return unescape(r[2]);
        }
        return null;
    }
    $("#btn").click(function () {
        let data = JSON.stringify($("#login").serializeJSON());
        $.ajax({
            url:"http://localhost:8080/api/login",
            contentType:"application/json;charset=UTF-8",
            data:data,
            type:"post",
            dataType:"text",
            success:function (data) {
                if (JSON.parse(data).code === "200") {
                    $.cookie("code", JSON.parse(data).code, { expires: 7 });
                    window.location.href="../index.html";
                } else {
                    alert(JSON.parse(data).message);
                    window.location.href="#";
                }
            },
            error:function () {
                alert("网络异常，请稍后再试！");
                window.location.href="#";
            }
        });
    }),
    $("#login").bootstrapValidator({
            //全局的默认的错误信息提示
            message: "数据校验不通过",
            //错误信息高亮显示
            feedbackIcons: {
                //通过验证输入框状态
                valid: "glyphicon glyphicon-ok",
                //验证失败输入框状态
                invalid: "glyphicon glyphicon-remove",
                //验证中输入框状态
                validating: "glyphicon glyphicon-refresh"
            },
            fields: {
                username: {
                    message: "用户名不符合规范",
                    //验证规则
                    validators: {
                        notEmpty: {
                            message: "用户名不能为空"
                        },
                        regexp: {
                            regexp: "^[a-zA-Z0-9]{1,15}$",
                            message: "用户名必须是长度在2-16之间"
                        }
                    }
                },
                password: {
                    //密码校验规则 必须是大写字母开头 长度是不能小于 6
                    message: "密码不符合规范",
                    validators: {
                        notEmpty: {
                            message: "密码不能为空"
                        },
                        regexp: {
                            regexp: "^[a-zA-Z][a-zA-Z0-9]{1,15}$",
                            message: "密码必须是字母开头长度在2-16之间"
                        }
                    }
                },
                type: {
                    validators: {
                        notEmpty: {
                            message: "请选择用户类型"
                        },
                        regexp: {
                            regexp: "",
                        }
                    }
                }
            }
        }
    )
});
function ff (){
    if($("#username").val() === "" || $("#password").val() === "" || $("#rePassword").val() === "" || $("#type").val() === ""){
        alert("内容不能为空！");
        return false;
    }
    return true;
}