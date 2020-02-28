CREATE TABLE IF NOT EXISTS public.phone_book
(
    id integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT phone_book_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.phone_book
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.phone_book_entry
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    description character varying(255) COLLATE pg_catalog."default",
    phone_number character varying(255) COLLATE pg_catalog."default",
    phonebook_id integer,
    CONSTRAINT phone_book_entry_pkey PRIMARY KEY (id),
    CONSTRAINT fkxvcexkqjdreoqdes19teqj43 FOREIGN KEY (phonebook_id)
        REFERENCES public.phone_book (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.phone_book_entry
    OWNER to postgres;

