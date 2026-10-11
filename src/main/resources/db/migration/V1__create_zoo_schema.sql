CREATE TABLE enclosures (
    id              integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    capacity        integer,
    food            integer
);

CREATE TABLE animals (
    id              integer PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    enclosure_id    integer REFERENCES enclosures(id),
    type            varchar(100),
    weight          integer,
    hunger          integer
);
