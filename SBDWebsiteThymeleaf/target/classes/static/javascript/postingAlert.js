function alertMessage() {
    // 작성자의 신체정보
    var squat = document.getElementById("squat").value;
    var benchpress = document.getElementById("benchpress").value;
    var deadlift = document.getElementById("deadlift").value;
    var weight = document.getElementById("weight").value;
    // select로 성별 받기
    var select = document.getElementById('gender');
    var gender = select.options[select.selectedIndex].value;
    // 게시물 정보
    var title = document.getElementById("title").value;
    var body = document.getElementById("body").value;
    var videolink = document.getElementById("videolink").value;
    var videolinkTwo = document.getElementById("videolinkTwo").value;
    var videolinkThree = document.getElementById("videolinkThree").value;
    var sbdTotal = parseInt(squat) + parseInt(benchpress) + parseInt(deadlift);
    var returnScript = "이용자의 3대와 신체정보 입니다. 확인바랍니다.\nPlease check the following user info\n3대(SBD total): "
                        + sbdTotal + "kg\n스쿼트(squat): " + squat + "kg\n벤치프레스(benchpress): " + benchpress +
                        "kg\n데드리프트(deadlift): "+ deadlift + "kg\n몸무게(weight): " + weight + "kg\n성별(gender): "
                        + gender;

    if( !squat|| !benchpress || !deadlift || !weight || !title || !body){
        alert("빈칸의 값을 채워주시기 바랍니다\nPlease fill in the blank");
        return false;
    } else if( !/^[0-9]+$/.test(squat) || !/^[0-9]+$/.test(benchpress) || !/^[0-9]+$/.test(deadlift) || !/^[0-9]+$/.test(weight)){
      alert("숫자만 입력해주시기 바랍니다\nPlease type numbers only");
      return false;
    } else if( title.length > 100 ){
      alert("제목이 너무 깁니다. 100자 아래로 입력해주세요\nThe title is too long (Maximum 100 characters).");
      return false;
    } else if( body.length > 1000 ){
      alert("본문이 너무 큽니다. 1000자 아래로 입력해주세요.\nThe body is too long (Maximum 1000 characters).");
      return false;
    } else if( videolink.length > 150 ){
            alert("첫번째 영상 링크가 너무 큽니다. 150자 아래로 입력해주세요\nYour first video link is too long (Maximum 150 characters).");
            return false;
    } else if( videolinkTwo.length > 150 ){
            alert("두번째 영상 링크가 너무 큽니다. 150자 아래로 입력해주세요\nYour second video link is too long (Maximum 150 characters).");
            return false;
    }else if( videolinkThree.length > 150 ){
            alert("서번째 영상 링크가 너무 큽니다. 150자 아래로 입력해주세요\nYour third video link is too long (Maximum 150 characters).");
            return false;
    } else {
        if(confirm(returnScript)){
          if (confirm("글을 한번 게시하면 수정/삭제가 불가능합니다, 그래도 글을 게시하시겠습니까?\n" +
                      "You can't edit/delete the posting after submission\nwill you still submit?") ) { return true; }
          else { return false; }
        }
        else{ return false; }
    }
 }

 function BSChecker() {

     var squat = parseInt(document.getElementById("squat").value);
     var benchpress = parseInt(document.getElementById("benchpress").value);
     var deadlift = parseInt(document.getElementById("deadlift").value);
     var weight = parseInt(document.getElementById("weight").value);

     if( weight < 30 ){
        alert("쇠질을 할 때가 아닙니다. 밥을 먹을 때입니다.\nIt's no time to hit the gym. Go eat something.");
        return false;
     }else if(benchpress > 355){
        alert("벤치프레스 세계기록은 355kg으로 Julius Maddox가 보유하고 있습니다\n" +
              "당신의 벤치기록은 지금 입력한 그것이 아닙니다\n" +
              "(Benchpress T-shirt는 인정하지 않습니다)\n" +
              "The benchpress world record is held by Julius Maddox with 355kg\n" +
              "Your benchpress record is not what you wrote here\n" +
              "(Benchpress T-shirts don't count)");
        return false;
     }
      else if( deadlift > 502 ){
        alert("데드리프트 세계기록은 502.5kg 으로 Krzysztof Wierzbicki이 보유하고 있습니다\n" +
              "당신의 데드 기록은 지금 입력한 그것이 아닙니다\n" +
              "The deadlift world record is held by Krzysztof Wierzbicki with 502.5kg\n" +
              "Your deadlift record is not what you wrote here");
        return false;
      } else if( squat > 580 ){
        alert("스쿼트 세계기록은 580kg 으로 Nathan Baptist가 보유하고 있습니다\n" +
              "당신의 스쿼트 기록은 지금 입력한 그것이 아닙니다\n" +
              "The squat world record is held by Nathan Baptist with 580kg\n" +
              "Your squat record is not what you wrote here");
        return false;
     }

 }

 function youSureYouWannaReturn() {
    if (confirm("지금 메인화면으로 돌아가면 작성한 본문이 날라갈 수 있습니다\n" +
                "그래도 나가시겠습니까?\n" +
                "If you leave this page now all progress might get lost\n" +
                "Will you still leave?") ) { return true; }
    else { return false; }
 }




