
$(document).ready(function(){

    showAllUsers();

    $('#btnRegister').on('click', function(){
        signup();
    });

    $(document).on('click', '#usersTable tbody button',function(e){
        let btnId = e.target.id;
        let userId = btnId.split('-')[1];
        console.log(userId)
        deleteUser(userId);
    });

});

function deleteUser(userId){
    let deleteUser = confirm("Are you sure want to delete user");
    if(deleteUser){
        alert("User with id " + userId + " was deleted" );
    }
}

function signup(){
    let userName = $('#userName').val();
    let userSurname = $('#userSurname').val();
    let telephoneNumber = $('#telephoneNumber').val();
    let email = $('#email').val();
    let login = $('#login').val();
    let userPassword = $('#userPassword').val();
    let userSexType = $('#userSexType').val();
    let userPasswordConfirm = $('#userPasswordConfirm').val();

    console.log(userSurname);

    let user = {
        firstName : userName,
        lastName : userSurname,
        telephoneNumber : telephoneNumber,
        email : email,
        login : login,
        password : userPassword,
        sexType : userSexType,
        PasswordConfirm: userPasswordConfirm
    };

    // EndPoint: PostMappling : /users
    $.ajax({
        url: SERVER_URL + 'users',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(user),
        complete: function(serverResponse){
            if(serverResponse.status == 201){
                alert("Users was added to database");
                $('#addUserForm')[0].reset();
                $('#addUserForm').empty();
                showAllUsers();
            }
        }

    });

}

function showAllUsers(){
    $.ajax({
        url: SERVER_URL + 'users',
        method: 'GET',
        contentType: 'application/json',
        complete:function(serverResponse){
            console.log(serverResponse);
            let users = serverResponse.responseJSON;

            $.each(users, function(key, value){
                $('#usersTable tbody').append(
                    `
                    <tr>
                        <td>${value.id}</td>
                        <td>${value.firstName}</td>
                        <td>${value.lastName}</td>
                        <td>${value.telephoneNumber}</td>
                        <td>${value.email}</td>
                        <td>${value.sexType}</td>
                        <td>
                        <button class="btn-danger btn-sm" id="user-${value.id}">Delete</button>
                        </td>
                    </tr>
                    `
                )
            })
        }
    });
}