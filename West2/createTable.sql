create table weather
(
    fxDate  varchar(50) not null,
    CityID  varchar(50) not null,
    tempMax int         null,
    tempMin int         null,
    textDay varchar(50) null,
    primary key (fxDate, CityID)
);
create table city
(
    name      varchar(50) null,
    id        varchar(50) not null
        primary key,
    latitude  double      null,
    longitude double      null
);