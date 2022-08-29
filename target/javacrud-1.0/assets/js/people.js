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

    $('.form-editpeople').on('submit', (event) => {
        event.preventDefault();
        $.ajax({
            url: "editpeople",
            type: "POST",
            data: $("form").serialize(),
            success: function (result) {
                if (result.status) {
                    Swal.fire({
                        icon: 'success',
                        title: 'User Edit',
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

    $('#tb tbody').on('click', '.del', (event) => {
        event.preventDefault();
        let str = event.target.href;
        let id = str.charAt(str.length - 1);
        Swal.fire({
            title: 'Do you really want delete this people ?',
            showDenyButton: true,
            showCancelButton: true,
            confirmButtonText: 'Save',
            denyButtonText: `Don't delete`,
        }).then((result) => {
            /* Read more about isConfirmed, isDenied below */
            if (result.isConfirmed) {
                $.ajax({
                    type: "POST",
                    url: "deletepeople",
                    data: {
                        id
                    },
                    success: function (data) {
                        if (data.status) {
                            location.reload();
                        }
                    }
                });
            } else if (result.isDenied) {
                Swal.fire('People not delete', '', 'info');
            }
        })

    });
});