DROP TABLE IF EXISTS finances_dev.tb_produtos CASCADE;
DROP TABLE IF EXISTS finances_dev.tb_detalhes_negociacao CASCADE;

-- TB_PRODUTOS --
CREATE TABLE finances_dev.tb_produtos
(
    id_produto serial NOT NULL,
    nm_produto text   NOT NULL,
    descricao  text,
    CONSTRAINT prod_pk PRIMARY KEY (id_produto)
);
CREATE INDEX in_prod_nm_produto on finances_dev.tb_produtos USING btree (nm_produto);

-- TB_DETALHES_NEGOCIACAO_PRODUTOS --
CREATE TABLE finances_dev.tb_detalhes_negociacao
(
    id_detalhes_negociacao serial    NOT NULL,
    id_produto             integer   NOT NULL,
    preco_estimado         numeric   NOT NULL,
    preco_final            numeric,
    tp_negociacao          text      NOT NULL,
    dh_estimada_negociacao timestamp,
    dh_final_negociacao    timestamp,
    dh_criacao             timestamp NOT NULL,
    CONSTRAINT dene_pk PRIMARY KEY (id_detalhes_negociacao),
    CONSTRAINT dene_id_produto_fk FOREIGN KEY (id_produto) references finances_dev.tb_produtos (id_produto)
);
CREATE INDEX in_dene_preco_estimado on finances_dev.tb_detalhes_negociacao USING btree (preco_estimado);
CREATE INDEX in_dene_preco_final on finances_dev.tb_detalhes_negociacao USING btree (preco_final);
CREATE INDEX in_dene_tp_negociacao on finances_dev.tb_detalhes_negociacao USING btree (tp_negociacao);
CREATE INDEX in_dene_dh_criacao on finances_dev.tb_detalhes_negociacao USING btree (dh_criacao);