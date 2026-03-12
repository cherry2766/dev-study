/*tabMenu.js*/

$(function(){
  //탭 컨텐츠 이미지 참조 저장
  let $tabContent = $('#tabContent div');
  
  /*tabContent는 첫번째 이미지를 먼저 보여주므로 
    tabMenu도 첫번째 메뉴가 선택되도록 구성*/
  $('#tabMenu li:first-child').addClass('selectedItem');
  
  //tabMenu의 각 li에 대해서 클릭이벤트 연결
  $('#tabMenu li').on('click',function(){
    let index = $(this).index(); // index()현재 참조하는 객체의 idx 반환
    
    //모든 텝메뉴 li에 대해 적용되었던 selectedItem 클래스를 제거
    $('#tabMenu li').removeClass('selectedItem');
    //클릭한 li에 대해서만 class 설정
    $(this).addClass('selectedItem');
    
    //선택된 메뉴에 대해 관련 컨텐츠 표현(이미지 표현)
    $tabContent.css('display','none'); //모든 컨텐츠 전부 숨김
    //클릭한 탭 메뉴(index)에 해당되는 div:img만 보이게 함
    $tabContent.eq(index).css('display','block');
  }); //on 끝
  
}); //ready 끝