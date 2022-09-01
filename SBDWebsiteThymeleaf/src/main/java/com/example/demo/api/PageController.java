package com.example.demo.api;

import com.example.demo.DTO.Posting;
import com.example.demo.service.PostingServiceImpl;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    PostingServiceImpl postingService;

    // URL이 "" 이기때문에 홈 화면을 디폴트 값으로 출력
    // http://localhost:8080/?pageNum=페이지번호  <- 이렇게 URL 에 작성하면 페이지가 넘어가지기는 하는데, 이걸 어떻게 view에 추가하지
    @GetMapping("")
    public String home(@RequestParam(required=true,defaultValue="1")int pageNum, Model model){
        // 아래에 있는 postingService.getListPaging(pageNum) 가 리턴하는 값은 10개의 게시글이 포함된 List<Posting>
        model.addAttribute("postings", postingService.getListPaging(pageNum));
        return "home";
    }

    /* 이전에 있었던 디폴트 홈 값
    // URL이 "" 이기때문에 홈 화면을 디폴트 값으로 출력, 글 리스트를 가져와서 model에 그 정보를 담아서 home.html로 전달함
    @GetMapping("")
    public String home( Model model){
        model.addAttribute("postings", postingService.getAll());
        return "home";
    }
     */



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
    //일단 페이지 나눠서 게시글을 10개씩 호출하는거 성공
    @GetMapping("/posting/list")
    public String boardListGET(@RequestParam(required=true,defaultValue="1")int pageNum, Model model) {
        model.addAttribute("postings", postingService.getListPaging(pageNum));
        return "testPaging";
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



