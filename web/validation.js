function validateForm() {
    var name = document.forms["createuser"]["username"].value;
    var password = document.forms["createuser"]["password"].value;
    var address = document.forms["createuser"]["address"].value;
    var zip = document.forms["createuser"]["zipcode"].value;
    var phone = document.forms["createuser"]["phone"].value;
    var mail = document.forms["createuser"]["email"].value;

    if (name === "" || name.match(' ') || password === "" || password.match(' ') || address == "" || zip == "" || zip.match(' ') || phone == "" || phone.match(' ') || phone.length != 8 || mail == "" || mail.match(' '))
    {
        if (name === "" || name.match(' ')) {
            $("#inName").css("border", "2px solid red");
        }
        if (password === "" || password.match(' ')) {
            $("#inPass").css("border", "2px solid red");
        }
        if (address == "") {
            $("#inAdd").css("border", "2px solid red");
        }
        if (zip == "" || zip.match(' ')) {
            $("#inZip").css("border", "2px solid red");
        }
        if (phone == "" || phone.match(' ') || phone.length != 8) {
            $("#inPhone").css("border", "2px solid red");
        }
        if (mail == "" || mail.match(' ')) {
            $("#inMail").css("border", "2px solid red");
        }
        
        
        
        
        
        
        if (!(name === "" || name.match(' '))) {
            $("#inName").css("border", "2px solid green");
        }
        if (!(password === "" || password.match(' '))) {
            $("#inPass").css("border", "2px solid green");
        }
        if (!(address == "")) {
            $("#inAdd").css("border", "2px solid green");
        }
        if (!(zip == "" || zip.match(' '))) {
            $("#inZip").css("border", "2px solid green");
        }
        if (!(phone == "" || phone.match(' ') || phone.length != 8)) {
            $("#inPhone").css("border", "2px solid green");
        }
        if (!(mail == "" || mail.match(' '))) {
            $("#inMail").css("border", "2px solid green");
        }
        return false;
    }
    else {
        return true;
    }
}