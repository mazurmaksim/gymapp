function getUsers() {
    const apiUrl = '/admin/users';

    return new Promise((resolve, reject) => {
        fetch(apiUrl)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                resolve(data);
            })
            .catch(error => {
                reject(error);
            });
    });
}

function populateUserTable(users) {
    const tableBody = document.getElementById('users');
    tableBody.innerHTML = '';

    users.forEach(user => {
        const row = document.createElement('tr');

        row.innerHTML = `
            <td>${user.username}</td>
            <td>${user.lastname}</td>
            <td>${new Date(user.regDate).toLocaleString()}</td> 
            <td>${user.email || 'N/A'}</td>
            <td>${user.phoneNumber || 'N/A'}</td>
            <td>${user.socialMedia || 'N/A'}</td> 
            <td>${user.userSubscription.length === 0 || false ? 'N/A' : user.userSubscription[0].existingSubscriptions.subType || 'N/A'}</td> 
            <td>${user.userSubscription.length === 0 || false ? 'N/A' : user.userSubscription[0].userPaid || 'N/A'}</td> 
            <td>${user.userSubscription.length === 0 || false ? 'N/A' : user.userSubscription[0].coach ? 'Yes' : 'No'}</td> 
        `;

        row.addEventListener('click', () => {
            openUserModal(user);
        });

        tableBody.appendChild(row);
    });
}

function openUserModal(user) {
    document.getElementById('username').value = user.username;
    document.getElementById('lastname').value = user.lastname;
    document.getElementById('regDate').value = new Date(user.regDate).toISOString().slice(0, 16);
    document.getElementById('email').value = user.email || '';
    document.getElementById('phoneNumber').value = user.phoneNumber || '';
    document.getElementById('socialMedia').value = user.socialMedia || '';
    document.getElementById('subStatus').innerText = user.userSubscription.length === 0 ? 'Unknown status' :
        user.userSubscription[0].active ? 'Active: ' + user.userSubscription[0].existingSubscriptions.subType : 'Not Active: ' + user.userSubscription[0].existingSubscriptions.subType;


    const userSubscriptions = document.getElementById('userSubscriptions');
    userSubscriptions.innerHTML = '';
    userSubscriptions.value = user.userSubscription.length === 0 ? 'No Subscription' :  user.userSubscription[0].existingSubscriptions.subType;
    userSubscriptions.text = user.userSubscription.length === 0 ? 'emptySubscription' : user.userSubscription[0].existingSubscriptions.id;

    const modal = new bootstrap.Modal(document.getElementById('exampleModal'));
    modal.show();
}
function saveUser() {
    const userData = {
        username: document.getElementById('username').value,
        lastname: document.getElementById('lastname').value,
        regDate: document.getElementById('regDate').value,
        email: document.getElementById('email').value,
        phoneNumber: document.getElementById('phoneNumber').value,
        socialMedia: document.getElementById('socialMedia').value,
        userSubscriptions: document.getElementById('userSubscriptions').value
    };

    const csrfToken = document.getElementById('csrfToken').value;

    fetch('/admin/user/save', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(userData)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Failed to save user');
            }
        })
        .then(data => {
            alert('User saved successfully');
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Error saving user');
        });
}


getUsers()
    .then(users => {
        console.log('Fetched users:', users);
        populateUserTable(users);
    })
    .catch(error => {
        console.error('Error fetching users:', error);
    });
