--insert
CREATE OR REPLACE PROCEDURE articulo_insert (
	   descripcion ARTICULO.DESCRIPCION%TYPE,
	   cantidadMinima	ARTICULO.CANTMINIMA%TYPE, P_RESULT OUT VARCHAR2)
	 
IS
codigoSiguiente int;
BEGIN

SELECT MAX(CODIGOARTICULO) into codigoSiguiente FROM ARTICULO;

if codigoSiguiente is null then
codigoSiguiente := 1;
ELSE
codigoSiguiente := codigoSiguiente + 1;
end if;

INSERT INTO ARTICULO  
    (CODIGOARTICULO, DESCRIPCION, CANTMINIMA, FECHACREACION)
    VALUES (codigoSiguiente,descripcion,cantidadMinima,sysdate);
    
INSERT INTO ARTICULOPRECIO 
(CODIGOARTICULO, PRECIO, TARIFAIMPUESTO, PORCENTAJEUTILIDAD, MONTOCOSTO)    
VALUES (codigoSiguiente, 0, 0, 0, 0);

INSERT INTO ARTICULOEXISTENCIA 
(CODIGOARTICULO, EXISTENCIA)
VALUES (codigoSiguiente, 0);
 

P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  

COMMIT;  
END;
/

--DELETE	 

--BEGIN 
--DROP PROCEDURE articuloDelete
--END; 



CREATE OR REPLACE PROCEDURE articulo_delete( 
    CODIGOARTICULOVar ARTICULO.CODIGOARTICULO%TYPE, P_RESULT OUT VARCHAR2)
AS 
    BEGIN
    DELETE FROM ARTICULOPRECIO where CODIGOARTICULO = CODIGOARTICULOVar;
    DELETE FROM ARTICULOEXISTENCIA where CODIGOARTICULO = CODIGOARTICULOVar;
    DELETE FROM ARTICULO WHERE  CODIGOARTICULO = CODIGOARTICULOVar;


P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  

COMMIT; 
END;
/


declare
begin
ARTICULO_DELETE(8);
end;
--UPDATE

--BEGIN 
--DROP PROCEDURE codigoArticulo_Update
--END 

CREATE OR REPLACE PROCEDURE articulo_update(
    codigoArticuloVar ARTICULO.CODIGOARTICULO%TYPE,
    descripcionVar ARTICULO.descripcion%TYPE,
    cantMinimaVar ARTICULO.cantMinima%TYPE, 
    P_RESULT OUT VARCHAR2)
AS 
BEGIN 
UPDATE articulo
SET  descripcion = descripcionVar, 
     cantMinima = cantMinimaVar
WHERE  codigoArticulo = codigoArticuloVar;
COMMIT; 

P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  

END;
/


-- READ

--BEGIN 
--    DROP PROCEDURE articuloRead
--END 

CREATE OR REPLACE PROCEDURE articulo_Read(codigoArticuloVar ARTICULO.CODIGOARTICULO%TYPE, articulo_read OUT SYS_REFCURSOR, P_RESULT OUT VARCHAR2)
AS 
BEGIN 

    if codigoArticuloVar <> 0  then
    OPEN articulo_read for SELECT a.codigoArticulo, a.descripcion, a.cantMinima, a.fechaCreacion, P.PRECIO, P.PORCENTAJEUTILIDAD, P.TARIFAIMPUESTO, P.MONTOCOSTO, AE.EXISTENCIA
    FROM   articulo a inner join ARTICULOPRECIO p on a.CODIGOARTICULO = P.CODIGOARTICULO inner join ARTICULOEXISTENCIA ae on A.CODIGOARTICULO = AE.CODIGOARTICULO where a.codigoArticulo = codigoArticuloVar;
    else
    OPEN articulo_read for  SELECT a.codigoArticulo, a.descripcion, a.cantMinima, a.fechaCreacion, P.PRECIO, P.PORCENTAJEUTILIDAD, P.TARIFAIMPUESTO, P.MONTOCOSTO, AE.EXISTENCIA
    FROM   articulo a inner join ARTICULOPRECIO p on a.CODIGOARTICULO = P.CODIGOARTICULO inner join ARTICULOEXISTENCIA ae on A.CODIGOARTICULO = AE.CODIGOARTICULO order by codigoArticulo;
    end if;
 



P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  

COMMIT; 
END;
/


--insert
CREATE OR REPLACE PROCEDURE proveedor_insert (
	   NOMBRE	PROVEEDOR.NOMBRE%TYPE, P_RESULT OUT VARCHAR2
      )
	 
IS
codigoSiguiente int;
BEGIN

SELECT MAX(CODIGOPROVEEDOR) into codigoSiguiente FROM PROVEEDOR;

if codigoSiguiente is null then
codigoSiguiente := 1;
ELSE
codigoSiguiente := codigoSiguiente + 1;
end if;

INSERT INTO PROVEEDOR  
    (CODIGOPROVEEDOR, NOMBRE, FECHAINGRESO)
    VALUES (codigoSiguiente,NOMBRE,sysdate);  

P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM; 

COMMIT;  
END;
/
--DELETE	 
create or replace PROCEDURE proveedor_delete( 
    codigoVar PROVEEDOR.CODIGOPROVEEDOR%TYPE,
    P_RESULT OUT VARCHAR2)
AS 
BEGIN 
DELETE
FROM   PROVEEDOR
WHERE  CODIGOPROVEEDOR = codigoVar;

P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM; 

COMMIT; 
END;

/
--UPDATE

create or replace PROCEDURE proveedor_update(
    codigoVar PROVEEDOR.CODIGOPROVEEDOR%TYPE,
    nombreVar PROVEEDOR.NOMBRE%TYPE,
    P_RESULT OUT VARCHAR2)
AS 
BEGIN 

UPDATE PROVEEDOR
SET NOMBRE = nombreVar
WHERE  CODIGOPROVEEDOR = codigoVar;

P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  

COMMIT; 
END;
/

-- READ
create or replace PROCEDURE proveedor_Read(codigoVar PROVEEDOR.CODIGOPROVEEDOR%TYPE, proveedor_Read OUT SYS_REFCURSOR, P_RESULT OUT VARCHAR2)
AS 
BEGIN 
    
    if codigoVar <> 0  then
    OPEN proveedor_Read for SELECT CODIGOPROVEEDOR, NOMBRE, FECHAINGRESO
    FROM   PROVEEDOR where CODIGOPROVEEDOR = codigoVar;
    else
    OPEN proveedor_Read for SELECT CODIGOPROVEEDOR, NOMBRE, FECHAINGRESO
    FROM   PROVEEDOR order by CODIGOPROVEEDOR;
    end if;

    P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  

COMMIT; 
END;
/

CREATE OR REPLACE PROCEDURE compra_insert (
     facturavar COMPRA.FACTURA%TYPE,
     codigoproveedorvar COMPRA.CODIGOPROVEEDOR%TYPE,
       montocompravar COMPRA.MONTOCOMPRA%TYPE,
       usuarioregistrovar COMPRA.USUARIOREGISTRO%TYPE,
       P_RESULT OUT VARCHAR2)
IS
codigoSiguiente int;
codprovee number;
resultado int;
BEGIN

SELECT MAX(CODIGOCOMPRA) into codigoSiguiente FROM COMPRA;
SELECT count(*) into resultado FROM PROVEEDOR WHERE CODIGOPROVEEDOR=codigoproveedorvar;


if codigoSiguiente is null then
codigoSiguiente := 1;
ELSE
codigoSiguiente := codigoSiguiente + 1;
end if;

if(resultado = 1) then
P_RESULT := '';
else
P_RESULT := 'El Proveedor no existe';
end if;

INSERT INTO COMPRA  
    (CODIGOCOMPRA, FACTURA, CODIGOPROVEEDOR, MONTOCOMPRA,FECHACOMPRA, USUARIOREGISTRO)
    VALUES (codigoSiguiente,facturavar, codigoproveedorvar, montocompravar,sysdate,usuarioregistrovar);

P_RESULT := 'codigoSiguiente:' || codigoSiguiente;  

COMMIT;  
END;
/

CREATE OR REPLACE PROCEDURE compraDetalle_insert (
	   codigocompraVar COMPRADETALLE.CODIGOCOMPRA%TYPE,
	   codigoarticuloVar COMPRADETALLE.CODIGOARTICULO%TYPE,
       cantidadcompraVar COMPRADETALLE.CANTIDADCOMPRA%TYPE,
       MONTOCOSTOVar COMPRADETALLE.MONTOCOSTO%TYPE,
       fechaVencimientoVar COMPRADETALLE.fechaVencimiento%TYPE,
       P_RESULT OUT VARCHAR2)
AS

BEGIN

INSERT INTO COMPRADETALLE  
    (CODIGOCOMPRA, CODIGOARTICULO, CANTIDADCOMPRA, MONTOCOSTO, fechaVencimiento)
    VALUES (codigocompraVar,codigoarticuloVar, cantidadcompraVar, MONTOCOSTOVar, fechaVencimientoVar);

COMMIT;  
END;
/



SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE  usuario_loggin
(P_USUARIO IN USUARIO.USUARIO%TYPE,
P_CONTRASENA IN USUARIO.CONTRASENA%TYPE,
P_RESULT OUT VARCHAR2)
IS
resultado int;
BEGIN

SELECT count(*) into resultado FROM USUARIO WHERE USUARIO=P_USUARIO
AND CONTRASENA=P_CONTRASENA;

if(resultado = 1) then
P_RESULT := '';
else
P_RESULT := 'El usuario o la contraseño no coinciden';
end if;

END usuario_loggin;




CREATE OR REPLACE PROCEDURE venta_insert (
	   identificacionclienteVar VENTA.IDENTIFICACIONCLIENTE%TYPE,
       nombreClienteVar VENTA.NOMBRECLIENTE%TYPE,
       montoventaVar VENTA.MONTOVENTA%TYPE,
       usuarioregistroVar VENTA.USUARIOREGISTRO%TYPE,
       P_RESULT OUT VARCHAR2)
IS
codigoSiguiente int;
BEGIN

SELECT MAX(CODIGOVENTA) into codigoSiguiente FROM VENTA;

if codigoSiguiente is null then
codigoSiguiente := 1;
ELSE
codigoSiguiente := codigoSiguiente + 1;
end if;

INSERT INTO VENTA  
    (CODIGOVENTA, FACTURA, IDENTIFICACIONCLIENTE,NOMBRECLIENTE, MONTOVENTA,FECHAVENTA, USUARIOREGISTRO)
    VALUES (codigoSiguiente,codigoSiguiente, identificacionclienteVar, nombreClienteVar, montoventaVar,sysdate,usuarioregistroVar);
    
P_RESULT := 'codigoSiguiente:' || codigoSiguiente;  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  


COMMIT;  
END;
/

CREATE OR REPLACE PROCEDURE ventaDetalle_insert (
	   codigoventavar VENTADETALLE.CODIGOVENTA%TYPE,
	   codigoarticulovar VENTADETALLE.CODIGOARTICULO%TYPE,
       cantidadVar VENTADETALLE.CANTIDAD%TYPE,
       preciovar VENTADETALLE.PRECIO%TYPE,
       P_RESULT OUT VARCHAR2)
AS

BEGIN

INSERT INTO VENTADETALLE  
    (CODIGOVENTA, CODIGOARTICULO, PRECIO, CANTIDAD)
    VALUES (codigoventavar,codigoarticulovar, preciovar, cantidadVar);
    
update ARTICULOEXISTENCIA set EXISTENCIA = (EXISTENCIA - cantidadVar) where CODIGOARTICULO = codigoarticulovar;

P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  


COMMIT;  
END;
/


