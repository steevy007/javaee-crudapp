$(document).ready(() => {
    console.log('charge');
    $('.signup-form').submit((event) => {
        event.preventDefault();
        $.ajax({
            url: "signup",
            type: "POST",
            data: $("form").serialize(),
            success: function (result) {
                console.log(result);
               
                if (result.status) {
                     $('.signup-form')[0].reset();
                    Swal.fire(
                            'Good job!',
                            result.message,
                            'success'
                            );
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: result.message,
                        footer: 'Alphasystem+'
                    });
                }
            }
        });
    });
    
     $('.login-form').submit((event) => {
         event.preventDefault();
         console.log("login");
        $.ajax({
            url: "signin",
            type: "POST",
            data: $("form").serialize(),
            success: function (result) {
                console.log(result);
               
                if (result.status) {
                     $('.login-form')[0].reset();
                    Swal.fire(
                            'Good job!',
                            result.message,
                            'success'
                            );
                    window.location.replace("http://localhost:8080/javacrud/dashboard.jsp");
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops...',
                        text: result.message,
                        footer: 'Alphasystem+'
                    });
                }
            }
        });
     });
    
});