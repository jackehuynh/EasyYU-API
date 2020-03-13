CREATE TABLE IF NOT EXISTS subject(subject varchar(8) PRIMARY KEY, name TEXT, UNIQUE (subject, name));
CREATE TABLE IF NOT EXISTS faculty(code varchar(8) PRIMARY KEY, name TEXT, UNIQUE (code, name));
CREATE TABLE IF NOT EXISTS course(faculty varchar(8) REFERENCES faculty, subject varchar(8) REFERENCES subject, course_number varchar(8), name TEXT, description TEXT, credit TEXT, loi TEXT, offerings JSONB, url TEXT);

CREATE TABLE IF NOT EXISTS AthleticBuilding(name TEXT UNIQUE, hours TEXT[]);
CREATE TABLE IF NOT EXISTS FoodBuilding(restaurant TEXT, building TEXT, description TEXT, hours TEXT[], campus TEXT, phone TEXT, email TEXT, paymentmethods TEXT[]);
CREATE TABLE IF NOT EXISTS WaterRefill(id SERIAL PRIMARY KEY, campus varchar(50), building TEXT, location TEXT, UNIQUE (building, location));

CREATE TABLE IF NOT EXISTS buildingacronym(acronym varchar(8), name TEXT, UNIQUE (acronym, name));
