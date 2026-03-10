import './App.css';
import Header from './components/Header';
import Nav from './components/Nav'
import Article from './components/Article';
//사용자 정의 리액트 함수 js 영역임
// function Header(){
//   return(
//     <header>  {/*리액트가 해석합니다. 리액트 주석입니다.*/}
//         <h1><a href="/">React</a></h1>
//     </header>
//   )
// }

// function Nav(){
//   return(
//     <nav>
//       <ol>
//       <li><a href="">html</a></li>
//       <li><a href="">css</a></li>
//       <li><a href="">js</a></li>
//       </ol>
//     </nav>
//   )
// }

// function Article(){
//   return(
//   <article>
//     <h2>welcome</h2>
//     Hello, Web
//   </article>
//   )
// }

function App() {
  return (
    <div className="App">
      <Header/> 
      <Header></Header>
      <Nav/>
      <Article/>
      <Nav/>
    </div>
  );
}

export default App;
