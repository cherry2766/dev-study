package sec07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDAO {
	
	public ArrayList<ProductVO> productSelect() {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    ArrayList<ProductVO> prdList = new ArrayList<>();
	    
	    try {
	    	con = DBConnect.getConnection();
	    	
	    	String sql = "select * from product1";
	    	pstmt = con.prepareStatement(sql);
	    	rs = pstmt.executeQuery();
	    	
	    	while(rs.next()) {
	    		String prdNo = rs.getString("prdNo");
	    		String prdName = rs.getString("prdName");
	    		int prdPrice = rs.getInt("prdPrice");
	    		String prdCompany = rs.getString("prdCompany");
	    		
	    		ProductVO vo = new ProductVO();
	    		vo.setPrdNo(prdNo);
	    		vo.setPrdName(prdName);
	    		vo.setPrdPrice(prdPrice);
	    		vo.setPrdCompany(prdCompany);
	    		
	    		prdList.add(vo);
	    	}
	    }catch(Exception e) {
	    	e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return prdList;	    
	}

}
