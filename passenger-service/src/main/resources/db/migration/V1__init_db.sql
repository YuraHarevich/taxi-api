CREATE TABLE IF NOT EXISTS Passenger
(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    rate REAL
);
create sequence if not exists passenger_seq increment by 1;