CREATE TABLE IF NOT EXISTS subject(subject varchar(8) PRIMARY KEY, name TEXT);
CREATE TABLE IF NOT EXISTS faculty(code varchar(8) PRIMARY KEY, name TEXT);
CREATE TABLE IF NOT EXISTS course(faculty varchar(8) REFERENCES faculty, subject varchar(8) REFERENCES subject, course_number varchar(8), name TEXT, description TEXT, credit TEXT, loi TEXT, offerings JSONB, url TEXT);

CREATE TABLE IF NOT EXISTS AthleticBuilding(name TEXT UNIQUE, hours JSONB);
CREATE TABLE IF NOT EXISTS FoodBuilding(restaurant TEXT, building TEXT, description TEXT, hours JSONB, campus TEXT, phone TEXT, email TEXT, paymentMethods JSONB);
CREATE TABLE IF NOT EXISTS WaterRefill(id SERIAL PRIMARY KEY, campus varchar(50), building TEXT, location TEXT, UNIQUE (building, location));
