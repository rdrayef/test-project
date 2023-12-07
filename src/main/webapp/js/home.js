function executeCommand() {
    const commandInput = document.getElementById('commandInput');
    const resultDiv = document.getElementById('result');

    const command = commandInput.value.trim();

    resultDiv.innerHTML = '';

    if (command === '') {
        alert('Please enter a command.');
        return;
    }

    fetch(`proxmox-api/execute-command?command=${command}`)
        .then(response => response.text())
        .then(result => {
            resultDiv.innerHTML = `<pre>${result}</pre>`;
        })
        .catch(error => {
            console.error('Error:', error);
            resultDiv.innerHTML = `<p>Error executing command.</p>`;
        });
}
