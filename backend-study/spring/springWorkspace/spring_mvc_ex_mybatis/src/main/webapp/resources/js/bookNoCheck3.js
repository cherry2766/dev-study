/**
 *  도서번호 중복 체크 : fetch post 활용
 */
 
 $(document).ready(function() {
 	$('#bookNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val();
 	
 		if(bookNo == "") {
 			alert("도서번호를 입력하세요");
 			return false;
 		}else {
 			fetch("/mybatisEx/book/bookNoCheck3",
 			{
 				method:'post',
 				headers:{
 					'Content-Type':'application/json'},
 				body:bookNo

 			})
 			.then(response=>response.text())
 			.then(result => {
 				if(result == "ok") 
 						alert("사용가능한 번호 입니다3.");
 					else
 						alert("사용 불가능한 번호 입니다3.");
 			})
 			.catch(err=> console.log(err));
 		}
 	});
 }); 