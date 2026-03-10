//컴포넌트는 매개변수로 전달된 속성(props)
//상위 컴포넌트에서 전달된 값 받아 사용 가능
//key : value 형태로 전달됨
//속성으로 전달된 값을 사용하려면 - 객체(매개변수).속성

import React from "react"
function Header(props){
  console.log(props.title); {/* props 매개변수는 title:'WEB' title2="REACT" 내용이 저장됨 */}
  return(
    <header>  
        <h1><a href="/">{props.title}</a></h1>
        <h3>{props.title2}</h3>
    </header>
  )
}
export default Header;