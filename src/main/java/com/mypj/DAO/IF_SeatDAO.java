package com.mypj.DAO;

import java.util.List;

import com.mypj.VO.SeatFlagVO;
import com.mypj.VO.SeatVO;

public interface IF_SeatDAO {

	SeatVO getSeatList(int setMnTNo)throws Exception;

	List<SeatFlagVO> getSeatFlag(int setMnTNo)throws Exception;

}
