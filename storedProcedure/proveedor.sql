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

create or replace PROCEDURE proveedor_Read(proveedor_Read OUT SYS_REFCURSOR, P_RESULT OUT VARCHAR2)
AS 
BEGIN 

    OPEN proveedor_Read for SELECT CODIGOPROVEEDOR, NOMBRE, FECHAINGRESO
    FROM   PROVEEDOR;

    P_RESULT := 'Correcto';  

COMMIT; 
END;
/
