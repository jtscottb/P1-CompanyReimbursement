function Login() {
    var text = document.body.nodeType === Node.ELEMENT_NODE;

    document.getElementById("start").innerHTML =
    "<button onclick=reset()>Go Back</button> <br> <br>"

    + "<p>Please sign in</p>"
    + "<form action=./Login method=post>"
    + "<label for=uname>Username</label> <br>"
    + "<input type=text id=uname name=uname> <br> <br>"

    + "<label for=pword>Password</label> <br>"
    + "<input type=text id=pword name=pword> <br> <br>"

    + "<input type=submit value=Login>"
    + "</form>";
}

function Register() {
    document.getElementById("start").innerHTML =
    "<button onclick=reset()>Go Back</button> <br> <br>"

    + "<form action=./Register method=post>"
    + "<input type=radio id=role1 name=role value=1 checked>"
    + "<label for=role1>EMPLOYEE</label> &nbsp; &nbsp;"
    + "<input type=radio id=role2 name=role value=2>"
    + "<label for=role2>MANAGER</label> <br> <br>"

    + "<label for=uname>Username</label> <br>"
    + "<input type=text id=uname name=uname placeholder=user> <br> <br>"

    + "<label for=pword>Password</label> <br>"
    + "<input type=text id=pword name=pword placeholder=password> <br> <br>"

    + "<label for=fname>First Name</label> <br>"
    + "<input type=text id=fname name=fname placeholder='first name'> <br> <br>"

    + "<label for=lname>Last Name</label> <br>"
    + "<input type=text id=lname name=lname placeholder='last name'> <br> <br>"

    + "<label for=email>Email</label> <br>"
    + "<input type=text id=email name=email placeholder=user@email.com> <br> <br>"

    + "<input type=submit value=Register>"
    + "</form>";
}

function reset() {
    window.location.href = "index.html";
}