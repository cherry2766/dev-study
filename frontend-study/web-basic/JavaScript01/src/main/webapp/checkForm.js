/**
 * ioin.html에 포함되는 js
 * submit 버튼 클릭시 동작되도록 구성
 */

// 성명 : 필수입력

window.onload = function() {
  // submit 이벤트 발생시 유효성 검사
  document.getElementById("joinForm").onsubmit = () => {
    let name = document.getElementById("name");
    if(name.value == "") {
      alert("성명을 입력하세요");
      name.focus();
      return false;
      //submit 이벤트는 처리함수를 실행하고 서버 요청을 진행함
      //서버 요청 진행되지 않도록 return false;
    }
    
    let id = document.getElementById("id");
    if(id.value.length < 6 || id.value.length > 10) {
          alert("id는 6~10자로 입력하세요");
          id.value=""; //기존 입력값 지우고 포커스 주기
          id.focus();
          return false;
    }
    
    let password = document.getElementById("password");
    let passwordCheck = document.getElementById("passwordCheck");
    
    if(password.value != passwordCheck.value) {
      alert("비밀번호가 일치하지 않습니다");
      passwordCheck.value="";
      passwordCheck.focus();
      return false;
    }
    
    //직업을 선택하지 않은 경우
    
    let job = document.getElementById('job');
    if(job.selectedIndex == 0) { //job.value="" 로 조건 검사 가능
      alert("직업을 선택하세요");
      return false;
    }
    
    //라디오 버튼의 그룹 참조를 위해 name 속성 활용한 참조
    //라디오 버튼의 name 속성이 같은 태그가 여러개 이므로 배열과 유사한 형태로 반환
    let chk = false;
    for(let i=0;i<joinForm.emailRcv.length;i++) {
       if(joinForm.emailRcv[i].checked ==true)
          chk=true;
    }
    //체크 여부 확인
    if(chk==false) {
      alert("이메일 수신 여부를 선택하세요");
      return false;
    }
    
    //모두 동의해야 회원가입 가능
    let agree1 = document.getElementById('agreement1');
    let agree2 = document.getElementById('agreement2');
    
    if(agree1.checked == false || agree1.checked == false) {
       alert("모두 동의해야 합니다");
       return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }; //onsubmit 끝
}; //onload 끝