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
            <td>${user.subscriptions.length === 0 ? 'N/A' : user.subscriptions[0].subType || 'N/A'}</td> 
            <td>${user.subscriptions.length === 0 ? 'N/A' : user.subscriptions[0].price || 'N/A'}</td> 
            <td>${user.subscriptions.length === 0 ? 'N/A' : user.subscriptions[0].coach ? 'Yes' : 'No'}</td> 
        `;

        tableBody.appendChild(row);
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
