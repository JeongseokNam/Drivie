package com.mypj.service;

import java.util.List;

import com.mypj.VO.ReservationVO;
import com.mypj.VO.ReserveFoodVO;

public interface IF_ReserveService {
	
	int addReservatrion(ReservationVO vo)throws Exception;

	void addReserveFood(List<ReserveFoodVO> list)throws Exception;

	List<ReservationVO> getMyList(String id)throws Exception;

}
