use biblioteca;
INSERT INTO user (name, email, password, type) VALUES ('admin', 'admin@admin.com', 'admin', 'ADMIN');
INSERT INTO user (name, email, password, type) VALUES ('Nicole', 'nicole@mail.com', '1234', 'READER');

-- Inserir autores na tabela author
INSERT INTO author (name) VALUES ('J.R.R. Tolkien');
INSERT INTO author (name) VALUES ('George Orwell');
INSERT INTO author (name) VALUES ('J.K. Rowling');
INSERT INTO author (name) VALUES ('Gabriel García Márquez');
INSERT INTO author (name) VALUES ('Antoine de Saint-Exupéry');

-- Inserir livros na tabela livro
INSERT INTO livro (name, date, id_author, status) VALUES ('O Senhor dos Anéis: A Sociedade do Anel', '1954-07-29', 1, 'DISPONIVEL');
INSERT INTO livro (name, date, id_author, status) VALUES ('1984', '1949-06-08', 2, 'DISPONIVEL');
INSERT INTO livro (name, date, id_author, status) VALUES ('Harry Potter e a Pedra Filosofal', '1997-06-26', 3, 'INDISPONIVEL');
INSERT INTO livro (name, date, id_author, status) VALUES ('Cem Anos de Solidão', '1967-05-30', 4, 'INDISPONIVEL');
INSERT INTO livro (name, date, id_author, status) VALUES ('O Pequeno Príncipe', '1943-04-06', 5, 'EMPRESTADO');
