CREATE SEQUENCE SUPER_ANDES_SEQUENCE;

CREATE TABLE PRODUCTOS(
ID NUMBER,
NOMBRE VARCHAR2(256 BYTE) NOT NULL,
MARCA VARCHAR2(64) NOT NULL,
PRECIO_UNITARIO NUMBER NOT NULL,
TAMANO NUMBER NOT NULL,
UNIDADES VARCHAR2(3) NOT NULL,
VOL_EMPAQUE NUMBER NOT NULL,
PESO_EMPAQUE NUMBER NOT NULL,
HEXA VARCHAR(255) NOT NULL,
PRESENTACION VARCHAR2(64) NOT NULL,
PRECIO_POR_UNIDAD NUMBER NOT NULL,
CATEGORIA VARCHAR2(64) NOT NULL,
CONSTRAINT PRODUCTOS_PK PRIMARY KEY(ID),
CONSTRAINT CHK_Producto CHECK (CATEGORIA  IN('Perecedero','No Perecedero','Abarrote','Limpieza','Higiene')));


CREATE TABLE SUCURSAL(
ID NUMBER,
NOMBRE VARCHAR2(20),
CIUDAD VARCHAR2(32) NOT NULL,
DIRECCION VARCHAR2(128) NOT NULL UNIQUE,
SEGMENTO_MERCADO VARCHAR2(32) NOT NULL,
CONSTRAINT SUCURSAL_PK PRIMARY KEY(ID),
CONSTRAINT CHK_Sucursal CHECK (CIUDAD  IN ('Bogota','Medellin','Cali')));

CREATE TABLE BODEGA(
ID NUMBER,
CAPACIDAD_VOL NUMBER NOT NULL,
CAPACIDAD_PESO NUMBER NOT NULL,
CATEGORIA VARCHAR2(16) NOT NULL,
ID_SUCURSAL NUMBER NOT NULL,
CONSTRAINT BODEGA_PK PRIMARY KEY(ID),
CONSTRAINT FK_Sucursal FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL(ID));

CREATE TABLE ESTANTE(
ID NUMBER,
CAPACIDAD_VOL NUMBER NOT NULL,
CAPACIDAD_PESO NUMBER NOT NULL,
CATEGORIA VARCHAR2(16) NOT NULL,
POSICION NUMBER NOT NULL,
NIVEL_ABASTECIMIENTO NUMBER NOT NULL,
ID_SUCURSAL NUMBER NOT NULL,
CONSTRAINT ESTANTE_PK PRIMARY KEY(ID),
CONSTRAINT FK_Sucursal1 FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL(ID));

CREATE TABLE PROVEEDOR(
NIT NUMBER,
NOMBRE VARCHAR2(64) NOT NULL,
CALIFICACION NUMBER NOT NULL,
CONSTRAINT PROVEEDOR_PK PRIMARY KEY(NIT));

CREATE TABLE ORDEN_DE_COMPRA(
ID NUMBER,
FECHA_ESTIMADA_ENTREGA DATE NOT NULL,
ENTREGADO NUMBER(1) NOT NULL,
CALIFICACION NUMBER NOT NULL,
FECHA_ENTREGA DATE,
ID_PROVEEDOR NUMBER NOT NULL,
ID_SUCURSAL NUMBER NOT NULL,
CONSTRAINT ORDEN_DE_COMPRA_PK PRIMARY KEY(ID),
CONSTRAINT FK_Sucursa12 FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL(ID),
CONSTRAINT FK_Proveedor FOREIGN KEY (ID_PROVEEDOR)
REFERENCES PROVEEDOR(NIT));

CREATE TABLE CLIENTE(
ID NUMBER,
IDENTIFICACION NUMBER NOT NULL UNIQUE,
NOMBRE VARCHAR2(32) NOT NULL,
CORREO VARCHAR2(40) NOT NULL UNIQUE,
DIRECCION VARCHAR2(128) NOT NULL ,
CONSTRAINT CLIENTE_PK PRIMARY KEY(ID));

CREATE TABLE EMPLEADO(
ID NUMBER,
IDENTIFICACION NUMBER NOT NULL UNIQUE,
NOMBRE VARCHAR2(32) NOT NULL,
CORREO VARCHAR2(40) NOT NULL UNIQUE,
DIRECCION VARCHAR2(128) NOT NULL ,
ROL VARCHAR(32),
CONSTRAINT EMPLEADO_PK PRIMARY KEY(ID),
CONSTRAINT CHK_ROL CHECK(ROL IN('Administrador', 'Cajero')));

CREATE TABLE COMPRA(
ID NUMBER,
PRECIO_TOTAL NUMBER NOT NULL,
PAGADA NUMBER(1) NOT NULL,
FECHA DATE NOT NULL,
ID_CLIENTE NUMBER NOT NULL,
ID_SUCURSAL NUMBER NOT NULL,
CONSTRAINT COMPRA_PK PRIMARY KEY(ID),
CONSTRAINT FK_Cliente FOREIGN KEY (ID_CLIENTE)
REFERENCES CLIENTE(ID),
CONSTRAINT FK_Sucursal2 FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL(ID));

CREATE TABLE FACTURA(
NUMERO_SERIE NUMBER,
ID_COMPRA NUMBER NOT NULL,
CONSTRAINT FACTURA_PK PRIMARY KEY(NUMERO_SERIE),
CONSTRAINT FK_Compra FOREIGN KEY (ID_COMPRA)
REFERENCES COMPRA(ID));

CREATE TABLE BODEGA_PRODUCTO(
ID_PRODUCTO NUMBER,
ID_BODEGA NUMBER,
CANTIDAD NUMBER NOT NULL,
CONSTRAINT BODEGA_PRODUCTO_PK PRIMARY KEY(ID_PRODUCTO, ID_BODEGA),
CONSTRAINT FK_Producto FOREIGN KEY (ID_PRODUCTO)
REFERENCES PRODUCTOS(ID),
CONSTRAINT FK_Bodega FOREIGN KEY (ID_BODEGA)
REFERENCES BODEGA(ID));

CREATE TABLE ESTANTE_PRODUCTO(
ID_PRODUCTO NUMBER,
ID_ESTANTE NUMBER,
CANTIDAD NUMBER NOT NULL,
CONSTRAINT ESTANTE_PRODUCTO_PK PRIMARY KEY(ID_PRODUCTO, ID_ESTANTE),
CONSTRAINT FK_Producto1 FOREIGN KEY (ID_PRODUCTO)
REFERENCES PRODUCTOS(ID),
CONSTRAINT FK_Estante FOREIGN KEY (ID_ESTANTE)
REFERENCES ESTANTE(ID));

CREATE TABLE ORDEN_DE_COMPRA_PRODUCTO(
ID_ORDEN_DE_COMPRA NUMBER,
ID_PRODUCTO NUMBER,
PRECIO_ACORDADO NUMBER NOT NULL,
VOLUMEN NUMBER NOT NULL,
CONSTRAINT ORDEN_COMPRA_PRODUCTO_PK PRIMARY KEY(ID_ORDEN_DE_COMPRA, ID_PRODUCTO),
CONSTRAINT FK_Producto2 FOREIGN KEY (ID_PRODUCTO)
REFERENCES PRODUCTOS(ID),
CONSTRAINT FK_Orden_de_compra FOREIGN KEY (ID_ORDEN_DE_COMPRA)
REFERENCES ORDEN_DE_COMPRA(ID));

CREATE TABLE PRODUCTO_COMPRA(
ID_COMPRA NUMBER,
ID_PRODUCTO NUMBER,
CANTIDAD NUMBER NOT NULL,
CONSTRAINT PRODUCTO_COMPRA_PK PRIMARY KEY(ID_COMPRA, ID_PRODUCTO),
CONSTRAINT FK_Compra2 FOREIGN KEY (ID_COMPRA)
REFERENCES COMPRA(ID),
CONSTRAINT FK_Producto3 FOREIGN KEY (ID_PRODUCTO)
REFERENCES PRODUCTOS(ID));

CREATE TABLE PROVEEDOR_PRODUCTO(
ID_PROVEEDOR NUMBER,
ID_PRODUCTO NUMBER,
CONSTRAINT PROVEEDOR_PRODUCTO_PK PRIMARY KEY(ID_PROVEEDOR, ID_PRODUCTO),
CONSTRAINT FK_Producto4 FOREIGN KEY (ID_PRODUCTO)
REFERENCES PRODUCTOS(ID),
CONSTRAINT FK_Proveedor1 FOREIGN KEY (ID_PROVEEDOR)
REFERENCES PROVEEDOR(NIT));

CREATE TABLE SUCURSAL_PRODUCTO(
ID_SUCURSAL NUMBER,
ID_PRODUCTO NUMBER,
PRECIO NUMBER NOT NULL,
NIVEL_REORDEN NUMBER NOT NULL,
CONSTRAINT SUCURSAL_PRODUCTO_PK PRIMARY KEY (ID_SUCURSAL, ID_PRODUCTO),
CONSTRAINT FK_Sucursal4 FOREIGN KEY (ID_SUCURSAL)
REFERENCES SUCURSAL(ID),
CONSTRAINT FK_Producto5 FOREIGN KEY (ID_PRODUCTO)
REFERENCES PRODUCTOS(ID));

CREATE TABLE PROMOCIONES(
ID NUMBER,
DESCRIPCION VARCHAR(32) NOT NULL,
FECHAINICIO DATE NOT NULL,
FECHAFINAL DATE NOT NULL,
PRECIO NUMBER NOT NULL,
CONSTRAINT PROMOCION_PK PRIMARY KEY(ID));

CREATE TABLE PROMOCION_PRODUCTO(
IDPROMOCION NUMBER,
IDPRODUCTO NUMBER,
CONSTRAINT PROMOCION_PRODUCTO_PK PRIMARY KEY(IDPROMOCION, IDPRODUCTO),
CONSTRAINT FK_PROMOCION FOREIGN KEY(IDPROMOCION)
REFERENCES PROMOCIONES(ID),
CONSTRAINT FK_PRODUCTO6 FOREIGN KEY (IDPRODUCTO)
REFERENCES PRODUCTOS(ID));

CREATE TABLE CARRITOS(
ID NUMBER,
IDCLIENTE NUMBER,
IDSUCURSAL NUMBER,
CONSTRAINT CARRITO_PK PRIMARY KEY(ID),
CONSTRAINT FK_CLIENTE2 FOREIGN KEY(IDCLIENTE)
REFERENCES CLIENTE(ID),
CONSTRAINT FK_SUCURSAL22 FOREIGN KEY(IDSUCURSAL)
REFERENCES SUCURSAL(ID));

CREATE TABLE CARRITO_PRODUCTO(
IDCARRITO NUMBER,
IDPRODUCTO NUMBER,
CANTIDAD NUMBER NOT NULL,
CONSTRAINT CARRITO_PRODUCTO_PK PRIMARY KEY(IDCARRITO, IDPRODUCTO),
CONSTRAINT FK_CARRITO FOREIGN KEY (IDCARRITO)
REFERENCES CARRITOS(ID),
CONSTRAINT FK_PRODUCTO80 FOREIGN KEY (IDPRODUCTO)
REFERENCES PRODUCTOS(ID));


COMMIT;
