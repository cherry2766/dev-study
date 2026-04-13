/**
 * login.js
 * 로그인 요청 전에 폼 데이터 비어있는지 여부에 따라 진행하는 스크립트
 * 로그인 실패 시 아이디 비밀번호 reset 후에 id 입력칸에 포커스
 */

$(document).ready(function() {
	$('#loginForm').on('submit', function() {
		event.preventDefault();
		
		$.ajax({
			type:"post",
			url:"/member/login",
			data:{"id": $('#id').val() , "pwd": $('#pwd').val()},
			dataType:"text",
			success:function(result){
				if(result == "success") {
					alert("로그인 성공\nmain페이지로 이동합니다");
					location.href="/"; //로그인 처리된 메인페이지
				}else {
					alert("아이디 또는 비밀번호가 일치하지 않습니다");
					
					$('#id').val("");
					$('#pwd').val("");
					$('#id').focus();
					
				}
			},
			error:function(){
				alert("전송 실패");
			}
		});//ajax 끝
	});//on 끝
});//ready 끝