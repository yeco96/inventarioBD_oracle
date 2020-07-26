create table inventario.articulos
(codigoArticulo NUMBER(9,0), descripcion VARCHAR2(40 BYTE), cantMinima NUMBER(6,0), fechaCreacion DATE,
CONSTRAINT codigoArticulo_PK PRIMARY KEY (codigoArticulo));

create table inventario.Proveedor
(codigoProveedor NUMBER(6,0), nombre VARCHAR2(20 BYTE), fechaIngreso DATE);

create table inventario.Usuario
(usuario VARCHAR2(20 BYTE), nombre VARCHAR2(20 BYTE), contrasena password);

create table inventario.articuloPrecio
(codigoArticulo NUMBER(9,0), precio NUMBER(6,0), tarifaImpuesto NUMBER(6,0), porcentajeUtilidad NUMBER(6,0), montoCosto NUMBER(9,0),
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);
  
create table inventario.articuloExistencia
(codigoArticulo NUMBER(9,0), existencia NUMBER(6,0),
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);

create table inventario.Compras
(codigoCompra NUMBER(9,0), factura NUMBER(9,0), codigoProveedor number (6,0), montoCompra NUMBER(9,0), fechaCompra Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT codigoCompra_PK PRIMARY KEY (codigoCompra),
CONSTRAINT codigoProveedor_FK FOREIGN KEY (codigoProveedor)
  REFERENCES inventario.Proveedor (codigoProveedor) ENABLE,
CONSTRAINT usuarioRegistro_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);

  
create table inventario.ComprasDetalle 
(codigoCompra NUMBER(9,0),codigoArticulo NUMBER(9,0), cantidadCompra NUMBER(6,0), montoCosto NUMBER(9,0),
CONSTRAINT codigoCompra_FK FOREIGN KEY (codigoCompra)
  REFERENCES inventario.Compras (codigoCompra) ENABLE,
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);
  
create table inventario.Ventas  
(codigoVenta NUMBER(9,0), factura NUMBER(9,0), identificacionCliente NUMBER(9,0), montoVenta NUMBER(9,0),fechaVenta Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT codigoVenta_PK PRIMARY KEY (codigoVenta),
CONSTRAINT usuarioRegistro_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);
  
create table inventario.VentasDetalle 
(codigoVenta NUMBER(9,0),codigoArticulo NUMBER(9,0), precio NUMBER(6,0),
CONSTRAINT codigoVenta_FK FOREIGN KEY (codigoVenta)
  REFERENCES inventario.Ventas (codigoVenta) ENABLE,
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);
  
create table inventario.Movimientos
(codigoArticulo NUMBER(9,0), concepto varchar2 (20 BYTE), cantidadAntes number(6,0), cantidad number(6,0), cantidadDespues number(6,0), fechaRegistro Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE,
 CONSTRAINT usuarioRegistro_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);
  