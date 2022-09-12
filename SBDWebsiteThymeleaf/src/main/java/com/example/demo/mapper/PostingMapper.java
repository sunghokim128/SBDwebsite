package com.example.demo.mapper;

import com.example.demo.DTO.Posting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostingMapper {

    int insert(Posting posting);

    int getTotalCount(String title, String filterValue);

    Posting getById(int id);

    void updateViews(int id);

    List<Posting> getPage(String title, int skipFrom, String filterValue); // String filter어쩌고 하고 더 늘어날 수 있음




    /*

    Posting getByCorrectTitle(String title);
    */
}
