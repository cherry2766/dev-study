/**
 *  도서번호 중복 체크 : ajax get 활용
 */
 
 $(document).ready(function() {
 	$('#bookNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val();
 	
 		if(bookNo == "") {
 			alert("도서번호를 입력하세요");
 			return false;
 		}else {
 			$.ajax({
 				type:"get",
 				url: "/mybatisEx/book/bookNoCheck/"+bookNo,
 				dataType: 'text',
 				success: function(result) {
 					if(result == "ok") 
 						alert("사용가능한 번호 입니다.");
 					else
 						alert("사용 불가능한 번호 입니다.");
 				},
 				error: function(data, textStatus) {
 					alert("전송실패");
 				}
 			});
 		}
 	});
 }); 