package com.spring_boot.projectEx.service;

import java.util.ArrayList;

import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.dto.OrderInfoDTO;
import com.spring_boot.projectEx.dto.OrderProductDTO;

public interface IOrderService {
	
	public MemberDTO getMemberInfo(String memId);
	public void insertOrderInfo(OrderInfoDTO ordDto);
	public ArrayList<OrderInfoDTO> orderList(String memId);
	OrderInfoDTO getOrderInfo(String ordNo);
	ArrayList<OrderProductDTO> getOrderProductList(String ordNo);

}
