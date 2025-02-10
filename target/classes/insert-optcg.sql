DROP TABLE IF EXISTS rols;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS expansiones;
DROP TABLE IF EXISTS cartas;
DROP TABLE IF EXISTS colecciones;
DROP TABLE IF EXISTS mazos;
DROP TABLE IF EXISTS mazos_cartas;

-- Tabla de roles
CREATE TABLE rols (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(50) NOT NULL UNIQUE
);

-- Insertar roles
INSERT INTO rols (name)
VALUES
('ROLE_ADMIN'),
('ROLE_USER');

-- Tabla de usuarios
CREATE TABLE usuarios (
    idUsuario INTEGER PRIMARY KEY AUTOINCREMENT,
    nombreUsuario VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    contraseña VARCHAR(255) NOT NULL,
    fechaRegistro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    idRol INT NOT NULL,
    FOREIGN KEY (idRol) REFERENCES rols (id) 
);

-- Insertar usuarios
INSERT INTO usuarios (nombreUsuario, email, contraseña, idRol)
VALUES
('luffy', 'luffy@onepiece.com', '$2a$10$P0fZ.FcD.rBwolLS9P5bAOZETI3K9E5JsiE/NQC82HgkXccYnFvry', 2), -- Jugador
('zoro', 'zoro@onepiece.com', '$2a$10$P0fZ.FcD.rBwolLS9P5bAOZETI3K9E5JsiE/NQC82HgkXccYnFvry', 2), -- Jugador
('nami', 'nami@onepiece.com', '$2a$10$P0fZ.FcD.rBwolLS9P5bAOZETI3K9E5JsiE/NQC82HgkXccYnFvry', 2), -- Jugador
('admin', 'admin@onepiece.com', '$2a$10$P0fZ.FcD.rBwolLS9P5bAOZETI3K9E5JsiE/NQC82HgkXccYnFvry', 1); -- Administrador

-- Tabla de expansiones
CREATE TABLE expansiones (
    idExpansion INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre VARCHAR(100) NOT NULL,
    fechaLanzamiento DATE
);

-- Insertar expansiones
INSERT INTO expansiones (nombre, fechaLanzamiento)
VALUES
('Base Set', '2023-01-01'),
('Expansion 1', '2023-06-01');

-- Tabla de cartas
CREATE TABLE cartas (
    idCarta INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    rareza VARCHAR(20) NOT NULL,
    costo INT NOT NULL,
    descripcion TEXT,
    expansion VARCHAR(50),
    imagen_url TEXT,
    idExpansion INT,
    FOREIGN KEY (idExpansion) REFERENCES expansiones (idExpansion) ON DELETE SET NULL
);

-- Insertar cartas
INSERT INTO cartas (nombre, tipo, rareza, costo, descripcion, imagen_url, idExpansion)
VALUES
('Monkey D. Luffy', 'Personaje', 'Legendaria', 6, 'El capitán de los Sombreros de Paja con habilidades de Gomu Gomu.', 'http://onepiece.com/luffy.jpg', 1),
('Roronoa Zoro', 'Personaje', 'Épica', 5, 'Espadachín de los Sombreros de Paja con un estilo de tres espadas.', 'http://onepiece.com/zoro.jpg', 1),
('Nami', 'Personaje', 'Rara', 3, 'Navegante de los Sombreros de Paja con habilidades de clima.', 'http://onepiece.com/nami.jpg', 1),
('Gol D. Roger', 'Personaje', 'Legendaria', 7, 'El Rey de los Piratas con habilidades abrumadoras.', 'http://onepiece.com/roger.jpg', 2),
('Thousand Sunny', 'Barco', 'Épica', 4, 'El barco de los Sombreros de Paja.', 'http://onepiece.com/sunny.jpg', 2);

-- Tabla de colecciones
CREATE TABLE colecciones (
    idColeccion INTEGER PRIMARY KEY AUTOINCREMENT,
    idUsuario INT NOT NULL,
    idCarta INT NOT NULL,
    cantidad INT DEFAULT 1,
    FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario) ,
    FOREIGN KEY (idCarta) REFERENCES cartas (idCarta) 
);

-- Insertar colecciones
INSERT INTO colecciones (idUsuario, idCarta, cantidad)
VALUES
(1, 1, 1), -- Luffy tiene 1 carta de "Monkey D. Luffy"
(2, 2, 2), -- Zoro tiene 2 cartas de "Roronoa Zoro"
(3, 3, 3), -- Nami tiene 3 cartas de "Nami"
(1, 4, 1), -- Luffy tiene 1 carta de "Gol D. Roger"
(2, 5, 1); -- Zoro tiene 1 carta de "Thousand Sunny"

-- Tabla de mazos
CREATE TABLE mazos (
    idMazo INTEGER PRIMARY KEY AUTOINCREMENT,
    idUsuario INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertar mazos
INSERT INTO mazos (idUsuario, nombre, descripcion)
VALUES
(1, 'Sombreros de Paja', 'Un mazo con los personajes principales de la tripulación.'),
(2, 'Espadachines', 'Mazo centrado en los espadachines del mundo de One Piece.');

-- Tabla de cartas en mazos
CREATE TABLE mazos_cartas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    idMazo BIGINT NOT NULL,
    idCarta BIGINT NOT NULL,
    cantidad INT DEFAULT 1,
    FOREIGN KEY (idMazo) REFERENCES mazos (idMazo) ,
    FOREIGN KEY (idCarta) REFERENCES cartas (idCarta) 
);

-- Insertar cartas en mazos
INSERT INTO mazos_cartas (idMazo, idCarta, cantidad)
VALUES
(1, 1, 1), -- "Sombreros de Paja" incluye 1 "Monkey D. Luffy"
(1, 3, 1), -- "Sombreros de Paja" incluye 1 "Nami"
(2, 2, 2), -- "Espadachines" incluye 2 "Roronoa Zoro"
(2, 4, 1); -- "Espadachines" incluye 1 "Gol D. Roger"
