package com.example.demo.api;

import com.example.demo.DTO.Posting;
import com.example.demo.service.PostingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    PostingServiceImpl postingService;

    // 홈 화면을 띄우고 정해진 개수만큼 게시글을 출력함
    @GetMapping("")
    public String home(@RequestParam(required=true,defaultValue="") String title,
                       @RequestParam(required=true,defaultValue="1") int pageNum,
                       //@RequestParam Filters filters, 이렇게 필터객체 추가?
                       Model model) {
        // 게시글의 제목(title)으로 게시글 검색 (한글자라도 일치하면 제목을 가져온다. 다만 순서에 어긋나면 안됨)
        model.addAttribute("postings", postingService.getByTitle(title, pageNum));
        model.addAttribute("totalPages", postingService.getTotalPageCount(title));
        model.addAttribute("currentTitle", title);
        model.addAttribute("currentPage", pageNum);

        if( pageNum == 800 ){ model.addAttribute("easterEggStatement", postingService.easterEgg(pageNum));}

        return "home";
    }



    // 다른 화면에서 홈 화면으로 돌아가는 기능
    @GetMapping("home")
    public String returnHome() { return "redirect:/"; }


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
    이거 이제 쓸 필요가 없어짐, Thymeleaf에서
    // 글 자세히보기 기능 (게시물의 제목으로 게시글 조회)
    @GetMapping("/posting/correcttitle/{title}")
    public String getPostingByTitle(@PathVariable String title, Model model) {
        model.addAttribute("posting", postingService.getByCorrectTitle(title));
        return "postingView";
    }

     */

}
