
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