--insert
CREATE OR REPLACE PROCEDURE proveedor_insert (
	   NOMBRE	PROVEEDOR.NOMBRE%TYPE
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
COMMIT;  
END;
/
--DELETE	 


CREATE OR REPLACE PROCEDURE proveedor_delete( 
    CODIGOPROVEEDOR PROVEEDOR.CODIGOPROVEEDOR%TYPE)
AS 
BEGIN 
DELETE
FROM   PROVEEDOR
WHERE  CODIGOPROVEEDOR = CODIGOPROVEEDOR;
COMMIT; 
END;
/
--UPDATE

CREATE OR REPLACE PROCEDURE proveedor_update(
    CODIGOPROVEEDOR PROVEEDOR.CODIGOPROVEEDOR%TYPE,
    NOMBRE PROVEEDOR.NOMBRE%TYPE)
AS 
BEGIN 
 
UPDATE PROVEEDOR
SET  CODIGOPROVEEDOR = CODIGOPROVEEDOR,
     NOMBRE = NOMBRE
WHERE  CODIGOPROVEEDOR = CODIGOPROVEEDOR;
COMMIT; 
END;
/

-- READ

CREATE OR REPLACE PROCEDURE proveedor_Read(
    CODIGOPROVEEDOR PROVEEDOR.CODIGOPROVEEDOR%TYPE,
    proveedor_Read OUT SYS_REFCURSOR)
AS 
BEGIN 
 
    OPEN proveedor_Read for SELECT CODIGOPROVEEDOR, NOMBRE, FECHAINGRESO
    FROM   PROVEEDOR  
    WHERE  (CODIGOPROVEEDOR = CODIGOPROVEEDOR);
COMMIT; 
END;
/
