//Jsx.js
//함수형 컴포넌트 : rsc

import React from 'react';

const Jsx = () => {
  const name ='홍길동'; //함수의 지역 변수(상수) -지역변수는 return():JSX 영역 안에서 사용하려면 {} 활용
  //{} 리액트가 rendering 할 태그에 동적 모듈 반영하고자 할 때 사용하는 기호
  //{} 에 있는 코드를 실행해서 결과를 태그에 반영
  //{변수명} : 변수에 저장된 값을 표현할 것
  //{조건문 ? (조건이 참일때 실행할 문장) : (조건이 거짓일 때 실행할 문장)}

  //&&/|| expression
  //조건 && expression
  //조건이 참이면 expression 반환/거짓이면 무시(아무것도 반환되지 않음)
  //조건 || expression
  //조건이 0 또는 false면 expression 반환
  //조건이 0이 아니면 해당 값 출력
  const num = 3;
  const number = 0;

  //사용자 정의 객체 선언
  const person = {
    name: "성춘향",
    age: 20
  }

  //함수 정의
  function getPerson(){
    return person.name + "," + person.age;
  }

  return (
    <div>
      <h1>JSX 입니다</h1>
      <h2>{name} 안녕!</h2>
      { name === '홍길동' ?
        (<h3>홍길동 입니다</h3>):
        (<h3>홍길동이 아닙니다</h3>)
      }
      {
        name === '이몽룡' ? <h3>이몽룡 입니다</h3> : <h3>이몽룡이 아닙니다</h3>
      }
      { num && '표현식 입니다'}
      { num || '오리'}

      {number || '값이 undefined 입니다'}
      {/* jsx의 인라인 스타일 적용 시 속성명에 -  사용 불가능
      카멜표기법 사용(두번째단어시작 대문자) */}
      <div className='react' style={ {
        margin : '0 auto',
        width : '50%',
        backgroundColor:'red',
        fontSize:'36px',
        padding:10,
        marginTop:'20px'
      } }> 
        인라인 스타일 적용
      </div>
      <div>
        <input type='text'/>
        <br/>
        <input type='password'></input>
      </div>

      <div>
        함수가 자동 호출 되었습니다 <br/>
        {
          // 자동 호출되는 함수
          // (()=> {})() : 화살표 함수 사용 가능
          (function(){
            if (num===3) return <div>value=1</div>
            if (num===3) return <div>value=2</div>
            if (num===3) return <div>value=3</div>
          })()
        }
      </div>
      {/* 사용자 정의 함수 호출 */}
      <div>{getPerson()}</div>
      <div>getPerson()</div>
      {/* 사용자 정의 함수 호출이 아니고 텍스트 처리 */}

    </div>
  );
};
//리액트에서 반환되는 태그는 반드시 닫아야 함, 
//자바스크립트 영역 : // 주석 사용
//JSX 영역 : {/* */}
export default Jsx;