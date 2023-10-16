create database Buscadores_Aventuras;
use Buscadores_Aventuras;

CREATE TABLE Cliente (
    Nome VARCHAR (40),
    Email VARCHAR(40),
    Senha VARCHAR(20),
    Telefone VARCHAR(20),
    Cpf VARCHAR(20),
	Rua VARCHAR(80),
    Cep varchar(10),
	Numero int,
	Bairro varchar(20),
	Cidade varchar(40),
	Estado varchar (40),
    Id_cliente INT  AUTO_INCREMENT PRIMARY KEY,
    fk_Agencia_Id_agencia INT
);

CREATE TABLE Passagens (
    Id_passagem INT,
    Id_voo INT,
    fk_Cliente_Id_cliente INT,
    fk_Voo_Id_voo INT,
    PRIMARY KEY (Id_passagem, Id_voo)
);

CREATE TABLE Hoteis (
    Id_hotel INT PRIMARY KEY,
    Preco_noite DECIMAL,
    Categorias VARCHAR(20),
    Nomes_Hoteis VARCHAR(40),
    Cep VARCHAR(10),
	Rua varchar(40),
	Bairro varchar(20),
	Telefone VARCHAR(20)
);

CREATE TABLE Contato (
    Id_contato INT  AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(40),
    Email VARCHAR(40),
    Telefone VARCHAR(20),
    Mensagen VARCHAR(255),
    fk_Agencia_Id_agencia INT
);

CREATE TABLE Agencia (
    Id_agencia INT  AUTO_INCREMENT PRIMARY KEY,
    Nome_agencia VARCHAR(40),
	Cep VARCHAR(10),
	Rua varchar(40),
	Bairro varchar(20),
	Telefone VARCHAR(20)
);

CREATE TABLE Voo (
    Hora_decolagem TIME,
    Data_decolagem DATE,
    Hora_aterrissagem TIME,
	Data_aterrissagem DATE,
	Origem VARCHAR(80),
    Destino VARCHAR(80),
    Preco DECIMAL(10, 2),
    Id_voo INT  AUTO_INCREMENT PRIMARY KEY
);

CREATE TABLE Reserva_quarto (
    Id_reserva INT  AUTO_INCREMENT PRIMARY KEY,
    quarto INT,
    Data_check_out DATE,
    Data_check_in DATE,
    fk_Hoteis_Id_hotel INT,
    fk_Cliente_Id_cliente INT
);
 
ALTER TABLE Cliente ADD CONSTRAINT FK_Cliente_2
    FOREIGN KEY (fk_Agencia_Id_agencia)
    REFERENCES Agencia (Id_agencia)
    ON DELETE CASCADE;
 
ALTER TABLE Passagens ADD CONSTRAINT FK_Passagens_2
    FOREIGN KEY (fk_Cliente_Id_cliente)
    REFERENCES Cliente (Id_cliente)
    ON DELETE CASCADE;
 
ALTER TABLE Passagens ADD CONSTRAINT FK_Passagens_3
    FOREIGN KEY (fk_Voo_Id_voo)
    REFERENCES Voo (Id_voo)
    ON DELETE CASCADE;
 
ALTER TABLE Contato ADD CONSTRAINT FK_Contato_2
    FOREIGN KEY (fk_Agencia_Id_agencia)
    REFERENCES Agencia (Id_agencia)
    ON DELETE CASCADE;
 
ALTER TABLE Reserva_quarto ADD CONSTRAINT FK_Reserva_quarto_2
    FOREIGN KEY (fk_Hoteis_Id_hotel)
    REFERENCES Hoteis (Id_hotel)
    ON DELETE CASCADE;
 
ALTER TABLE Reserva_quarto ADD CONSTRAINT FK_Reserva_quarto_3
    FOREIGN KEY (fk_Cliente_Id_cliente)
    REFERENCES Cliente (Id_cliente)
    ON DELETE CASCADE;
    
    select * from agencia;
    select * from cliente;
    select * from voo;
    select * from hoteis;
    select * from contato;
    select * from Reserva_quarto;
    select * from passagens;

ALTER TABLE Cliente MODIFY COLUMN Cep VARCHAR(20);

    
    
INSERT INTO Agencia VALUES (default,'Busacdores de Aventuras', '12345', 'Paraíso', 'Paz', '123-456-7890');

INSERT INTO Cliente (nome, email, senha, telefone, cpf, rua, cep,  numero, bairro,cidade, estado,fk_Agencia_Id_agencia)VALUES 
('Ana', 'ana@example.com', 'senha123', '42850-780', '12345678901', 'Rua das flores', '54321',  123, 'Centro', 'Salvador', 'Ba',2);

INSERT INTO Voo VALUES ('08:00:00', '2023-09-20', '10:00:00', '2023-09-20', 'Salvador', 'São paulo', 500.00,default);

INSERT INTO Hoteis VALUES (2, 150.00, '3 estrelas', 'Hotel Lima', '54321', 'Áurea seixas', 'Bosque', '789-123-4567');

INSERT INTO Contato VALUES (default,'Paula', 'paulaA@example.com', '987-654-3210', 'Mensagem de contato ', 2);

INSERT INTO Reserva_quarto VALUES (default, 101, '2023-09-22', '2023-09-20', 2, 9);

INSERT INTO Passagens VALUES (1, 1, 1, 1); 

UPDATE Cliente
SET Nome = 'paulo', Email = 'paulo@email.com', Senha = '25', Telefone = '45826-14', Cpf = '98765432', Rua = 'margarida', Cep = '5879', Numero = 321, Bairro = 'Novo', Cidade = 'são paulo', Estado = 'Sp'
WHERE Id_cliente = 4;

UPDATE Passagens
SET Id_voo = 456, fk_Cliente_Id_cliente = 789, fk_Voo_Id_voo = 123
WHERE Id_passagem = 1 AND Id_voo = 123;

UPDATE Hoteis
SET Preco_noite = 180.00, Categorias = '5 estrelas', Nomes_Hoteis = 'Hotel celli', Cep = '78956', Rua = 'principal', Bairro = 'lessa', Telefone = '74569'
WHERE Id_hotel = 1;

UPDATE Contato
SET Nome = 'francisco', Email = 'francisco@email.com', Telefone = '2536987', Mensagen = 'olá', fk_Agencia_Id_agencia = 456
WHERE Id_contato = 2;

UPDATE Agencia
SET Nome_agencia = 'NovoNomeAgencia', Cep = 'NovoCepAgencia', Rua = 'NovaRuaAgencia', Bairro = 'NovoBairroAgencia', Telefone = 'NovoTelefoneAgencia'
WHERE Id_agencia = 1;

UPDATE Voo
SET Hora_decolagem = '12:00:00', Data_decolagem = '2023-11-01', Hora_aterrissagem = '15:00:00', Data_aterrissagem = '2023-11-02', Origem = 'são paulo', Destino = 'frança', Preco = 950.75
WHERE Id_voo = 2;

UPDATE Reserva_quarto
SET quarto = 2, Data_check_out = '2023-11-05', Data_check_in = '2023-11-03', fk_Hoteis_Id_hotel = 2, fk_Cliente_Id_cliente = 1
WHERE Id_reserva = 1;

DELETE FROM Cliente
WHERE Id_cliente = 7;

DELETE FROM Passagens
WHERE Id_passagem = 1 AND Id_voo = 123;

DELETE FROM Hoteis
WHERE Id_hotel = 1;

DELETE FROM Contato
WHERE Id_contato = 1;

DELETE FROM Agencia
WHERE Id_agencia = 1;

DELETE FROM Voo
WHERE Id_voo = 1;

DELETE FROM Reserva_quarto
WHERE Id_reserva = 1;




