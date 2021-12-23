package com.mypj.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_SeatDAO;
import com.mypj.VO.SeatFlagVO;
import com.mypj.VO.SeatVO;

@Service
public class IF_SeatServiceImpl implements IF_SeatService{
	@Inject IF_SeatDAO seatDAO;

	@Override
	public SeatVO getSeatList(int setMnTNo) throws Exception {
		// TODO Auto-generated method stub
		return seatDAO.getSeatList(setMnTNo);
	}

	@Override
	public List<SeatFlagVO> getSeatFlag(int setMnTNo) throws Exception {
		// TODO Auto-generated method stub
		return seatDAO.getSeatFlag(setMnTNo);
	}
}
