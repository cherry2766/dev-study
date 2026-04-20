import axios from 'axios';
import { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const ProductUpdate = () => {
  //detailView + insert
  const { prdNo } = useParams();
  //prd에는 1개 상품 정보를 저장할 예정 : {key:value}로 설정, prdNo는 파라미터 값 사용
  const [prd, setPrd] = useState({
    prdName: '',
    prdPrice: '',
    prdCompany: '',
    prdStock: '',
    prdDate: '',
  });

  const [loading, setLoading] = useState(false);

  const loadData = async () => {
    setLoading(true);
    const response = await axios.get(
      'http://localhost:8080/product/productDetailView/' + prdNo,
    );
    console.log('detail : ', response.data);
    setPrd({
      prdName: response.data.prdName,
      prdPrice: response.data.prdPrice,
      prdCompany: response.data.prdCompany,
      prdStock: response.data.prdStock,
      prdDate: response.data.prdDate,
    });
    setLoading(false);
  };

  //렌더링할때마다 호출
  useEffect(() => {
    loadData();
  }, []);

  //날짜 포맷 변경
  let moment = require('moment');
  let date = moment(prd.prdDate).format('YYYY-MM-DD');
  let history = useNavigate();

  //폼에 입력된 값 전송 후 수정 -> 완료 후 포워딩
  const onChange = (e) => {
    const { value, name } = e.target;

    setPrd({
      ...prd, //기존 prd 객체 복사
      [name]: value, //name키를 가진 값을 value로 설정
    });
  };

  const onReset = () => {
    setPrd({
      prdNo:prdNo,
      prdName: '',
      prdPrice: '',
      prdCompany: '',
      prdStock: '',
      prdDate: prd.prdDate,
    });
  };

  const onSubmit = (e) => {
    e.preventDefault();

    let frmData = new FormData(document.frmUpdate);
    //axios.post('http://localhost:8080/product/update', frmData)
    axios.put('http://localhost:8080/product/update', frmData)
    .then(
      response => {
        alert("상품 수정 완료");
        history('/productList'); //현재 상품 조회 화면으로 포워딩, location.href로도 가능함
      }
    );
  };

  return (
    <div>
      <h3>상품 정보 수정</h3>
      <form name="frmUpdate" onSubmit={onSubmit} onReset={onReset}>
        <table>
          <thead>
            <tr>
              <td>상품번호</td>
              <td>
                <input type="text" name="prdNo" value={prdNo} readOnly />
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
                <input type="submit" value="수정" />
                <input type="reset" value="취소" />
              </td>
            </tr>
          </thead>
        </table>
      </form>
    </div>
  );
};

export default ProductUpdate;
