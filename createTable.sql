CREATE TABLE public.user_details
(
  id integer NOT NULL,
  city character varying(255),
  country character varying(255),
  first_name character varying(255),
  last_name character varying(255),
  state character varying(255),
  street character varying(255),
  CONSTRAINT user_details_pkey PRIMARY KEY (id)
);

insert  into public.user_details ("id","first_name","last_name","city","country","state","street") value (1,"Ram","Das","Kol","India","WB","M.G.Road")
