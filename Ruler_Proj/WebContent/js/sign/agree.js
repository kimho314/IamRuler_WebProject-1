addEventListener("load", function() {
  var section = document.querySelector("#약관동의버튼");
  var 동의링크 = section.querySelector("a");
  var 동의버튼 = section.querySelector(".button");
  $(".약관내용스크롤").scroll(function() {
    //    console.log($(this).scrollTop() + $(this).innerHeight());
    //    console.log($(this).prop("scrollHeight"));

    if (
      $(this).scrollTop() + $(this).innerHeight() >=
      $(this).prop("scrollHeight") * 0.95
    ) {
      동의링크.href = "sign-up";
      동의버튼.className = "button special";
    }
  });
});
