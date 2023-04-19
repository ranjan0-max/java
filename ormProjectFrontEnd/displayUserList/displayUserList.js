window.onload = function(e){
    e=e|| window.event;
    e.preventDefault();
    fetch('http://localhost:8080/OrmProject/user')
        .then(response => response.json())
        .then(userList => {
            if(userList){
                let table = document.getElementById("userTable");
                userList.forEach(function(user){
                    let row = table.insertRow();
                    row.insertCell().innerHTML = `<a onclick="updateUser(${user.userId})" >${user.name}</a>`;
                    row.insertCell().innerHTML = user.mobileNumber;
                    row.insertCell().innerHTML = user.address;
                    row.insertCell().innerHTML = user.email;
                    row.insertCell().innerHTML = user.stateId;
                    row.insertCell().innerHTML = user.countryId;
                    row.insertCell().innerHTML = `<button onclick="deleteUser(${user.userId})">Delete</button>`;
                })
            }
        })
        .catch(error => console.error(error));
}

function deleteUser(id){
    console.log(id)
    fetch(`http://localhost:8080/OrmProject/login/${id}`,{
        method: 'DELETE'
    });
    location.reload();
}

function updateUser(userId) {
    window.location.href=`/SignUp/signUp.html?userId=${userId}`;
}