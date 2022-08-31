package com.example.demo.DTO;

import lombok.Data;

@Data
public class Posting {
    private int id; // 게시글 아이디
    private String title; // 게시글 제목
    private String body; // 게시글 본문
    private int weight; // 작성자 체중 (체급별 랭킹)
    //private boolean gender;   에서 바꿈
    private String gender; // 작성자 성별 (성별 랭킹)
    private int squat; // 작성자 스쿼트 1RM
    private int benchpress; // 작성자 벤치프레스 1RM
    private int deadlift; // 작성자 데드리프트 1RM
    private String rank; // 게스트의 랭크 (3대합계를 체급, 성별 조건을 넣어서 계산함)
    // private String videoLink; // 3대 인증 영상
}


