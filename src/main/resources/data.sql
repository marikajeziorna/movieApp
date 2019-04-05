INSERT INTO movie(id, title, premiere_date, budget, target_audience) VALUES
 (1, 'Titanic', '1995-12-12', 50000000, 'ALL'),
 (2, 'Matrix', '1992-05-12', 5000000, 'ALL'),
 (3, 'Piła', '1995-12-12', 200000, 'ADULTS'),
 (4, 'Spongebob Kanciastoporty', '2000-12-12', 200000, 'KIDS');

INSERT INTO comment(content, added_time, movie_id, author) VALUES
('Leo ginie!', '2019-04-03 18:36:00', 1, 'Kasia'),
('A zmieściłby się na tych drzwiach', '2019-04-03 18:37:00', 1, 'Bartek'),
('No niby tak', '2019-04-03 18:38:00', 1, 'Zbyszek'),
('Za gruby był', '2019-04-03 18:40:00', 1, 'Ania');

INSERT INTO actor(gender, name, movie_id) VALUES
('MEN','Leonardo DiCaprio', 1),
('MEN','Keanu Reeves', 2);



