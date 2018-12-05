CREATE TABLE `animal` (
  `ani_codigo` int(11) NOT NULL,
  `ani_nome` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `animal` (`ani_codigo`, `ani_nome`) VALUES
(1, 'cachorro'),
(2, 'gato'),
(3, 'papagaio'),
(4, 'cavalo');


CREATE TABLE `ficha` (
  `fch_codigo` int(11) NOT NULL,
  `fch_ativo` bit(1) DEFAULT NULL,
  `fch_dt_cadastro` datetime DEFAULT NULL,
  `fch_observacao` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE `ficha_animais` (
  `fch_codigo` int(11) NOT NULL,
  `ani_codigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `animal`
  ADD PRIMARY KEY (`ani_codigo`);


ALTER TABLE `ficha`
  ADD PRIMARY KEY (`fch_codigo`);


ALTER TABLE `ficha_animais`
  ADD KEY `FK_isjgrivcyx83at7v8mk842b2o` (`fch_codigo`),
  ADD KEY `UK_mo5x9lgt97pui6vqbw6k6xupf` (`ani_codigo`) USING BTREE;


ALTER TABLE `animal`
  MODIFY `ani_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;


ALTER TABLE `ficha`
  MODIFY `fch_codigo` int(11) NOT NULL AUTO_INCREMENT;


ALTER TABLE `ficha_animais`
  ADD CONSTRAINT `FK_isjgrivcyx83at7v8mk842b2o` FOREIGN KEY (`fch_codigo`) REFERENCES `ficha` (`fch_codigo`),
  ADD CONSTRAINT `FK_mo5x9lgt97pui6vqbw6k6xupf` FOREIGN KEY (`ani_codigo`) REFERENCES `animal` (`ani_codigo`);
COMMIT;

