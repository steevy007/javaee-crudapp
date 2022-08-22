$(document).ready(() => {
    $('.validate-form').on('submit', (event) => {
        event.preventDefault();
        $.ajax({
            url: "validatepswd",
            type: "POST",
            data: $("form").serialize(),
            success: function (result) {
                console.log(result);
                if (result.status) {
                    $('.validate-form')[0].reset();
                    Swal.fire({
                        title: 'Do you want to change password ?',
                        showDenyButton: false,
                        showCancelButton: false,
                        confirmButtonText: 'OUI',
                        denyButtonText: `Don't save`,
                    }).then((result) => {
                        /* Read more about isConfirmed, isDenied below */
                        if (result.isConfirmed) {
                            window.location.replace("http://localhost:8080/javacrud/newpassword.jsp");
                        } 
                    })

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