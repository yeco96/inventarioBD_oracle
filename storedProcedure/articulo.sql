--insert
CREATE OR REPLACE PROCEDURE usp_insertArticulo (
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

--DELETE	 

--BEGIN 
--DROP PROCEDURE articuloDelete
--END; 

CREATE OR REPLACE PROCEDURE articuloDelete( 
    @CODIGOARTICULO ARTICULO.CODIGOARTICULO%TYPE)
AS 
BEGIN 
DELETE
FROM   articulo
WHERE  CODIGOARTICULO = @CODIGOARTICULO
 
END


--UPDATE

--BEGIN 
--DROP PROCEDURE codigoArticulo_Update
--END 

CREATE OR REPLACE PROCEDURE codigoArticulo_Update(
    @codigoArticulo ARTICULO.CODIGOARTICULO%TYPE,
    @descripcion ARTICULO.descripcion%TYPE(40 BYTE),
    @cantMinima ARTICULO.cantMinima%TYPE,
    @fechaCreacion ARTICULO.fechaCreacion%TYPE)
AS 
BEGIN 
 
UPDATE articulo
SET  codigoArticulo = @codigoArticulo,
     descripcion = @descripcion, 
     cantMinima = @cantMinima,
     fechaCreacion = @fechaCreacion
WHERE  codigoArticulo = @codigoArticulo
END


-- READ

--BEGIN 
--    DROP PROCEDURE articuloRead
--END 

CREATE OR REPLACE PROCEDURE articuloRead(
    @codigoArticulo ARTICULO.CODIGOARTICULO%TYPE)
AS 
BEGIN 
 
    SELECT codigoArticulo, descripcion, cantMinima, fechaCreacion
    FROM   articulo  
    WHERE  (codigoArticulo = @codigoArticulo) 
END


