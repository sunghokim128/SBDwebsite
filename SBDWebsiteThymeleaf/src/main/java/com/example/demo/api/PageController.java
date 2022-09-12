package com.example.demo.api;

import com.example.demo.DTO.Posting;
import com.example.demo.service.PostingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    PostingServiceImpl postingService;

    // create를 누르면 게시글을 올릴 폼(form)을 가져옴
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

    // 이용자가 처음 웹사이트에 들어왔을때 홈 화면을 띄움
    @GetMapping("")
    public String home(@RequestParam(required=true,defaultValue="") String title,
                       @RequestParam(required=true,defaultValue="1") int pageNum,
                       @RequestParam(required=true,defaultValue="") String filterValue,
                       Model model) {
        model.addAttribute("postings", postingService.getPage(title, pageNum, filterValue));
        model.addAttribute("totalPages", postingService.getTotalPageCount(title, filterValue));
        model.addAttribute("currentTitle", title);
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("currentFilter", filterValue);
        if( pageNum == 800 ){ model.addAttribute("easterEggStatement", postingService.easterEgg(pageNum));}
        return "home";
    }

    // 글 자세히보기 기능 (게시글의 id로 게시글 조회)
    @GetMapping("/posting/id/{id}")
    public String getPostingById(@PathVariable("id") int id, Model model) {
        model.addAttribute("posting", postingService.getById(id));
        return "postingView";
    }

    // 1RM 로고를 눌러서 홈 화면으로 돌아가는 기능
    @GetMapping("home")
    public String returnHome() { return "redirect:/"; }
}
