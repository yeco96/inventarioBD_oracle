CREATE OR REPLACE PROCEDURE venta_insert (
	   factura VENTA.FACTURA%TYPE,
	   identificacioncliente VENTA.IDENTIFICACIONCLIENTE%TYPE,
       montoventa VENTA.MONTOVENTA%TYPE,
       usuarioregistro VENTA.USUARIOREGISTRO%TYPE)
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
    (CODIGOVENTA, FACTURA, IDENTIFICACIONCLIENTE, MONTOVENTA,FECHAVENTA, USUARIOREGISTRO)
    VALUES (codigoSiguiente,factura, identificacioncliente, montoventa,sysdate,usuarioregistro);

COMMIT;  
END;
/