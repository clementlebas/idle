// JavaScript source code
$(document).ready(function(){
    
    $("h1").fadeIn('18000');
    $('#Inscription').click(function () {
        $('.ConnexionPage').hide();
        $('.ConnexionPage').removeAttr("id");
        $('.InscriptionPage').attr('id', 'overlay');
        $('#overlay').show('3000');
    });
    $('.InscriptionPage #abort').click(function () {
        $('#overlay').hide('3000', function () { $('.InscriptionPage').removeAttr("id");});
    });

    $('#Connexion').click(function () {
        $('.InscriptionPage').hide();
        $('.InscriptionPage').removeAttr("id");
        $('.ConnexionPage').attr('id', 'overlay');
        $('#overlay').show('3000');
    });
    $('.ConnexionPage #abort').click(function () {
        $('#overlay').hide('3000', function () { $('.ConnexionPage').removeAttr("id"); });
    });

    $('#pass2').keyup(function () {
        $(this).append("Hello")
        if ($('#pass1').val() == $('#pass2').val()) {
            $('#validpass').hide();
            $('#pass2').removeAttr("class");
            $('#suscribe').removeAttr('Class');
        }
        else {
            $('#pass2').addClass("wrongpass");
            $('#suscribe').addClass("notvalidButton");
            $('#validpass').show();
        }
    });

});