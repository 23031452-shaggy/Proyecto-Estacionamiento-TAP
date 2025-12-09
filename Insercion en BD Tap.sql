USE AdminEstacionamiento;

INSERT INTO Estacionamientos (nombre, Ubicacion) VALUES 
('Estacionamiento A', 'Junto al edificio de idiomas'),
('Estacionamiento B', 'En frente del edificio de sistemas'),
('Estacionamiento C', 'Alrededor del Centro de las artes');

DELIMITER $$
CREATE PROCEDURE LlenarLugares()
BEGIN
    DECLARE i INT;
    SET i = 1;
    WHILE i <= 50 DO
        INSERT INTO Lugares (id_lugar, id_estacionamiento, esta_ocupado) VALUES (i, 1, FALSE);
        SET i = i + 1;
    END WHILE;

    SET i = 1;
    WHILE i <= 30 DO
        INSERT INTO Lugares (id_lugar, id_estacionamiento, esta_ocupado) VALUES (i, 2, FALSE);
        SET i = i + 1;
    END WHILE;

    SET i = 1;
    WHILE i <= 40 DO
        INSERT INTO Lugares (id_lugar, id_estacionamiento, esta_ocupado) VALUES (i, 3, FALSE);
        SET i = i + 1;
    END WHILE;
END$$
DELIMITER ;

CALL LlenarLugares();
DROP PROCEDURE LlenarLugares;

INSERT INTO Personas (noCont, nombre, hashPass, telefono) VALUES 
(11101, 'Arturo Leon Hurtado', SHA1('Alh'), '461 234 7982'),
(11102, 'Diego Mendoza Caballero', SHA1('Dmc'), '461 127 0373'),
(11103, 'Sofia Martinez Lopez', SHA1('1234'), '461 555 1001'),
(11104, 'Jorge Ramirez Soto', SHA1('1234'), '461 555 2002'),
(11105, 'Lucia Fernandez Gil', SHA1('1234'), '461 555 3003'),
(11106, 'Miguel Angel Torres', SHA1('1234'), '461 555 4004'),
(11107, 'Elena Gomez Paz', SHA1('1234'), '461 555 5005'),
(11108, 'Roberto Diaz Ruiz', SHA1('1234'), '461 555 6006'),
(11109, 'Ana Karen Vega', SHA1('1234'), '461 555 7007'),
(11110, 'Carlos Ruiz Zafon', SHA1('1234'), '461 555 8008');

INSERT INTO Vehiculos (placa, noCont, marca, modelo, color) VALUES 
('GTO-100', 11101, 'Nissan', 'Versa', 'Rojo'),
('QRO-999', 11101, 'Honda', 'Civic', 'Negro'),
('GTO-200', 11102, 'Chevrolet', 'Aveo', 'Blanco'),
('GTO-301', 11103, 'Volkswagen', 'Jetta', 'Plata'),
('GTO-302', 11103, 'Ford', 'Fiesta', 'Azul'),
('GTO-400', 11104, 'Mazda', 'Mazda 3', 'Gris'),
('GTO-500', 11105, 'Toyota', 'Corolla', 'Blanco'),
('GTO-601', 11106, 'Nissan', 'Sentra', 'Arena'),
('GTO-602', 11106, 'Jeep', 'Renegade', 'Verde'),
('GTO-700', 11107, 'Kia', 'Rio', 'Rojo'),
('GTO-800', 11108, 'BMW', 'Serie 3', 'Negro'),
('GTO-901', 11109, 'Audi', 'A3', 'Blanco'),
('GTO-902', 11109, 'Mini', 'Cooper', 'Amarillo'),
('GTO-110', 11110, 'Hyundai', 'Accent', 'Azul');