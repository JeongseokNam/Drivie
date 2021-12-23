package com.mypj.DAO;

import java.util.List;

import com.mypj.VO.ReservationVO;

public interface IF_ReserveDAO {

	void addReservatrion(ReservationVO vo)throws Exception;

	int getReserveNo()throws Exception;

	List<ReservationVO> getMyList(String id)throws Exception;
}
