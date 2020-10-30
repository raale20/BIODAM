INSERT INTO PRODUCTO (ID, NOMBRE, PRECIO, ESTADO)
VALUES (NEXTVAL('hibernate_sequence'), 'Manzanas',3.4, TRUE);

INSERT INTO PRODUCTO (ID, NOMBRE, PRECIO, ESTADO)
VALUES (NEXTVAL('hibernate_sequence'), 'Sandía',10.99, TRUE);

INSERT INTO PRODUCTO (ID, NOMBRE, PRECIO, ESTADO)
VALUES (NEXTVAL('hibernate_sequence'), 'Brocoli',3.4, FALSE);

INSERT INTO USUARIO(ID, NOMBRE, APELLIDOS, EMAIL, PASSWORD, ESADMIN) --Será el admin
VALUES ((NEXTVAL('hibernate_sequence'), 'Manuel', 'Fernández Romero', ferroma20@biodam.com, 'ferro20', TRUE);

INSERT INTO USUARIO(ID, NOMBRE, APELLIDOS, EMAIL, PASSWORD, ESADMIN) --Será una cuenta a denegar por el admin
VALUES ((NEXTVAL('hibernate_sequence'), 'Luis', 'Tomillo Pérez', 'girls333@nospam.com', 'girls20', FALSE);

INSERT INTO USUARIO(ID, NOMBRE, APELLIDOS, EMAIL, PASSWORD, ESADMIN) --Será una cuenta a aceptar por el admin
VALUES ((NEXTVAL('hibernate_sequence'), 'Andrea', 'Martínez Sánchez', 'marsaan36@gmail.com', 'marsa36', FALSE);