addEventListener("load", function() {
  var spanSign = document.querySelector("span.회원가입성공확인");

  if (spanSign != null) {
    $(function() {
      document.querySelector("#회원가입-pop").checked = true;
      spanSign = null;
    });
  }
});
