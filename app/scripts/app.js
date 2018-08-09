$(document).ready(function () {
    $("#button").click(function () {
        var data = {
            "userName": $('input[name="user"]').val(),
            "password": $('input[name="pass"]').val()
        };
        $.ajax({
            url: 'http://localhost:8080/qrapi/api/v1/accounts/check/',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",

            success: function (response) {
                if (response == undefined) {
                    loginErr();
                }
                else {
                    loginFine();
                    var ID = response.id;
                    console.log("ID: " + ID);

                    window.localStorage.accountId = ID;
                    window.localStorage.name = response.name;
                    window.localStorage.userName = response.userName;
                    window.localStorage.emailDomain = response.emailDomain;
                    window.localStorage.timeZoneCity = response.timeZoneCity;

                    window.location.href = "contacts.html";
                }
            },
            error: function (result) {
                alert("Oops Something went wrong...");
            }
        });

    });

    populateAccountInfo();
    if ($('.tbl-contacts')) {
        populateTableContacts(1, 6);
    }

});

function populateAccountInfo() {
    var usernameArea = $('#username');
    if (usernameArea) {
        usernameArea.html("(" + getUserName() + ")");
    }
    var WelcomenameArea = $('#name');
    if (WelcomenameArea) {
        WelcomenameArea.html("WELCOME, " + getName() + getEmailDomain());
    }
}

function populateTableContacts(from, to) {

    url = "http://localhost:8080/qrapi/api/v1/contacts/getAllOf/" + getAccountId();
    $.get(url,
        function (contacts, status) {
            var currentRow = 0;
            $.each(contacts, function (i) {
                currentRow = i + 1;
                var current;
                var id;
                var addressID;
                var firstName;
                var lastName;
                var emailAddress;
                var gender;
                var phoneNumber;
                var status;
                var street;
                var city;
                var state;
                var country;
                $.each(this, function (key, value) {
                    //console.log(currentRow + "> " + key + ": " + value);
                    if (currentRow >= from && currentRow <= to) {
                        current = +(currentRow % 6);
                        if (current == 0) {
                            current = 6;
                        }
                        $("#" + current + '' + 0).html(currentRow);

                        if (key == "id") {
                            //console.log(contacts[currentRow-1]);
                            id = value;
                        }
                        if (key == "firstName") {
                            $("#" + current + '' + 1).html(value);
                            firstName = value;
                        }
                        if (key == "lastName") {
                            $("#" + current + '' + 2).html(value);
                            lastName = value;
                        }
                        if (key == "emailAddress") {
                            $("#" + current + '' + 3).html(value);
                            emailAddress = value;
                        }
                        if (key == "gender") {
                            $("#" + current + '' + 4).html(value);
                            gender = value;
                        }
                        if (key == "phoneNumber") {
                            $("#" + current + '' + 5).html(value);
                            phoneNumber = value;
                        }
                        if (key == "status") {
                            if (value) {
                                $("#" + current + '' + 6).html("Active");
                                status = "Active";
                            }
                            else {
                                $("#" + current + '' + 6).html("Non-Active");
                                status = "Non-Active";
                            }
                        }
                        if (key == "addresses") {
                            var i;
                            var currentAddress = "Add your address!";

                            for (i = 0; i < value.length; i++) {

                                if (value[i]["current"]) {
                                    addressID = value[i]["id"];
                                    street = value[i]["streetAddress"];
                                    city = value[i]["city"];
                                    state = value[i]["state"];
                                    country = value[i]["country"];

                                    currentAddress = "" + street + ", "
                                        + city + ", " + state + ", "
                                        + country;
                                    $("#" + current + '' + 7).html(currentAddress);
                                }
                            }
                        }

                        window.localStorage.currentPos = currentRow;
                    }
                });
                var datazz = "data-id=" + id + " data-first=" + firstName + " data-last=" + lastName
                    + " data-email=" + emailAddress + " data-gender =" + gender + " data-phone=" + phoneNumber
                    + " data-status=" + status + " data-street=" + street + " data-city=" + city
                    + " data-state=" + state + " data-country=" + country + " data-addressid=" + addressID + "";
                var actionz = '<span><a href="#" style="color: rgb(13, 1, 119);font_weight: bold;" id="edit" ' + datazz
                    + ' data-OpName="edit" onClick="DELETEopenUpdateModal()">EDIT</a></span>'
                    + '<p> </p>'
                    + '<span><a href="#" style="color: rgb(224, 45, 13);font_weight: bold;" id="delete" ' + datazz
                    + ' data-OpName="delete" onClick="DELETEopenUpdateModal()">DELETE</a></span>';
                $("#" + current + '' + 8).html(actionz);
            });

            window.localStorage.SizeContacts = currentRow;
        });

}

function myMap() {
    var mapProp = {
        center: new google.maps.LatLng(32.9328, 72.8630),
        zoom: 5,
    };
    var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
    getAllCurrentAddresses(map);
}

function getAllCurrentAddresses(map) {
    url = "http://localhost:8080/qrapi/api/v1/contacts/getAllCurrentAdd/" + getAccountId();
    $.get(url,
        function (addresses, status) {
            console.log("Total addresses are: " + addresses.length);
            var i;
            for (i = 0; i < addresses.length; i++) {
                console.log(addresses[i]["city"]);
                var geoCodeUrl = 'http://maps.googleapis.com/maps/api/geocode/json?address=' + addresses[i]["city"] + " " + addresses[i]["country"] + '&sensor=false';
                $.getJSON(geoCodeUrl,null,
                    function (mark) {
                        console.log(mark);
                        var point = mark.results[0].geometry.location;
                        var latlng = new google.maps.LatLng(point.lat, point.lng);

                        new google.maps.Marker({
                            position: latlng,
                            map: map
                        });
                    }
                );
            }
        }
    );

}

function DELETEopenUpdateModal() {
    var OpName = $(event.target).data("opname");
    var contactId = $(event.target).data("id");
    var addressID = $(event.target).data("addressid");
    var firstName = $(event.target).data("first");
    var lastName = $(event.target).data("last");
    var emailAddress = $(event.target).data("email");
    var gender = $(event.target).data("gender");
    var phoneNumber = $(event.target).data("phone");
    var status = $(event.target).data("status");
    var street = $(event.target).data("street");
    var city = $(event.target).data("city");
    var state = $(event.target).data("state");
    var country = $(event.target).data("country");

    window.localStorage.contactId = contactId;
    window.localStorage.addressId = addressID;
    if (OpName == "edit") {

        $("#headerID").html("Edit Contact!");
        $("#first_name").val(firstName);
        $("#last_name").val(lastName);
        $("#email").val(emailAddress);
        $("#phone").val(phoneNumber);
        $("#street").val(street);
        $("#city").val(city);
        $("#state").val(state);
        $("#country").val(country);
        $("#genderSelect").val(gender);
        $("#statusSelect").val(status);
        $("#buttonSubmit").html('<input type="button" data-dismiss="modal" onclick="updateContact()" class="btn btn-info btn-block" value="Add Contact"/>');
        $("#editModal").modal();

    }
    if (OpName == "delete") {
        deleteContact();
    }
}

function updateContact() {
    var contactId = getContactId();
    var addressId = getAddressId();
    var status = $("#statusSelect").val();
    var statusBool;
    if (status == "Active") {
        statusBool = true;
    }
    else {
        statusBool = false;
    }
    var dataContact = {
        "firstName": $("#first_name").val(),
        "lastName": $("#last_name").val(),
        "emailAddress": $("#email").val(),
        "gender": $("#genderSelect").val(),
        "phoneNumber": $("#phone").val(),
        "status": statusBool
    };

    var dataAddress = {
        "streetAddress": $("#street").val(),
        "city": $("#city").val(),
        "state": $("#state").val(),
        "country": $("#country").val(),
        "current": true
    }

    $.ajax({//apdating contact
        url: 'http://localhost:8080/qrapi/api/v1/contacts/update/' + contactId,
        type: 'PUT',
        data: JSON.stringify(dataContact),
        contentType: "application/json; charset=utf-8",
        dataType: "json",

        success: function (contact) {
            if (contact == undefined) {
                console.log("couldn't update contact ")
            }
            else {
                console.log("contact updated!");
                console.log(contact);
            }
            cleanTable();
            populateTableContacts(1, 6);//after
        },
        error: function (result) {
            console.log("Oops Something went wrong in contact updation");
            cleanTable();
            populateTableContacts(1, 6);//after
        }
    });

    $.ajax({//updating address
        url: 'http://localhost:8080/qrapi/api/v1/contacts/updateAddress/' + addressId,
        type: 'PUT',
        data: JSON.stringify(dataAddress),
        contentType: "application/json; charset=utf-8",
        dataType: "json",

        success: function (CurrentAddress) {
            if (CurrentAddress == undefined) {
                console.log("couldn't update address ")
            }
            else {
                console.log("address updated!");
                console.log(CurrentAddress);

            }
            cleanTable();
            populateTableContacts(1, 6);//after
        },
        error: function (result) {
            console.log("Oops Something went wrong in address updation");
            cleanTable();
            populateTableContacts(1, 6);//after
        }
    });
}

function deleteContact() {
    var url = 'http://localhost:8080/qrapi/api/v1/contacts/delete/' + getContactId();
    $.ajax({//deleting contact
        url: url,
        type: 'DELETE',
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (result) {
            if (result) {
                console.log("deleted! " + result);
            }
            cleanTable();
            populateTableContacts(1, 6);//after
        },
        error: function (result) {
            console.log("Oops Something went wrong in deletion");
            cleanTable();
            populateTableContacts(1, 6);//after
        }
    });
}

function addContactModal() {
    $("#headerID").html("Add Contact!");
    $("#buttonSubmit").html('<input type="button" data-dismiss="modal" onclick="addContact()" class="btn btn-info btn-block" value="Add Contact"/>');
    $("#editModal").modal();
}

function addContact() {
    var status = $("#statusSelect").val();
    var statusBool;
    if (status == "Active") {
        statusBool = true;
    }
    else {
        statusBool = false;
    }
    var dataContact = {
        "firstName": $("#first_name").val(),
        "lastName": $("#last_name").val(),
        "emailAddress": $("#email").val(),
        "gender": $("#genderSelect").val(),
        "phoneNumber": $("#phone").val(),
        "status": statusBool
    };

    var dataAddress = {
        "streetAddress": $("#street").val(),
        "city": $("#city").val(),
        "state": $("#state").val(),
        "country": $("#country").val(),
        "current": true
    }
    url = 'http://localhost:8080/qrapi/api/v1/contacts/add/' + getAccountId();
    console.log(url);
    $.ajax({//Adding contact and address
        url: url,
        type: 'POST',
        data: JSON.stringify(dataContact),
        contentType: "application/json; charset=utf-8",
        dataType: "json",

        success: function (contact) {
            if (contact == undefined) {
                console.log("couldn't add contact")
            }
            else {
                console.log("contact added!");
                var ContactId = contact['id'];
                console.log(contact['id']);
                $.ajax({//adding address
                    url: 'http://localhost:8080/qrapi/api/v1/contacts/addAddressIn/' + ContactId,
                    type: 'POST',
                    data: JSON.stringify(dataAddress),
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    success: function (address) {
                        if (address == undefined) {
                            console.log("couldn't add address")
                        }
                        else {
                            console.log("address added!");
                            console.log(address);
                        }
                        cleanTable();
                        populateTableContacts(1, 6);//after addition remake table
                    },
                    error: function (result) {
                        console.log("Oops Something went wrong in address addition");
                        cleanTable();
                        populateTableContacts(1, 6);//after addition remake table
                    }
                });
            }
            cleanTable();
            populateTableContacts(1, 6);//after addition remake table
        },
        error: function (result) {
            console.log("Oops Something went wrong in contact addition");
            cleanTable();
            populateTableContacts(1, 6);//after addition remake table
        }
    });
}

function loginErr() {
    $('#err').html('>Wrong username or password!');
}

function loginFine() {
    $('#err').html('>Login Successfull!');
}

function getAccountId() {
    var accountId = window.localStorage.getItem('accountId');
    return accountId ? accountId : "";
}

function getContactId() {
    var contactId = window.localStorage.getItem('contactId');
    return contactId ? contactId : "";
}

function getAddressId() {
    var addressId = window.localStorage.getItem('addressId');
    return addressId ? addressId : "";
}

function getUserName() {
    var userName = window.localStorage.getItem('userName');
    return userName ? userName : "";
}

function getName() {
    var name = window.localStorage.getItem('name');
    return name ? name : "";
}

function getEmailDomain() {
    var email = window.localStorage.getItem('emailDomain');
    return email ? email : "";
}

function getTimeZoneCity() {
    var timeZoneCity = window.localStorage.getItem('timeZoneCity');
    return timeZoneCity ? timeZoneCity : "";
}

function logout() {
    window.localStorage.clear();
}

function isLoggedIn() {
    var id = getAccountId();
    return !(id == "" || id == null || id == undefined);
}

function isLoggedOut() {
    var id = getAccountId();
    return (id == "" || id == null || id == undefined);
}

function cleanTable() {
    var i;
    for (i = 0; i <= 8; i++) {
        var j;
        for (j = 1; j <= 6; j++) {
            var ID = j + "" + i;
            $('#' + ID).html(" ");
        }

    }
}

function onNext() {
    var pos = window.localStorage.currentPos;
    var size = window.localStorage.SizeContacts;

    if (+pos < +size) {
        cleanTable();
        console.log("Position: " + pos + " Size: " + size);
        var NextFrom = (+pos + +1);
        var NextTo = (+NextFrom + +5);
        console.log("NextFrom: " + NextFrom + " NextTo: " + NextTo);
        populateTableContacts(NextFrom, NextTo);
    }

}

function onBack() {
    var pos = window.localStorage.currentPos;
    var size = window.localStorage.SizeContacts;

    if (+pos >= +size && +size > 6) {
        cleanTable();
        console.log("Position: " + pos + " Size: " + size);
        var BackTo = (+size - +(pos % 6));
        var BackFrom = (+BackTo - +5);
        console.log("BackFrom: " + BackFrom + " BackTo: " + BackTo);
        populateTableContacts(BackFrom, BackTo);
    }
}

function openMap() {
    $("#mapModal").modal();
}
