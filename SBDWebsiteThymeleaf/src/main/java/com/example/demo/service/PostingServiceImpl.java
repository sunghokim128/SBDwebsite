package com.example.demo.service;

import com.example.demo.DTO.Posting;
import com.example.demo.mapper.PostingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PostingServiceImpl implements PostingService {

    @Autowired
    PostingMapper postingMapper;

    @Override
    public int insert(Posting posting) {
        return postingMapper.insert(posting);
    }

    @Override
    public List<Posting> getByTitle(String title, int pageNum) {

        int skipFrom = (pageNum - 1) * 10;

        List<Posting> postingList = postingMapper.getByTitle(title, skipFrom);

        for(int i = 0; i < postingList.size(); i++ ){
            Posting posting = postingList.get(i);

            RankingSystem.createSBD(posting); // 스쿼트, 벤치프레스, 데드리프트 값의 총합을 sbd에 넣어주기
            RankingSystem.createRank(posting); // 랭킹을 계산해서 rank에 집어넣음
            LinkSystem.changeToEmbed(posting); // 동영상을 embed할 수 있게 URL을 변경해줌
            LinkSystem.createThumbnailImage(posting); // videolink가 비어있으면 디폴트 썸네일 이미지 출력
        }

        return postingList;
    }


    @Override
    public List<Posting> getAll() {
        return postingMapper.getAll();
    }

    @Override
    public int getTotalCount(String title) {
        return postingMapper.getTotalCount(title);
    }

    public int getTotalPageCount(String title){
        int totalPostingNum = postingMapper.getTotalCount(title);
        // int division 때문에 총 페이지 수가 게시물이 1개 일땐 0페이지 10개일땐 1페이지 11개 일때도 1페이지로 표시됨
        // (총 게시물 수) / (한 페이지 당 게시물 수) 가 정수로 나눠떨어지면 그대로 두고, 아닐 경우 1페이지를 추가해주는 조건을 추가
        return totalPostingNum / 10 + (totalPostingNum % 10 == 0 ? 0 : 1);
    }

    @Override
    public Posting getById(int id) {
        return postingMapper.getById(id);
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

    @Override
    public List<Posting> getListPaging(int pageNum){
        // skipFrom 은 DB의 Limit a,b의 a 부분을 담당함. 아래있는 10을 고칠거면 mapper도 고쳐주어야 함
        int skipFrom = (pageNum - 1) * 10;
        return postingMapper.getListPaging(skipFrom);
    }


    /*

    @Override
    public Posting getByCorrectTitle(String title) {
        return postingMapper.getByCorrectTitle(title);
    }
    */


}
