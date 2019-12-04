addEventListener("load", function() {
  var finder = document.querySelector("span.finder");
  var finderId = document.querySelector("span.finder-id");
  var finderPwd = document.querySelector("span.finder-pwd");
  var resultId = document.querySelector(".아이디출력");
  var resultPwd = document.querySelector(".비밀번호출력");

  if (finder === null) {
    return;
  }

  if (finder != null) {
    $(function(e) {
      if (finderId != null) {
        document.querySelector("#아이디-pop").checked = true;
        resultId.innerHTML = finderId.innerHTML;
      }
      if (finderPwd != null) {
        document.querySelector("#비밀번호-pop").checked = true;
        resultPwd.innerHTML = finderPwd.innerHTML;
      }
      console.log(finder.innerHTML);
      finder.innerHTML = null;
    });
  }
});
