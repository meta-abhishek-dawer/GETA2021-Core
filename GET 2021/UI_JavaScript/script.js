/* Hiding all the labels and input field of Employee section except name */
document.getElementById("employee-label-gender").style.visibility = "hidden";
document.getElementById("employee-label-email").style.visibility = "hidden";
document.getElementById('emailEmployee').style.visibility = "hidden";
document.getElementById('employee-label-password').style.visibility = "hidden";
document.getElementById('password').style.visibility = "hidden";
document.getElementById('employee-label-confirmPassword').style.visibility = "hidden";
document.getElementById('confirmPassword').style.visibility = "hidden";
document.getElementById('employee-label-contactNumber').style.visibility = "hidden";
document.getElementById('contactNumber').style.visibility = "hidden";
document.getElementById('submitEmployee').style.visibility = "hidden";
document.getElementById('gender-male').style.visibility = "hidden";
document.getElementById('span-male').style.visibility = "hidden";
document.getElementById('gender-female').style.visibility = "hidden";
document.getElementById('span-female').style.visibility = "hidden";
document.getElementById('gender-others').style.visibility = "hidden";
document.getElementById('span-others').style.visibility = "hidden";

/* javascript function to make employee form collapsible */
function openEmployeeForm() {
    var details = document.getElementById("employee-form");
    details.style.display = "block";
}
/* Validation on employee name, if valid then show next field else input again */
function employeeNameValidation() {
    var name = document.getElementById('nameEmployee').value;

    if (name.length < 2 || name == "") {
        document.getElementById('nameEmployeeSpan').innerHTML = "Please provide valid input";
        return false;
    } else if (!isNaN(name)) {
        document.getElementById('nameEmployeeSpan').innerHTML = "Please provide input in characters";
        return false;
    } else {
        alert(name + '. What is your gender!');
        document.getElementById("employee-label-gender").style.visibility = "visible";
        document.getElementById('gender-male').style.visibility = "visible";
        document.getElementById('span-male').style.visibility = "visible";
        document.getElementById('gender-female').style.visibility = "visible";
        document.getElementById('span-female').style.visibility = "visible";
        document.getElementById('gender-others').style.visibility = "visible";
        document.getElementById('span-others').style.visibility = "visible";
        return true;
    }
}
/* Validate on Employee Radio, if valid then show next field else false */
function validateRadio() {
    var genders = document.getElementsByName('gender');
    if (genders[0].checked == true) {
        alert("Your gender is male");
    } else if (genders[1].checked == true) {
        alert("Your gender is female");
    } else if (genders[2].checked == true) {
        alert("Your gender is others.");
    } else {
        alert("Please select a gender.");
        return false;
    }
    document.getElementById("employee-label-email").style.visibility = "visible";
    document.getElementById('emailEmployee').style.visibility = "visible";
    return true;
}
/*Validation on Employee email, if valid then show next field else false*/
function validateEmail() {
    var email = document.getElementById('emailEmployee').value;
    if (email == "") {
        document.getElementById('emailEmployeeSpan').innerHTML = "Please provide valid input";
        return false;
    } else if (email.indexOf('@') < 1) {
        document.getElementById('emailEmployeeSpan').innerHTML = "need some value before @";
        return false;
    } else if ((email.charAt(email.length - 4) != '.') && (email.charAt(email.length - 3) != '.')) {
        document.getElementById('emailEmployeeSpan').innerHTML = "Please provide valid input";
        return false;
    } else {
        document.getElementById('employee-label-password').style.visibility = "visible";
        document.getElementById('password').style.visibility = "visible";
        return true;
    }
}
/*Validation on Employee password, if valid then show next field else false */
function validatePassword() {
    var password = document.getElementById('password').value;
    var re = /[0-9]/;
    var re1 = /[a-z]/;
    var re2 = /[A-Z]/;

    if (password == "" || password.length < 8) {
        document.getElementById('password').style.borderColor = "red";
        return false;
    } else if (!re.test(password)) {
        document.getElementById('password').style.borderColor = "red";
        return false;
    } else if (!re1.test(password)) {
        document.getElementById('password').style.borderColor = "red";
        return false;
    } else if (!re2.test(password)) {
        document.getElementById('password').style.borderColor = "red";
        return false;
    } else {
        document.getElementById('employee-label-confirmPassword').style.visibility = "visible";
        document.getElementById('confirmPassword').style.visibility = "visible";
        return true;
    }
}

/*Validation on confirm password, if valid then show next field else false */
function validateConfirmPassword() {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;
    if (confirmPassword == "") {
        document.getElementById('confirmPassword').style.borderColor = 'red';
        return false;
    } else if (password != confirmPassword) {
        document.getElementById('confirmPassword').style.borderColor = 'red';
        return false;
    } else {
        document.getElementById('employee-label-contactNumber').style.visibility = "visible";
        document.getElementById('contactNumber').style.visibility = "visible";
        return true;
    }
}

/*Validation on contact number, if valid then show next field else false */
function validateContactNumber() {
    var contactNumber = document.getElementById('contactNumber').value;
    if (contactNumber == "") {
        document.getElementById('contactNumberSpan').innerHTML = "Please provide an input";
        return false;
    } else if (isNaN(contactNumber)) {
        document.getElementById('contactNumberSpan').innerHTML = "Please provide value in number";
        return false;
    } else if (contactNumber.length != 10) {
        document.getElementById('contactNumberSpan').innerHTML = "length of Contact Number should be 10";
        return false;
    } else {
        document.getElementById('submitEmployee').style.visibility = "visible";
        return true;
    }
}

document.getElementById("submitEmployee").addEventListener("click", function (event) {
    event.preventDefault()
});
/*Employee section javascript ends */
/*Vehicle section javascript started */

/*Function to show vehicle form after previous one completed */
function openVehicleForm() {

    var details = document.getElementById("Vehicle-form");
    details.style.visibility = "visible";
}

/* Hiding all the labels and input field of Vehicle form  to display one by one */
document.getElementById('vehicle-label-model').style.visibility = "hidden";
document.getElementById('vehicleModel').style.visibility = "hidden";
document.getElementById('vehicle-label-type').style.visibility = "hidden";
document.getElementById('vehicleCompanyType').style.visibility = "hidden";
document.getElementById('vehicle-label-number').style.visibility = "hidden";
document.getElementById('vehicleNumber').style.visibility = "hidden";
document.getElementById('vehicle-label-Id').style.visibility = "hidden";
document.getElementById('employeeIdForm').style.visibility = "hidden";
document.getElementById('vehicle-label-identification').style.visibility = "hidden";
document.getElementById('vehicleTextarea').style.visibility = "hidden";
document.getElementById('submit-vehicle').style.visibility = "hidden";

/*Validation on Vehicle Company Name, if valid then show next else input again */
function validateCompanyName() {
    var companyName = document.getElementById('vehicleCompanyName').value;
    if (companyName == "" || companyName.length < 2) {
        document.getElementById('companyNameSpan').innerHTML = "please provide valid input!!";
        return false;
    } else if (!isNaN(companyName)) {
        document.getElementById('companyNameSpan').innerHTML = "Please provide input in characters";
        return false;
    } else {
        document.getElementById('vehicle-label-model').style.visibility = "visible";
        document.getElementById('vehicleModel').style.visibility = "visible";
        document.getElementById('vehicle-label-type').style.visibility = "visible";
        document.getElementById('vehicleCompanyType').style.visibility = "visible";
        return true;
    }
}
/*Validation on Vehicle Company Type, if valid then show next else input again */
function validateCompanyType() {
    var vehicleType = document.getElementById('vehicleCompanyType').value;
    if (vehicleType == "") {
        document.getElementById('vehicleTypeSpan').innerHTML = "Input cannot be empty!!";
        return false;
    } else if (!isNaN(vehicleType)) {
        document.getElementById('vehicleTypeSpan').innerHTML = "Please provide value in Characters!!";
        return false;
    } else {
        document.getElementById('vehicle-label-number').style.visibility = "visible";
        document.getElementById('vehicleNumber').style.visibility = "visible";
        return true;
    }
}
/*Validate Vehicle Number , if valid then show next else input again */
function validateNumber() {
    var number = document.getElementById('vehicleNumber').value;
    if (number == "") {
        document.getElementById('vehicleNumberSpan').innerHTML = "Please provide an input";
        return false;
    } else if (isNaN(number)) {
        document.getElementById('vehicleNumberSpan').innerHTML = "Please provide value in number";
        return false;
    } else {
        document.getElementById('vehicle-label-Id').style.visibility = "visible";
        document.getElementById('employeeIdForm').style.visibility = "visible";
        return true;
    }
}
/*Validation on Employee Id, if valid then show next else input again */
function validateId() {
    var employeeId = document.getElementById('employeeIdForm').value;
    if (employeeId == "") {
        document.getElementById('employeeIdSpan').innerHTML = "Input Cannot be empty!!";
        return false;
    } else if (isNaN(employeeId)) {
        document.getElementById('contactNumberSpan').innerHTML = "Please provide value in number";
        return false;
    } else {
        document.getElementById('vehicle-label-identification').style.visibility = "visible";
        document.getElementById('vehicleTextarea').style.visibility = "visible";
        return true;
    }
}
/*Validation on Vehicle text area, if valid then show next else input again */
function validateVehicleTextarea() {
    var vehicleTextarea = document.getElementById('vehicleTextarea').value;

    if (vehicleTextarea == "") {
        document.getElementsById('vehicleTextareaSpan').innerHTML = "Textarea cannot be Empty!!";
        return false;
    } else {
        document.getElementById('submit-vehicle').style.visibility = "visible";
        return true;
    }
}

document.getElementById("submit-vehicle").addEventListener("click", function (event) {
    event.preventDefault()
});
/*Vehicle section javascript ends */
/*Pricing section javascript started */

/*Hiding the pricing options */
document.getElementById('vehicle-div-cycle').style.visibility = "hidden";
document.getElementById('vehicle-div-motor-cycle').style.visibility = "hidden";
document.getElementById('vehicle-div-car').style.visibility = "hidden";

/*Method to open particular pricing section */
function openPricingSection() {
    var vehicleType = document.getElementById('vehicleCompanyType').value;
    if (vehicleType == "cycle")
        document.getElementById('vehicle-div-cycle').style.visibility = "visible";
    else if (vehicleType == "motor cycle")
        document.getElementById('vehicle-div-motor-cycle').style.visibility = "visible";
    else if (vehicleType == "car")
        document.getElementById('vehicle-div-car').style.visibility = "visible";
}