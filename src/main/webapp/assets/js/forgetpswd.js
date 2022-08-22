$(document).ready(()=>{
    $('.forget-form').on('submit',(event)=>{
        event.preventDefault();
         $.ajax({
            url: "forget",
            type: "POST",
            data: $("form").serialize(),
            success: function (result) {
                console.log(result);           
            }
        });
    });
});