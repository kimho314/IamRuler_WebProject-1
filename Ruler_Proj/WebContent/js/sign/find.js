addEventListener("load", function() {
  var section = document.querySelector("#찾기테이블");
  var finder = section.querySelector(".finder");
  var 팝업창 = section.querySelector(".팝업창");

  if (finder.innerHTML != null) {
    $(function(e) {
      console.log(finder.innerHTML);
      finder.innerHTML = null;
      //   팝업창.
    });
  }
});
