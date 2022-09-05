package com.example.demo.service;

import com.example.demo.DTO.Posting;

import java.util.List;

public interface PostingService {

    int insert(Posting posting);

    List<Posting> getAll();

    int getTotalCount(String title);

    Posting getById(int id);

    List<Posting> getListPaging(int pageNum);

    String easterEgg(int pageNum);


    List<Posting> getByTitle(String title, int pageNum);

    //Posting getByCorrectTitle(String title);


}
