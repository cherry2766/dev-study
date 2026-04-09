/**
 *  도서번호 중복 체크 : fetch get 활용
 */
 
 $(document).ready(function() {
 	$('#bookNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val();
 	
 		if(bookNo == "") {
 			alert("도서번호를 입력하세요");
 			return false;
 		}else {
 			fetch("/mybatisEx/book/bookNoCheck2/" + bookNo)
 			.then(response=>response.text())
 			.then(result => {
 				if(result == "ok") 
 						alert("사용가능한 번호 입니다2.");
 					else
 						alert("사용 불가능한 번호 입니다2.");
 			})
 			.catch(err=> console.log(err));
 		}
 	});
 }); 