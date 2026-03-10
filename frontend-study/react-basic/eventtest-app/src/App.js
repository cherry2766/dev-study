import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Article from './components/Article';
import Nav from './components/Nav';

function App() {
  const topics = [
    {id:1, title:'html', body:'html is ...'},
    {id:2, title:'css', body:'css is ...'},
    {id:3, title:'javascript', body:'javascript is ...'}
  ]

  return (
    <div className="App">
      <Header title="WEB" onChangeMode={()=>{
        alert('Header'); //Header 리액트 태그 속성 onChangeMode에 속성값으로 함수 전달, 리액트 태그에서 함수 활용 내용을 코드로 구성해야 함
      }}></Header>
      <Nav topics={topics} onChangeMode={(id)=>{
        alert(id);
      }}></Nav>
      <Article title="Welcome" body="Hello, Web"></Article>
    </div>
  );
}

export default App;
