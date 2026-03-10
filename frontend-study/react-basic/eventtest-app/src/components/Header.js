import React from 'react';

function Header(props) {
  //표현식이 아닌 객체 매개변수 : porps내부에 key(속성):value(속성값)로 전달된 값이 저장됨
  console.log('props', props.title);
  //매개변수로 전달된 onChangeMode 속성의 값 콜백함수는 a 태그의 클릭 이벤트가 발생하면 콜백함수가 실행되도록 코드 구성
  return (
    <header>
      <h1>
        <a
          href="/"
          onClick={function (event) {
            event.preventDefault();
            props.onChangeMode(); //매개변수로 콜백함수가 전달되면 속성을 통해 해당 함수 호출 가능
          }}
        >
          {props.title}
        </a>
      </h1>
    </header>
  );
}

export default Header;
