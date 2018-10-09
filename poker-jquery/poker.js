var noSleep = new NoSleep();
$(function() {
    cards();
});

function cards() {
    [
        '0',
        '1',
        '2',
        '3',
        '5',
        '8',
        '13',
        '20',
        '40',
        '100',
    ].forEach(function(est) {
        $("#table").append("<div class = 'card'>" + est + "</div>");
    });

    $(".card").click(function(item) {
        // console.log("item: " + $(item.delegateTarget).text())
        show($(item.delegateTarget).text())
    });

    noSleep.disable();
};

function show(value) {
    $(".card").remove()
    $('#table').append("<div class = 'show'>" + value + "</div");
    $('.show').click(function() {
        $('.show').unbind();
        $('.show').remove();
        cards();
    });

    noSleep.enable();
};
