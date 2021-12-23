package com.mypj.drivie;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mypj.VO.FoodInTheaterVO;
import com.mypj.VO.FoodVO;
import com.mypj.VO.MemberVO;
import com.mypj.VO.MovieInTheaterVO;
import com.mypj.VO.MovieVO;
import com.mypj.VO.TheaterVO;
import com.mypj.service.IF_FoodInTheaterService;
import com.mypj.service.IF_FoodService;
import com.mypj.service.IF_MemberService;
import com.mypj.service.IF_MovieInTheaterService;
import com.mypj.service.IF_MovieService;
import com.mypj.service.IF_TheaterService;
import com.mypj.util.FileDataUtil;

@Controller
public class AdminController {
	@Inject
	IF_MovieService movieService;
	@Inject
	IF_TheaterService theaterService;
	@Inject
	IF_FoodService foodService;
	@Inject
	IF_MemberService memberService;
	@Inject
	FileDataUtil fileDataUtil;
	@Inject IF_MovieInTheaterService MnTService;
	@Inject IF_FoodInTheaterService FnTService;
	// 영화admin
	@GetMapping("/admin") // 관리자창
	public String addmin() throws Exception {
		return "admin/adminHome";
	}

	@GetMapping("/adminMovie") // 영화관리
	public String adminMovie(Model model) throws Exception {
		model.addAttribute("movieList", movieService.getMovieList());
		return "admin/adminMovie";
	}

	@GetMapping("/admin_addMovieForm") // 영화추가폼
	public String admin_addMovieForm() throws Exception {
		return "admin/admin_addMovieForm";
	}

	@PostMapping("/admin_addMovie") // 영화추가
	public String admin_addMovie(MovieVO vo, MultipartFile file) throws Exception {
		if (file.getOriginalFilename() == "") {
			movieService.addMovie(vo);
		} else {
			String photo = fileDataUtil.fileUpload(file);
			vo.setPhoto(photo);
			movieService.addMovie(vo);
		}
		return "redirect:/adminMovie";
	}

	@GetMapping("/admin_modMovieForm") // 영화수정폼
	public String admin_modMovieForm(int no, Model model) throws Exception {
		model.addAttribute("movieInfo", movieService.selectMovie(no));
		return "admin/admin_modMovieForm";
	}

	@PostMapping("/admin_modMovie") // 영화수정
	public String admin_modMovie(MovieVO vo, MultipartFile file) throws Exception {
		if (file.getOriginalFilename() == "") {
			movieService.modMovie(vo);
		} else {
			String photo = fileDataUtil.fileUpload(file);
			vo.setPhoto(photo);
			movieService.modMovie(vo);
		}
		return "redirect:/adminMovie";
	}

	@GetMapping("/admin_delMovie") // 영화삭제
	public String admin_delMovie(int no) throws Exception {
		movieService.delMovie(no);
		return "redirect:/adminMovie";
	}

	@GetMapping("/admin_searchMovie") // 영화검색
	public String admin_searchMovie(String searchWord, Model model) throws Exception {
		model.addAttribute("movieList", movieService.searchMovie(searchWord));
		return "admin/adminMovie";
	}

	// 영화관admin
	@GetMapping("/adminTheater") // 영화관관리
	public String adminTheater(Model model) throws Exception {
		model.addAttribute("theaterList", theaterService.getTheaterList());
		return "admin/adminTheater";
	}

	@GetMapping("/admin_addTheaterForm") // 영화관추가폼
	public String admin_addTheaterForm() throws Exception {
		return "admin/admin_addTheaterForm";
	}

	@PostMapping("/admin_addTheater") // 영화관추가
	public String admin_addTheater(TheaterVO vo) throws Exception {
		theaterService.addTheater(vo);
		return "redirect:/adminTheater";
	}

	@GetMapping("/admin_modTheaterForm") // 영화관수정폼
	public String admin_modTheaterForm(Model model, int no) throws Exception {
		model.addAttribute("theaterInfo", theaterService.selectTheater(no));
		return "admin/admin_modTheaterForm";
	}

	@PostMapping("/admin_modTheater") // 영화관수정
	public String admin_modTheater(TheaterVO vo) throws Exception {
		theaterService.modTheater(vo);
		return "redirect:/adminTheater";
	}

	@GetMapping("/admin_delTheater") // 영화관삭제
	public String admin_delTheater(int no) throws Exception {
		theaterService.delTheater(no);
		return "redirect:/adminTheater";
	}

	@GetMapping("/admin_searchTheater") // 영화관검색
	public String admin_searchTheater(String searchWord, Model model) throws Exception {
		model.addAttribute("theaterList", theaterService.searchTheater(searchWord));
		return "admin/adminTheater";
	}

	// 음식admin
	@GetMapping("/adminFood") // 음식관리창
	public String adminFood(Model model) throws Exception {
		model.addAttribute("foodList", foodService.getFoodList());
		return "admin/adminFood";
	}

	@GetMapping("/admin_addFoodForm") // 음식추가폼
	public String admin_addFoodForm() throws Exception {
		return "admin/admin_addFoodForm";
	}

	@PostMapping("/admin_addFood") // 음식추가
	public String admin_addFood(FoodVO vo, MultipartFile file) throws Exception {
		if (file.getOriginalFilename() == "") {
			foodService.addFood(vo);
		} else {
			String photo = fileDataUtil.fileUpload(file);
			vo.setPhoto(photo);
			foodService.addFood(vo);
		}
		return "redirect:/adminFood";
	}

	@GetMapping("/admin_modFoodForm") // 음식수정폼
	public String admin_modFoodForm(int no, Model model) throws Exception {
		model.addAttribute("foodInfo", foodService.selectFood(no));
		return "admin/admin_modFoodForm";
	}

	@PostMapping("/admin_modFood") // 음식수정
	public String admin_modFood(FoodVO vo, MultipartFile file) throws Exception {
		if (file.getOriginalFilename() == "") {
			foodService.modFood(vo);
		} else {
			String photo = fileDataUtil.fileUpload(file);
			vo.setPhoto(photo);
			foodService.modFood(vo);
		}
		return "redirect:/adminFood";
	}

	@GetMapping("/admin_delFood") // 음식삭제
	public String admin_delFood(int no) throws Exception {
		foodService.delFood(no);
		return "redirect:/adminFood";
	}

	@GetMapping("/admin_searchFood") // 음식검색
	public String admin_searchFood(String searchWord, Model model) throws Exception {
		model.addAttribute("foodList", foodService.searchFood(searchWord));
		return "admin/adminFood";
	}

	// 회원admin
	@GetMapping("/adminMember") // 멤버관리창
	public String adminMember(Model model) throws Exception {
		model.addAttribute("memberList", memberService.getMemberList());
		return "admin/adminMember";
	}
	
	@GetMapping("/admin_modMemberForm")//멤버수정창
	public String admin_modMemberForm(Model model,String id)throws Exception{
		model.addAttribute("memberInfo",memberService.getMemberInfo(id));
		return "admin/admin_modMemberForm";
		
	}

	@PostMapping("/admin_modMember")//회원수정
	public String admin_modMember(MemberVO vo)throws Exception{
		memberService.updateMemberInfo(vo);
		return"redirect:/adminMember";
	}
	
	@GetMapping("/admin_delMember")//회원삭제
	public String admin_delMember(String id)throws Exception{
		memberService.delMember(id);
		return"redirect:/adminMember";
	}
	
	// 점주관리메뉴
	@GetMapping("/admin_movieInTheater") //상영영화리스트
	public String admin_movieInTheater(HttpServletRequest request, Model model) throws Exception{
		model.addAttribute("theaterList",theaterService.getTheaterList());
		model.addAttribute("movieList",movieService.getMovieList());
		model.addAttribute("MnTList",MnTService.getMnTList());
		
		return "admin/admin_movieInTheater";
	}
	
	@PostMapping("admin_addMovieInTheater")//상영영화삭제추가
	public String admin_addMovieInTheater(MovieInTheaterVO vo)throws Exception{
		
		MnTService.addMnT(vo);
		return "redirect:/admin_movieInTheater";
	}
	
	@GetMapping("/admin_delMnT")//상영영화삭제
	public String admin_delMnT(int no)throws Exception{
		MnTService.delMnT(no);
		return "redirect:/admin_movieInTheater";
	}
	
	@GetMapping("/admin_searchMnT")//검색
	public String admin_searchMnT(String searchWord,Model model)throws Exception{
		model.addAttribute("theaterList",theaterService.getTheaterList());
		model.addAttribute("movieList",movieService.getMovieList());
		model.addAttribute("MnTList",MnTService.theaterSearchList(searchWord));
		
		
		return "admin/admin_movieInTheater";
	}

	@GetMapping("/admin_FoodInTheater")//극장&음식
	public String admin_FoodInTheater(Model model)throws Exception{
		model.addAttribute("theaterList", theaterService.getTheaterList());
		model.addAttribute("foodList", foodService.getFoodList());
		model.addAttribute("FnTList", FnTService.getFnTList());
		return "admin/admin_FoodInTheater";
	}
	
	@PostMapping("/admin_addFnT")//추가
	public String admin_addFnT(FoodInTheaterVO vo)throws Exception{
		FnTService.addFnT(vo);
		
		return "redirect:/admin_FoodInTheater";
	}
	
	@GetMapping("admin_delFnT")
	public String admin_delFnT(int no)throws Exception{
		FnTService.delFnT(no);
		return "redirect:/admin_FoodInTheater";
	}
	
	@GetMapping("/admin_searchFnT")
	public String admin_searchFnT(String searchWord,Model model)throws Exception{
		model.addAttribute("theaterList", theaterService.getTheaterList());
		model.addAttribute("foodList", foodService.getFoodList());
		model.addAttribute("FnTList",FnTService.getSearchFnTList(searchWord));
		return "admin/admin_FoodInTheater";
	}
}
