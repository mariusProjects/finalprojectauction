$(document).ready(function () {

  var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
  var theUrl = "http://localhost:8080/api/test";
  xmlhttp.open("POST", theUrl);
  xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xmlhttp.send(JSON.stringify({ email: "hello@user.com"}));


  // $.get("http://localhost:8080/api/test", JSON.stringify({ email: "b@g.c" }),
  //     function (data, status) {
  //       alert("Data: " + data + "\nStatus: " + status);
  //     });
});

