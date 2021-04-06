var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var TagVisibility = /** @class */ (function () {
    function TagVisibility() {
        this.hide = function (id) {
            document.getElementById(id).setAttribute("style", "display:none");
        };
        this.display = function (id) {
            document.getElementById(id).setAttribute("style", "display:block");
        };
    }
    return TagVisibility;
}());
var Employee = /** @class */ (function () {
    function Employee() {
        var _this = this;
        this.newTagVisibility = new TagVisibility();
        this.openEmployeeForm = function () {
            document.getElementById("employee-form").setAttribute("style", "display : block");
        };
        this.validateName = function (name, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (name.value.length > 0) {
                    if (name.value.length >= 2 && isNaN(name.value)) {
                        name.style = "border: 2px solid blue";
                        document.getElementById('nameerror').innerHTML = "  ";
                        _this.employeeName = name.value;
                        name.style = "display: none";
                        _this.newTagVisibility.display("gen");
                        document.getElementById("genmessage").innerHTML = "Hi  " + name.value + ". please enter your gender.";
                    }
                    else {
                        name.style = "border: 2px solid red";
                        document.getElementById("nameerror").innerHTML = "Name must be in alphabets and Length greater than 2";
                    }
                }
                else {
                    name.style = "border: 2px solid red";
                    document.getElementById("nameerror").innerHTML = "Please enter the name!!";
                }
            }
        };
        this.validateGender = function (keyboardEvent) {
            document.getElementById("emailmessage").innerHTML = "Hi. " + _this.employeeName + ". Please enter your mail.";
            _this.newTagVisibility.hide("gen");
            _this.newTagVisibility.hide("genmessage");
            _this.newTagVisibility.display("email");
        };
        this.validateEmail = function (email, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (email.value.length > 0) {
                    if (email.value.search(/[a-zA-Z0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z]/) != -1) {
                        email.value = "border: 2px solid blue ";
                        document.getElementById("emailerror").innerHTML = "  ";
                        email.style = "display: none ";
                        _this.newTagVisibility.hide("emailmessage");
                        _this.newTagVisibility.display("password");
                        document.getElementById("passmessage").innerHTML = "Hi. " + _this.employeeName + ". create the password.";
                    }
                    else {
                        email.style = "border: 2px solid red ";
                        document.getElementById("emailerror").innerHTML = "Please enter valid email";
                    }
                }
                else {
                    email.style = "border: 2px solid red ";
                    document.getElementById("emailerror").innerHTML = "Please enter the email!!";
                }
            }
        };
        this.validatePassword = function (password, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (password.value.length > 0) {
                    if (password.value.search(/[0-9]+/) != -1 && password.value.search(/[!@#$%^^&*(){}?><]+/) != -1 && password.value.search(/[A-Z]+/) != -1 && password.value.length >= 8) {
                        password.style = "border: 2px solid blue ";
                        document.getElementById("passerror").innerHTML = "  ";
                        _this.employeePassword = password.value;
                        password.style = "display: none";
                        _this.newTagVisibility.display("confirmPassword");
                        _this.newTagVisibility.hide("passmessage");
                        document.getElementById("cpassmessage").innerHTML = "Hi." + _this.employeeName + ". re-enter your password.";
                    }
                    else {
                        password.style = "border: 2px solid blue";
                        document.getElementById("passerror").innerHTML = "Password must be greater then 8 characters, one special character, one number..";
                    }
                }
                else {
                    password.style = "border: 2px solid red";
                    document.getElementById("passerror").innerHTML = "please enter your password!!";
                }
            }
        };
        this.validateConfirmPassword = function (confirmPassword, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (confirmPassword.value.length > 0) {
                    if (_this.employeePassword == confirmPassword.value) {
                        confirmPassword.style = "border: 2px solid blue";
                        document.getElementById("cpasserror").innerHTML = "  ";
                        confirmPassword.style = "display: none";
                        _this.newTagVisibility.display("contact");
                        _this.newTagVisibility.hide("cpassmessage");
                        document.getElementById("contactmessage").innerHTML = "Hi " + _this.employeeName + ". please enter contact number.";
                    }
                    else {
                        document.getElementById("cpasserror").innerHTML = "Password not matched!!";
                    }
                }
                else {
                    confirmPassword.style = "border: 2px solid red";
                    document.getElementById("cpasserror").innerHTML = "please enter the password";
                }
            }
        };
        this.validateContactNumber = function (contactNumber, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (contactNumber.value.length > 0) {
                    if (!isNaN(contactNumber.value) && contactNumber.value.length > 8) {
                        contactNumber.style = "border:2px solid blue";
                        document.getElementById("contacterror").innerHTML = "  ";
                        contactNumber.style = "display:none";
                        _this.newTagVisibility.display("Vehicle-Form");
                        _this.newTagVisibility.display("company");
                        _this.newTagVisibility.hide("contactmessage");
                        _this.newTagVisibility.hide("employee-form");
                        document.getElementById("companymessage").innerHTML = "Hi " + _this.employeeName + ". please add Vehicle details.";
                    }
                    else {
                        contactNumber.style = "border: 2px solid red";
                        document.getElementById("contacterror").innerHTML = "please enter valid contact number!!";
                    }
                }
                else {
                    contactNumber.style = "border: 2px solid red";
                    document.getElementById("contacterror").innerHTML = "please enter the contact number!!";
                }
            }
        };
    }
    return Employee;
}());
var Vehicle = /** @class */ (function () {
    function Vehicle() {
        var _this = this;
        this.newTagVisibility = new TagVisibility();
        this.validateCompanyName = function (companyName, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (companyName.value.length > 0) {
                    if (companyName.value.length >= 2 && isNaN(companyName.value)) {
                        companyName.style = "border: 2px solid blue";
                        document.getElementById("companyerror").innerHTML = "  ";
                        companyName.style = "display:none";
                        _this.newTagVisibility.display("model");
                        _this.newTagVisibility.hide("companymessage");
                        document.getElementById("modelmessage").innerHTML = "Hi. enter your vehicle model.";
                    }
                    else {
                        companyName.style = "border: 2px solid red";
                        document.getElementById("companyerror").innerHTML = "Please enter valid name";
                    }
                }
                else {
                    companyName.style = "border: 2px solid red";
                    document.getElementById("companyerror").innerHTML = "please enter the company name!";
                }
            }
        };
        this.validateVehicleModel = function (vehicleModel, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (vehicleModel.value.length > 0) {
                    if (vehicleModel.value.length == 4 && !isNaN(vehicleModel.value)) {
                        vehicleModel.style = "border: 2px solid blue";
                        document.getElementById("modelerror").innerHTML = "  ";
                        vehicleModel.style = "display:none";
                        _this.newTagVisibility.display("type");
                        _this.newTagVisibility.hide("modelmessage");
                        document.getElementById("vehicletypemessage").innerHTML = "Hi. enter your vehicle type.";
                    }
                    else {
                        vehicleModel.style = "border: 2px solid red";
                        document.getElementById("modelerror").innerHTML = "Please enter valid model";
                    }
                }
                else {
                    vehicleModel.style = "border: 2px solid red";
                    document.getElementById("modelerror").innerHTML = "please enter the vehicle model!";
                }
            }
        };
        this.validateVehicleType = function (vehicleType, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            document.getElementById("vehicletypeerror").innerHTML = " ";
            vehicleType.style = "display: none";
            _this.newTagVisibility.display("number");
            _this.newTagVisibility.hide("vehicletypemessage");
            vehicleType = vehicleType.value;
            document.getElementById("numbermessage").innerHTML = "Hi. enter your vehicle number";
        };
        this.validateVehicleNumber = function (vehicleNumber, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (vehicleNumber.value.length > 0) {
                    if (!isNaN(vehicleNumber.value) && vehicleNumber.value > 2) {
                        vehicleNumber.style = "border: 2px solid blue";
                        document.getElementById("numbererror").innerHTML = "  ";
                        vehicleNumber.style = "display:none";
                        _this.newTagVisibility.display("empid");
                        _this.newTagVisibility.hide("numbermessage");
                        document.getElementById("empidmessage").innerHTML = "Hi. enter your employee id.";
                    }
                    else {
                        vehicleNumber.style = "border: 2px solid red";
                        document.getElementById("numbererror").innerHTML = "Please enter valid number and greater then 2";
                    }
                }
                else {
                    vehicleNumber.style = "border: 2px solid red";
                    document.getElementById("numbererror").innerHTML = "please enter the vehicle numeber!";
                }
            }
        };
        this.validateEmployeeId = function (id, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (id.value.length > 0) {
                    if (!isNaN(id.value) && id.value > 0) {
                        id.style = "border: 2px solid blue";
                        document.getElementById("empiderror").innerHTML = "  ";
                        id.style = "display:none";
                        _this.newTagVisibility.display("identification");
                        _this.newTagVisibility.hide("empidmessage");
                        document.getElementById("identificationmessage").innerHTML = "Hi. Please enter about vehicle.";
                    }
                    else {
                        id.style = "border: 2px solid red";
                        document.getElementById("empiderror").innerHTML = "Please enter valid id and should be greater then 0";
                    }
                }
                else {
                    id.style = "border: 2px solid red";
                    document.getElementById("empiderror").innerHTML = "please enter the employee id!";
                }
            }
        };
        this.validateVehicleIdentification = function (identification, keyboardEvent) {
            var key = keyboardEvent.keyCode;
            if (key == 13) {
                if (identification.value.length > 0) {
                    if (identification.value.length > 4) {
                        identification.style = "border: 2px solid blue";
                        document.getElementById("identificationerror").innerHTML = "  ";
                        identification.style = "display:none";
                        _this.newTagVisibility.hide("identificationmessage");
                        _this.newTagVisibility.hide("Vehicle-Form");
                        _this.newTagVisibility.display("pricing-form");
                        _this.newTagVisibility.display("currency");
                        document.getElementById("selectCurrancymessage").innerHTML = "Hi. In which currency you want to pay.";
                    }
                    else {
                        identification.style = "border: 2px solid red";
                        document.getElementById("identificationerror").innerHTML = "Please enter more then 4 characters.";
                    }
                }
                else {
                    identification.style = "border: 2px solid red";
                    document.getElementById("identificationerror").innerHTML = "please enter the vehicleIdentification!";
                }
            }
        };
    }
    return Vehicle;
}());
var Pricing = /** @class */ (function (_super) {
    __extends(Pricing, _super);
    function Pricing() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.newTagVisibility = new TagVisibility();
        _this.selectCurrencyType = function (currencyType) {
            _this.currency = currencyType.value;
            document.getElementById("selectPassmessage").innerHTML = "Hi. Please select your plan.";
            _this.newTagVisibility.hide("currency");
            _this.newTagVisibility.hide("selectCurrencymessage");
            _this.newTagVisibility.display("selectPass");
        };
        _this.selectPassType = function (passType) {
            var selected = passType.selectedIndex;
            if (selected == 1) {
                if (_this.currency == "USD") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "0.07$";
                        document.getElementById("passCost").innerHTML = "Daily parking 0.07$";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "0.14$";
                        document.getElementById("passCost").innerHTML = "Daily Pass 0.14$";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "0.28$";
                        document.getElementById("passCost").innerHTML = "Daily parking 0.28$";
                    }
                }
                else if (_this.currency == "INR") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "5rs";
                        document.getElementById("passCost").innerHTML = "Daily parking 5rs";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "10rs";
                        document.getElementById("passCost").innerHTML = "Daily parking 10rs";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "20rs";
                        document.getElementById("passCost").innerHTML = "Daily parking 20rs";
                    }
                }
                else if (_this.currency == "YEN") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "7.54YEN";
                        document.getElementById("passCost").innerHTML = "Daily parking 7.54YEN";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "15.07YEN";
                        document.getElementById("passCost").innerHTML = "DAILY Pass 15.07YEN";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "30.15YEN";
                        document.getElementById("passCost").innerHTML = "DAILY Pass 30.15YEN";
                    }
                }
            }
            else if (selected == 2) {
                if (_this.currency == "USD") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "1.4$";
                        document.getElementById("passCost").innerHTML = "Monthly parking 1.4$";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "2.8$";
                        document.getElementById("passCost").innerHTML = "Monthly Pass 2.8$";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "7.14$";
                        document.getElementById("passCost").innerHTML = "Monthly parking 7.14$";
                    }
                }
                else if (_this.currency == "INR") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "100rs";
                        document.getElementById("passCost").innerHTML = "Monthly parking 100rs";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "200rs";
                        document.getElementById("passCost").innerHTML = "monthly parking 200rs";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "500rs";
                        document.getElementById("passCost").innerHTML = "Monthly parking 500rs";
                    }
                }
                else if (_this.currency == "YEN") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "150.53YEN";
                        document.getElementById("passCost").innerHTML = "Monthly parking 150.53YEN";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "301YEN";
                        document.getElementById("passCost").innerHTML = "Monthly Pass 301YEN";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "753.65YEN";
                        document.getElementById("passCost").innerHTML = "Monthly Pass 753.65YEN";
                    }
                }
            }
            else if (selected == 3) {
                if (_this.currency == "USD") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "7$";
                        document.getElementById("passCost").innerHTML = "Yearly parking 7$";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "14$";
                        document.getElementById("passCost").innerHTML = "Yearly Pass 14$";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "28$";
                        document.getElementById("passCost").innerHTML = "Yearly parking 28$";
                    }
                }
                else if (_this.currency == "INR") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "100rs";
                        document.getElementById("passCost").innerHTML = "Yearly parking 100rs";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "200rs";
                        document.getElementById("passCost").innerHTML = "Yearly parking 200rs";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "500rs";
                        document.getElementById("passCost").innerHTML = "Yearly parking 500rs";
                    }
                }
                else if (_this.currency == "YEN") {
                    if (_this.vehicleType == "Cycle") {
                        _this.billValue = "753.65YEN";
                        document.getElementById("passCost").innerHTML = "Yearly parking 753.65YEN";
                    }
                    else if (_this.vehicleType == "Motor Cycle") {
                        _this.billValue = "1507.31YEN";
                        document.getElementById("passCost").innerHTML = "Yearly Pass 1507.31YEN";
                    }
                    else if (_this.vehicleType == "Car") {
                        _this.billValue = "5275.57YEN";
                        document.getElementById("passCost").innerHTML = "Yearly Pass 5275.57YEN";
                    }
                }
            }
            document.getElementById("passCostmessage").innerHTML = "Hi.  Bill is " + _this.billValue;
            _this.newTagVisibility.hide("selectPass");
            _this.newTagVisibility.hide("selectPassmessage");
            _this.newTagVisibility.display("submitfinal");
        };
        _this.final = function () {
            alert('Thanks for the registration..');
            _this.newTagVisibility.hide("passCostmessage");
            _this.newTagVisibility.hide("submitfinal");
        };
        return _this;
    }
    return Pricing;
}(Vehicle));
