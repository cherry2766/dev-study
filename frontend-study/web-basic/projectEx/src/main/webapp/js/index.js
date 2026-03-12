/*index.js*/

$(function(){
  //브라우저 scroll 이벤트 - 윈도우객체
  $(window).on('scroll',function(){
    //스크롤되는 문서의 스크롤top이 #headerBox의 height 이상이면
    //메인 메뉴 고정하고 그림자 표시
    if($(document).scrollTop() >= $('#headerBox').height()) {
      $('#mainMenuBox').addClass('mainMenuFixed mainMenuShadow');
    }
    else
      $('#mainMenuBox').removeClass('mainMenuFixed mainMenuShadow');
  }); //on 끝
  
  //moveToTop 이미지 클릭했을때 top으로 이동
  $('#moveToTop').on('click',function(){
    $('html,body').animate({scrollTop:0},300);
  }); //click on 끝
}); //ready 끝