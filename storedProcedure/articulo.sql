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


