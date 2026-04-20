import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ProductListItem from './ProductListItem';

const ProductList = () => {
  //요청 후 응답 데이터 받을 state 객체 생성
  //응답받아올 데이터가 ArrayList이므로 배열로 초기화
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(false); //비동기 요청 시작과 끝을 표시할 상태변수

  //스프링 서버에 비동기요청(async~await)해서 데이터 받아오는 함수 작성
  const loadData = async () => {
    setLoading(true);
    const response = await axios.get(
      'http://localhost:8080/product/productList',
    );
    console.log(response.data);
    setData(response.data);
    setLoading(false);
  };
  //렌더링 할때마다 호출
  useEffect(() => {
    loadData();
  }, []);

  return (
    <div>
      <h3>상품정보 조회</h3>
      <table border="1">
        <thead>
          <tr>
            <th>상품번호</th>
            <th>상품명</th>
            <th>상품가격</th>
            <th>제조사</th>
            <th>재고</th>
            <th>등록일</th>
            <th>수정</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {
            /* 여기에 출력 */
            data.map(
              //data 배열에 들어있는 원소 하나씩 prd에 대입 i는 반복 변수
              function (prd, i) {
                return <ProductListItem prd={prd} key={i} />;
              },
            )
          }
        </tbody>
      </table>
    </div>
  );
};

export default ProductList;
