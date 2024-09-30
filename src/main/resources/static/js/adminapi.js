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
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.lastname}</td>
            <td>${new Date(user.regDate).toLocaleString()}</td> 
            <td>${user.email || 'N/A'}</td>
            <td>${user.phoneNumber || 'N/A'}</td>
            <td>${user.socialMedia || 'N/A'}</td> 
            <td>${user.subscriptionType || 'N/A'}</td> 
            <td>${user.price || 'N/A'}</td> 
            <td>${user.coachIncluded ? 'Yes' : 'No'}</td> 
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
