package com.example.demo.service;

import com.example.demo.DTO.Posting;

public class RankingSystem {

    public static void createSBD(Posting posting){ // 3대 총량 계산해서 sbd에 값 넣어주기
        posting.setSbd( posting.getSquat() + posting.getBenchpress() + posting.getDeadlift() + "kg");
    }

    public static void createRank(Posting posting){
        // 3대 총량 계산
        double sbdTotal = posting.getBenchpress() + posting.getDeadlift() + posting.getSquat();
        if( posting.getGender().equals("남성") ){
            // 75kg 남성기준 약 3대 150 이하
            if( sbdTotal / posting.getWeight() <= 2 ){ posting.setRank("환자"); }
            // 75kg 남성기준 약 3대 150~215
            else if( sbdTotal / posting.getWeight() < 3 ){ posting.setRank("일반인"); }
            // 75kg 남성기준 약 3대 215~375
            else if( sbdTotal / posting.getWeight() < 5 ){ posting.setRank("헬린이"); }
            // 75kg 남성기준 약 3대 375~500
            else if( sbdTotal / posting.getWeight() < 6.6 ){ posting.setRank("헬어른"); }
            // 75kg 남성기준 약 3대 500~600
            else if( sbdTotal / posting.getWeight() < 8 ){ posting.setRank("헬창"); }
            // 그 이상
            else{posting.setRank("로니콜먼");}
        } else {//성별이 여자인 경우
            // 60kg 여성기준 약 3대 120 이하
            if( sbdTotal / posting.getWeight() <= 2 ){ posting.setRank("환자"); }
            // 60kg 여성기준 약 3대 120~180
            if( sbdTotal / posting.getWeight() < 3 ){ posting.setRank("일반인"); }
            // 60kg 여성기준 약 3대 180~250
            else if( sbdTotal / posting.getWeight() < 4.16 ){ posting.setRank("헬린이"); }
            // 60kg 여성기준 약 3대 250~360
            else if( sbdTotal / posting.getWeight() < 6 ){ posting.setRank("헬어른"); }
            // 60kg 여성기준 약 3대 360~480
            else if( sbdTotal / posting.getWeight() < 8 ){ posting.setRank("헬창"); }
            // 그 이상
            else{posting.setRank("로니콜먼");}
        }

    }

}
