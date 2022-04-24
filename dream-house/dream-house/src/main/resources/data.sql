insert into anuncio
(dt_publicacao, descricao, inicio_disponibilidade, fim_disponibilidade, cidade, bairro, logradouro, numero, nota_anuncio)
values
('03/04/2022', 'Casa boa', '2022-04-04', '2022-04-11', 'São Paulo', 'Vila Mariana', 'Rua Afonso Celso', '235', '***'),
('25/02/2022', 'Casa Impressionante', '2022-01-01', '2022-01-10', 'São Paulo', 'Vila Mariana', 'Rua Condillac', '351', '*****'),
('03/04/2022', 'Casa Magnifica', '2022-02-01', '2022-04-01', 'São Paulo', 'Vila Mariana', 'Rua Davi Hume', '212', '****'),
('03/04/2022', 'Casa Mediana', '2022-03-29', '2022-04-02', 'São Paulo', 'Vila Mariana', 'Rua Galofre', '123', '***');

insert into detalhes_anuncio
(ativo_diaria, ativo_semanal, ativo_mensal, valor_diaria, valor_semanal, valor_mensal,
 qtd_dormitorios, qtd_toaletes, garagem, mobiliada)
values
(true, true, false, 1.000, 6.000, 0.0, 7, 2, true, true),
(false, false, true, 0.0, 0.0, 5.000, 10, 3, true, true),
(true, true, true, 2.000, 5.000, 10.000, 8, 2, false, true),
(true, false, false, 3.500, 0.0, 0.0, 7, 2, true, false);