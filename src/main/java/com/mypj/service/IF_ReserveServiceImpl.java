package com.mypj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_ReserveDAO;
import com.mypj.VO.ReservationVO;
import com.mypj.VO.ReserveFoodVO;

@Service
public class IF_ReserveServiceImpl implements IF_ReserveService {
	@Inject
	IF_ReserveDAO reserveDAO;

	@Override
	public int addReservatrion(ReservationVO vo) throws Exception {
		int reserveNo = reserveDAO.getReserveNo();
		vo.setReserveno(reserveNo);
		reserveDAO.addReservatrion(vo);
		return reserveNo;
	}

	@Override
	public void addReserveFood(List<ReserveFoodVO> list)throws Exception {
		

	}

	@Override
	public List<ReservationVO> getMyList(String id)throws Exception {
		// TODO Auto-generated method stub
		return reserveDAO.getMyList(id);
	}

}
