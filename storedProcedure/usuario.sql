SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE  usuario_loggin
(P_USUARIO IN USUARIO.USUARIO%TYPE,
P_CONTRASENA IN USUARIO.CONTRASENA%TYPE,
P_RESULT OUT VARCHAR2)
IS
resultado int;
BEGIN

SELECT count(*) into resultado FROM USUARIO WHERE USUARIO=P_USUARIO
AND CONTRASENA=P_CONTRASENA;

if(resultado = 1) then
P_RESULT := '';
else
P_RESULT := 'El usuario o la contraseņo no coinciden';
end if;

END usuario_loggin;