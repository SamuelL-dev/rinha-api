CREATE TABLE tb_clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    balance INT NOT NULL,
    balanceLimit INT NOT NULL
);

CREATE TABLE tb_transactions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    amount INT NOT NULL,
    description VARCHAR(255) NOT NULL,
    realizedIn DATETIME,
    client_id INT,
    FOREIGN KEY (client_id) REFERENCES tb_clients(id)
);

INSERT INTO tb_clients (name, balance, balanceLimit) VALUES
('Samuel', 1000, 5000),
('Lucas', 2000, 8000),
('Pedro', 5000, 10000),
('Victor', 5000, 10000),
('Gustavo', 5000, 10000);