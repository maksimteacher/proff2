function myClickOld(num) {
    document.getElementById("block1").style.display = "none";
   // document.getElementById(numNotActive).style.display = "block";
}

function myClick(num) {
    var str = "block"
    $(".myBlockCass").css( "background-color", "beige");
    $("#"+str+num).css("background-color", "red");
}

$(document).ready(function() {
	$("input").click(function(){
        alert("Privet");
    });
});