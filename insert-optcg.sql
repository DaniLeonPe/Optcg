-- Tabla de roles
--CREATE TABLE rols (
--    id int PRIMARY KEY,
--    name VARCHAR(50) NOT NULL UNIQUE
--);

-- Insertar roles
INSERT INTO rols (name)
VALUES
('Administrador'),
('Jugador'),
('Moderador');

-- Tabla de usuarios
--CREATE TABLE usuarios (
--    id_usuario int PRIMARY KEY,
--    nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
--    email VARCHAR(100) NOT NULL UNIQUE,
--    contraseña VARCHAR(255) NOT NULL,
--    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 --   id_rol INT NOT NULL,
 --   FOREIGN KEY (id_rol) REFERENCES roles (id_rol) ON DELETE CASCADE
--);

-- Insertar usuarios
INSERT INTO usuarios (nombre_usuario, email, contraseña, id_rol)
VALUES
('luffy', 'luffy@onepiece.com', 'hashed_password1', 2), -- Jugador
('zoro', 'zoro@onepiece.com', 'hashed_password2', 2), -- Jugador
('nami', 'nami@onepiece.com', 'hashed_password3', 2), -- Jugador
('admin', 'admin@onepiece.com', 'hashed_password4', 1); -- Administrador

-- Tabla de expansiones
--CREATE TABLE expansiones (
--    id_expansion INTEGER PRIMARY KEY,
--    nombre VARCHAR(100) NOT NULL,
--    fecha_lanzamiento DATE
--);

-- Insertar expansiones
INSERT INTO expansiones (nombre, fecha_lanzamiento)
VALUES
('Base Set', '2023-01-01'),
('Expansion 1', '2023-06-01');

-- Tabla de cartas
--CREATE TABLE cartas (
--    id_carta INTEGER PRIMARY KEY,
  --  nombre VARCHAR(100) NOT NULL,
    --tipo VARCHAR(50) NOT NULL,
   -- rareza VARCHAR(20) NOT NULL,
   -- costo INT NOT NULL,
   -- descripcion TEXT,
   -- expansion VARCHAR(50),
   -- imagen_url TEXT,
   -- id_expansion INT,
   -- FOREIGN KEY (id_expansion) REFERENCES expansiones (id_expansion) ON DELETE SET NULL
--);

-- Insertar cartas
INSERT INTO cartas (nombre, tipo, rareza, costo, descripcion, imagen_url, id_expansion)
VALUES
('Monkey D. Luffy', 'Personaje', 'Legendaria', 6, 'El capitán de los Sombreros de Paja con habilidades de Gomu Gomu.', 'http://onepiece.com/luffy.jpg', 1),
('Roronoa Zoro', 'Personaje', 'Épica', 5, 'Espadachín de los Sombreros de Paja con un estilo de tres espadas.', 'http://onepiece.com/zoro.jpg', 1),
('Nami', 'Personaje', 'Rara', 3, 'Navegante de los Sombreros de Paja con habilidades de clima.', 'http://onepiece.com/nami.jpg', 1),
('Gol D. Roger', 'Personaje', 'Legendaria', 7, 'El Rey de los Piratas con habilidades abrumadoras.', 'http://onepiece.com/roger.jpg', 2),
('Thousand Sunny', 'Barco', 'Épica', 4, 'El barco de los Sombreros de Paja.', 'http://onepiece.com/sunny.jpg', 2);

-- Tabla de colecciones
--CREATE TABLE colecciones (
--    id_coleccion INTEGER PRIMARY KEY,
--    id_usuario INT NOT NULL,
-- id_carta INT NOT NULL,
--    cantidad INT DEFAULT 1,
--    FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario) ON DELETE CASCADE,
--    FOREIGN KEY (id_carta) REFERENCES cartas (id_carta) ON DELETE CASCADE
--);

-- Insertar colecciones
INSERT INTO colecciones (id_usuario, id_carta, cantidad)
VALUES
(1, 1, 1), -- Luffy tiene 1 carta de "Monkey D. Luffy"
(2, 2, 2), -- Zoro tiene 2 cartas de "Roronoa Zoro"
(3, 3, 3), -- Nami tiene 3 cartas de "Nami"
(1, 4, 1), -- Luffy tiene 1 carta de "Gol D. Roger"
(2, 5, 1); -- Zoro tiene 1 carta de "Thousand Sunny"

-- Tabla de mazos
--CREATE TABLE mazos (
--    id_mazo INTEGER PRIMARY KEY,
--    id_usuario INT NOT NULL,
--    nombre VARCHAR(100) NOT NULL,
--    descripcion TEXT,
--    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--);

-- Insertar mazos
INSERT INTO mazos (id_usuario, nombre, descripcion)
VALUES
(1, 'Sombreros de Paja', 'Un mazo con los personajes principales de la tripulación.'),
(2, 'Espadachines', 'Mazo centrado en los espadachines del mundo de One Piece.');

-- Tabla de cartas en mazos
--CREATE TABLE mazos_cartas (
--    id_mazo BIGINT NOT NULL,
--    id_carta BIGINT NOT NULL,
 --   cantidad INT DEFAULT 1,
 --   PRIMARY KEY (id_mazo, id_carta),
--    FOREIGN KEY (id_mazo) REFERENCES mazos (id_mazo) ON DELETE CASCADE,
--    FOREIGN KEY (id_carta) REFERENCES cartas (id_carta) ON DELETE CASCADE
--);

-- Insertar cartas en mazos
INSERT INTO mazos_cartas (id_mazo, id_carta, cantidad)
VALUES
(1, 1, 1), -- "Sombreros de Paja" incluye 1 "Monkey D. Luffy"
(1, 3, 1), -- "Sombreros de Paja" incluye 1 "Nami"
(2, 2, 2), -- "Espadachines" incluye 2 "Roronoa Zoro"
(2, 4, 1); -- "Espadachines" incluye 1 "Gol D. Roger"
