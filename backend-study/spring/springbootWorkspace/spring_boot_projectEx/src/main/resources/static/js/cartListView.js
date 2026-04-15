/**
 * 장바구니 목록 : 삭제를 위한 품목 체크 버튼 기능
 */

$(document).ready(function() {
	//[전체선택] 체크박스 클릭 했을 때
	$('#allCheck').on('click', function() {
		let chk = $('#allCheck').prop('checked')
		
		if (chk) {
			$('.chkDelete').prop('checked', true);
		}else {
			$('.chkDelete').prop('checked', false);
		}	
	});
	
	//개별 체크박스 해제할 경우 [전체선택] 체크박스 해제
	//개별 체크박스가 모두 체크했을 경우 [선체선택] 체크박스 선택
	$('.chkDelete').click(function(){
		let total = $('.chkDelete').length; //개별 체크박스의 전체 개수
		let checked = $('.chkDelete:checked').length; //개별 체크박스 중 체크된 체크박스의 개수
		
		if (total != checked) {
			$('#allCheck').prop('checked', false); //해제
		}else {
			$('#allCheck').prop('checked', true); //선택
		}
	});
	
	//장바구니 상품 삭제 요청(ajax)
	$('#deleteCartBtn').on('click', function() {
		//개별 삭제 버튼 체크 여부 확인
		let chk = $('.chkDelete').is(':checked');
		
		if(chk) { //하나라도 선택한 경우
			let answer = confirm("선택된 상품을 삭제하시겠습니까?");
			if(answer) {
				let checkArr = new Array();
				$('.chkDelete:checked').each(function() {
					console.log($(this).val());
					checkArr.push($(this).val());
				});
				
				//배열 data 파라미터로 해서 요청
				$.ajax({
					url:"/product/deleteCart",
					type:"post",
					data:{"delPrd" : checkArr},
					success:function(result) {
						if(result) {
							location.href="/product/cartList";
						}
					},
					error:function() {
						alert("오류발생!");
					}
					
				});
			}
		}else { //아무것도 선택하지 않은 경우
			alert("선택된 상품이 없습니다");
		}
	});
	
	// 수량 변경 시 구매금액, 총구매금액 업데이트
	$('.cartQty').on('input', function() {
	    let tr = $(this).closest('tr'); // 수량 변경한 행
	    let price = parseInt(tr.find('.price').data('price')); // 단가
	    let qty = parseInt($(this).val()); // 입력 수량
	    if (isNaN(qty) || qty < 0) qty = 0; // 비정상 입력 처리 (음수만 막음)

	    // 해당 행 구매예정금액 업데이트
	    tr.find('.amount').text((price * qty).toLocaleString());

	    // 총구매예정금액 다시 계산
	    let total = 0;
	    $('.amount').each(function() {
	        let row = $(this).closest('tr');
	        let p = parseInt(row.find('.price').data('price')); // 행 단가
	        let q = parseInt(row.find('.cartQty').val()); // 행 수량
	        if (isNaN(q) || q < 0) q = 0;
	        total += p * q;
	    });
	    $('#total').text(total.toLocaleString());
	});
});

