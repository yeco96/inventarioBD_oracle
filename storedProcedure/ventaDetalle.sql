CREATE OR REPLACE PROCEDURE ventaDetalle_insert (
	   codigoventavar VENTADETALLE.CODIGOVENTA%TYPE,
	   codigoarticulovar VENTADETALLE.CODIGOARTICULO%TYPE,
       preciovar VENTADETALLE.PRECIO%TYPE,
       P_RESULT OUT VARCHAR2)
AS

BEGIN

INSERT INTO VENTADETALLE  
    (CODIGOVENTA, CODIGOARTICULO, PRECIO)
    VALUES (codigoventavar,codigoarticulovar, preciovar);

P_RESULT := 'Correcto';  

EXCEPTION
  WHEN OTHERS THEN
    P_RESULT := SQLCODE || SQLERRM;  


COMMIT;  
END;
/