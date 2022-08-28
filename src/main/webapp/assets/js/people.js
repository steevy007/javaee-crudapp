$(document).ready(() => {

    $('.form-addpeople').on('submit', (event) => {
        event.preventDefault();
        $.ajax({
            url: "addpeople",
            type: "POST",
            data: $("form").serialize(),
            success: function (result) {
                if (result.status) {
                    $('.form-addpeople')[0].reset();
                     Swal.fire({
                        icon: 'success',
                        title: 'User Add',
                        text: result.message,
                        footer: 'Alphasystem+'
                    });

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