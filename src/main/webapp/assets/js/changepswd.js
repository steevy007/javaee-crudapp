$(document).ready(()=>{
    $('.changepswd-form').on('submit',(event)=>{
        event.preventDefault();
         $.ajax({
            url: "changepswd",
            type: "POST",
            data: $("form").serialize(),
            success: function (result) {
                console.log(result.status);
                if (result.status) {
                    window.location.replace("http://localhost:8080/javacrud");
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