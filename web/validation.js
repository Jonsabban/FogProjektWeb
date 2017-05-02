function validateForm() {
    var name = document.forms["createuser"]["username"].value;
    if (name == "") {
        alert("username must be filled out");
        return false;
    }
}