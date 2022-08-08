$(document).ready(()=>{
    console.log('charge');
    $('.signup-form').submit((event)=>{
        event.preventDefault();
        $.ajax({
              url: "user",
              type:"POST",
              data: $("form").serialize(),
              success: function(result) {
                 if(result.status){
                     $('.signup-form')[0].reset();
                 }
                 console.log(result.status);
              }
            });
    });
});