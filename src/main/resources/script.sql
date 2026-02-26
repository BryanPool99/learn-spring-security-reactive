CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    roles VARCHAR(255) NOT NULL, -- Guardaremos "ROLE_USER,ROLE_ADMIN"
    enabled BOOLEAN DEFAULT TRUE
);

-- Insertamos un usuario de prueba (La contraseña es '12345' en BCrypt)
INSERT INTO usuarios (username, password, email, roles)
VALUES ('admin', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqRzgVymGe07xd00DMxs.7uqqQOa', 'admin@mail.com', 'ROLE_ADMIN,ROLE_USER');