package com.example.demo.mapper;

import com.example.demo.DTO.Criteria;
import com.example.demo.DTO.Posting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PostingMapper {

    int insert(Posting posting);

    List<Posting> getAll();

    Posting getById(int id);

    public List<Posting> getListPaging(Criteria cri);

    /*
    List<Posting> getByTitle(String title);

    Posting getByCorrectTitle(String title);
    */
}
