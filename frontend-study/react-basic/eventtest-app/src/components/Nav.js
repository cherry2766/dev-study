import React from 'react';

function Nav(props) {
  const lis = []
  for(let i=0; i<props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(<li key={t.id}><a id={t.id} href={'/read/'+t.id} onClick={
      event=>{
        event.preventDefault();
        props.onChangeMode(event.target.id); //click 이벤트가 발생한 a 객체의 id속성값을 cnChangeMode에 전달
      }
    }>{t.title}</a></li>);
  }
  return (
    <nav>
      <ol>
        {lis}
      </ol>
    </nav>
  )
}

export default Nav;