/**
 * 유효성 검사 jQuery로 체크
 */

$(function(){
  $('#id').focus();
  
  $(':text,:password').on('focus', function(){
      $(this).css('backgroundColor','rgb(232,232,232)');
  });
  $(':text,:password').on('blur', function(){
      $(this).css('backgroundColor','white');
  });
  
  //키보드 이벤트
  $('#hp1').on('keyup',function() {
      if($(this).val().length==3) {
        $('#hp2').focus();
      }
  });
  
  $('#hp2').on('keyup',function() {
      if($(this).val().length==4) {
        $('#hp3').focus();
      }
  });
  
  //form 태그 내에서 enter키를 누르면 submit 이벤트가 발생함
  //imput 입력란에서 enter키를 입력했을때 submit이 발생하는 상황을 중지시켜야 함
  //문서 전체에 이벤트 처리
  //[enter]키 아스키코드 : 13
  //입력된 key의 정보는 핸들러에 의해 event 객체로 전달
  //화면 변화 없음
  
  /*$(document).on('keydown', function(e) {
      if(e.keyCode==13) 
        return false; //submit 진행하지 않고 처리함수 종료
  });*/  
  
  $('#id').on('keydown', function(e) {
       if($('#id').val()!="" && e.keyCode==13) {
           $('#pwd').focus(); //비밀번호 입력칸으로 커서이동
           return false; //기본 동작(엔터 submit) 막음
       }
   });
  
  $('#newMemberForm').on('submit', function() {
     //아이디를 입력하지 않은 경우
     if($('#id').val()=="") {
          alert("아이디를 입력하세요");
          $('#id').focus();
          return false;
     }
     //비번을 입력하지 않은 경우
     if($('#pwd').val()=="") {
         alert("비밀번호를 입력하세요");
         $('#pwd').focus();
         return false;
     }
     //input[type="radio"]
     //객체 중 선택의 여부를 갖고 있는 객체에는 is() 메서드 사용
     //여러개의 라디오 객체의 checked 속성이 하나라도 체크가 되어 있으면 true
     //하나도 체크가 안되어 있으면 false
     if(!$(':radio').is(':checked')) {
          alert("학년을 선택하세요");
          return false;
     }
     if(!$(':checkbox').is(':checked')) {
          alert("관심분야는 1개이상 선택하세요");
          return false;
     }
     if($('select').val()=="") {
          alert("학과를 선택하세요");
          return false;
     }    
  });
});