$(document).ready(function(){

    $('.nBtn, .table .eBtn').click(function(e){
        e.preventDefault();
        $('p[id*="cac"]').text("");
        var href = $(this).attr('href');
        var text = $(this).text();

        if(text == 'Edit') {
            $.getJSON(href, function(response){
                $('.myForm #id').val(response.id).hide();
                $('.myForm #nama').val(response.nama);
                $('.myForm #jurusan').val(response.jurusan);
            });
            $('.myForm #exampleModal').modal();

        } else {
            $('.myForm #id').val('').hide();

            $('.myForm #nama').val('');
            $('.myForm #jurusan').val('');
            $('.myForm #exampleModal').modal();
        }

    });

    $("#editKML").click(function () {
        let id=$('.myForm #id').val();
        let nama=$('.myForm #nama').val();
        let jurusan=$('.myForm #jurusan').val();

        let ssss={"id":id,"nama":nama,"jurusan":jurusan};
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type : "POST",
            data: JSON.stringify(ssss),
            url: "http://localhost:8080/validate",
            success: function(student) {
                console.log(student);
                $('.myForm #exampleModal').modal('hide');
                location.reload();
            },
            error: function(content) {
                // $('p[id="cac1"]').text(content.responseJSON[1].defaultMessage)
              for (let i=0;i<content.responseJSON.length;i++){
                  if(content.responseJSON[i]!=null){
                      $('p[id="cac'+i+'"]').text(content.responseJSON[i].defaultMessage);
                  }else $('p[id="cac'+i+'"]').text("");
                }
            }
        });
    });

    $('.rBtn').click(function(event){
        event.preventDefault();
        var href=$(this).attr('href');
        $(".myRemove .dBtn").attr('href',href);
        $('.myRemove #exampleModal').modal();

    });

});
