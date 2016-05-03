INSERT INTO faculty (name, date_register, date_update, state_id, campus_id) VALUES 
('Agronomía', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Artes', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Ciencias', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Física', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Biología', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Geociencias', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Matemáticas', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Estadística', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Deparmamento de Farmacia', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Química', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Instituto de Ciencias Naturales', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Observatorio Astronómico', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Ciencias Económicas', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Ciencias Humanas', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Antropología', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Filosofía', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Geografía', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Historia', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Lenguas Extranjeras', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Lingüística', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Literatura', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Psicología', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Sociología', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Departamento de Trabajo Social', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Escuela Estudios en Psicoanálisis y Cultura', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Escuela de Estudios de Género ', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Derecho, Ciencias Políticas y Sociales', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Enfermería', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Ingeniería', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Medicina', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Medicina Veterinaria y Zootecnia', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá')),
('Odontología', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Bogotá'));

INSERT INTO faculty (name, date_register, date_update, state_id, campus_id) VALUES 
('Ciencias Humanas y Económicas', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Medellín')),
('Ciencias Agropecuarias', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Medellín')),
('Arquitectura', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Medellín')),
('Ciencias', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Medellín')),
('Minas', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Medellín'));

INSERT INTO faculty (name, date_register, date_update, state_id, campus_id) VALUES 
('Ingeniería y Arquitectura', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Manizalez')),
('Ciencias y Administración', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Manizalez'));

INSERT INTO faculty (name, date_register, date_update, state_id, campus_id) VALUES 
('Ciencias Agropecuarias', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Palmira')),
('Ingeniería y Administración ', NOW(), NOW(), 1, (SELECT id FROM campus WHERE name ='Palmira'));
