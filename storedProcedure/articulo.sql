--insert
CREATE OR REPLACE PROCEDURE articulo_insert (
	   descripcion ARTICULO.DESCRIPCION%TYPE,
	   cantidadMinima	ARTICULO.CANTMINIMA%TYPE)
	 
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
 
COMMIT;  
END;
/

--DELETE	 

--BEGIN 
--DROP PROCEDURE articuloDelete
--END; 



CREATE OR REPLACE PROCEDURE articulo_delete( 
    CODIGOARTICULO ARTICULO.CODIGOARTICULO%TYPE)
AS 
    BEGIN
    DELETE FROM ARTICULOPRECIO where CODIGOARTICULO = CODIGOARTICULO;
    DELETE FROM ARTICULOEXISTENCIA where CODIGOARTICULO = CODIGOARTICULO;
    DELETE FROM ARTICULO WHERE  CODIGOARTICULO = CODIGOARTICULO;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE(SQLCODE || SQLERRM);
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
    codigoArticulo ARTICULO.CODIGOARTICULO%TYPE,
    descripcion ARTICULO.descripcion%TYPE,
    cantMinima ARTICULO.cantMinima%TYPE)
AS 
BEGIN 
UPDATE articulo
SET  codigoArticulo = codigoArticulo,
     descripcion = descripcion, 
     cantMinima = cantMinima
WHERE  codigoArticulo = codigoArticulo;
COMMIT; 
END;
/


-- READ

--BEGIN 
--    DROP PROCEDURE articuloRead
--END 

CREATE OR REPLACE PROCEDURE articulo_Read(
    codigoArticulo ARTICULO.CODIGOARTICULO%TYPE,
    articulo_read OUT SYS_REFCURSOR)
AS 
BEGIN 
 
    OPEN articulo_read for SELECT codigoArticulo, descripcion, cantMinima, fechaCreacion
    FROM   articulo  
    WHERE  (codigoArticulo = codigoArticulo);
COMMIT; 
END;
/


