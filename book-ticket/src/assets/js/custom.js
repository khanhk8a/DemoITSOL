$(document).ready(function () {
  // $(".carousel").carousel({
  //   interval: 2000,
  // });

  $("#btn1").on("click", function () {
    $("#tab1").css("display", "table");
    $("#tab2").css("display", "none");
    $(".tx_black2").removeClass("active");
    $(".tx_black1").addClass("active");
  });
  $("#btn2").on("click", function () {
    $("#tab2").css("display", "table");
    $("#tab1").css("display", "none");
    $(".tx_black1").removeClass("active");
    $(".tx_black2").addClass("active");
    console.log("hello");
  });

  $("input:checkbox").on("click", function () {
    // in the handler, 'this' refers to the box clicked on
    var $box = $(this);
    console.log($box);
    if ($box.is(":checked")) {
      // the name of the box is retrieved using the .attr() method
      // as it is assumed and expected to be immutable
      var group = "input:checkbox[name='" + $box.attr("name") + "']";
      console.log(group);
      // the checked state of the group/box on the other hand will change
      // and the current value is retrieved using .prop() method
      $(group).prop("checked", false);
      $box.prop("checked", true);
    } else {
      $box.prop("checked", false);
    }
  });
  $(function () {
    $(".date_select").each(function (index) {
      var cmd = $(this);
      var _filmId = $("#fiml_id_" + index).val();
      var _date = $(this).val();
      var url =
        "/Film/LoadLichChieuPhim?filmId=" + _filmId + "&projectDate=" + _date;
      cmd.change(function () {
        //  alert('Hello word' + _filmId + _date);
      });

      $.get(url, function (data) {
        $("#session_time_" + index).html(data);
      });
    });
  });

  $(".room_box_seat").each(function () {
    var $rowLength = $(this).find("div.seat_line:first").find("a").length;
    $(this)
      .find("div.seat_line")
      .attr("style", "width:" + $rowLength * 25 + "px");
  });
  $("#btn-ao-continue").click(function () {
    // var _url = "/ShoppingCart/StartCheckout";
    // if ($isProcess == true) {
    //   alert(
    //     "Xin bạn chờ đợi trong giấy lát hệ thống  đang thực hiện giao dịch trước đó của bạn"
    //   );
    //   return false;
    // }
    // $isProcess = true;
    // $.get(_url, function (data) {
    //   $isProcess = false;
    //   if (data != undefined && data.redirect) {
    //     location.href = data.redirect;
    //   } else {
    //     location.href = "/checkout";
    //   }
    // });
    console.log("hello");
  });
  

});
