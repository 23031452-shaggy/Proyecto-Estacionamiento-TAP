DROP DATABASE adminestacionamiento;
CREATE DATABASE AdminEstacionamiento;
USE AdminEstacionamiento;

CREATE TABLE Estacionamientos (
    id_estacionamiento INT AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    Ubicacion VARCHAR(100) NOT NULL,
    CONSTRAINT EstacionamientosPK PRIMARY KEY (id_estacionamiento)
);

CREATE TABLE Lugares (
    id_lugar int NOT NULL,
    id_estacionamiento INT NOT NULL,
    esta_ocupado BOOLEAN DEFAULT FALSE,
    CONSTRAINT LugaresPK PRIMARY KEY (id_lugar, id_estacionamiento),
    CONSTRAINT LugaresFK FOREIGN KEY (id_estacionamiento) REFERENCES Estacionamientos(id_estacionamiento)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Personas (
    noCont INT NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    hashPass VARCHAR(300),
    telefono VARCHAR (15),
    CONSTRAINT PersonasPK PRIMARY KEY (noCont)
);


CREATE TABLE Vehiculos (
    placa VARCHAR(15) NOT NULL,
    noCont INT NOT NULL,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    color VARCHAR(30),
    CONSTRAINT VehiculosPK PRIMARY KEY (placa),
    CONSTRAINT VehiculosFK FOREIGN KEY (noCont) REFERENCES Personas(noCont)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Registros (
    id_registro BIGINT AUTO_INCREMENT,
    placa_vehiculo VARCHAR(15) NOT NULL,
    id_lugar int NOT NULL,
    id_estacionamiento INT NOT NULL,
    
    fecha_hora_entrada DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    fecha_hora_salida DATETIME NULL,
    CONSTRAINT RegistrosPK PRIMARY KEY (id_registro),
    CONSTRAINT RegistrosFK1 FOREIGN KEY (placa_vehiculo) REFERENCES Vehiculos(placa),
    CONSTRAINT RegistrosFK2 FOREIGN KEY (id_lugar, id_estacionamiento) REFERENCES Lugares(id_lugar, id_estacionamiento)
);