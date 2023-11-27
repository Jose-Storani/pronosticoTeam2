use pronosticosdb;
INSERT INTO Participante (email, nombre) VALUES
('juanmbrubius@gmail.com', 'Juan Manuel Brios'),
('darinob@hotmail.com', 'Darío Espindola '),
('locura.87@gmail.com', 'Miguel Ohara'),
('martinmb@gmail.com', 'Martin Marino'),
('exequielxintos', 'Exequiel Martinez');


INSERT INTO Equipo (nombre) values
('Argentina'), 
('Brasil'),
('Francia'),
('Alemania'),
('España'),
('Italia');


INSERT INTO Partido (equipo1_id, equipo2_id,resultado, goles_equipo_1, goles_equipo_2  ) VALUES
(1, 2, 'GANA1', 2, 0),
(3, 4, 'EMPATE', 3, 3),
(5, 6, 'GANA2', 1, 3),
(4,6, "GANA1", 3, 1),
(1,5,"GANA1",4,0),
(2,3, "EMPATE",0,0),
(6,2,"GANA2", 2,3),
(1,3,"GANA1", 3,2),
(5,4,"GANA1", 3,2);

INSERT INTO Pronostico (Participante_id, partido_id, resultado_propuesto) values
(1,1,"GANA1"),
(1,2,"GANA2"),
(1,3,"EMPATE"),
(1,4,"EMPATE"),
(1,5,"GANA2"),
(1,6,"GANA1"),
(1,7,"EMPATE"),
(1,8,"GANA2"),
(1,9,"EMPATE"),
(2,1,"GANA1"),
(2,2,"GANA1"),
(2,3,"GANA2"),
(2,4,"GANA2"),
(2,5,"GANA1"),
(2,6,"EMPATE"),
(2,7,"GANA2"),
(2,8,"GANA2"),
(2,9,"EMPATE"),
(3,1,"EMPATE"),
(3,2,"GANA1"),
(3,3,"GANA2"),
(3,4,"GANA2"),
(3,5,"GANA1"),
(3,6,"GANA2"),
(3,7,"GANA2"),
(3,8,"GANA2"),
(3,9,"GANA1"),
(4,1,"EMPATE"),
(4,2,"EMPATE"),
(4,3,"GANA2"),
(4,4,"GANA2"),
(4,5,"GANA2"),
(4,6,"GANA1"),
(4,7,"GANA1"),
(4,8,"GANA2"),
(4,9,"GANA1"),
(5,1,"GANA2"),
(5,2,"GANA1"),
(5,3,"GANA2"),
(5,4,"EMPATE"),
(5,5,"EMPATE"),
(5,6,"GANA2"),
(5,7,"GANA1"),
(5,8,"GANA2"),
(5,9,"GANA1");


INSERT INTO Ronda (numero_ronda,partido_id) values
(1,1),
(1,2),
(1,3),
(2,4),
(2,5),
(2,6),
(3,7),
(3,8),
(3,9);

