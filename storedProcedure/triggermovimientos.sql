
CREATE OR REPLACE TRIGGER MOVIMIENTOS
AFTER INSERT OR UPDATE OR DELETE ON ARTICULO 
FOR EACH ROW
BEGIN
IF INSERTING THEN
INSERT INTO MOVIMIENTO (CODIGOMOVIMIENTO, CODIGOARTICULO, CONCEPTO, CANTIDADANTES, CANTIDAD, CANTIDADDESPUES,FECHAREGISTRO,
USUARIOREGISTRO) VALUES (:NEW.CODIGOMOVIMIENTO, :NEW.CODIGOARTICULO, :NEW.CONCEPTO, :NEW.CANTIDADANTES, :NEW.CANTIDAD, 
:NEW.CANTIDADDESPUES, :NEW.FECHAREGISTRO, :NEW.USUARIOREGISTRO);
elsif updating then
INSERT INTO MOVIMIENTO (CODIGOMOVIMIENTO, CODIGOARTICULO, CONCEPTO, CANTIDADANTES, CANTIDAD, CANTIDADDESPUES,FECHAREGISTRO,
USUARIOREGISTRO) VALUES (:old.CODIGOMOVIMIENTO, :old.CODIGOARTICULO, :old.CONCEPTO, :old.CANTIDADANTES, :old.CANTIDAD,
:old.CANTIDADDESPUES, :old.FECHAREGISTRO, :old.USUARIOREGISTRO);
elsif deleting then
INSERT INTO MOVIMIENTO (CODIGOMOVIMIENTO, CODIGOARTICULO, CONCEPTO, CANTIDADANTES, CANTIDAD, CANTIDADDESPUES,FECHAREGISTRO,
USUARIOREGISTRO) VALUES (:old.CODIGOMOVIMIENTO, :old.CODIGOARTICULO, :old.CONCEPTO, :old.CANTIDADANTES, :old.CANTIDAD,
:old.CANTIDADDESPUES, :old.FECHAREGISTRO, :old.USUARIOREGISTRO);
end if;
end MOVIMIENTOS;