async function validator(e) {
    e=e|| window.event;
    e.preventDefault();
    let userEmail = document.getElementById("userEmail").value;
    let password = document.getElementById("pass").value;
    await fetch('http://localhost:8080/OrmProject/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email: userEmail, password: password })
    })
    .then(response => response.text())
    .then(userPresent=> {
        console.log(userPresent)
        if(userPresent == "true"){
            window.location.replace("/displayUserList/displayUserList.html")
        } else {
            alert("invalid user")
        }
    })
    .catch(error=> console.log(error))
}

function signUpPage(){
    window.location.href = "/SignUp/signUp.html";
}