let hide = (id) => {
    console.log(id);
    document.getElementById(id).style = "display: none";
}

let display = (id) => {
    document.getElementById(id).style = "display: block";
}

hide("gen");
hide("email");
hide("password");
hide("confirmPassword");
hide("contact");
hide("Vehicle-Form");
hide("company");
hide("model");
hide("type");
hide("number");
hide("identification");
hide("pricing-form");
hide("empid");
hide("submitfinal");
hide("currency");

let employeeName;
let employeePassword;
let vehicle;
let id;
let currency;

let openEmployeeForm = () => {
    document.getElementById("employee-form").style.display = "block";
}

let validateName = (name) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (name.value.length > 0) {
            if (name.value.length >= 2 && isNaN(name.value)) {
                name.style = "border: 2px solid blue";
                document.getElementById('nameerror').innerHTML = `  `;
                this.employeeName = name.value;
                name.style = "display: none";
                display("gen");
                document.getElementById("genmessage").innerHTML = `Hi  ${name.value}. please enter your gender.`;
            } else {
                name.style = "border: 2px solid red";
                document.getElementById("nameerror").innerHTML = `Name must be in alphabets and Length greater than 2`;
            }
        } else {
            name.style = "border: 2px solid red";
            document.getElementById("nameerror").innerHTML = `Please enter the name!!`;
        }
    }
}

let validateGender = (value) => {
    document.getElementById("emailmessage").innerHTML = `Hi. ${this.employeeName}. Please enter your mail.`;
    hide("gen");
    hide("genmessage");
    display("email");
}

let validateEmail = (email) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (email.value.length > 0) {
            if (email.value.search(/[a-zA-Z0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z]/) != -1) {
                email.value = "border: 2px solid blue ";
                document.getElementById("emailerror").innerHTML = `  `;
                email.style = "display: none ";
                hide("emailmessage");
                display("password");
                document.getElementById("passmessage").innerHTML = `Hi. ${this.employeeName}. create the password.`;
            } else {
                email.style = "border: 2px solid red ";
                document.getElementById("emailerror").innerHTML = `Please enter valid email`;
            }
        } else {
            email.style = "border: 2px solid red ";
            document.getElementById("emailerror").innerHTML = `Please enter the email!!`;
        }
    }
}

let validatePassword = (password) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (password.value.length > 0) {
            if (password.value.search(/[0-9]+/) != -1 && password.value.search(/[!@#$%^^&*(){}?><]+/) != -1 && password.value.search(/[A-Z]+/) != -1 && password.value.length >= 8) {
                password.style = "border: 2px solid blue ";
                document.getElementById("passerror").innerHTML = `  `;
                employeePassword = password.value;
                password.style = "display: none";
                display("confirmPassword");
                hide("passmessage");
                document.getElementById("cpassmessage").innerHTML = `Hi.${this.employeeName}. re-enter your password.`;
            } else {
                password.style = "border: 2px solid blue";
                document.getElementById("passerror").innerHTML = `Password must be greater then 8 characters, one special character, one number..`;
            }
        } else {
            password.style = "border: 2px solid red";
            document.getElementById("passerror").innerHTML = `please enter your password!!`;
        }
    }
}

let validateConfirmPassword = (confirmPassword) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (confirmPassword.value.length > 0) {
            if (employeePassword == confirmPassword.value) {
                confirmPassword.style = "border: 2px solid blue";
                document.getElementById("cpasserror").innerHTML = `  `;
                confirmPassword.style = "display: none";
                document.getElementById("contact").style = "display:block";
                display("contact");
                hide("cpassmessage");
                document.getElementById("contactmessage").innerHTML = `Hi ${this.employeeName}. please enter contact number.`;
            } else {
                document.getElementById("cpasserror").innerHTML = `Password not matched!!`;
            }
        } else {
            confirmPassword.style = "border: 2px solid red";
            document.getElementById("cpasserror").innerHTML = `please enter the password`;
        }
    }
}

let validateContactNumber = (contactNumber) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (contactNumber.value.length > 0) {
            if (!isNaN(contactNumber.value) && contactNumber.value.length > 8) {
                contactNumber.style = "border:2px solid blue";
                document.getElementById("contacterror").innerHTML = `  `;
                contactNumber.style = "display:none";
                display("Vehicle-Form");
                display("company");
                hide("contactmessage");
                hide("employee-form");
                document.getElementById("companymessage").innerHTML = `Hi ${this.employeeName}. please add Vehicle details.`;
            } else {
                contactNumber.style = "border: 2px solid red";
                document.getElementById("contacterror").innerHTML = `please enter valid contact number!!`;
            }
        } else {
            contactNumber.style = "border: 2px solid red";
            document.getElementById("contacterror").innerHTML = `please enter the contact number!!`;
        }
    }
}

let validateCompanyName = (companyName) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (companyName.value.length > 0) {
            if (companyName.value.length >= 2 && isNaN(companyName.value)) {
                companyName.style = "border: 2px solid blue";
                document.getElementById("companyerror").innerHTML = `  `;
                companyName.style = "display:none";
                display("model");
                hide("companymessage");
                document.getElementById("modelmessage").innerHTML = `Hi ${this.employeeName} enter your vehicle model.`;
            } else {
                companyName.style = "border: 2px solid red";
                document.getElementById("companyerror").innerHTML = `Please enter valid name`;
            }
        } else {
            companyName.style = "border: 2px solid red";
            document.getElementById("companyerror").innerHTML = `please enter the company name!`;
        }
    }
}

let validateVehicleModel = (vehicleModel) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (vehicleModel.value.length > 0) {
            if (vehicleModel.value.length == 4 && !isNaN(vehicleModel.value)) {
                vehicleModel.style = "border: 2px solid blue";
                document.getElementById("modelerror").innerHTML = `  `;
                vehicleModel.style = "display:none";
                display("type");
                hide("modelmessage");
                document.getElementById("vehicletypemessage").innerHTML = `Hi ${this.employeeName} enter your vehicle type.`;
            } else {
                vehicleModel.style = "border: 2px solid red";
                document.getElementById("modelerror").innerHTML = `Please enter valid model`;
            }
        } else {
            vehicleModel.style = "border: 2px solid red";
            document.getElementById("modelerror").innerHTML = `please enter the vehicle model!`;
        }
    }
}

let validateVehicleType = (vehicleType) => {
    let key = this.event.keyCode;
    document.getElementById("vehicletypeerror").innerHTML = ` `;
    vehicleType.style = "display: none";
    display("number");
    hide("vehicletypemessage");
    vehicle = vehicleType.value;
    document.getElementById("numbermessage").innerHTML = `Hi ${this.employeeName}, enter your vehicle number`;
}

let validateVehicleNumber = (vehicleNumber) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (vehicleNumber.value.length > 0) {
            if (!isNaN(vehicleNumber.value) && vehicleNumber.value > 2) {
                vehicleNumber.style = "border: 2px solid blue";
                document.getElementById("numbererror").innerHTML = `  `;
                vehicleNumber.style = "display:none";
                display("empid");
                hide("numbermessage");
                document.getElementById("empidmessage").innerHTML = `Hi ${this.employeeName} enter your employee id.`;
            } else {
                vehicleNumber.style = "border: 2px solid red";
                document.getElementById("numbererror").innerHTML = `Please enter valid number and greater then 2`;
            }
        } else {
            vehicleNumber.style = "border: 2px solid red";
            document.getElementById("numbererror").innerHTML = `please enter the vehicle numeber!`;
        }
    }
}

let validateEmployeeId = (id) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (id.value.length > 0) {
            if (!isNaN(id.value) && vehicleNumber.value > 0) {
                id.style = "border: 2px solid blue";
                document.getElementById("empiderror").innerHTML = `  `;
                id.style = "display:none";
                display("identification");
                hide("empidmessage");
                document.getElementById("identificationmessage").innerHTML = `Hi ${this.employeeName} Please enter about vehicle.`;
            } else {
                id.style = "border: 2px solid red";
                document.getElementById("empiderror").innerHTML = `Please enter valid id and should be greater then 0`;
            }
        } else {
            id.style = "border: 2px solid red";
            document.getElementById("empiderror").innerHTML = `please enter the employee id!`;
        }
    }
}

let validateVehicleIdentification = (identification) => {
    let key = this.event.keyCode;
    if (key == 13) {
        if (identification.value.length > 0) {
            if (identification.value.length > 4) {
                identification.style = "border: 2px solid blue";
                document.getElementById("identificationerror").innerHTML = `  `;
                identification.style = "display:none";
                hide("identificationmessage");
                hide("Vehicle-Form");
                display("pricing-form");
                display("currency");
                document.getElementById("selectCurrancymessage").innerHTML = `Hi ${this.employeeName} In which currency you want to pay.`;
            } else {
                identification.style = "border: 2px solid red";
                document.getElementById("identificationerror").innerHTML = `Please enter more then 4 characters.`;
            }
        } else {
            identification.style = "border: 2px solid red";
            document.getElementById("identificationerror").innerHTML = `please enter the vehicleIdentification!`;
        }
    }
}

let selectCurrencyType = (currencyType) => {
    currency = document.getElementById("currency").value;
    document.getElementById("selectPassmessage").innerHTML = `Hi ${this.employeeName} Please select your plan.`;
    hide("currency");
    hide("selectCurrencymessage");
    display("selectPass");
}

let selectPassType = (passType) => {
    let selected = passType.selectedIndex;
    if (selected == 1) {
        if (currency == "USD") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Daily parking 0.07$`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `Daily Pass 0.14$`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Daily parking 0.28$`;
            }
        } else if (currency == "INR") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Daily parking 5rs`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `Daily parking 10rs`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Daily parking 20rs`;
            }
        } else if (currency == "YEN") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Daily parking 7.54YEN`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `DAILY Pass 15.07YEN`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `DAILY Pass 30.15YEN`;
            }
        }
    } else if (selected == 2) {
        if (currency == "USD") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Monthly parking 1.4$`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `Monthly Pass 2.8$`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Monthly parking 7.14$`;
            }
        } else if (currency == "INR") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Monthly parking 100rs`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `monthly parking 200rs`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Monthly parking 500rs`;
            }
        } else if (currency == "YEN") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Monthly parking 150.53YEN`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `Monthly Pass 301YEN`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Monthly Pass 753.65YEN`;
            }
        }
    } else if (selected == 3) {
        if (currency == "USD") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Yearly parking 7$`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `Yearly Pass 14$`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Yearly parking 28$`;
            }
        } else if (currency == "INR") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Yearly parking 100rs`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `Yearly parking 200rs`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Yearly parking 500rs`;
            }
        } else if (currency == "YEN") {
            if (vehicle == "Cycle") {
                document.getElementById("passCost").innerHTML = `Yearly parking 753.65YEN`;
            } else if (vehicle == "Motor Cycle") {
                document.getElementById("passCost").innerHTML = `Yearly Pass 1507.31YEN`;
            } else if (vehicle == "Car") {
                document.getElementById("passCost").innerHTML = `Yearly Pass 5275.57YEN`;
            }
        }
    }
    let bill = document.getElementById("passCost").value;
    document.getElementById("passCostmessage").innerHTML = `Hi ${this.employeeName}, Bill is ${bill.value}`;
    hide("selectPass");
    hide("selectPassmessage");
    display("submitfinal");
}

let final = () => {
    alert('Thanks for the registration..');
    hide("passCostmessage");
    hide("submitfinal")
}