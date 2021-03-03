CREATE TABLE artist
(
    artist_id SERIAL,
    name VARCHAR(120),
    CONSTRAINT PK_Artist PRIMARY KEY  (artist_id)
);
INSERT INTO artist (name) VALUES ( N'AC/DC');
INSERT INTO artist (name) VALUES ( N'Accept');