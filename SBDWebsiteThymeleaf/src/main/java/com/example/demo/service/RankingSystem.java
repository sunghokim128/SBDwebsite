package com.example.demo.service;

import com.example.demo.DTO.Posting;

public class RankingSystem {

    //  3대 총량 계산해서 sbd에 값 넣어주기
    public static void createSBD(Posting posting){
        posting.setSbd( posting.getSquat() + posting.getBenchpress() + posting.getDeadlift() );
    }

    public static void createRank(Posting posting){

        // 3대 총량 계산
        double sbdTotal = posting.getBenchpress() + posting.getDeadlift() + posting.getSquat();

        if( posting.getGender().equals("남성") ){

            // 70kg 남성기준 약 3대 70 이하
            if( sbdTotal / posting.getWeight() <= 1 ){ posting.setRank("헬스가 절실히 필요한 자"); }
            // 70kg 남성기준 약 3대 70~200
            else if( sbdTotal / posting.getWeight() < 2.9 ){ posting.setRank("일반인"); }
            // 70kg 남성기준 약 3대 200~300
            else if( sbdTotal / posting.getWeight() < 4.3 ){ posting.setRank("헬린이"); }
            // 70kg 남성기준 약 3대 300~400
            else if( sbdTotal / posting.getWeight() < 5.8 ){ posting.setRank("헬소년"); }
            // 70kg 남성기준 약 3대 400~500
            else if( sbdTotal / posting.getWeight() < 7.1 ){ posting.setRank("헬어른"); }
            // 70kg 남성기준 약 3대 500~600
            else if( sbdTotal / posting.getWeight() < 8.6 ){ posting.setRank("헬창"); }
            // 그 이상
            else{posting.setRank("로니콜먼");}

        } else {

            // 60kg 여성기준 약 3대 60 이하
            if( sbdTotal / posting.getWeight() <= 1 ){ posting.setRank("헬스가 절실히 필요한 자"); }
            // 60kg 여성기준 약 3대 60~120
            if( sbdTotal / posting.getWeight() < 2 ){ posting.setRank("일반인"); }
            // 60kg 여성기준 약 3대 120~180
            else if( sbdTotal / posting.getWeight() < 3 ){ posting.setRank("헬린이"); }
            // 60kg 여성기준 약 3대 180~260
            else if( sbdTotal / posting.getWeight() < 4.3 ){ posting.setRank("헬소녀"); }
            // 60kg 여성기준 약 3대 260~300
            else if( sbdTotal / posting.getWeight() < 5.5 ){ posting.setRank("헬어른"); }
            // 60kg 여성기준 약 3대 300~400
            else if( sbdTotal / posting.getWeight() < 6.6 ){ posting.setRank("헬창"); }
            // 그 이상
            else{posting.setRank("로니콜먼");}

        }

    }

}
