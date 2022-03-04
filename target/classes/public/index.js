$(document).ready(function() {
    $('#body').append("<div id='temp'></div>");
    $("#create").submit(addressCreate);

    function addContent(data) {
    //clear the temp div
        $( ".temp" ).empty();
        // adds data into div
        $( data ).appendTo( ".temp" );
    };

    function addressCreate(event) {
        event.preventDefault();
        $.ajax({
            url:"/addressbook",
            type:"POST",
            success:addContent
        });

    };

});