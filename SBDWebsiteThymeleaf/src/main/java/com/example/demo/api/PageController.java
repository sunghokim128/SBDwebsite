package com.example.demo.api;

import com.example.demo.DTO.Criteria;
import com.example.demo.DTO.Posting;
import com.example.demo.service.PostingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @Autowired
    PostingServiceImpl postingService;

    // URL이 "" 이기때문에 홈 화면을 디폴트 값으로 출력
    @GetMapping("")
    public String home(Model model){
        //글 리스트를 가져와서 home.html 파일에 글 정보를 넘겨줌
        model.addAttribute("postings", postingService.getAll());
        return "home";
    }

    // 홈 화면으로 돌아가는 기능
    @GetMapping("home")
    public String home() { return "redirect:/"; }

    // 게시글을 올릴 폼(form)을 가져옴
    @GetMapping("/posting/new")
    public String createForm(){
        return "postingForm";
    }

    // 게시글 작성 후 게시하면 DB에 저장됨. 입력된 값이 유효한지는 프론트에서 관리
    @PostMapping("/posting/new")
    public String postPosting(Posting posting) {
        postingService.insert(posting);
        return "redirect:/";
    }

    // 글 자세히보기 기능 (게시글의 id로 게시글 조회)
    @GetMapping("/posting/id/{id}")
    public String getPostingById(@PathVariable("id") int id, Model model) {
        model.addAttribute("posting", postingService.getById(id));
        return "postingView";
    }

    /*
    //게시판 목록 페이지 접속(페이징 적용)
    @GetMapping("/posting/list")
    @ResponseBody
    public void boardListGET(Model model, Criteria cri) {

        //log.info("boardListGET");
        model.addAttribute("list", postingService.getListPaging(cri));

    }
    */

    /*
    이거 이제 쓸 필요가 없어짐, Thymeleaf에서
    // 글 자세히보기 기능 (게시물의 제목으로 게시글 조회)
    @GetMapping("/posting/correcttitle/{title}")
    public String getPostingByTitle(@PathVariable String title, Model model) {
        model.addAttribute("posting", postingService.getByCorrectTitle(title));
        return "postingView";
    }


    //게시글의 제목(title)으로 게시글 검색 (한글자라도 일치하면 제목을 가져온다. 다만 순서에 어긋나면 안됨)
    @GetMapping("/posting/title/{title}")
    @ResponseBody
    public List<Posting> getPostingBySimilarTitle(@PathVariable("title") String title) { return postingService.getByTitle(title); }
    */
}



