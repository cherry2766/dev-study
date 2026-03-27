package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	private DataSource dataFactory;
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public ProductDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProductVO> findAll() {
		ArrayList<ProductVO> prdList = new ArrayList<>();

		try {
			con = dataFactory.getConnection();
			String sql = "select * from product1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String prdNo = rs.getString("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				String prdCompany = rs.getString("prdCompany");

				ProductVO dto = new ProductVO(prdNo, prdName, prdPrice, prdCompany);

				prdList.add(dto);
			}

		} catch (Exception e) {
			System.out.println("상품 정보 조회 실패");
			e.printStackTrace();
		}
		return prdList;

	}

	// 상품 등록
	public void addProduct(ProductVO vo) {
		try {
			con = dataFactory.getConnection();
			String no = vo.getPrdNo();
			String name = vo.getPrdName();
			int price = vo.getPrdPrice();
			String company = vo.getPrdCompany();
			String sql = "INSERT INTO product1 (prdno, prdname, prdprice, prdcompany) VALUES(?, ? ,? ,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, name);
			pstmt.setInt(3, price);
			pstmt.setString(4, company);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 상품 상세 조회
	public ProductVO findProduct(String prdId) {
		ProductVO prdInfo = null;
		try {
			con = dataFactory.getConnection();
			String sql = "select * from  product1 where prdno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prdId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String prdNo = rs.getString("prdNo");
				String prdName = rs.getString("prdName");
				int prdPrice = rs.getInt("prdPrice");
				String prdCompany = rs.getString("prdCompany");
				prdInfo = new ProductVO(prdNo, prdName, prdPrice, prdCompany);
			}
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return prdInfo;
	}
	// 상품 수정
	public void modProduct(ProductVO vo) {
		String no = vo.getPrdNo();
		String name = vo.getPrdName();
		int price = vo.getPrdPrice();
		String company = vo.getPrdCompany();

		try {
			String sql = "update product1 set prdname=?, prdprice=?, prdcompany=? where prdno=?";
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, company);
			pstmt.setString(4, no);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 상품 삭제
	public void delProduct(String prdId) {
		try {
			String sql = "delete from product1 where prdno=?";
			con = dataFactory.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, prdId);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}
