$(function () {
    $("#btn").click(function () {
        let data = JSON.stringify($("#login").serializeJSON());
        $.ajax({
            url:"http://localhost:8080/api/login",
            contentType:"application/json;charset=UTF-8",
            data:data,
            type:"post",
            dataType:"text",
            success:function (data) {
                alert("aa");
            },
            error:function () {
                alert("bb");
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
                            regexp: "^[a-zA-Z0-9]{5,15}$",
                            message: "用户名必须是长度在6-16之间"
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
                            regexp: "^[a-zA-Z][a-zA-Z0-9]{5,15}$",
                            message: "密码必须是字母开头长度在6-16之间"
                        }
                    }
                }
            }
        }
    )
})