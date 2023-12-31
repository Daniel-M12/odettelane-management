--
-- PostgreSQL database dump
--

-- Dumped from database version 14.6
-- Dumped by pg_dump version 14.6

-- Started on 2023-12-15 06:03:50 -05

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
-- TOC entry 6 (class 2615 OID 99095)
-- Name: inventario; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA inventario;


--ALTER SCHEMA inventario OWNER TO postgres;

--
-- TOC entry 3679 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA inventario; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA inventario IS 'Gestión de inventario de prendas';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 211 (class 1259 OID 99096)
-- Name: categoria; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.categoria (
                                      co_id_categoria integer NOT NULL,
                                      no_categoria character varying(50) NOT NULL
);


--ALTER TABLE inventario.categoria OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 99099)
-- Name: categoria_co_id_categoria_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario.categoria_co_id_categoria_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE inventario.categoria_co_id_categoria_seq OWNER TO postgres;

--
-- TOC entry 3680 (class 0 OID 0)
-- Dependencies: 212
-- Name: categoria_co_id_categoria_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario.categoria_co_id_categoria_seq OWNED BY inventario.categoria.co_id_categoria;


--
-- TOC entry 213 (class 1259 OID 99100)
-- Name: color; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.color (
                                  co_id_color integer NOT NULL,
                                  no_color_primario character varying(50) NOT NULL,
                                  no_color_secundario character varying(50),
                                  tx_distribucion character varying(100)
);


--ALTER TABLE inventario.color OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 99103)
-- Name: color_co_id_color_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario.color_co_id_color_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE inventario.color_co_id_color_seq OWNER TO postgres;

--
-- TOC entry 3681 (class 0 OID 0)
-- Dependencies: 214
-- Name: color_co_id_color_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario.color_co_id_color_seq OWNED BY inventario.color.co_id_color;


--
-- TOC entry 215 (class 1259 OID 99104)
-- Name: inventario; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.inventario (
                                       co_id_inventario integer NOT NULL,
                                       nu_cantidad integer DEFAULT 0 NOT NULL,
                                       prenda_co_id_prenda integer NOT NULL,
                                       CONSTRAINT positive_quantity CHECK ((nu_cantidad >= 0))
);


--ALTER TABLE inventario.inventario OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 99108)
-- Name: inventario_co_id_inventario_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario.inventario_co_id_inventario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE inventario.inventario_co_id_inventario_seq OWNER TO postgres;

--
-- TOC entry 3682 (class 0 OID 0)
-- Dependencies: 216
-- Name: inventario_co_id_inventario_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario.inventario_co_id_inventario_seq OWNED BY inventario.inventario.co_id_inventario;


--
-- TOC entry 217 (class 1259 OID 99109)
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


--ALTER TABLE inventario.prenda OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 99112)
-- Name: prenda_co_id_prenda_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario.prenda_co_id_prenda_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE inventario.prenda_co_id_prenda_seq OWNER TO postgres;

--
-- TOC entry 3683 (class 0 OID 0)
-- Dependencies: 218
-- Name: prenda_co_id_prenda_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario.prenda_co_id_prenda_seq OWNED BY inventario.prenda.co_id_prenda;


--
-- TOC entry 219 (class 1259 OID 99113)
-- Name: talla; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.talla (
                                  co_id_talla integer NOT NULL,
                                  no_talla character varying(5) NOT NULL
);


--ALTER TABLE inventario.talla OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 99116)
-- Name: talla_co_id_talla_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario.talla_co_id_talla_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE inventario.talla_co_id_talla_seq OWNER TO postgres;

--
-- TOC entry 3684 (class 0 OID 0)
-- Dependencies: 220
-- Name: talla_co_id_talla_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario.talla_co_id_talla_seq OWNED BY inventario.talla.co_id_talla;


--
-- TOC entry 221 (class 1259 OID 99117)
-- Name: tela; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.tela (
                                 co_id_tela integer NOT NULL,
                                 no_tela character varying(50) NOT NULL
);


--ALTER TABLE inventario.tela OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 99120)
-- Name: tela_co_id_tela_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario.tela_co_id_tela_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE inventario.tela_co_id_tela_seq OWNER TO postgres;

--
-- TOC entry 3685 (class 0 OID 0)
-- Dependencies: 222
-- Name: tela_co_id_tela_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario.tela_co_id_tela_seq OWNED BY inventario.tela.co_id_tela;


--
-- TOC entry 223 (class 1259 OID 99121)
-- Name: tipo; Type: TABLE; Schema: inventario; Owner: postgres
--

CREATE TABLE inventario.tipo (
                                 co_id_tipo integer NOT NULL,
                                 no_tipo character varying(50) NOT NULL
);


--ALTER TABLE inventario.tipo OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 99124)
-- Name: tipo_co_id_tipo_seq; Type: SEQUENCE; Schema: inventario; Owner: postgres
--

CREATE SEQUENCE inventario.tipo_co_id_tipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--ALTER TABLE inventario.tipo_co_id_tipo_seq OWNER TO postgres;

--
-- TOC entry 3686 (class 0 OID 0)
-- Dependencies: 224
-- Name: tipo_co_id_tipo_seq; Type: SEQUENCE OWNED BY; Schema: inventario; Owner: postgres
--

ALTER SEQUENCE inventario.tipo_co_id_tipo_seq OWNED BY inventario.tipo.co_id_tipo;

--
-- TOC entry 3466 (class 2604 OID 99125)
-- Name: categoria co_id_categoria; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.categoria ALTER COLUMN co_id_categoria SET DEFAULT nextval('inventario.categoria_co_id_categoria_seq'::regclass);


--
-- TOC entry 3467 (class 2604 OID 99126)
-- Name: color co_id_color; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.color ALTER COLUMN co_id_color SET DEFAULT nextval('inventario.color_co_id_color_seq'::regclass);


--
-- TOC entry 3469 (class 2604 OID 99127)
-- Name: inventario co_id_inventario; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario ALTER COLUMN co_id_inventario SET DEFAULT nextval('inventario.inventario_co_id_inventario_seq'::regclass);


--
-- TOC entry 3471 (class 2604 OID 99128)
-- Name: prenda co_id_prenda; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda ALTER COLUMN co_id_prenda SET DEFAULT nextval('inventario.prenda_co_id_prenda_seq'::regclass);


--
-- TOC entry 3472 (class 2604 OID 99129)
-- Name: talla co_id_talla; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.talla ALTER COLUMN co_id_talla SET DEFAULT nextval('inventario.talla_co_id_talla_seq'::regclass);


--
-- TOC entry 3473 (class 2604 OID 99130)
-- Name: tela co_id_tela; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tela ALTER COLUMN co_id_tela SET DEFAULT nextval('inventario.tela_co_id_tela_seq'::regclass);


--
-- TOC entry 3474 (class 2604 OID 99131)
-- Name: tipo co_id_tipo; Type: DEFAULT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tipo ALTER COLUMN co_id_tipo SET DEFAULT nextval('inventario.tipo_co_id_tipo_seq'::regclass);


--
-- TOC entry 3479 (class 2606 OID 99133)
-- Name: categoria categoria_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.categoria
    ADD CONSTRAINT categoria_pk PRIMARY KEY (co_id_categoria);


--
-- TOC entry 3481 (class 2606 OID 99135)
-- Name: categoria categoria_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.categoria
    ADD CONSTRAINT categoria_unique UNIQUE (no_categoria);


--
-- TOC entry 3483 (class 2606 OID 99137)
-- Name: color color_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.color
    ADD CONSTRAINT color_pk PRIMARY KEY (co_id_color);


--
-- TOC entry 3485 (class 2606 OID 99139)
-- Name: color color_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.color
    ADD CONSTRAINT color_unique UNIQUE (no_color_primario);


--
-- TOC entry 3488 (class 2606 OID 99141)
-- Name: inventario inventario_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario
    ADD CONSTRAINT inventario_pk PRIMARY KEY (co_id_inventario);


--
-- TOC entry 3490 (class 2606 OID 99143)
-- Name: inventario inventario_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario
    ADD CONSTRAINT inventario_unique UNIQUE (prenda_co_id_prenda);


--
-- TOC entry 3497 (class 2606 OID 99201)
-- Name: prenda prenda_definicion_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT prenda_definicion_unique UNIQUE (no_prenda, talla_co_id_talla, color_co_id_color, tela_co_id_tela, tipo_co_id_tipo);


--
-- TOC entry 3499 (class 2606 OID 99147)
-- Name: prenda prenda_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT prenda_pk UNIQUE (co_id_prenda);


--
-- TOC entry 3501 (class 2606 OID 99149)
-- Name: prenda prenda_pkey; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT prenda_pkey PRIMARY KEY (co_id_prenda);


--
-- TOC entry 3503 (class 2606 OID 99151)
-- Name: talla talla_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.talla
    ADD CONSTRAINT talla_pk PRIMARY KEY (co_id_talla);


--
-- TOC entry 3505 (class 2606 OID 99153)
-- Name: talla talla_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.talla
    ADD CONSTRAINT talla_unique UNIQUE (no_talla);


--
-- TOC entry 3507 (class 2606 OID 99155)
-- Name: tela tela_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tela
    ADD CONSTRAINT tela_pk PRIMARY KEY (co_id_tela);


--
-- TOC entry 3509 (class 2606 OID 99157)
-- Name: tela tela_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tela
    ADD CONSTRAINT tela_unique UNIQUE (no_tela);


--
-- TOC entry 3511 (class 2606 OID 99159)
-- Name: tipo tipo_pk; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tipo
    ADD CONSTRAINT tipo_pk PRIMARY KEY (co_id_tipo);


--
-- TOC entry 3513 (class 2606 OID 99161)
-- Name: tipo tipo_unique; Type: CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.tipo
    ADD CONSTRAINT tipo_unique UNIQUE (no_tipo);



--
-- TOC entry 3486 (class 1259 OID 99162)
-- Name: fki_fk__inventario_prenda; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__inventario_prenda ON inventario.inventario USING btree (prenda_co_id_prenda);


--
-- TOC entry 3491 (class 1259 OID 99163)
-- Name: fki_fk__prenda_categoria; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_categoria ON inventario.prenda USING btree (categoria_co_id_categoria);


--
-- TOC entry 3492 (class 1259 OID 99164)
-- Name: fki_fk__prenda_color; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_color ON inventario.prenda USING btree (color_co_id_color);


--
-- TOC entry 3493 (class 1259 OID 99165)
-- Name: fki_fk__prenda_talla; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_talla ON inventario.prenda USING btree (talla_co_id_talla);


--
-- TOC entry 3494 (class 1259 OID 99166)
-- Name: fki_fk__prenda_tela; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_tela ON inventario.prenda USING btree (tela_co_id_tela);


--
-- TOC entry 3495 (class 1259 OID 99167)
-- Name: fki_fk__prenda_tipo; Type: INDEX; Schema: inventario; Owner: postgres
--

CREATE INDEX fki_fk__prenda_tipo ON inventario.prenda USING btree (tipo_co_id_tipo);


--
-- TOC entry 3514 (class 2606 OID 99168)
-- Name: inventario fk__inventario_prenda; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.inventario
    ADD CONSTRAINT fk__inventario_prenda FOREIGN KEY (prenda_co_id_prenda) REFERENCES inventario.prenda(co_id_prenda) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3515 (class 2606 OID 99173)
-- Name: prenda fk__prenda_categoria; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_categoria FOREIGN KEY (categoria_co_id_categoria) REFERENCES inventario.categoria(co_id_categoria) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3516 (class 2606 OID 99178)
-- Name: prenda fk__prenda_color; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_color FOREIGN KEY (color_co_id_color) REFERENCES inventario.color(co_id_color) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3517 (class 2606 OID 99183)
-- Name: prenda fk__prenda_talla; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_talla FOREIGN KEY (talla_co_id_talla) REFERENCES inventario.talla(co_id_talla) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3518 (class 2606 OID 99188)
-- Name: prenda fk__prenda_tela; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_tela FOREIGN KEY (tela_co_id_tela) REFERENCES inventario.tela(co_id_tela) ON UPDATE CASCADE ON DELETE RESTRICT;


--
-- TOC entry 3519 (class 2606 OID 99193)
-- Name: prenda fk__prenda_tipo; Type: FK CONSTRAINT; Schema: inventario; Owner: postgres
--

ALTER TABLE ONLY inventario.prenda
    ADD CONSTRAINT fk__prenda_tipo FOREIGN KEY (tipo_co_id_tipo) REFERENCES inventario.tipo(co_id_tipo) ON UPDATE CASCADE ON DELETE RESTRICT;


-- Completed on 2023-12-15 06:03:50 -05

--
-- PostgreSQL database dump complete
--

