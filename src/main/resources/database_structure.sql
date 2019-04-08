-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    id bigint NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id),
    CONSTRAINT uk_sx468g52bpetvlad2j9y0lptc UNIQUE (email)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;