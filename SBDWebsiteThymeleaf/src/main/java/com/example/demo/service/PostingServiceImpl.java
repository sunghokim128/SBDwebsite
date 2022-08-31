package com.example.demo.service;

import com.example.demo.DTO.Criteria;
import com.example.demo.DTO.Posting;
import com.example.demo.mapper.PostingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
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
    public Posting getById(int id) {
        return postingMapper.getById(id);
    }

    /* 게시판 목록(페이징 적용) */
    @Override
    public List<Posting> getListPaging(Criteria cri) {

        return postingMapper.getListPaging(cri);
    }

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