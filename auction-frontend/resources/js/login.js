const errorLineStart = "<p class='error'>";
const errorLineEnd = "</p>";

function login() {

  const email = $("form#login_form input#email").val();
  const password = $("form#login_form input#password").val();
  const loginDto = JSON.stringify({ email, password });
calStorage.jwt);
  $.ajax({
    url: 'http://localhost:8080/api/login',  //adresa la care este trimisa cererea AJAX
    dataType: 'json',  //tip date asteptat ca raspuns de la server
    type: 'post',  //tipul prin care sunt trimise datele
    contentType: 'application/json',     //tip date trimis la server
    data: loginDto,  //datele care sunt trimise la server
    success: function (data, textStatus, jQxhr) {
      localStorage.jwt = data.jwt;
      console.log('success: ' + lo
      window.location.href = "home.html";
    },
    error: function (jqXhr, textStatus, errorThrown) {
      const errorsArray = jqXhr.responseJSON.errors;
      if (errorsArray != undefined) {
        for (var index = 0; index < errorsArray.length; index++) {

          const element = $("#" + errorsArray[index].field);

          if (!$(element).next().hasClass("error")) {
            const errorLine = errorLineStart + errorsArray[index].defaultMessage + errorLineEnd;
            $(errorLine).insertAfter(element);

          }

          // console.log("error " + index + "-> " + errorsArray[index].field + ":"
          //     + errorsArray[index].defaultMessage);
        }
      } else {
        const errorMessage = jqXhr.responseJSON.message;
        console.log("singura eroare: " + errorMessage);

        const errorLine = errorLineStart + errorMessage + errorLineEnd;
        console.log(errorLine);
        var element = $("form#login_form .loginError");
        if ($(element).children().length == 0) {
          $(element).append(errorLine);
        }

      }

    }
  });

}

$(document).ready(function () {
  $("form#login_form button").click(function () {
    login();
  });
});
