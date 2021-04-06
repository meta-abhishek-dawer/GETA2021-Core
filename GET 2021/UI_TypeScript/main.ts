class TagVisibility {
    hide: Function = (id: string) => {
        document.getElementById(id).setAttribute("style", "display:none");
    }

    display: Function = (id: string) => {
        document.getElementById(id).setAttribute("style", "display:block");
    }
}

class Employee {
    employeeName: string;
    employeePassword: string;

    newTagVisibility = new TagVisibility();

    openEmployeeForm: Function = () => {
        document.getElementById("employee-form").setAttribute("style", "display : block");
    }

    validateName: Function = (name, keyboardEvent: KeyboardEvent) => {
        let key: number = keyboardEvent.keyCode;
        if (key == 13) {
            if (name.value.length > 0) {
                if (name.value.length >= 2 && isNaN(name.value)) {
                    name.style = "border: 2px solid blue";
                    document.getElementById('nameerror').innerHTML = `  `;
                    this.employeeName = name.value;
                    name.style = "display: none";
                    this.newTagVisibility.display("gen");
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

    validateGender: Function = (keyboardEvent: KeyboardEvent) => {
        document.getElementById("emailmessage").innerHTML = `Hi. ${this.employeeName}. Please enter your mail.`;
        this.newTagVisibility.hide("gen");
        this.newTagVisibility.hide("genmessage");
        this.newTagVisibility.display("email");
    }

    validateEmail: Function = (email, keyboardEvent: KeyboardEvent) => {
        let key: Number = keyboardEvent.keyCode;
        if (key == 13) {
            if (email.value.length > 0) {
                if (email.value.search(/[a-zA-Z0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z]/) != -1) {
                    email.value = "border: 2px solid blue ";
                    document.getElementById("emailerror").innerHTML = `  `;
                    email.style = "display: none ";
                    this.newTagVisibility.hide("emailmessage");
                    this.newTagVisibility.display("password");
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

    validatePassword: Function = (password, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (password.value.length > 0) {
                if (password.value.search(/[0-9]+/) != -1 && password.value.search(/[!@#$%^^&*(){}?><]+/) != -1 && password.value.search(/[A-Z]+/) != -1 && password.value.length >= 8) {
                    password.style = "border: 2px solid blue ";
                    document.getElementById("passerror").innerHTML = `  `;
                    this.employeePassword = password.value;
                    password.style = "display: none";
                    this.newTagVisibility.display("confirmPassword");
                    this.newTagVisibility.hide("passmessage");
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

    validateConfirmPassword: Function = (confirmPassword, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (confirmPassword.value.length > 0) {
                if (this.employeePassword == confirmPassword.value) {
                    confirmPassword.style = "border: 2px solid blue";
                    document.getElementById("cpasserror").innerHTML = `  `;
                    confirmPassword.style = "display: none";
                    this.newTagVisibility.display("contact");
                    this.newTagVisibility.hide("cpassmessage");
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

    validateContactNumber: Function = (contactNumber, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (contactNumber.value.length > 0) {
                if (!isNaN(contactNumber.value) && contactNumber.value.length > 8) {
                    contactNumber.style = "border:2px solid blue";
                    document.getElementById("contacterror").innerHTML = `  `;
                    contactNumber.style = "display:none";
                    this.newTagVisibility.display("Vehicle-Form");
                    this.newTagVisibility.display("company");
                    this.newTagVisibility.hide("contactmessage");
                    this.newTagVisibility.hide("employee-form");
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
}

class Vehicle {

    vehicleType: string;
    newTagVisibility = new TagVisibility();

    validateCompanyName: Function = (companyName, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (companyName.value.length > 0) {
                if (companyName.value.length >= 2 && isNaN(companyName.value)) {
                    companyName.style = "border: 2px solid blue";
                    document.getElementById("companyerror").innerHTML = `  `;
                    companyName.style = "display:none";
                    this.newTagVisibility.display("model");
                    this.newTagVisibility.hide("companymessage");
                    document.getElementById("modelmessage").innerHTML = `Hi. enter your vehicle model.`;
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

    validateVehicleModel: Function = (vehicleModel, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (vehicleModel.value.length > 0) {
                if (vehicleModel.value.length == 4 && !isNaN(vehicleModel.value)) {
                    vehicleModel.style = "border: 2px solid blue";
                    document.getElementById("modelerror").innerHTML = `  `;
                    vehicleModel.style = "display:none";
                    this.newTagVisibility.display("type");
                    this.newTagVisibility.hide("modelmessage");
                    document.getElementById("vehicletypemessage").innerHTML = `Hi. enter your vehicle type.`;
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

    validateVehicleType: Function = (vehicleType, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        document.getElementById("vehicletypeerror").innerHTML = ` `;
        vehicleType.style = "display: none";
        this.newTagVisibility.display("number");
        this.newTagVisibility.hide("vehicletypemessage");
        vehicleType = vehicleType.value;
        document.getElementById("numbermessage").innerHTML = `Hi. enter your vehicle number`;
    }

    validateVehicleNumber: Function = (vehicleNumber, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (vehicleNumber.value.length > 0) {
                if (!isNaN(vehicleNumber.value) && vehicleNumber.value > 2) {
                    vehicleNumber.style = "border: 2px solid blue";
                    document.getElementById("numbererror").innerHTML = `  `;
                    vehicleNumber.style = "display:none";
                    this.newTagVisibility.display("empid");
                    this.newTagVisibility.hide("numbermessage");
                    document.getElementById("empidmessage").innerHTML = `Hi. enter your employee id.`;
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

    validateEmployeeId: Function = (id, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (id.value.length > 0) {
                if (!isNaN(id.value) && id.value > 0) {
                    id.style = "border: 2px solid blue";
                    document.getElementById("empiderror").innerHTML = `  `;
                    id.style = "display:none";
                    this.newTagVisibility.display("identification");
                    this.newTagVisibility.hide("empidmessage");
                    document.getElementById("identificationmessage").innerHTML = `Hi. Please enter about vehicle.`;
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

    validateVehicleIdentification: Function = (identification, keyboardEvent: KeyboardEvent) => {
        let key = keyboardEvent.keyCode;
        if (key == 13) {
            if (identification.value.length > 0) {
                if (identification.value.length > 4) {
                    identification.style = "border: 2px solid blue";
                    document.getElementById("identificationerror").innerHTML = `  `;
                    identification.style = "display:none";
                    this.newTagVisibility.hide("identificationmessage");
                    this.newTagVisibility.hide("Vehicle-Form");
                    this.newTagVisibility.display("pricing-form");
                    this.newTagVisibility.display("currency");
                    document.getElementById("selectCurrancymessage").innerHTML = `Hi. In which currency you want to pay.`;
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

}

class Pricing extends Vehicle {
    currency: string;
    billValue: string;
    newTagVisibility = new TagVisibility();

    selectCurrencyType: Function = (currencyType) => {
        this.currency = currencyType.value;
        document.getElementById("selectPassmessage").innerHTML = `Hi. Please select your plan.`;
        this.newTagVisibility.hide("currency");
        this.newTagVisibility.hide("selectCurrencymessage");
        this.newTagVisibility.display("selectPass");
    }

    selectPassType: Function = (passType) => {
        let selected = passType.selectedIndex;
        if (selected == 1) {
            if (this.currency == "USD") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "0.07$";
                    document.getElementById("passCost").innerHTML = `Daily parking 0.07$`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "0.14$";
                    document.getElementById("passCost").innerHTML = `Daily Pass 0.14$`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "0.28$";
                    document.getElementById("passCost").innerHTML = `Daily parking 0.28$`;
                }
            } else if (this.currency == "INR") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "5rs";
                    document.getElementById("passCost").innerHTML = `Daily parking 5rs`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "10rs";
                    document.getElementById("passCost").innerHTML = `Daily parking 10rs`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "20rs"
                    document.getElementById("passCost").innerHTML = `Daily parking 20rs`;
                }
            } else if (this.currency == "YEN") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "7.54YEN";
                    document.getElementById("passCost").innerHTML = `Daily parking 7.54YEN`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "15.07YEN";
                    document.getElementById("passCost").innerHTML = `DAILY Pass 15.07YEN`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "30.15YEN";
                    document.getElementById("passCost").innerHTML = `DAILY Pass 30.15YEN`;
                }
            }
        } else if (selected == 2) {
            if (this.currency == "USD") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "1.4$";
                    document.getElementById("passCost").innerHTML = `Monthly parking 1.4$`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "2.8$";
                    document.getElementById("passCost").innerHTML = `Monthly Pass 2.8$`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "7.14$";
                    document.getElementById("passCost").innerHTML = `Monthly parking 7.14$`;
                }
            } else if (this.currency == "INR") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "100rs";
                    document.getElementById("passCost").innerHTML = `Monthly parking 100rs`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "200rs";
                    document.getElementById("passCost").innerHTML = `monthly parking 200rs`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "500rs";
                    document.getElementById("passCost").innerHTML = `Monthly parking 500rs`;
                }
            } else if (this.currency == "YEN") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "150.53YEN";
                    document.getElementById("passCost").innerHTML = `Monthly parking 150.53YEN`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "301YEN";
                    document.getElementById("passCost").innerHTML = `Monthly Pass 301YEN`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "753.65YEN";
                    document.getElementById("passCost").innerHTML = `Monthly Pass 753.65YEN`;
                }
            }
        } else if (selected == 3) {
            if (this.currency == "USD") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "7$";
                    document.getElementById("passCost").innerHTML = `Yearly parking 7$`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "14$";
                    document.getElementById("passCost").innerHTML = `Yearly Pass 14$`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "28$";
                    document.getElementById("passCost").innerHTML = `Yearly parking 28$`;
                }
            } else if (this.currency == "INR") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "100rs";
                    document.getElementById("passCost").innerHTML = `Yearly parking 100rs`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "200rs";
                    document.getElementById("passCost").innerHTML = `Yearly parking 200rs`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "500rs";
                    document.getElementById("passCost").innerHTML = `Yearly parking 500rs`;
                }
            } else if (this.currency == "YEN") {
                if (this.vehicleType == "Cycle") {
                    this.billValue = "753.65YEN";
                    document.getElementById("passCost").innerHTML = `Yearly parking 753.65YEN`;
                } else if (this.vehicleType == "Motor Cycle") {
                    this.billValue = "1507.31YEN";
                    document.getElementById("passCost").innerHTML = `Yearly Pass 1507.31YEN`;
                } else if (this.vehicleType == "Car") {
                    this.billValue = "5275.57YEN";
                    document.getElementById("passCost").innerHTML = `Yearly Pass 5275.57YEN`;
                }
            }
        }
        document.getElementById("passCostmessage").innerHTML = `Hi.  Bill is ${this.billValue}`;
        this.newTagVisibility.hide("selectPass");
        this.newTagVisibility.hide("selectPassmessage");
        this.newTagVisibility.display("submitfinal");
    }

    final: Function = () => {
        alert('Thanks for the registration..');
        this.newTagVisibility.hide("passCostmessage");
        this.newTagVisibility.hide("submitfinal")
    }
}