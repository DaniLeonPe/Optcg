DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS expansiones;
DROP TABLE IF EXISTS cartas;
DROP TABLE IF EXISTS colecciones;
DROP TABLE IF EXISTS mazos;
DROP TABLE IF EXISTS mazos_cartas;

-- Crear la tabla de roles
CREATE TABLE roles (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    name VARCHAR(255)
);

-- Insertar roles
INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');

-- Crear la tabla de usuarios
CREATE TABLE usuarios (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,  -- Renombrado a id_usuario
    email VARCHAR(255),
    name VARCHAR(255),
    password VARCHAR(255),
    role_id INTEGER,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Insertar usuarios
INSERT INTO usuarios (id, name, email, password, role_id) 
VALUES 
(1, 'Daniel', 'dani1234@gmail.com', '$2a$10$P0fZ.FcD.rBwolLS9P5bAOZETI3K9E5JsiE/NQC82HgkXccYnFvry', 1);

-- Crear la tabla de expansiones
CREATE TABLE expansiones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- Renombrado a id_expansion
    nombre VARCHAR(100) NOT NULL,
    fecha_lanzamiento DATE
);

-- Insertar expansiones
INSERT INTO expansiones (nombre, fecha_lanzamiento)
VALUES
('Base Set', '2023-01-01'),
('Expansion 1', '2023-06-01');

-- Crear la tabla de cartas
CREATE TABLE cartas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- Renombrado a id_carta
    nombre VARCHAR(100) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    rareza VARCHAR(20) NOT NULL,
    costo INT NOT NULL,
    descripcion TEXT,
    imagen_url TEXT,
    id_expansion INT,  -- Relación con expansiones
    FOREIGN KEY (id_expansion) REFERENCES expansiones (id_expansion) ON DELETE SET NULL
);

-- Insertar cartas
INSERT INTO cartas (nombre, tipo, rareza, costo, descripcion, imagen_url, id_expansion)
VALUES
('Monkey D. Luffy', 'Personaje', 'Legendaria', 6, 'El capitán de los Sombreros de Paja con habilidades de Gomu Gomu.', 'http://onepiece.com/luffy.jpg', 1),
('Roronoa Zoro', 'Personaje', 'Épica', 5, 'Espadachín de los Sombreros de Paja con un estilo de tres espadas.', 'http://onepiece.com/zoro.jpg', 1),
('Nami', 'Personaje', 'Rara', 3, 'Navegante de los Sombreros de Paja con habilidades de clima.', 'http://onepiece.com/nami.jpg', 1),
('Gol D. Roger', 'Personaje', 'Legendaria', 7, 'El Rey de los Piratas con habilidades abrumadoras.', 'http://onepiece.com/roger.jpg', 2),
('Thousand Sunny', 'Barco', 'Épica', 4, 'El barco de los Sombreros de Paja.', 'http://onepiece.com/sunny.jpg', 2);

-- Crear la tabla de colecciones
CREATE TABLE colecciones (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- Renombrado a id_coleccion
    id_usuario INT NOT NULL,  -- Renombrado a id_usuario
    id_carta INT NOT NULL,    -- Renombrado a id_carta
    cantidad INT DEFAULT 1,
    FOREIGN KEY (id_usuario) REFERENCES usuarios (id_usuario),  -- Relación con usuarios
    FOREIGN KEY (id_carta) REFERENCES cartas (id_carta)          -- Relación con cartas
);

-- Insertar colecciones
INSERT INTO colecciones (id_usuario, id_carta, cantidad)
VALUES
(1, 1, 1), -- Luffy tiene 1 carta de "Monkey D. Luffy"
(1, 4, 1); -- Luffy tiene 1 carta de "Gol D. Roger"


-- Crear la tabla de mazos
CREATE TABLE mazos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,  -- Renombrado a id_mazo
    id_usuario INT NOT NULL,  -- Renombrado a id_usuario
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    fecha_creacion DATE DEFAULT CURRENT_DATE,  -- Renombrado a fecha_creacion
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)  -- Relación con usuarios
);

-- Insertar mazos
INSERT INTO mazos (id_usuario, nombre, descripcion)
VALUES
(1, 'Sombreros de Paja', 'Un mazo con los personajes principales de la tripulación.');

-- Crear la tabla de cartas en mazos
CREATE TABLE mazos_cartas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_mazo INT NOT NULL,  -- Renombrado a id_mazo
    id_carta INT NOT NULL, -- Renombrado a id_carta
    cantidad INT DEFAULT 1,
    FOREIGN KEY (id_mazo) REFERENCES mazos (id_mazo),
    FOREIGN KEY (id_carta) REFERENCES cartas (id_carta)
);

-- Insertar cartas en mazos
INSERT INTO mazos_cartas (id_mazo, id_carta, cantidad)
VALUES
(1, 1, 1), -- "Sombreros de Paja" incluye 1 "Monkey D. Luffy"
(1, 3, 1), -- "Sombreros de Paja" incluye 1 "Nami"
(2, 2, 2), -- "Espadachines" incluye 2 "Roronoa Zoro"
(2, 4, 1); -- "Espadachines" incluye 1 "Gol D. Roger"
