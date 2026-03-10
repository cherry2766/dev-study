import React from 'react'
import '../App.css'
//리액트 함수 : 화살표 함수 사용 가능
const Nav = () => {
  return(
    <div className="nav"> 
    {/* 리액트 함수 return 태그는 html 문법 거의 사용/다른 부분도 있음
        class는 리액트 예약어기 때문에 태그 속성 사용 불가능 :class => className */}
      <nav>
        <ol>
        <li><a href="">html</a></li>
        <li><a href="">css</a></li>
        <li><a href="">js</a></li>
        </ol>
      </nav>
    </div>
  )
}
export default Nav;