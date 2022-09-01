package com.example.demo.mapper;

import com.example.demo.DTO.Posting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostingMapper {

    int insert(Posting posting);

    List<Posting> getAll();

    Posting getById(int id);

    List<Posting> getListPaging(int skipFrom);

    /*
    List<Posting> getByTitle(String title);

    Posting getByCorrectTitle(String title);
    */
}