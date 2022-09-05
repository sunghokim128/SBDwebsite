package com.example.demo.service;

import com.example.demo.DTO.Posting;

import java.sql.SQLOutput;

public class LinkSystem {

    public static void changeToEmbed(Posting posting){

        /* 유투브에서 바로 동영상 링크를 가져오면 이런 식으로 뜬다 https://www.youtube.com/watch?v=NLEbQySk1yA
           그런데 iframe 안에 넣으려면 watch?= 부분을 embed/ 로 바꾸어주어야 한다.
           그래서 changeToEmbed 가 watch?= 부분을 embed/로 교체해준다
           youtube shorts도 embed할 수 있게 바꿔준다
        */
        if( posting.getVideolink() != null && !posting.getVideolink().isEmpty() ) {
            posting.setVideolink(posting.getVideolink()
                    .replace("watch?v=", "embed/")
                    .replace("shorts/", "embed/"));
        }
        if( posting.getVideolinkTwo() != null && !posting.getVideolinkTwo().isEmpty() ){
            posting.setVideolinkTwo( posting.getVideolinkTwo()
                    .replace("watch?v=","embed/")
                    .replace("shorts/","embed/") );
        }
        if( posting.getVideolinkThree() != null && !posting.getVideolinkThree().isEmpty() ){
            posting.setVideolinkThree( posting.getVideolinkThree()
                    .replace("watch?v=","embed/")
                    .replace("shorts/","embed/") );
        }
        // videolink 가 비어있으면 그대로 두기 ( createThumbnailImage에서 videolink 가 비어있어야지 thumbnail 이미지 입력함)
    }


    public static void createThumbnailImage(Posting posting){ // videolink 에서 썸네일을 추출해서 가져오는 기능

        if( posting.getVideolink() == null || posting.getVideolink().isEmpty() ){
            // videolink 가 비어있으면, 미리 준비해둔 이미지로 대체하기
            posting.setThumbnail("images/thumbnail.png");
        } else {
            // 만약에 videolink 에 값이 들어가면 img 형식으로 주소 바꿔주기
            String thumbnailURL = posting.getVideolink()
                    .replace("www", "img")
                    .replace("embed/", "vi/")
                    + "/default.jpg";
            posting.setThumbnail(thumbnailURL);
        }
    }
}
