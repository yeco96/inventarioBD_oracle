drop table Usuario;
drop table articuloPrecio;
drop table articuloExistencia;
drop table articulo;
drop table Proveedor;
drop table inventario.CompraDetalle;
drop table Compra;
drop table VentaDetalle;
drop table Venta;
drop table Movimiento;


create table inventario.articulo
(codigoArticulo int, descripcion VARCHAR2(40 BYTE), cantMinima NUMBER(18,3), fechaCreacion DATE,
CONSTRAINT codigoArticulo_PK PRIMARY KEY (codigoArticulo));

create table inventario.Proveedor
(codigoProveedor int, nombre VARCHAR2(20 BYTE), fechaIngreso DATE,
CONSTRAINT codigoProveedor_PK PRIMARY KEY (codigoProveedor));

create table inventario.Usuario
(usuario VARCHAR2(20 BYTE), nombre VARCHAR2(20 BYTE), contrasena VARCHAR2(20 BYTE),
CONSTRAINT usuario_PK PRIMARY KEY (usuario));

create table inventario.articuloPrecio
(codigoArticulo int, precio NUMBER(18,3), tarifaImpuesto NUMBER(5,3), porcentajeUtilidad NUMBER(5,3), montoCosto NUMBER(18,3),
CONSTRAINT articuloPrecio_PK PRIMARY KEY (codigoArticulo),
CONSTRAINT codigoArticulo_arti_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulo (codigoArticulo) ENABLE);
  
create table inventario.articuloExistencia
(codigoArticulo int, existencia NUMBER(18,3),
CONSTRAINT articuloExistencia_PK PRIMARY KEY (codigoArticulo),
CONSTRAINT articulo_articuloExistencia_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulo (codigoArticulo) ENABLE);

create table inventario.Compra
(codigoCompra int, factura NUMBER(20,0), codigoProveedor int, montoCompra NUMBER(18,3), fechaCompra Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT compra_PK PRIMARY KEY (codigoCompra),
CONSTRAINT compra_proveedor_FK FOREIGN KEY (codigoProveedor)
  REFERENCES inventario.Proveedor (codigoProveedor) ENABLE,
CONSTRAINT compra_usuario_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);

  
create table inventario.CompraDetalle 
(codigoCompra int,codigoArticulo int, cantidadCompra NUMBER(18,3), montoCosto NUMBER(18,3),fechaVencimiento Date,
CONSTRAINT CompraDetalle_PK PRIMARY KEY (codigoCompra, codigoArticulo),
CONSTRAINT CompraDetalle_compra_FK FOREIGN KEY (codigoCompra)
  REFERENCES inventario.Compra (codigoCompra) ENABLE,
CONSTRAINT codigoArticulo_compra_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulo (codigoArticulo) ENABLE);
 
  
create table inventario.Venta 
(codigoVenta int, factura NUMBER(20,0), identificacionCliente NUMBER(12,0), nombreCliente varchar2(100), montoVenta NUMBER(18,3),fechaVenta Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT Venta_PK PRIMARY KEY (codigoVenta),
CONSTRAINT usuarioRegistro_Venta_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);
  
create table inventario.VentaDetalle 
(codigoVenta int, codigoArticulo int, cantidad int, precio  NUMBER(18,3),
CONSTRAINT VentaDetalle_PK PRIMARY KEY (codigoVenta, codigoArticulo),
CONSTRAINT codigoVenta_detalle_FK FOREIGN KEY (codigoVenta)
  REFERENCES inventario.Venta (codigoVenta) ENABLE,
CONSTRAINT codigoArticulo_venta_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulo (codigoArticulo) ENABLE);
  
create table inventario.Movimiento
(codigoMovimiento int,codigoArticulo int, concepto varchar2 (20 BYTE), cantidadAntes NUMBER(18,3), cantidad NUMBER(18,3), cantidadDespues NUMBER(18,3), fechaRegistro Date, usuarioRegistro varchar2(20 BYTE),
CONSTRAINT Movimiento_PK PRIMARY KEY (codigoMovimiento),
CONSTRAINT codigoArticulo_Movimiento_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulo (codigoArticulo) ENABLE,
 CONSTRAINT usuarioRegistro_Movimiento_FK FOREIGN KEY (usuarioRegistro)
  REFERENCES inventario.Usuario (usuario) ENABLE);
  


insert into Usuario values('yeco', 'Yeison', '123' );
insert into Usuario values('gmena', 'Yeison', '123' );