window.onload = function(e){
    e=e|| window.event;
    e.preventDefault();
    fetch('http://localhost:8080/OrmProject/country')
        .then(response => response.json())
        .then(countryList =>{
            let listOfCountry = document.getElementById("countryList")
            for(let country in countryList){
                let option = document.createElement("option");
                option.value = countryList[country].name
                listOfCountry.appendChild(option)
            }
        })

        fetch('http://localhost:8080/OrmProject/state')
        .then(response => response.json())
        .then(stateList =>{
            let listOfState = document.getElementById("stateList")
            for(let state in stateList){
                let stateOption = document.createElement("option");
                stateOption.value = stateList[state].name;
                listOfState.appendChild(stateOption)
            }
        })
}
  
const urlParams = new URLSearchParams(window.location.search);
const userId = parseInt(urlParams.get('userId'));
if(userId){
    var user;
    const getUserByIdUrl = `http://localhost:8080/OrmProject/login/${userId}`;
    fetch(getUserByIdUrl)
    .then(response => response.json())
    .then(data =>{
        let name = document.getElementById("userName").value = data.name;
        let email = document.getElementById("email").value = data.email;
        let address = document.getElementById("address").value = data.address;
        let mobileNumber = document.getElementById("mobileNumber").value = data.mobileNumber;
        let countryId = document.getElementById("countryId").value = data.country.name;
        let stateId = document.getElementById("stateId").value = data.state.name;
        document.getElementById("signButton").value = "UPDATE"
    })
} 

function setState(){
    let countryId = document.getElementById("countryId").value;
    fetch('http://localhost:8080/OrmProject/country')
        .then(response => response.json())
        .then(countryList =>{
            for(let country in countryList){
                if(countryList)
            }
        })
}

function insertOrUpdateUser(e){
    e=e|| window.event;
    e.preventDefault();
    let name = document.getElementById("userName").value;
    let password = document.getElementById("password").value
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let mobileNumber = document.getElementById("mobileNumber").value;
    let stateId = document.getElementById("stateId").value;
    let countryId = document.getElementById("countryId").value;
    if(userId){
        fetch('http://localhost:8080/OrmProject/user',{
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ userId: userId,name: name, email: email, password: password, address: address, mobileNumber: mobileNumber,stateId:stateId, countryId: countryId })
        })
    } else{
        fetch('http://localhost:8080/OrmProject/user', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ name: name, email: email, password: password, address: address, mobileNumber: mobileNumber,stateId:stateId, countryId: countryId })
        })
    }

    window.location.href = "/logIn/LogIn.html";
}

