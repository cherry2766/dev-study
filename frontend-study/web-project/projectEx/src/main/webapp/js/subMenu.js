/**
 * subMenu.js
 */

$(function(){
  //[전체보기]를 클릭했을 때 모든 메뉴 항복 보이게
  $('#showAllMenu').on('click',function(){
    if($(this).text()=='전체보기 ▼') {
      $('#subMenuBox').css('visibility','visible');
      $(this).text('메뉴닫기 ▲').css('color','blue');
    }else {
      $('#subMenuBox').css('visibility','hidden');
      $(this).text('전체보기 ▼').css('color','black');
    }
  });//click 끝
  
  
}); //document.ready 끝