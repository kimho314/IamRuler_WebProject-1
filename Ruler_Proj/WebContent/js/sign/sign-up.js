addEventListener("load", function() {
  var spanSign = document.querySelector("span.회원가입성공확인");
  var oldVal = null;

  if (spanSign != null) {
    $(function() {
      document.querySelector("#회원가입-pop").checked = true;
      spanSign = null;
    });
  }

  $(".input-id").on("propertychange change keyup paste input", function() {
    var currentVal = $(this).val();
    if (currentVal.length > 16) {
      this.value = $(this)
        .val()
        .slice(0, (currentVal.length - 16) * -1);
    }

    if (currentVal == oldVal) {
      return;
    }

    oldVal = currentVal;
    console.log(currentVal.length);
  });

  $(".input-pwd").on("propertychange change keyup paste input", function() {
    var currentVal = $(this).val();
    if (currentVal.length > 16) {
      this.value = $(this)
        .val()
        .slice(0, (currentVal.length - 16) * -1);
    }

    if (currentVal == oldVal) {
      return;
    }

    oldVal = currentVal;
  });
});
