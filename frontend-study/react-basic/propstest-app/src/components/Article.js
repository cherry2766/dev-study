import React from 'react';

//함수의 매개변수 표현식으로 구성
//표현식의 상위 컴포넌트에서 설정한 속성명과 동일한 변수 사용(key로 받음)
function Article({title, sub}){
  return(
  <article>
    <h2 id="title">{title}</h2>
    Hello, Web <br/>
    {sub}
  </article>
  )
}
export default Article;