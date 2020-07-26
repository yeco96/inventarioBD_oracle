create table inventario.articulos
(codigoArticulo NUMBER(9,0), descripcion VARCHAR2(40 BYTE), cantMinima NUMBER(6,0), fechaCreacion DATE,
CONSTRAINT codigoArticulo_PK PRIMARY KEY (codigoArticulo));

create table inventario.articuloPrecio
(codigoArticulo NUMBER(9,0), precio NUMBER(6,0), tarifaImpuesto NUMBER(6,0), porcentajeUtilidad NUMBER(6,0), montoCosto NUMBER(9,0),
CONSTRAINT codigoArticulo_FK FOREIGN KEY (codigoArticulo)
  REFERENCES inventario.articulos (codigoArticulo) ENABLE);
  
