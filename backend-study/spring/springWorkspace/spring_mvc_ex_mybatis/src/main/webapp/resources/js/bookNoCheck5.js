/**
 *  도서번호 중복 체크 : axios post 활용
 */
 
 $(document).ready(function() {
 	$('#bookNoCheckBtn').on('click', function() {
 		event.preventDefault();
 		
 		let bookNo = $('#bookNo').val();
 	
 		if(bookNo == "") {
 			alert("도서번호를 입력하세요");
 			return false;
 		}else {
 			let data={bookNo:bookNo};
 			axios.post("/mybatisEx/book/bookNoCheck5/" , data)
 			.then(function(response){
 				if(response.data == "ok") 
 					alert("사용가능한 번호 입니다5.");
				else
					alert("사용 불가능한 번호 입니다5.");
 			})
 			.catch(
				(error)=> {console.log(error.response)}
 			)
 		}
 	});
 }); 