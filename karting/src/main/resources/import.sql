INSERT INTO KART (id, centimetros_cubicos, descripcion, edad_minima, nombre, potencia, precio_sesion, velocidad_maxima, img_url) VALUES (NEXTVAL('hibernate_sequence'),50.2,'La experiencia de conduccion perfecta para los más chicos',8,'Junior',12,10,40,'https://i.imgur.com/sVmhmxd.jpg');
INSERT INTO KART (id, centimetros_cubicos, descripcion, edad_minima, nombre, potencia, precio_sesion, velocidad_maxima, img_url) VALUES (NEXTVAL('hibernate_sequence'),150,'Siente la potencia de un motor de dos tiempos de 150 centímetros cúbicos',15,'Senior',28,14,68,'https://i.imgur.com/bhsJLdj.jpg');
INSERT INTO KART (id, centimetros_cubicos, descripcion, edad_minima, nombre, potencia, precio_sesion, velocidad_maxima, img_url) VALUES (NEXTVAL('hibernate_sequence'),275,'Karts federados con los reglajes usados en el campeonato español, para los amantes de la adrenalina',18,'Competicion',45,16,85,'https://i.imgur.com/SiY3ojx.jpg');

INSERT INTO PILOTO (dni, nombre, apellidos, email, fecha_nacimiento) VALUES ('54219289D','Alvaro','Franco Martínez','alvaro@gmail.com','1995-11-14');
INSERT INTO PILOTO (dni, nombre, apellidos, email, fecha_nacimiento) VALUES ('58792129D','Pablo','Franco Martínez','pablo@gmail.com','2001-06-01');
INSERT INTO PILOTO (dni, nombre, apellidos, email, fecha_nacimiento) VALUES ('12323674A','Jose Antonio','Espinal','jose@gmail.com','1996-08-12');
INSERT INTO PILOTO (dni, nombre, apellidos, email, fecha_nacimiento) VALUES ('98237421Q','Miguel Angel','Bailón','miguel@gmail.com','1996-04-22');
INSERT INTO PILOTO (dni, nombre, apellidos, email, fecha_nacimiento) VALUES ('23542345E','Alejandro','Gonzalez','ale@gmail.com','1995-09-12');

INSERT INTO SESION (id, fecha_reserva, fecha_sesion, precio, kart_id) VALUES (NEXTVAL('hibernate_sequence'), '2022-04-27T10:38:54', '2022-05-02T12:30:00', 40, 2);

INSERT INTO PARTICIPACION (sesion_id, piloto_dni, precio) VALUES (4, '54219289D', (SELECT precio_sesion FROM kart WHERE id=(SELECT kart_id FROM sesion WHERE id=4)));
INSERT INTO PARTICIPACION (sesion_id, piloto_dni, precio) VALUES (4, '12323674A', (SELECT precio_sesion FROM kart WHERE id=(SELECT kart_id FROM sesion WHERE id=4)));
INSERT INTO PARTICIPACION (sesion_id, piloto_dni, precio) VALUES (4, '98237421Q', (SELECT precio_sesion FROM kart WHERE id=(SELECT kart_id FROM sesion WHERE id=4)));
INSERT INTO PARTICIPACION (sesion_id, piloto_dni, precio) VALUES (4, '23542345E', (SELECT precio_sesion FROM kart WHERE id=(SELECT kart_id FROM sesion WHERE id=4)));

INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 1, 72312000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 2, 72312000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 3, 72312000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 4, 72312000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 5, 72312000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 6, 72302000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 7, 72312000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '54219289D', 8, 72312000000);

INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 1, 72412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 2, 72412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 3, 72412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 4, 72412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 5, 72412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 6, 72412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 7, 72404000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '12323674A', 8, 72412000000);

INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 1, 73412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 2, 73412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 3, 73412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 4, 73412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 5, 73412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 6, 73412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 7, 73312000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '98237421Q', 8, 73212000000);

INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 1, 74372000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 2, 71412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 3, 74412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 4, 74412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 5, 74412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 6, 74412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 7, 74412000000);
INSERT INTO VUELTA (participacion_sesion_id, participacion_piloto_dni, numero_vuelta, tiempo) VALUES (4, '23542345E', 8, 74812000000);