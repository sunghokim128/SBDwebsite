 function testAlert() {

    var pageNum = document.getElementById("pageNum").value;
    var pageNumInt = parseInt(document.getElementById("pageNum").value);
    var validPageNum = /^[0-9]*$/.test(pageNum);
    var maxPage = document.getElementById("totalPages").value;

    if ( pageNum == 800 ) {     // easterEgg
        return true;
    } else if ( pageNumInt > maxPage ) {
        alert("가장 끝에 있는 페이지는 " + maxPage + " 입니다\n 더 작은 수를 입력해주세요");
         return false;
    } else if( validPageNum ){
        return true;
    } else {
        alert("숫자만 입력해 주시기 바랍니다");
        return false;
    }

 }