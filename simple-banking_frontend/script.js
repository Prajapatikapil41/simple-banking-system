const accountId = 1; // default account initialized in backend

const backendUrl = "http://localhost:8080/api/bank";

function deposit() {
    const amount = document.getElementById("depositAmount").value;
    if (amount <= 0) {
        alert("Please enter a valid amount to deposit.");
        return;
    }
    fetch(`${backendUrl}/deposit?accountId=${accountId}&amount=${amount}`, {
        method: "POST"
    })
    .then(response => response.text())
    .then(data => {
        alert(data);
        document.getElementById("depositAmount").value = "";
    })
    .catch(error => alert("Error: " + error));
}

function withdraw() {
    const amount = document.getElementById("withdrawAmount").value;
    if (amount <= 0) {
        alert("Please enter a valid amount to withdraw.");
        return;
    }
    fetch(`${backendUrl}/withdraw?accountId=${accountId}&amount=${amount}`, {
        method: "POST"
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => { throw new Error(text); });
        }
        return response.text();
    })
    .then(data => {
        alert(data);
        document.getElementById("withdrawAmount").value = "";
    })
    .catch(error => alert("Error: " + error.message));
}

function getBalance() {
    fetch(`${backendUrl}/balance?accountId=${accountId}`)
    .then(response => response.text())
    .then(data => {
        document.getElementById("balanceResult").innerText = data;
    })
    .catch(error => alert("Error: " + error));
}
