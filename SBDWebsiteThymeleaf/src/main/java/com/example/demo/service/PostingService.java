package com.example.demo.service;

import com.example.demo.DTO.Posting;

import java.util.List;

public interface PostingService {

    int insert(Posting posting);

    List<Posting> getPage(String title, int pageNum, String filterValue);

    int getTotalPageCount(String title, String filterValue);

    Posting getById(int id);

    String easterEgg(int pageNum);
}
