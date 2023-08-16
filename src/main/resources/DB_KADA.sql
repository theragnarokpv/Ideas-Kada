/*Se crea la base de datos */
drop schema if exists dbkada;
drop user if exists usuario_admin;
CREATE SCHEMA dbkada;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_admin'@'%' identified by 'Clave_admin';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on dbkada.* to 'usuario_admin'@'%';
flush privileges;

/* la tabla de categoria contiene categorias de productos*/
create table dbkada.categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  activo bool,
  PRIMARY KEY (id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table dbkada.producto (
  id_producto INT NOT NULL AUTO_INCREMENT,
  id_categoria INT NOT NULL,
  descripcion VARCHAR(100) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_producto),
  foreign key fk_producto_categoria (id_categoria) references categoria(id_categoria)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE dbkada.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(512) NOT NULL,
  nombre VARCHAR(20) NOT NULL,
  apellidos VARCHAR(30) NOT NULL,
  correo VARCHAR(25) NULL,
  telefono VARCHAR(15) NULL,
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table dbkada.factura (
  id_factura INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  fecha date,  
  total double,
  estado int,
  PRIMARY KEY (id_factura),
  foreign key fk_factura_usuario (id_usuario) references usuario(id_usuario)  
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table dbkada.rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol),
  foreign key fk_rol_usuario (id_usuario) references usuario(id_usuario)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table dbkada.tipo (
  id_tipo INT NOT NULL AUTO_INCREMENT,
  descripcion varchar(20),
  activo bool,
  PRIMARY KEY (id_tipo)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

create table dbkada.pedido (
  id_pedido INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  pedido INT NOT NULL,
  descripcion varchar(1000),
  telefono varchar(10),
  correo_elec varchar(100),
  ruta_imagen varchar(1024),
  activo boolean,
  PRIMARY KEY (id_pedido),
  foreign key fk_pedido_tipo (pedido) references tipo(id_tipo)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO dbkada.usuario (id_usuario, username,password,nombre, apellidos, correo, telefono,ruta_imagen,activo) VALUES 
(1,'Carito','$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.','Carolina', 'Castillo Monge',    'ccastillo@gmail.com',    '8888-8888', 'https://img.freepik.com/free-photo/portrait-beautiful-young-woman-standing-grey-wall_231208-10760.jpg',true),
(2,'DSolis','$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi','David',  'Solis Vazques', 'dsolis@gmail.com', '7777-7777','https://img.freepik.com/free-photo/portrait-handsome-young-man-with-crossed-arms_176420-15569.jpg?w=2000',true),
(3,'pedro','$2a$10$koGR7eS22Pv5KdaVJKDcge04ZB53iMiw76.UjHPY.XyVYlYqXnPbO','Pedro', 'Mena Loria',     'lmena@gmail.com',      '7898-8936','https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eduardo_de_Pedro_2019.jpg/480px-Eduardo_de_Pedro_2019.jpg?20200109230854',true);

/*Se insertan 3 categorias de productos como ejemplo */
INSERT INTO dbkada.categoria (id_categoria,descripcion,activo) VALUES 
('1','Anime',true), 
('2','Astethic',true),
('3','Naturaleza',true),
('4','Videojuegos',true),
('5','Personalizadas',true);

/*Se insertan 4 productos por categoria */
INSERT INTO dbkada.producto (id_producto,id_categoria,descripcion,ruta_imagen,activo) VALUES
(1,1,'Demon Slayer','https://cdn.discordapp.com/attachments/1132040104370769920/1132040131352723627/2872.png',true),
(2,2,'Demon Slayer','https://cdn.discordapp.com/attachments/1132040104370769920/1132040131352723627/2872.png',true),
(3,3,'Demon Slayer','https://cdn.discordapp.com/attachments/1132040104370769920/1132040131352723627/2872.png',true),
(4,4,'Demon Slayer','https://cdn.discordapp.com/attachments/1132040104370769920/1132040131352723627/2872.png',true),
(5,5,'Demon Slayer','https://cdn.discordapp.com/attachments/1132040104370769920/1132040131352723627/2872.png',true);

insert into dbkada.rol (id_rol, nombre, id_usuario) values
 (1,'ROLE_ADMIN',1), (2,'ROLE_VENDEDOR',1), (3,'ROLE_USER',1),
 (4,'ROLE_VENDEDOR',2), (5,'ROLE_USER',2),
 (6,'ROLE_USER',3);
 
 insert into dbkada.tipo (id_tipo, descripcion, activo) values
 (1,'Planificador',true), (2,'Agenda',true), (3,'Cuaderno',true);
 
 INSERT INTO dbkada.pedido (id_pedido,nombre,pedido,descripcion,telefono,correo_elec,ruta_imagen,activo) VALUES
(1,'Karen Ruiz',2,'Quiero un libro con la tematica parecida a la foto en caso de que la imagen no de lo suficiente.','8888-8888','kruiz@hotmail.com','https://cdn.discordapp.com/attachments/1132040104370769920/1132040131352723627/2872.png',true);