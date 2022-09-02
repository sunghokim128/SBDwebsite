package com.example.demo.service;

import com.example.demo.DTO.Posting;

import java.util.List;

public interface PostingService {

    int insert(Posting posting);

    List<Posting> getAll();

    int getTotalCount();

    Posting getById(int id);

    List<Posting> getListPaging(int pageNum);



    //List<Posting> getByTitle(String title);

    //Posting getByCorrectTitle(String title);


}
