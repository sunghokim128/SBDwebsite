package com.example.demo.service;

import com.example.demo.DTO.Posting;
import com.example.demo.mapper.PostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostingServiceImpl implements PostingService {

    @Autowired
    PostingMapper postingMapper;

    @Override
    public int insert(Posting posting) {
        // 랭킹을 계산함
        RankingSystem.createRank(posting);
        return postingMapper.insert(posting);
    }

    @Override
    public List<Posting> getAll() {
        return postingMapper.getAll();
    }

    @Override
    public int getTotalCount() {
        return postingMapper.getTotalCount();
    }

    public int getTotalPageCount(){
        int totalPostingNum = postingMapper.getTotalCount();
        // int division 때문에 총 페이지 수가 게시물이 1개 일땐 0페이지 10개일땐 1페이지 11개 일때도 1페이지로 표시됨
        // (총 게시물 수) / (한 페이지 당 게시물 수) 가 정수로 나눠떨어지면 그대로 두고, 아닐 경우 1페이지를 추가해주는 조건을 추가
        return totalPostingNum / 10 + (totalPostingNum % 10 == 0 ? 0 : 1);
    }

    @Override
    public Posting getById(int id) {
        return postingMapper.getById(id);
    }

    @Override
    public List<Posting> getListPaging(int pageNum){
        int skipFrom = (pageNum - 1) * 10;
        return postingMapper.getListPaging(skipFrom);
    }

    @Override
    public String easterEgg(int pageNum){
        if(pageNum == 800){
            return "Ronnie's Legendary Squat: [800lb x 2]\n" +
                    "https://www.youtube.com/watch?v=LVVdlwf1iyM&feature=emb_imp_woyt\n" +
                    "The King";
        }
        return "";
    }

    /* 게시판 목록(페이징 적용) */

    /*
    @Override
    public List<Posting> getByTitle(String title) {
        return postingMapper.getByTitle(title);
    }

    @Override
    public Posting getByCorrectTitle(String title) {
        return postingMapper.getByCorrectTitle(title);
    }
    */


}
