import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const ProductInsert = () => {
  //상품 등록 완료 후 상품 정보 조회 화면으로 포워딩 : useNavigate() 모듈 사용
  let history = useNavigate();

  const [prd, setPrd] = useState({
    prdNo: '',
    prdName: '',
    prdPrice: '',
    prdCompany: '',
    prdStock: '',
    prdDate: '',
  });

  const onChange = (e) => {
    const { value, name } = e.target;

    setPrd({
      ...prd, //기존 prd 객체 복사
      [name]: value, //name키를 가진 값을 value로 설정
    });
  };

  const onReset = () => {
    setPrd({
      prdNo: '',
      prdName: '',
      prdPrice: '',
      prdCompany: '',
      prdStock: '',
      prdDate: '',
    });
  };

  const onSubmit = (e) => {
    e.preventDefault();

    let frmData = new FormData(document.frmInsert);
    axios.post('http://localhost:8080/product/insert', frmData)
    .then(
      response => {
        alert("상품 등록 완료");
        history('/productList'); //현재 상품 조회 화면으로 포워딩, location.href로도 가능함
      }
    );
  };

  return (
    <div>
      <h3>상품 등록</h3>
      <form name="frmInsert" onSubmit={onSubmit} onReset={onReset}>
        <table>
          <thead>
            <tr>
              <td>상품번호</td>
              <td>
                <input
                  type="text"
                  name="prdNo"
                  value={prd.prdNo}
                  onChange={onChange}
                />
              </td>
            </tr>
            <tr>
              <td>상품명</td>
              <td>
                <input
                  type="text"
                  name="prdName"
                  value={prd.prdName}
                  onChange={onChange}
                />
              </td>
            </tr>
            <tr>
              <td>가격</td>
              <td>
                <input
                  type="text"
                  name="prdPrice"
                  value={prd.prdPrice}
                  onChange={onChange}
                />
              </td>
            </tr>
            <tr>
              <td>제조회사</td>
              <td>
                <input
                  type="text"
                  name="prdCompany"
                  value={prd.prdCompany}
                  onChange={onChange}
                />
              </td>
            </tr>
            <tr>
              <td>재고</td>
              <td>
                <input
                  type="text"
                  name="prdStock"
                  value={prd.prdStock}
                  onChange={onChange}
                />
              </td>
            </tr>
            <tr>
              <td>제조일</td>
              <td>
                <input
                  type="text"
                  name="prdDate"
                  value={prd.prdDate}
                  onChange={onChange}
                />
              </td>
            </tr>
            <tr>
              <td colSpan="2">
                <input type="submit" value="등록" />
                <input type="reset" value="취소" />
              </td>
            </tr>
          </thead>
        </table>
      </form>
    </div>
  );
};

export default ProductInsert;
