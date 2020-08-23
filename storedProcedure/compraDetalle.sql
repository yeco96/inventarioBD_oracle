CREATE OR REPLACE PROCEDURE compraDetalle_insert (
	   codigocompra COMPRADETALLE.CODIGOCOMPRA%TYPE,
	   codigoarticulo COMPRADETALLE.CODIGOARTICULO%TYPE,
       cantidadcompra COMPRADETALLE.CANTIDADCOMPRA%TYPE,
       montocosto COMPRADETALLE.MONTOCOSTO%TYPE)
AS

BEGIN

INSERT INTO COMPRADETALLE  
    (CODIGOCOMPRA, CODIGOARTICULO, CANTIDADCOMPRA, MONTOCOSTO)
    VALUES (codigocompra,codigoarticulo, cantidadcompra, montocosto);

COMMIT;  
END;
/