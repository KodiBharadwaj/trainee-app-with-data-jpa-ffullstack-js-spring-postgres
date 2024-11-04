const baseUrl = "http://localhost:8080/api/v1/trainees";

async function getTrainees() {
    const response = await fetch(baseUrl);
    const data = await response.json();
    return data;
}

async function getTraineeById(id) {
    const response = await fetch(`${baseUrl}/${id}`);
    const data = await response.json();
    return data;
}

async function getTraineesByName(name) {
    const response = await fetch(`${baseUrl}?name=${name}`);
    const data = await response.json();
    return data;
}

async function addTrainee(trainee) {
    const response = await fetch(baseUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(trainee)
    });
    const data = await response.json();
    return data;
}

// async function deleteTrainee(id) {
//     const response = await fetch(`${baseUrl}/${id}`,
//         {
//             method: 'DELETE'
//         });
//     const data = await response.json();
//     return data;
// }

async function deleteTrainee(id) {
    try {
        const response = await fetch(`${baseUrl}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            // Remove the card of the deleted trainee from the UI
            document.getElementById(`trainee-card-${id}`).remove();

            alert('Trainee deleted successfully');
        } else {
            throw new Error('Failed to delete trainee');
        }
    } catch (error) {
        console.log(error);
        alert('An error occurred while deleting the trainee');
    }
}


async function updateTrainee(id, trainee) {
    const response = await fetch(`${baseUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(trainee)
    });
    const data = await response.json();
    return data;
}