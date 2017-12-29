$(document).ready(function() {
    var navOffone = $("#mainNav").offset().top;
    $("#mainNav").wrap("<div class='placeholder' id='placeholderOne'></div>'");
    $(".placeholder").height($("mainNav").outerHeight());
    $(window).scroll(function() {
        var scrollTracker = $(window).scrollTop();
        if (scrollTracker >= navOffone) {
            $("#mainNav").addClass("stickyMenu");
            $("#placeholderOne").css("height", "60px");
            $("#register").addClass("stickyRegister");
            $("#placeholder").removeClass("placeholder-images");
            $("#placeholder").addClass("stickyRegister");
            $("#form-logout").addClass("form-logout-class-sticky");
            $("#form-logout").removeClass("form-logout-class-move");
        } else if (scrollTracker < navOffone) {
            $("#mainNav").removeClass("stickyMenu");
            $("#register").removeClass("stickyRegister");
            $("#placeholder").removeClass("stickyRegister");
            $("#placeholder").addClass("placeholder-images");
            $("#form-logout").addClass("form-logout-class-move");
            $("#form-logout").removeClass("form-logout-class-sticky");
        }
    });

    $("#gallery-images-1").mouseover(function() {
        $("#placeholder").css("background-image", "url('images/logo.png')");
    });
    $("#gallery-images-1").mouseout(function() {
        $("#placeholder").css("background-image", "url('images/couple.png')");
    });
    $("#gallery-images-2").mouseover(function() {
        $("#placeholder").css("background-image", "url('images/jesus.png')");
    });
    $("#gallery-images-2").mouseout(function() {
        $("#placeholder").css("background-image", "url('images/couple.png')");
    });
    $("#events").mouseenter(function() {
        $("#servdrop").fadeIn();
        $("#servdrop").css("transform", "scale(1)");
    });
    $("#events").mouseleave(function() {

        $("#servdrop").css("transform", "scale(.01)");
        $("#servdrop").fadeOut();
    });
    $("#servdrop").mouseleave(function() {

        $("#servdrop").css("transform", "scale(.01)");
        $("#servdrop").fadeOut();
    });
});