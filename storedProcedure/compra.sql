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

