addEventListener("load", function() {
  var oldVal = null;

  $(".input").on("propertychange change keyup paste input", function() {
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
