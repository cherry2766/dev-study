//컴포넌트 이름은 대문자로 시작
//return()문 포함
//return()문 안의 태그는 하나의 최상위 태그로 시작해야 함
import React from "react"
function Header(){
  return(
    <header>  {/*리액트가 해석합니다. 리액트 주석입니다.*/}
        <h1><a href="/">React</a></h1>
    </header>
  )
}
export default Header;