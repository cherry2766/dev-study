import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import { useState } from 'react';

function App() {
  //let mode = 'READ'; //일반 변수는 동적으로 값이 변경되더라도 화면의 rendering이 진행될 때 리셋 됨
  //동적 변경 유지 시키려면 state 기능 사용해야 함 - 상태가 변경되면 변경 상태 유지하면서 rendering 진행 함

  //const _mode = useState('WELCOME'); //state 객체 할당 후 초기화
  //state 배열형태로 구성되어 있음 _mode[0] => 상태값 저장 / _mode[1] => 상태값 변경시키는 함수코드가 있음

  //배열 비 구조화 할당 - 리액트 형식(배열 요소를 쉽게 추출하기 위한 문법)
  const [mode, setMode] = useState('WELCOME');
  const [topicId, setTopicId] = useState(null);
  //console.log(_mode);

  //const mode = _mode[0]; //state의 값을 참조하는 상수
  //const setMode = _mode[1];//state의 값을 변경하는 함수
  const topics = [
    { id: 1, title: 'html', body: 'html is ...' },
    { id: 2, title: 'css', body: 'css is ...' },
    { id: 3, title: 'javascript', body: 'javascript is ...' },
  ];

  let content = null;
  if (mode === 'WELCOME') {
    content = <Article title="Welcome" body="Hello, Web"></Article>;
  } else if (mode === 'READ') {
    const topic = topics.find((t) => t.id === topicId);

    if (topic) {
      content = <Article title={topic.title} body={`${topic.body}`} />;
    }
  }
  return (
    <div className="App">
      <Header
        title="WEB"
        onChangeMode={() => {
          //mode = 'WELCOME';
          setMode('WELCOME');
        }}
      ></Header>
      <Nav
        topics={topics}
        onChangeMode={(id) => {
          //mode = 'READ';
          setMode('READ');
          setTopicId(Number(id));
        }}
      ></Nav>
      {content}
    </div>
  );
}

export default App;
