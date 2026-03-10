import React, {useState} from 'react';

const Message = () => {
  const [message,setMessage] = useState('출력 메시지');

  //한 컴포넌트에서 useState() 여러번 사용 가능
  const [colors, setColor] = useState('black');
  //익명함수 생성(버튼 클릭시 콜백용)
  const onClickEnter = () => setMessage('안녕하세요');
  const onClickLeave = () => setMessage('안녕히 가세요');
  const onClickInit = () => setMessage('출력 메시지');
  
  return (
    <div>
      <h3>{message}</h3>
      <p/>
      <button onClick={onClickEnter}>입장</button> &nbsp;&nbsp;
      <button onClick={onClickLeave}>퇴장</button> &nbsp;&nbsp;
      <button onClick={onClickInit}>초기화</button>
      <p/>
      <hr/>
      <h3 style={{color:colors}}>{colors}</h3>
      <p/>
      <button onClick={()=> setColor('red')}>빨강</button> &nbsp;&nbsp;
      <button onClick={()=> setColor('blue')}>파랑</button> &nbsp;&nbsp;
      <button onClick={()=> setColor('green')}>초록</button>
    </div>
  );
};

export default Message;