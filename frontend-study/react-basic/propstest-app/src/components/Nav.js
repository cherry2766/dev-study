import React from 'react'
import '../App.css'
//리액트 함수 : 화살표 함수 사용 가능
const Nav = (props) => {
  //props는 배열 객체가 전달됨. 전달된 배열 객체중 title key만 추출해서 return()의 ol태그의 목록으로 표현
  const lis =[];

  for(let i=0;i<props.topics.length;i++){
    let t = props.topics[i];
    lis.push(<li key={t.id}><a href={"/read/"+t.id}>{t.title}</a></li>)
  }
  return(
    <div className="nav"> 
    {/* 목록 태그의 내부 text를 상위 컴포넌트로부터 전달 받아서 표현
        집합 형태(객체)로 전달 받기 */}
      <nav>
        <ol>
          {lis}
        </ol>
      </nav>
    </div>
  )
}
export default Nav;