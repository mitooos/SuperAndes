SELECT * FROM cliente WHERE ID IN (SELECT UNIQUE ID_CLIENTE FROM compra WHERE FECHA >= '01/01/2018' AND FECHA <= '21/01/2018' AND ID IN (SELECT ID_COMPRA FROM producto_compra WHERE ID_PRODUCTO = 1))
