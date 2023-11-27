SELECT
    Partido.partido_id,
    Equipo1.nombre AS nombre_equipo1,
    Equipo2.nombre as nombre_equipo2,
    Partido.goles_equipo_1,
    Partido.goles_equipo_2,
    Partido.resultado
FROM
    Partido
JOIN
    Equipo AS Equipo1 ON Partido.equipo1_id = Equipo1.equipo_id
JOIN
	Equipo AS Equipo2 ON Partido.equipo2_id = Equipo2.equipo_id;
    
    
    SELECT
    Ronda.numero_ronda,
    Partido.partido_id,
    Equipo1.nombre AS nombre_equipo1,
    Equipo2.nombre AS nombre_equipo2,
    Partido.resultado
FROM
    Ronda
JOIN
    Partido ON Ronda.partido_id = Partido.partido_id
JOIN
    Equipo AS Equipo1 ON Partido.equipo1_id = Equipo1.equipo_id
JOIN
    Equipo AS Equipo2 ON Partido.equipo2_id = Equipo2.equipo_id
WHERE
    Ronda.numero_ronda = 1;