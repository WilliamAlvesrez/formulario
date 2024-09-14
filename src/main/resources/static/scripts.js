async function validar() {
    const form = document.getElementById('leadForm');
    const nome = form.nome.value;
    const phone = form.phone.value;
    const email = form.email.value;
    const mensagem = form.mensagem.value;

    if (!nome || !phone || !email || !mensagem) {
        alert('Todos os campos precisam ser preenchidos');
        return;
    }

    if (!isValidEmail(email)) {
        alert('Por favor, insira um email válido');
        return;
    }

    const formData = { nome, phone, email, mensagem };

    try {
        const response = await fetch('http://localhost:8080/api/leads', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(formData),
        });

        if (response.ok) {
            alert('Formulário enviado com sucesso!');
            form.reset();
        } else {
            alert('Erro ao enviar o formulário');
        }
    } catch (error) {
        console.error('Erro:', error);
        alert('Ocorreu um erro no envio do formulário');
    }
}
