create table inventario.articulos
(codigoArticulo int, descripcion VARCHAR2(40 BYTE), cantMinima NUMBER(18,3), fechaCreacion DATE,
CONSTRAINT codigoArticulo_PK PRIMARY KEY (codigoArticulo));

create table inventario.Proveedor
(codigoProveedor int, nombre VARCHAR2(20 BYTE), fechaIngreso DATE,
CONSTRAINT codigoProveedor_PK PRIMARY KEY (codigoProveedor));

create table inventario.Usuario
(usuario VARCHAR2(20 BYTE), nombre VARCHAR2(20 BYTE), contrasena password,
CONSTRAINT usuario_PK PRIMARY KEY (usuario));

create table inventario.articuloPrecio
(codigoArticulo int, precio NUMBER(18,3), tarifaImpuesto NUMBER(5,3), porcentajeUtilidad NUMBER(5,3), montoCosto NUMBER(18,3),
CONSTRAINT codigoCompra_PK PRIMARY KEY (codigoArticulo),
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);
  
create table inventario.articuloExistencia
(codigoArticulo int, existencia NUMBER(18,3),
CONSTRAINT codigoCompra_PK PRIMARY KEY (codigoArticulo),
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);

create table inventario.Compras
(codigoCompra int, factura NUMBER(20,0), codigoProveedor int, montoCompra NUMBER(18,3), fechaCompra Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT codigoCompra_PK PRIMARY KEY (codigoCompra),
CONSTRAINT codigoProveedor_FK FOREIGN KEY (codigoProveedor)
  REFERENCES inventario.Proveedor (codigoProveedor) ENABLE,
CONSTRAINT usuarioRegistro_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);

  
create table inventario.ComprasDetalle 
(codigoCompra int,codigoArticulo int, cantidadCompra NUMBER(18,3), montoCosto NUMBER(18,3),
CONSTRAINT codigoVenta_PK PRIMARY KEY (codigoCompra, codigoArticulo),
CONSTRAINT codigoCompra_FK FOREIGN KEY (codigoCompra)
  REFERENCES inventario.Compras (codigoCompra) ENABLE,
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);
  
create table inventario.Ventas  
(codigoVenta int, factura NUMBER(20,0), identificacionCliente NUMBER(12,0), montoVenta NUMBER(18,3),fechaVenta Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT codigoVenta_PK PRIMARY KEY (codigoVenta),
CONSTRAINT usuarioRegistro_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);
  
create table inventario.VentasDetalle 
(codigoVenta int, codigoArticulo int, precio  NUMBER(18,3),
CONSTRAINT codigoVenta_PK PRIMARY KEY (codigoVenta, codigoArticulo),
CONSTRAINT codigoVenta_FK FOREIGN KEY (codigoVenta)
  REFERENCES inventario.Ventas (codigoVenta) ENABLE,
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);
  
create table inventario.Movimientos
(codigoMovimiento int,codigoArticulo int, concepto varchar2 (20 BYTE), cantidadAntes NUMBER(18,3), cantidad NUMBER(18,3), cantidadDespues NUMBER(18,3), fechaRegistro Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT codigoVenta_PK PRIMARY KEY (codigoMovimiento),
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE,
 CONSTRAINT usuarioRegistro_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);
  