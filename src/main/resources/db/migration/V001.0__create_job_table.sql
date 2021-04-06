CREATE TABLE public.job (
	id varchar(40) NULL,
	name varchar(255) NULL,
	description text NULL,
	CONSTRAINT job_pk PRIMARY KEY (id)
);
CREATE INDEX job_id_idx ON public.job (id);