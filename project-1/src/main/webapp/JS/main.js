var loc = "project-1/src/main/java/com/revature"
function Login() {
    document.getElementById("start").innerHTML =
    "<form action=./Login method=post>"
    + "<label for=uname>Username</label> <br>"
    + "<input type=text id=uname name=uname> <br> <br>"

    + "<label for=pword>Password</label> <br>"
    + "<input type=text id=pword name=pword> <br> <br>"

    + "<input type=submit value=Enter>"
    + "</form>";
}

function Register() {
    document.getElementById("start").innerHTML =
    "<form action=./Register method=post>"
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

    + "<label for=role>Role</label> <br>"
    + "<input type=text id=role name=role placeholder='(1) Employee, (2) Manager'> <br> <br>"

    + "<input type=submit value=Enter>"
    + "</form>";
}
