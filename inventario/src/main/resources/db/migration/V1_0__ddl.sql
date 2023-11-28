--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6
-- Dumped by pg_dump version 14.6

-- Started on 2023-12-01 05:34:31 -05

-- SET statement_timeout = 0;
-- SET lock_timeout = 0;
-- SET idle_in_transaction_session_timeout = 0;
-- SET client_encoding = 'UTF8';
-- SET standard_conforming_strings = on;
-- SELECT pg_catalog.set_config('search_path', '', false);
-- SET check_function_bodies = false;
-- SET xmloption = content;
-- SET client_min_messages = warning;
-- SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 98982)
-- Name: inventario; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA inventario;


ALTER SCHEMA inventario OWNER TO postgres;

--
-- TOC entry 3678 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA inventario; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA inventario IS 'Gestión de inventario de prendas';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 98983)
-- Name: categoria; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.categoria (
                                      co_id_categoria integer NOT NULL,
                                      no_categoria character varying(50) NOT NULL
);


ALTER TABLE inventario.categoria OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 98986)
-- Name: categoria_co_id_categoria_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario."categoria_co_id_categoria_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario."categoria_co_id_categoria_seq" OWNER TO postgres;

--
-- TOC entry 3679 (class 0 OID 0)
-- Dependencies: 212
-- Name: categoria_co_id_categoria_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario."categoria_co_id_categoria_seq" OWNED BY inventario.categoria.co_id_categoria;


--
-- TOC entry 213 (class 1259 OID 98987)
-- Name: color; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.color (
                                  co_id_color integer NOT NULL,
                                  no_color_primario character varying(50) NOT NULL,
                                  no_color_secundario character varying(50),
                                  tx_distribucion character varying(100)
);


ALTER TABLE inventario.color OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 98990)
-- Name: color_co_id_color_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario."color_co_id_color_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario."color_co_id_color_seq" OWNER TO postgres;

--
-- TOC entry 3680 (class 0 OID 0)
-- Dependencies: 214
-- Name: color_co_id_color_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario."color_co_id_color_seq" OWNED BY inventario.color.co_id_color;


--
-- TOC entry 215 (class 1259 OID 98991)
-- Name: inventario; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.inventario (
                                       co_id_inventario integer NOT NULL,
                                       nu_cantidad integer DEFAULT 0 NOT NULL,
                                       prenda_co_id_prenda integer NOT NULL
);


ALTER TABLE inventario.inventario OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 98995)
-- Name: inventario_co_id_inventario_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario."inventario_co_id_inventario_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario."inventario_co_id_inventario_seq" OWNER TO postgres;

--
-- TOC entry 3681 (class 0 OID 0)
-- Dependencies: 216
-- Name: inventario_co_id_inventario_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario."inventario_co_id_inventario_seq" OWNED BY inventario.inventario.co_id_inventario;


--
-- TOC entry 217 (class 1259 OID 98996)
-- Name: prenda; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.prenda (
                                   co_id_prenda integer NOT NULL,
                                   no_prenda character varying(100) NOT NULL,
                                   talla_co_id_talla integer NOT NULL,
                                   color_co_id_color integer NOT NULL,
                                   tela_co_id_tela integer NOT NULL,
                                   categoria_co_id_categoria integer NOT NULL,
                                   tipo_co_id_tipo integer NOT NULL
);


ALTER TABLE inventario.prenda OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 98999)
-- Name: prenda_co_id_prenda_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario."prenda_co_id_prenda_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario."prenda_co_id_prenda_seq" OWNER TO postgres;

--
-- TOC entry 3682 (class 0 OID 0)
-- Dependencies: 218
-- Name: prenda_co_id_prenda_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario."prenda_co_id_prenda_seq" OWNED BY inventario.prenda.co_id_prenda;


--
-- TOC entry 219 (class 1259 OID 99000)
-- Name: talla; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.talla (
                                  co_id_talla integer NOT NULL,
                                  no_talla character varying(5) NOT NULL
);


ALTER TABLE inventario.talla OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 99003)
-- Name: talla_co_id_talla_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario."talla_co_id_talla_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario."talla_co_id_talla_seq" OWNER TO postgres;

--
-- TOC entry 3683 (class 0 OID 0)
-- Dependencies: 220
-- Name: talla_co_id_talla_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario."talla_co_id_talla_seq" OWNED BY inventario.talla.co_id_talla;


--
-- TOC entry 221 (class 1259 OID 99004)
-- Name: tela; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.tela (
                                 co_id_tela integer NOT NULL,
                                 no_tela character varying(50) NOT NULL
);


ALTER TABLE inventario.tela OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 99007)
-- Name: tela_co_id_tela_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario."tela_co_id_tela_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario."tela_co_id_tela_seq" OWNER TO postgres;

--
-- TOC entry 3684 (class 0 OID 0)
-- Dependencies: 222
-- Name: tela_co_id_tela_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario."tela_co_id_tela_seq" OWNED BY inventario.tela.co_id_tela;


--
-- TOC entry 223 (class 1259 OID 99008)
-- Name: tipo; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.tipo (
                                 co_id_tipo integer NOT NULL,
                                 no_tipo character varying(50) NOT NULL
);


ALTER TABLE inventario.tipo OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 99011)
-- Name: tipo_co_id_tipo_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario."tipo_co_id_tipo_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE inventario."tipo_co_id_tipo_seq" OWNER TO postgres;

--
-- TOC entry 3685 (class 0 OID 0)
-- Dependencies: 224
-- Name: tipo_co_id_tipo_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario."tipo_co_id_tipo_seq" OWNED BY inventario.tipo.co_id_tipo;


--
-- TOC entry 3466 (class 2604 OID 99012)
-- Name: categoria co_id_categoria; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.categoria ALTER COLUMN co_id_categoria SET DEFAULT nextval('inventario."categoria_co_id_categoria_seq"'::regclass);


--
-- TOC entry 3467 (class 2604 OID 99013)
-- Name: color co_id_color; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.color ALTER COLUMN co_id_color SET DEFAULT nextval('inventario."color_co_id_color_seq"'::regclass);


--
-- TOC entry 3469 (class 2604 OID 99014)
-- Name: inventario co_id_inventario; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario ALTER COLUMN co_id_inventario SET DEFAULT nextval('inventario."inventario_co_id_inventario_seq"'::regclass);


--
-- TOC entry 3470 (class 2604 OID 99015)
-- Name: prenda co_id_prenda; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda ALTER COLUMN co_id_prenda SET DEFAULT nextval('inventario."prenda_co_id_prenda_seq"'::regclass);


--
-- TOC entry 3471 (class 2604 OID 99016)
-- Name: talla co_id_talla; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.talla ALTER COLUMN co_id_talla SET DEFAULT nextval('inventario."talla_co_id_talla_seq"'::regclass);


--
-- TOC entry 3472 (class 2604 OID 99017)
-- Name: tela co_id_tela; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tela ALTER COLUMN co_id_tela SET DEFAULT nextval('inventario."tela_co_id_tela_seq"'::regclass);


--
-- TOC entry 3473 (class 2604 OID 99018)
-- Name: tipo co_id_tipo; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tipo ALTER COLUMN co_id_tipo SET DEFAULT nextval('inventario."tipo_co_id_tipo_seq"'::regclass);


--
-- TOC entry 3659 (class 0 OID 98983)
-- Dependencies: 211
-- Data for Name: categoria; Type: TABLE DATA; Schema: inventario; Owner: postgres
--

COPY inventario.categoria (co_id_categoria, no_categoria) FROM stdin;
\.


--
-- TOC entry 3661 (class 0 OID 98987)
-- Dependencies: 213
-- Data for Name: color; Type: TABLE DATA; Schema: inventario; Owner: postgres
--

COPY inventario.color (co_id_color, no_color_primario, no_color_secundario, tx_distribucion) FROM stdin;
\.


--
-- TOC entry 3663 (class 0 OID 98991)
-- Dependencies: 215
-- Data for Name: inventario; Type: TABLE DATA; Schema: inventario; Owner: postgres
--

COPY inventario.inventario (co_id_inventario, nu_cantidad, prenda_co_id_prenda) FROM stdin;
\.


--
-- TOC entry 3665 (class 0 OID 98996)
-- Dependencies: 217
-- Data for Name: prenda; Type: TABLE DATA; Schema: inventario; Owner: postgres
--

COPY inventario.prenda (co_id_prenda, no_prenda, talla_co_id_talla, color_co_id_color, tela_co_id_tela, categoria_co_id_categoria, tipo_co_id_tipo) FROM stdin;
\.


--
-- TOC entry 3667 (class 0 OID 99000)
-- Dependencies: 219
-- Data for Name: talla; Type: TABLE DATA; Schema: inventario; Owner: postgres
--

COPY inventario.talla (co_id_talla, no_talla) FROM stdin;
\.


--
-- TOC entry 3669 (class 0 OID 99004)
-- Dependencies: 221
-- Data for Name: tela; Type: TABLE DATA; Schema: inventario; Owner: postgres
--

COPY inventario.tela (co_id_tela, no_tela) FROM stdin;
\.


--
-- TOC entry 3671 (class 0 OID 99008)
-- Dependencies: 223
-- Data for Name: tipo; Type: TABLE DATA; Schema: inventario; Owner: postgres
--

COPY inventario.tipo (co_id_tipo, no_tipo) FROM stdin;
\.


--
-- TOC entry 3686 (class 0 OID 0)
-- Dependencies: 212
-- Name: categoria_co_id_categoria_seq; Type: SEQUENCE SET; Schema: inventario; Owner: postgres
--

SELECT pg_catalog.setval('inventario."categoria_co_id_categoria_seq"', 1, false);


--
-- TOC entry 3687 (class 0 OID 0)
-- Dependencies: 214
-- Name: color_co_id_color_seq; Type: SEQUENCE SET; Schema: inventario; Owner: postgres
--

SELECT pg_catalog.setval('inventario."color_co_id_color_seq"', 1, false);


--
-- TOC entry 3688 (class 0 OID 0)
-- Dependencies: 216
-- Name: inventario_co_id_inventario_seq; Type: SEQUENCE SET; Schema: inventario; Owner: postgres
--

SELECT pg_catalog.setval('inventario."inventario_co_id_inventario_seq"', 1, false);


--
-- TOC entry 3689 (class 0 OID 0)
-- Dependencies: 218
-- Name: prenda_co_id_prenda_seq; Type: SEQUENCE SET; Schema: inventario; Owner: postgres
--

SELECT pg_catalog.setval('inventario."prenda_co_id_prenda_seq"', 1, false);


--
-- TOC entry 3690 (class 0 OID 0)
-- Dependencies: 220
-- Name: talla_co_id_talla_seq; Type: SEQUENCE SET; Schema: inventario; Owner: postgres
--

SELECT pg_catalog.setval('inventario."talla_co_id_talla_seq"', 1, false);


--
-- TOC entry 3691 (class 0 OID 0)
-- Dependencies: 222
-- Name: tela_co_id_tela_seq; Type: SEQUENCE SET; Schema: inventario; Owner: postgres
--

SELECT pg_catalog.setval('inventario."tela_co_id_tela_seq"', 1, false);


--
-- TOC entry 3692 (class 0 OID 0)
-- Dependencies: 224
-- Name: tipo_co_id_tipo_seq; Type: SEQUENCE SET; Schema: inventario; Owner: postgres
--

SELECT pg_catalog.setval('inventario."tipo_co_id_tipo_seq"', 1, false);


--
-- TOC entry 3478 (class 2606 OID 99020)
-- Name: categoria categoria_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY (co_id_categoria);


--
-- TOC entry 3480 (class 2606 OID 99022)
-- Name: categoria categoria_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.categoria
    ADD CONSTRAINT categoria_unique UNIQUE (no_categoria);


--
-- TOC entry 3482 (class 2606 OID 99024)
-- Name: color color_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.color
    ADD CONSTRAINT color_pk PRIMARY KEY (co_id_color);


--
-- TOC entry 3484 (class 2606 OID 99026)
-- Name: color color_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.color
    ADD CONSTRAINT color_unique UNIQUE (no_color_primario);


--
-- TOC entry 3487 (class 2606 OID 99028)
-- Name: inventario inventario_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario
    ADD CONSTRAINT inventario_pk PRIMARY KEY (co_id_inventario);


--
-- TOC entry 3489 (class 2606 OID 99030)
-- Name: inventario inventario_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario
    ADD CONSTRAINT inventario_unique UNIQUE (prenda_co_id_prenda);


--
-- TOC entry 3496 (class 2606 OID 99032)
-- Name: prenda prenda_definicion_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT prenda_definicion_unique UNIQUE (talla_co_id_talla, color_co_id_color, tela_co_id_tela);


--
-- TOC entry 3498 (class 2606 OID 99034)
-- Name: prenda prenda_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT prenda_pk UNIQUE (co_id_prenda);


--
-- TOC entry 3500 (class 2606 OID 99036)
-- Name: prenda prenda_pkey; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT prenda_pkey PRIMARY KEY (co_id_prenda);


--
-- TOC entry 3502 (class 2606 OID 99038)
-- Name: talla talla_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.talla
    ADD CONSTRAINT talla_pk PRIMARY KEY (co_id_talla);


--
-- TOC entry 3504 (class 2606 OID 99040)
-- Name: talla talla_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.talla
    ADD CONSTRAINT talla_unique UNIQUE (no_talla);


--
-- TOC entry 3506 (class 2606 OID 99042)
-- Name: tela tela_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tela
    ADD CONSTRAINT tela_pk PRIMARY KEY (co_id_tela);


--
-- TOC entry 3508 (class 2606 OID 99044)
-- Name: tela tela_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tela
    ADD CONSTRAINT tela_unique UNIQUE (no_tela);


--
-- TOC entry 3510 (class 2606 OID 99046)
-- Name: tipo tipo_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tipo
    ADD CONSTRAINT tipo_pk PRIMARY KEY (co_id_tipo);


--
-- TOC entry 3512 (class 2606 OID 99048)
-- Name: tipo tipo_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tipo
    ADD CONSTRAINT tipo_unique UNIQUE (no_tipo);



--
-- TOC entry 3485 (class 1259 OID 99049)
-- Name: fki_fk__inventario_prenda; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__inventario_prenda ON inventario.inventario USING btree (prenda_co_id_prenda);


--
-- TOC entry 3490 (class 1259 OID 99050)
-- Name: fki_fk__prenda_categoria; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_categoria ON inventario.prenda USING btree (categoria_co_id_categoria);


--
-- TOC entry 3491 (class 1259 OID 99051)
-- Name: fki_fk__prenda_color; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_color ON inventario.prenda USING btree (color_co_id_color);


--
-- TOC entry 3492 (class 1259 OID 99052)
-- Name: fki_fk__prenda_talla; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_talla ON inventario.prenda USING btree (talla_co_id_talla);


--
-- TOC entry 3493 (class 1259 OID 99053)
-- Name: fki_fk__prenda_tela; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_tela ON inventario.prenda USING btree (tela_co_id_tela);


--
-- TOC entry 3494 (class 1259 OID 99054)
-- Name: fki_fk__prenda_tipo; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_tipo ON inventario.prenda USING btree (tipo_co_id_tipo);


--
-- TOC entry 3513 (class 2606 OID 99055)
-- Name: inventario fk__inventario_prenda; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario
    ADD CONSTRAINT fk__inventario_prenda FOREIGN KEY (prenda_co_id_prenda) REFERENCES inventario.prenda(co_id_prenda) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3514 (class 2606 OID 99060)
-- Name: prenda fk__prenda_categoria; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_categoria FOREIGN KEY (categoria_co_id_categoria) REFERENCES inventario.categoria(co_id_categoria) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3515 (class 2606 OID 99065)
-- Name: prenda fk__prenda_color; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_color FOREIGN KEY (color_co_id_color) REFERENCES inventario.color(co_id_color) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3516 (class 2606 OID 99070)
-- Name: prenda fk__prenda_talla; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_talla FOREIGN KEY (talla_co_id_talla) REFERENCES inventario.talla(co_id_talla) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3517 (class 2606 OID 99075)
-- Name: prenda fk__prenda_tela; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_tela FOREIGN KEY (tela_co_id_tela) REFERENCES inventario.tela(co_id_tela) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3518 (class 2606 OID 99080)
-- Name: prenda fk__prenda_tipo; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_tipo FOREIGN KEY (tipo_co_id_tipo) REFERENCES inventario.tipo(co_id_tipo) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2023-12-01 05:34:32 -05

--
-- PostgreSQL database dump complete
--

