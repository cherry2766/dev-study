import React, { useEffect, useState } from 'react';
import axios from 'axios';

const AxiosSpring = () => {
  const [data, setData] = useState('');
  const [loading, setLoading] = useState(false);

  //서버에 요청해서 데이터 받아옴
  //state값 저장 및 상태 변경
  const loadData = async () => {
    setLoading(true);
    const response = await axios.get('http://localhost:8080/hello');
    console.log(response.data);
    setData(response.data);
    setLoading(false);
  };

  //렌더링 할때마다 호출
  //[] 파라미터 : loadData 한번만 호출하게 설정해 줌
  useEffect(() => {
    loadData();
  }, []);

  return (
    <div>
      <h3>서버로부터 받아온 값</h3>
      {data}
    </div>
  );
};

export default AxiosSpring;
