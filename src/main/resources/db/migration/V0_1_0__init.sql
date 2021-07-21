CREATE TABLE IF NOT EXISTS app_user
(
    id         uuid      not null
        constraint app_user_pkey
            primary key,
    user_name  varchar   not null,
    first_name varchar   not null,
    last_name  varchar,
    birth_date date      not null,
    created    timestamp not null
);
