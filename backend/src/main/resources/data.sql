INSERT INTO mesa (is_open, quantidade_lugares) VALUES (1,1);
INSERT INTO mesa (is_open, quantidade_lugares) VALUES (0,4);
INSERT INTO mesa (is_open, quantidade_lugares) VALUES (0,3);
INSERT INTO mesa (is_open, quantidade_lugares) VALUES (1,2);


INSERT INTO produto (nome, preco, tipo, validade) VALUES ('Cachorro quente', 13.0, 'alimento', {ts '2019-10-01 18:47:52.69'});
INSERT INTO produto (nome, preco, tipo, validade) VALUES ('Cachorro quente', 13.0, 'alimento', {ts '2019-10-01 18:47:52.69'});
INSERT INTO produto (nome, descricao, preco, tipo, validade) VALUES ('Refrigerante', '600ml', 4.0, 'bebida', {ts '2021-09-17 18:47:52.69'});
INSERT INTO produto (nome, descricao, preco, tipo, validade) VALUES ('X salada', 'completo', 13.50, 'alimento', {ts '2019-10-01 18:47:52.69'});

INSERT INTO pedido ( fechado, quantidade, produto_id, valor, mesa_id) VALUES ( 0, 3, 1, 13.0, 4);
INSERT INTO pedido ( fechado, quantidade, produto_id, valor, mesa_id) VALUES ( 0, 1, 1, 13.0, 1);
