insert into regiones (id, nombre) values (1, 'centroamerica');
insert into regiones (id, nombre) values (2, 'norteamerica');
insert into regiones (id, nombre) values (3, 'sudaamerica');
insert into regiones (id, nombre) values (4, 'europa');
insert into regiones (id, nombre) values (5, 'asia');
insert into regiones (id, nombre) values (6, 'africa');
insert into regiones (id, nombre) values (7, 'oceania');
insert into regiones (id, nombre) values (8, 'antartida');


insert into clientes (region_id, nombre, apellido, email, create_at) values(2, 'Ivan','Moreno','ivanmoreno@sinbad.com','2020-08-03');
insert into clientes (region_id, nombre, apellido, email, create_at) values(1, 'carlos','Moreno','carlos@sinbad.com','2020-03-08');
insert into clientes (region_id, nombre, apellido, email, create_at) values(4, 'bolt','cafe','boltcafe@sinbad.com','2020-11-03');
insert into clientes (region_id, nombre, apellido, email, create_at) values(4, 'rocke','blanco','rockeblanco@sinbad.com','2020-11-08');
insert into clientes (region_id, nombre, apellido, email, create_at) values(5, 'blue','azul','blue@sinbad.com','2020-06-03');
insert into clientes (region_id, nombre, apellido, email, create_at) values(3, 'green','verde','green@sinbad.com','2020-09-03');

insert into usuarios (username, password, enabled, nombre, apellido, email) values ('benq', '$2a$10$pZdha0D7yZRYn3AsOz1rR.DEVU.K7QLTlCXprYtrxmfSgomT1VIZS', 1, 'BEn Q', 'Q2', 'ben@q.com');
insert into usuarios (username, password, enabled, nombre, apellido, email) values ('admin', '$2a$10$hFUrZSpA0lzgeL/lkRoaj.U4KNZkBWp8RdicY2tT7UpSN6/VNrtwa', 1, 'Rocket', 'RO', 'rocket@q.com');

insert into roles (nombre) values ('ROLE_USER');
insert into roles (nombre) values ('ROLE_ADMIN');

insert into usuarios_roles (usuario_id, role_id) values (1, 1);
insert into usuarios_roles (usuario_id, role_id) values (2, 2);
insert into usuarios_roles (usuario_id, role_id) values (2, 1);
