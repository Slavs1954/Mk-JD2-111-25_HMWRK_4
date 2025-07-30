-- Table: auth_app.users

-- DROP TABLE IF EXISTS auth_app.users;

CREATE TABLE IF NOT EXISTS auth_app.users
(
    username character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    full_name character varying COLLATE pg_catalog."default",
    birth_date date,
    registration_date timestamp without time zone NOT NULL,
    role character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (username)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS auth_app.users
    OWNER to postgres;

-- Table: auth_app.messages

-- DROP TABLE IF EXISTS auth_app.messages;

CREATE TABLE IF NOT EXISTS auth_app.messages
(
    sender character varying COLLATE pg_catalog."default" NOT NULL,
    receiver character varying COLLATE pg_catalog."default" NOT NULL,
    message text COLLATE pg_catalog."default",
    dt_send timestamp without time zone NOT NULL
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS auth_app.messages
    OWNER to postgres;

-- INSERT admin INTO users

INSERT INTO auth_app.users(
    username, password, full_name, birth_date, registration_date, role)
VALUES ('admin', 'root', NULL, NULL, '0001-01-01 00:00:00', 'ADMIN');
