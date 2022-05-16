CREATE TABLE IF NOT EXISTS producto(
  id SERIAL,
  descripcion VARCHAR (100) NOT NULL,
  pvp INT NOT NULL,
  stock INT  NOT NULL,
  PRIMARY KEY (id)
  );