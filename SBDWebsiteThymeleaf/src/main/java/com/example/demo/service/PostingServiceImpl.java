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
        return postingMapper.insert(posting);
    }

    public List<Posting> getPage(String title, int pageNum, String filterValue) {
        int skipFrom = (pageNum - 1) * 20; //한 페이지에 게시물은 최대 20게로 설정
        List<Posting> postingList = postingMapper.getPage(title, skipFrom, filterValue);
            for(int i = 0; i < postingList.size(); i++ ){
                    Posting posting = postingList.get(i);
                    RankingSystem.createSBD(posting); // 스쿼트, 벤치프레스, 데드리프트 값의 총합을 posting.sbd에 넣어줌
                    RankingSystem.createRank(posting); // 랭킹을 계산해서 posting.rank에 넣어줌
                    LinkSystem.changeToEmbed(posting); // 동영상을 embed할 수 있게 URL을 변경해줌
                    LinkSystem.createThumbnailImage(posting); // videolink가 비어있으면 디폴트 썸네일 이미지 출력
                }
        return postingList;
    }

    public int getTotalPageCount(String title, String filterValue){
        int totalPostingNum = postingMapper.getTotalCount(title, filterValue);
        return totalPostingNum / 20 + (totalPostingNum % 20 == 0 ? 0 : 1); //한 페이지에 게시물은 최대 20게로 설정
    }

    @Override
    public Posting getById(int id) {
        Posting posting = postingMapper.getById(id);
        postingMapper.updateViews(id);
        RankingSystem.createSBD(posting); // 스쿼트, 벤치프레스, 데드리프트 값의 총합을 sbd에 넣어주기
        RankingSystem.createRank(posting); // 랭킹을 계산해서 rank에 집어넣음
        return posting;
    }
    /*
    getPage에서 RankingSystem.create을 통해서 sbd와 rank를 계산했음에도 불구하고 getById에서 또 부르는 이유는 sbd와 rank가 DB에 따로
    저장되는 값들이 아니기 때문이다. 그리고 이렇게 DB에 저장하지 않고 RankingSystem를 통해서 rank값을 불러오는 형식을 유지하면 rank의 기준
    을 업데이트하기에 용이하다. (헬창의 요구조건이 3대500에서 3대550 이 되어도 DB에 손 안대고 RankingSystem만 손보면 됨)
     */

    @Override
    public String easterEgg(int pageNum){
        if(pageNum == 800){
            return "Ronnie's Legendary Squat: [800lb x 2]\n" +
                    "https://www.youtube.com/watch?v=LVVdlwf1iyM&feature=emb_imp_woyt\n" +
                    "The King\nCongratulations on finding the easter egg!!!\n" +
                    "Email me through sunghokim128@gmail.com with the title \'PageNum800 Easteregg Found\'\n" +
                    "I will send you protein powder";
        }
        return "";
    }

}
