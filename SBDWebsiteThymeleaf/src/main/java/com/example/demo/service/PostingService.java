package com.example.demo.service;

import com.example.demo.DTO.Criteria;
import com.example.demo.DTO.Posting;

import java.util.List;

public interface PostingService {

    int insert(Posting posting);

    List<Posting> getAll();

    Posting getById(int id);

    /* 게시판 목록(페이징 적용) */
    public List<Posting> getListPaging(Criteria cri);

    //List<Posting> getByTitle(String title);

    //Posting getByCorrectTitle(String title);


}
