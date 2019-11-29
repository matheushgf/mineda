INSERT INTO mesa (is_open, quantidade_lugares) VALUES (1,1);
INSERT INTO mesa (is_open, quantidade_lugares) VALUES (0,4);
INSERT INTO mesa (is_open, quantidade_lugares) VALUES (0,3);
INSERT INTO mesa (is_open, quantidade_lugares) VALUES (1,2);

INSERT INTO pedido (fechado, quantidade, valor, mesa_id) VALUES (0, 3, 30.0, 4);
INSERT INTO pedido (fechado, quantidade, valor, mesa_id) VALUES (0, 1, 13.5, 1);

INSERT INTO produto (nome, preco, tipo, validade, pedido) VALUES ('Cachorro quente', 13.0, 'alimento', {ts '2019-10-01 18:47:52.69'}, 1);
INSERT INTO produto (nome, preco, tipo, validade, pedido) VALUES ('Cachorro quente', 13.0, 'alimento', {ts '2019-10-01 18:47:52.69'}, 1);
INSERT INTO produto (nome, descricao, preco, tipo, validade, pedido) VALUES ('Refrigerante', '600ml', 4.0, 'bebida', {ts '2021-09-17 18:47:52.69'}, 1);
INSERT INTO produto (nome, descricao, preco, tipo, validade, pedido) VALUES ('X salada', 'completo', 13.50, 'alimento', {ts '2019-10-01 18:47:52.69'}, 2);

INSERT INTO usuario (nome, senha) VALUES
('Matheus', '1234'),
('Mayara', '1234');