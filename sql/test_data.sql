
USE ticket_store;


INSERT INTO ticket_store.persons (first_name, last_name, country, image_address, date_of_birth)
VALUES ('James', 'Cameron', 'USA', 'image_address', '2018-02-14');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 1', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 2', 'address', '2011', 'GBR', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 3', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 4', 'address', '2010', 'GBR', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 5', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 6', 'address', '2011', 'GBR', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 7', 'address', '2011', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 8', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 9', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 10', 'address', '2010', 'FRA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 11', 'address', '2011', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 23', 'address', '2010', 'FRA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 12', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 13', 'address', '2012', 'FRA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 14', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 15', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 16', 'address', '2010', 'FRA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 17', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 18', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 19', 'address', '2010', 'FRA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 20', 'address', '2010', 'USA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 21', 'address', '2010', 'FRA', '1');
INSERT INTO ticket_store.movies ( title, image_address, create_year, country, director_id) VALUES
  ('Movie 22', 'address', '2010', 'USA', '1');

INSERT INTO movies_genres (movie_id, genre) VALUES (1,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (1,'ACTION' );
INSERT INTO movies_genres (movie_id, genre) VALUES (1,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (2,'FANTASTIC' );
INSERT INTO movies_genres (movie_id, genre) VALUES (2,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (3,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (3,'ACTION' );
INSERT INTO movies_genres (movie_id, genre) VALUES (3,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (4,'FANTASTIC' );
INSERT INTO movies_genres (movie_id, genre) VALUES (5,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (5,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (6,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (6,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (6,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (7,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (7,'FANTASTIC' );
INSERT INTO movies_genres (movie_id, genre) VALUES (7,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (8,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (8,'FANTASTIC' );
INSERT INTO movies_genres (movie_id, genre) VALUES (9,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (10,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (10,'FANTASTIC' );
INSERT INTO movies_genres (movie_id, genre) VALUES (10,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (11,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (11,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (12,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (13,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (13,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (14,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (15,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (15,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (15,'FANTASTIC' );
INSERT INTO movies_genres (movie_id, genre) VALUES (16,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (16,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (17,'ACTION' );
INSERT INTO movies_genres (movie_id, genre) VALUES (17,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (17,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (18,'ACTION' );
INSERT INTO movies_genres (movie_id, genre) VALUES (18,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (19,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (19,'ACTION' );
INSERT INTO movies_genres (movie_id, genre) VALUES (20,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (20,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (20,'ACTION' );
INSERT INTO movies_genres (movie_id, genre) VALUES (21,'ADVENTURE' );
INSERT INTO movies_genres (movie_id, genre) VALUES (21,'COMEDY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (21,'FAMILY' );
INSERT INTO movies_genres (movie_id, genre) VALUES (22,'ADVENTURE' );


