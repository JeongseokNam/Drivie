package com.mypj.drivie;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypj.VO.FoodVO;
import com.mypj.VO.MovieInTheaterVO;
import com.mypj.VO.ReservationVO;
import com.mypj.VO.ReserveFoodVO;
import com.mypj.VO.SeatFlagVO;
import com.mypj.VO.SeatVO;
import com.mypj.service.IF_FoodInTheaterService;
import com.mypj.service.IF_FoodService;
import com.mypj.service.IF_MovieInTheaterService;
import com.mypj.service.IF_MovieService;
import com.mypj.service.IF_ReserveService;
import com.mypj.service.IF_SeatService;
import com.mypj.service.IF_TheaterService;

@Controller
public class TicketController {
	@Inject IF_MovieService movieService;
	@Inject IF_TheaterService theaterService;
	@Inject IF_MovieInTheaterService MnTService;
	@Inject IF_SeatService seatService;
	@Inject IF_FoodInTheaterService FnTService;
	@Inject IF_FoodService foodService;
	@Inject IF_ReserveService reserveService;
	@GetMapping("/reserveTicketForm")
	public String reserveTicketForm(Model model) throws Exception {
		model.addAttribute("movieList",movieService.getMovieList());
		model.addAttribute("theaterList",theaterService.getTheaterList());
		return "ticket/reserveTicketForm";
	}
	
	@GetMapping("/getTheaterListByMovie")
	@ResponseBody
	public List<MovieInTheaterVO> getTheaterListByMovie(@RequestParam("movieNo")int movieNo) throws Exception{
		
		return MnTService.getTheaterListByMovie(movieNo);
	}
	
	@GetMapping("/getShowTimeList")
	@ResponseBody
	public List<MovieInTheaterVO> getShowTimeList(@RequestParam("setMovieNo")int movieNo,@RequestParam("setTheaterNo")int theaterNo)throws Exception{
		MovieInTheaterVO vo = new MovieInTheaterVO();
		vo.setMovie_no(movieNo);
		vo.setTheater_no(theaterNo);
		return MnTService.getShowTimeLisetByMnT(vo);
	}
	
	@GetMapping("/getSeatList")
	@ResponseBody
	public SeatVO getSeatList(@RequestParam("setMnTNo") int setMnTNo)throws Exception{
		
		return seatService.getSeatList(setMnTNo);
	}
	@GetMapping("/getSeatFlag")
	@ResponseBody
	public List<SeatFlagVO> getSeatFlag(@RequestParam("setMnTNo") int setMnTNo)throws Exception{
		
		return seatService.getSeatFlag(setMnTNo);
	}
	@GetMapping("/getFoodListByTheaterNo")
	@ResponseBody
	public List<FoodVO> getFoodListByTheaterNo(@RequestParam("setTheaterNo")int setTheaterNo)throws Exception{
		
		return foodService.getFoodListByTheaterNo(setTheaterNo);
	}
	
	@PostMapping("/addResrvatrion")
	@ResponseBody
	public int addReservatrion(@RequestBody ReservationVO vo) throws Exception {
		return reserveService.addReservatrion(vo);
	}
	/*
	 * @PostMapping("/addReserveFood")
	 * 
	 * @ResponseBody public void addReserveFood(@RequestBody List<ReserveFoodVO>
	 * list)throws Exception{ reserveService.addReserveFood(list); for (int i = 0; i
	 * < list.size(); i++) { System.out.println(list.get(i).getReserveno());
	 * System.out.println(list.get(i).getFoodname());
	 * System.out.println(list.get(i).getFoodcnt()); } }
	 */
}
