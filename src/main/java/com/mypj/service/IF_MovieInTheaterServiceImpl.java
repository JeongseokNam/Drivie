package com.mypj.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.stereotype.Service;

import com.mypj.DAO.IF_MovieInTheaterDAO;
import com.mypj.VO.MovieInTheaterVO;

@Service
public class IF_MovieInTheaterServiceImpl implements IF_MovieInTheaterService {
	@Inject
	IF_MovieInTheaterDAO MnTDAO;

	@Override
	public void addMnT(MovieInTheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		MnTDAO.addMnT(vo);
	}

	@Override
	public List<MovieInTheaterVO> getMnTList() throws Exception {
		// TODO Auto-generated method stub
		return MnTDAO.getMnTList();
	}

	@Override
	public void delMnT(int no) throws Exception {
		// TODO Auto-generated method stub
		MnTDAO.delMnT(no);
	}

	@Override
	public List<MovieInTheaterVO> theaterSearchList(String searchWord) throws Exception {
		// TODO Auto-generated method stub
		return MnTDAO.theaterSearchList(searchWord);
	}

	@Override
	public List<MovieInTheaterVO> getTheaterListByMovie(int movieNo) throws Exception {
		List<MovieInTheaterVO> list = MnTDAO.getTheaterListByMovie(movieNo);

		for (int i = 0; i < list.size();i++) {
			for (int j = i+1; j < list.size(); j++) {
				if (list.get(i).getTheaterVO().getTheatername().equals(list.get(j).getTheaterVO().getTheatername())) {
					list.remove(j);
				}
			}
		}
		return list;
	}

	@Override
	public List<MovieInTheaterVO> getShowTimeLisetByMnT(MovieInTheaterVO vo) throws Exception {
		// TODO Auto-generated method stub
		return MnTDAO.getShowTimeLisetByMnT(vo);
	}

}
