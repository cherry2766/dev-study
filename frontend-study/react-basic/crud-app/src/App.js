import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import Create from './components/Create';

function App() {
  const [mode, setMode] = useState('WELCOME');
  const [id, setId] = useState(null);
  //id 관리하기 위한 state 추가
  const [nextId, setnextId] = useState(4);
  //topics에 사용자 입력값을 통해 원소 추가할 예정 - state 변경
  const [topics, setTopics] = useState([
    { id: 1, title: 'html', body: 'html is ...' },
    { id: 2, title: 'css', body: 'css is ...' },
    { id: 3, title: 'javascript', body: 'javascript is ...' },
  ]);

  let content = null;
  if (mode === 'WELCOME') {
    content = <Article title="Welcome" body="Hello, Web"></Article>;
  } else if (mode === 'READ') {
    let title,
      body = null;
    for (let i = 0; i < topics.length; i++) {
      console.log(topics[i].id, id);
      if (topics[i].id === id) {
        title = topics[i].title;
        body = topics[i].body;
      }
    }
    content = <Article title={title} body={body}></Article>;
  } else if (mode === 'create') {
    content = (
      <Create
        onCreate={(_title, _body) => {
          //Create 컴포넌트에서 submit 발생하면 실행시킬 함수
          const newtopic = { id: nextId, title: _title, body: _body };
          const newTopics = [...topics]; //원본 state topics를 복사(깊은복사)해서 복사본 생성(메모리에 서로 다른 배열 구성)
          newTopics.push(newtopic); //복사본 수정
          setTopics(newTopics); //복사본을 전달받아 원본하고 비교해서 다른게 있으면 원본 수정하고 새로 렌더링 진행함
          setMode('READ'); //추가된 이후 READ 상태로 변경
          setId(nextId); //READ 상태에서 Article content 결정
          setnextId(nextId + 1); //다음에 진행될 create 위해서 id 값 증가 시킴

          //topics.push(newtopic); //배열 객체 state여서 직접 push 했음
          //setTopics(topics); //값 state가 아닌 참조 state - 참조 변수로 확인하기 때문에 위에서 변경시킨 배열과 전달된 배열을 비교하면
          //문제점 setTopics(topics);는 push 되어진 결과가 전달되기 때문에 같은 배열로 인지됨 (원래 배열 보관 없이 수정해버림)
          //원본 보관 후 진행해야함 : setValue() 사용
        }}
      ></Create>
    );
  }

  return (
    <div className="App">
      <Header
        title="WEB"
        onChangeMode={() => {
          setMode('WELCOME');
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(_id) => {
          setMode('READ');
          setId(_id);
        }}
      ></Nav>
      {content}
      <hr />
      {/* 새로운 토픽을 추가하기 위한 링크(component) */}
      <a
        href="/create"
        onClick={(event) => {
          event.preventDefault();
          setMode('create'); //클릭하면 create 컴포넌트 추가
        }}
      >
        Create
      </a>
    </div>
  );
}

export default App;
