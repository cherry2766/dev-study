import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const ProductListItem = ({prd}) => {
  //날짜 포맷 변경
  let moment = require('moment');
  let date = moment(prd.prdDate).format('YYYY-MM-DD')

  let history = useNavigate();
  
  const onDeleteItem = () => {
    if(window.confirm("삭제하시겠습니까?")) {
      axios.get("http://localhost:8080/product/delete/" + prd.prdNo)
        .then(
          ()=>{
            history("/productList"); //동일 페이지 다시 보는 경우
            window.location.reload(); //명시적인 새로고침이 필요
          }
        ).catch(err=>console.log(err));
    }
  }
  return (
    <tr>
      <td><Link to={"/productDetailView/" + prd.prdNo}>{prd.prdNo}</Link></td>
      <td>{prd.prdName}</td>
      <td>{prd.prdPrice}</td>
      <td>{prd.prdCompany}</td>
      <td>{prd.prdStock}</td>
      <td>{date}</td>
      <td><Link to={"/productUpdate/"+prd.prdNo}>수정</Link></td>
      <td><button onClick={onDeleteItem}>삭제</button></td>
    </tr>
  );
};

export default ProductListItem;
