$(document).ready(function() {
 	$('#bookSearchForm2').on('submit', function(event) {
 		event.preventDefault();

 		let formData = $(this).serialize();
 		
 		let keyword = $('#keyword').val();
 		let type = $('#type').val();
 		
 		if(keyword == "" || type == "") {
 			alert("검색조건과 검색어를 입력하세요");
 		}else {
 			$.ajax({
 				type: "post",
 				url:"/mybatisEx/book/bookSearch2",
 				data:formData,
 				success:function(result) {
 					$('#searchResultBox').html(result);

 				},
 				error:function() {
 					alert("전송실패");
 				}		
 			});
 		} 
 	});  
 }); 