/**
 * 
 */

$(document).ready(function(){	
	
	$('#idCheck').click(function(e){
		e.preventDefault();
		
		let memId = $('#memId').val();
		
		if(memId == "") {
			alert("아이디를 입력하세요");
		}else {
			$.ajax({
				type:"post",
				url:"/member/idCheck",
				data:{"id":memId},
				dataType:"text",
				success:function(result){
					if(result > 0) {
						alert("사용할 수 없는 아이디입니다");
						
						$('#memId').val("");
						$('#memId').focus();
					}else {
						alert("사용 가능한 아이디입니다");
					}
				},
				error:function(){
					alert("실패");
				}
			});
		}
		
	});
	
	
});