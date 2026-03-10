import './App.css';
import Header from './components/Header';
import Nav from './components/Nav';
import Article from './components/Article';
import React from 'react';
import Student from './components/Student';
import imgBlack from './image/black.png';

function App() {
  const title = 'props 연습';
  //Nav로 전달할 객체
  const topics = [
    { id: 1, title: 'html', body: 'html is...' },
    { id: 2, title: 'css', body: 'css is...' },
    { id: 3, title: 'javascript', body: 'javascript is...' },
  ];

  const student = {
    name: '홍길동',
    age: 20,
    year: 4,
    address: '서울',
  };

  return (
    <div className="App">
      {/* 사용자 정의 태그 속성의 역할 
          태그의 속성은 속성값을 이용해서 변화를 줘야 함 -> 어떤 변화를 줄 것인지(개발자가 결정) 
          App 컴포넌트에서 하위 컴포넌트인 Header간의 전달은?
          컴포넌트 태그가 하위 컴포넌트의 함수의 인수로 전달됨 
          1. 속성 값을 정적 텍스트로 전달 Header('WEB')
          2. 속성 값을 변수를 통해서 전달 Article(title) << 실무에서 더 많이 씀
      */}
      <Header title="WEB" title2="REACT" />
      <Nav topics={topics} />
      <Article title={title} sub="부제목" />
      <Student student={student}></Student>
      {/* image 사용
          1. src폴더에 image 폴더 생성하고 이미지 저장 후 사용하려는 이미지 import 해서 사용
          2. app이 자동 제공하는 public > assets 폴더 생성(폴더명 아무거나 상관없음)하고 이미지 저장해서 사용 
          import 없이 바로 사용 가능(import 하면 안됨) */}
      <img src={imgBlack} alt="black" width="100" height="150" />
      <img src="/image/apple.png" />
      <img src="/image/banana.png" />
    </div>
  );
}

export default App;
