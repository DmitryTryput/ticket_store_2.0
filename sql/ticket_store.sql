CREATE DATABASE ticket_store;

DROP DATABASE ticket_store;


USE ticket_store;


CREATE TABLE cinemas (
  id    BIGINT AUTO_INCREMENT,
  title VARCHAR(40) UNIQUE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE persons (
  id            BIGINT AUTO_INCREMENT,
  first_name    VARCHAR(40) NOT NULL,
  last_name     VARCHAR(40) NOT NULL,
  country       VARCHAR(20) NOT NULL,
  image_address VARCHAR(55),
  date_of_birth DATE,
  PRIMARY KEY (id),
  UNIQUE (first_name, last_name)
);

CREATE TABLE movies (
  id            BIGINT AUTO_INCREMENT,
  title         VARCHAR(40) NOT NULL,
  image_address VARCHAR(55),
  create_date   DATE        NOT NULL,
  country       VARCHAR(20) NOT NULL,
  director_id   BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE movies_genres (
  movie_id BIGINT,
  genre    VARCHAR(15),
  PRIMARY KEY (movie_id, genre),
  FOREIGN KEY (movie_id) REFERENCES movies (id)
);

CREATE TABLE movies_actors (
  movie_id  BIGINT,
  person_id BIGINT,
  PRIMARY KEY (movie_id, person_id),
  FOREIGN KEY (movie_id) REFERENCES movies (id),
  FOREIGN KEY (person_id) REFERENCES persons (id)
);


CREATE TABLE cinema_halls (
  id        BIGINT AUTO_INCREMENT,
  title     VARCHAR(40) UNIQUE NOT NULL,
  rows      INT                NOT NULL,
  seats     INT                NOT NULL,
  cinema_id BIGINT             NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cinema_id) REFERENCES cinemas (id)
);

CREATE TABLE users (
  id            BIGINT AUTO_INCREMENT,
  email         VARCHAR(40) UNIQUE NOT NULL,
  first_name    VARCHAR(40)        NOT NULL,
  last_name     VARCHAR(40)        NOT NULL,
  user_password VARCHAR(40)        NOT NULL,
  user_value    DECIMAL(10, 2),
  role          VARCHAR(15)        NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE message (
  id        BIGINT AUTO_INCREMENT,
  date_time DATETIME,
  movie_id  BIGINT,
  user_id   BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (movie_id) REFERENCES movies (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);


CREATE TABLE reviews (
  name       VARCHAR(55),
  text       TEXT,
  message_id BIGINT,
  FOREIGN KEY (message_id) REFERENCES message (id)
);

CREATE TABLE comments (
  text       VARCHAR(55),
  message_id BIGINT,
  FOREIGN KEY (message_id) REFERENCES message (id)
);


CREATE TABLE seances (
  id             BIGINT AUTO_INCREMENT,
  movie_id       BIGINT         NOT NULL,
  cinema_hall_id BIGINT         NOT NULL,
  seance_date    DATE           NOT NULL,
  seance_time    TIME           NOT NULL,
  price          DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (movie_id) REFERENCES movies (id),
  FOREIGN KEY (cinema_hall_id) REFERENCES cinema_halls (id)
);

CREATE TABLE tickets (
  id           BIGINT     AUTO_INCREMENT,
  seance_id    BIGINT NOT NULL,
  row          INT,
  seat         INT,
  is_purchased TINYINT(1) DEFAULT 0,
  user_id      BIGINT,
  PRIMARY KEY (id),
  FOREIGN KEY (seance_id) REFERENCES seances (id),
  FOREIGN KEY (user_id) REFERENCES users (id)
);
      