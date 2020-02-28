CREATE TABLE IF NOT EXISTS public.phonebook
(
    id integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT phonebook_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.phonebook
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.entry
(
    id integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    phonenumber character varying(255) COLLATE pg_catalog."default",
    phonebook_id integer,
    CONSTRAINT entry_pkey PRIMARY KEY (id),
    CONSTRAINT fk_entry_phonebook_id FOREIGN KEY (phonebook_id)
        REFERENCES public.phonebook (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.entry
OWNER to postgres;