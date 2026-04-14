/**
 * 
 */

$(document).ready(function() {
    $("#loginForm").submit(function(e) {
        e.preventDefault();

        $.ajax({
            type: "post",
            url: "/member/login",
            data: {
                id: $("#id").val(),
                pwd: $("#pwd").val()
            },
            success: function(result) {
                if (result === "success") {
                    alert("로그인 성공");
                    location.href = "/";
                } else {
                    alert("아이디 또는 비밀번호가 틀립니다");
                    $('#id').val("");
                    $('#pwd').val("");
                    $('#id').focus();
                }
            },
            error: function() {
                alert("로그인 실패");
            }
        });
    });
});