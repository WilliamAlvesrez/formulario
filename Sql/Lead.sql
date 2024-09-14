CREATE SCHEMA IF NOT EXISTS my_schema;
USE my_schema;

CREATE TABLE Lead (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,  -- ID do lead, auto incrementado
    nome VARCHAR(60) NOT NULL,            -- Nome do lead, não nulo
    phone VARCHAR(15) NOT NULL,            -- Telefone do lead, não nulo
    email VARCHAR(255) NOT NULL,           -- Email do lead, não nulo
    mensagem TEXT                          -- Mensagem do lead
);

INSERT INTO Lead (nome, phone, email, mensagem) 
VALUES ('João Silva', '555-1234', 'joao.silva@email.com', 'Estou interessado em alugar o espaço para uma sessão de fotos de moda no próximo mês. Gostaria de saber sobre a disponibilidade.');

INSERT INTO Lead (nome, phone, email, mensagem) 
VALUES ('Maria Fernandes', '555-5678', 'maria.fernandes@email.com', 'Preciso de um espaço para uma sessão fotográfica de casamento. Qual é a capacidade máxima do estúdio?');

INSERT INTO Lead (nome, phone, email, mensagem) 
VALUES ('Carlos Souza', '555-8765', 'carlos.souza@email.com', 'Gostaria de saber mais detalhes sobre o aluguel do espaço para fotografia de produtos. Vocês têm equipamento disponível?');

INSERT INTO Lead (nome, phone, email, mensagem) 
VALUES ('Ana Oliveira', '555-4321', 'ana.oliveira@email.com', 'Estou procurando um estúdio para uma sessão de fotos corporativas. Vocês oferecem algum tipo de pacote promocional?');

INSERT INTO Lead (nome, phone, email, mensagem) 
VALUES ('Pedro Lima', '555-9876', 'pedro.lima@email.com', 'Estou interessado em alugar o espaço para fotos de um catálogo de moda. O estúdio possui iluminação profissional incluída?');
