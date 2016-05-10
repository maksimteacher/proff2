function regForm(){
    document.getElementbyId
    $(".authForm").css("display","none");
    $(".regForm").css("display","inline-block");
}
$(document).ready(function() {
    $("#openReg").click(regForm);
    $("#ajaxAction").click(function(){
        $.ajax({
            dataType: 'json',
            type: "POST",
            //data: "type=" + nameTable+"&otherName="+otherValue,
            url:'/iev_strygul_web/ajax',
            success: function(data){
                var str = "<tr><td>" + data.par1 + "</td><td>" + data.par2+"</td></tr>";
                //$('#table').html(str);
                $('#table').append(str);
            },
            error: function() {
                alert("Alarm!");
            }
        });

    });
});
