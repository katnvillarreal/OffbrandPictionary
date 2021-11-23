DROP TABLE players;
DROP TABLE words;
DROP TABLE categories;

CREATE TABLE players (
    username            VARCHAR(25),
    password            VARBINARY(25)
);

CREATE TABLE words (
    word                VARCHAR(128),
    category           VARCHAR(25)
);

CREATE TABLE categories (
    category           VARCHAR(25)
);

ALTER TABLE players
    ADD CONSTRAINT username_pk PRIMARY KEY(username);

ALTER TABLE words
    ADD CONSTRAINT word_pk PRIMARY KEY(word);

ALTER TABLE categories
    ADD CONSTRAINT category_pk PRIMARY KEY(category);

ALTER TABLE words
    ADD CONSTRAINT category_fk FOREIGN KEY(category)
    REFERENCES categories(category);

-- Player information
INSERT INTO players VALUES ("kvillarreal",aes_encrypt('veryG00dPass','key'));
INSERT INTO players VALUES ("makenzie",aes_encrypt('randomPassword','key'));

-- categories
INSERT INTO categories VALUES ("animal");
INSERT INTO categories VALUES ("place");
INSERT INTO categories VALUES ("sport");

-- Animal category
INSERT INTO words VALUES ("cat", "animal");
INSERT INTO words VALUES ("dog", "animal");
INSERT INTO words VALUES ("rat", "animal");
INSERT INTO words VALUES ("rabbit", "animal");
INSERT INTO words VALUES ("frog", "animal");
INSERT INTO words VALUES ("lizard", "animal");
INSERT INTO words VALUES ("snake", "animal");
INSERT INTO words VALUES ("hamster", "animal");
INSERT INTO words VALUES ("horse", "animal");
INSERT INTO words VALUES ("deer", "animal");
INSERT INTO words VALUES ("owl", "animal");
INSERT INTO words VALUES ("crow", "animal");
INSERT INTO words VALUES ("bear", "animal");
INSERT INTO words VALUES ("lion", "animal");
INSERT INTO words VALUES ("tiger", "animal");
INSERT INTO words VALUES ("penguin", "animal");
INSERT INTO words VALUES ("turtle", "animal");
INSERT INTO words VALUES ("racoon", "animal");
INSERT INTO words VALUES ("elephant", "animal");
INSERT INTO words VALUES ("fish", "animal");
INSERT INTO words VALUES ("alligator", "animal");
INSERT INTO words VALUES ("llama", "animal");
INSERT INTO words VALUES ("shark", "animal");
INSERT INTO words VALUES ("ram", "animal");
INSERT INTO words VALUES ("goat", "animal");
INSERT INTO words VALUES ("sheep", "animal");
INSERT INTO words VALUES ("fox", "animal");
INSERT INTO words VALUES ("wolf", "animal");
INSERT INTO words VALUES ("chicken", "animal");
INSERT INTO words VALUES ("monkey", "animal");
INSERT INTO words VALUES ("whale", "animal");
INSERT INTO words VALUES ("dolphin", "animal");
INSERT INTO words VALUES ("bat", "animal");
INSERT INTO words VALUES ("giraffe", "animal");
INSERT INTO words VALUES ("duck", "animal");
INSERT INTO words VALUES ("swan", "animal");
INSERT INTO words VALUES ("pig", "animal");
INSERT INTO words VALUES ("cow", "animal");
INSERT INTO words VALUES ("longhorn", "animal");

-- Places category
INSERT INTO words VALUES ("Statute of Liberty", "place");
INSERT INTO words VALUES ("Eiffel Tower", "place");
INSERT INTO words VALUES ("Big Ben", "place");
INSERT INTO words VALUES ("Leaning Tower of Pisa", "place");
INSERT INTO words VALUES ("Golden Gate Bridge", "place");
INSERT INTO words VALUES ("Notre Dame", "place");
INSERT INTO words VALUES ("Great Wall of China", "place");
INSERT INTO words VALUES ("Sydney Opera House", "place");
INSERT INTO words VALUES ("Stonehenge", "place");
INSERT INTO words VALUES ("Pyramids of Giza", "place");
INSERT INTO words VALUES ("White House", "place");
INSERT INTO words VALUES ("Louvre Museum", "place");
INSERT INTO words VALUES ("Mount Rushmore", "place");
INSERT INTO words VALUES ("Easter Island", "place");
INSERT INTO words VALUES ("Disney World", "place");
INSERT INTO words VALUES ("The Parthenon", "place");

-- Sports category
INSERT INTO words VALUES ("Basketball", "sport");
INSERT INTO words VALUES ("Gynmastics", "sport");
INSERT INTO words VALUES ("Skiing", "sport");
INSERT INTO words VALUES ("Archery", "sport");
INSERT INTO words VALUES ("Swimming", "sport");
INSERT INTO words VALUES ("Badminton", "sport");
INSERT INTO words VALUES ("Baseball", "sport");
INSERT INTO words VALUES ("Volleyball", "sport");
INSERT INTO words VALUES ("Bobsleigh", "sport");
INSERT INTO words VALUES ("Boxing", "sport");
INSERT INTO words VALUES ("Kayaking", "sport");
INSERT INTO words VALUES ("Curling", "sport");
INSERT INTO words VALUES ("Diving", "sport");
INSERT INTO words VALUES ("Equestrian", "sport");
INSERT INTO words VALUES ("Fencing", "sport");
INSERT INTO words VALUES ("Skating", "sport");
INSERT INTO words VALUES ("Football", "sport");
INSERT INTO words VALUES ("Soccer", "sport");
INSERT INTO words VALUES ("Golf", "sport");
INSERT INTO words VALUES ("Hockey", "sport");
INSERT INTO words VALUES ("Cycling", "sport");
INSERT INTO words VALUES ("Rowing", "sport");
INSERT INTO words VALUES ("Sailing", "sport");
INSERT INTO words VALUES ("Skateboarding", "sport");
INSERT INTO words VALUES ("Snowboarding", "sport");
INSERT INTO words VALUES ("Speed Skating", "sport");
INSERT INTO words VALUES ("Surfing", "sport");
INSERT INTO words VALUES ("Table Tennis", "sport");
INSERT INTO words VALUES ("Tennis", "sport");
INSERT INTO words VALUES ("Water Polo", "sport");
INSERT INTO words VALUES ("Weightlifting", "sport");
INSERT INTO words VALUES ("Wrestling", "sport");
