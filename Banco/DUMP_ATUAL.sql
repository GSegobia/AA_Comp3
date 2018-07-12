--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.12
-- Dumped by pg_dump version 10.4 (Ubuntu 10.4-0ubuntu0.18.04)

-- Started on 2018-07-12 02:26:26 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12397)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2278 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 188 (class 1259 OID 63106)
-- Name: associacao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.associacao (
    id integer NOT NULL,
    numero_oficio character varying(15) NOT NULL,
    data_oficio date NOT NULL,
    nome character varying(50) NOT NULL,
    sigla character varying(10) NOT NULL,
    matricula character varying(20) NOT NULL,
    telefone character varying(15) NOT NULL,
    num_comprovante_pgto character varying(15) NOT NULL,
    endereco character varying(100)
);


ALTER TABLE public.associacao OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 63104)
-- Name: associacao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.associacao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.associacao_id_seq OWNER TO postgres;

--
-- TOC entry 2279 (class 0 OID 0)
-- Dependencies: 187
-- Name: associacao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.associacao_id_seq OWNED BY public.associacao.id;


--
-- TOC entry 190 (class 1259 OID 63127)
-- Name: atleta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.atleta (
    id integer NOT NULL,
    matricula character varying(20) NOT NULL,
    nome character varying(50) NOT NULL,
    associacao_id integer NOT NULL,
    data_nascimento date NOT NULL,
    data_entrada_associacao date NOT NULL,
    data_oficio date NOT NULL,
    categoria_id integer NOT NULL,
    numero_oficio character varying(15) NOT NULL,
    num_comprovante_pgto character varying(20)
);


ALTER TABLE public.atleta OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 63125)
-- Name: atleta_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.atleta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.atleta_id_seq OWNER TO postgres;

--
-- TOC entry 2280 (class 0 OID 0)
-- Dependencies: 189
-- Name: atleta_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.atleta_id_seq OWNED BY public.atleta.id;


--
-- TOC entry 184 (class 1259 OID 63075)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.categoria (
    id integer NOT NULL,
    nome character varying(20) NOT NULL
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 63073)
-- Name: categoria_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_id_seq OWNER TO postgres;

--
-- TOC entry 2281 (class 0 OID 0)
-- Dependencies: 183
-- Name: categoria_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_id_seq OWNED BY public.categoria.id;


--
-- TOC entry 194 (class 1259 OID 63155)
-- Name: centro_aquatico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.centro_aquatico (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    endereco character varying(100),
    tamanho_piscina integer NOT NULL
);


ALTER TABLE public.centro_aquatico OWNER TO postgres;

--
-- TOC entry 193 (class 1259 OID 63153)
-- Name: centro_aquatico_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.centro_aquatico_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.centro_aquatico_id_seq OWNER TO postgres;

--
-- TOC entry 2282 (class 0 OID 0)
-- Dependencies: 193
-- Name: centro_aquatico_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.centro_aquatico_id_seq OWNED BY public.centro_aquatico.id;


--
-- TOC entry 192 (class 1259 OID 63147)
-- Name: classe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.classe (
    id integer NOT NULL,
    nome character varying(30) NOT NULL
);


ALTER TABLE public.classe OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 63145)
-- Name: classe_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.classe_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.classe_id_seq OWNER TO postgres;

--
-- TOC entry 2283 (class 0 OID 0)
-- Dependencies: 191
-- Name: classe_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.classe_id_seq OWNED BY public.classe.id;


--
-- TOC entry 196 (class 1259 OID 63180)
-- Name: competicao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.competicao (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    centro_aquatico_id integer NOT NULL,
    data_competicao timestamp without time zone NOT NULL,
    tamanho_piscina integer NOT NULL
);


ALTER TABLE public.competicao OWNER TO postgres;

--
-- TOC entry 195 (class 1259 OID 63178)
-- Name: competicao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.competicao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.competicao_id_seq OWNER TO postgres;

--
-- TOC entry 2284 (class 0 OID 0)
-- Dependencies: 195
-- Name: competicao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.competicao_id_seq OWNED BY public.competicao.id;


--
-- TOC entry 182 (class 1259 OID 63064)
-- Name: permissao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permissao (
    id integer NOT NULL,
    nome character varying NOT NULL
);


ALTER TABLE public.permissao OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 63062)
-- Name: permissao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.permissao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.permissao_id_seq OWNER TO postgres;

--
-- TOC entry 2285 (class 0 OID 0)
-- Dependencies: 181
-- Name: permissao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.permissao_id_seq OWNED BY public.permissao.id;


--
-- TOC entry 198 (class 1259 OID 63198)
-- Name: prova; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prova (
    id integer NOT NULL,
    nome character varying(30) NOT NULL,
    classe_id integer NOT NULL,
    categoria_id integer NOT NULL,
    competicao_id integer NOT NULL
);


ALTER TABLE public.prova OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 63250)
-- Name: prova_atleta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prova_atleta (
    id_prova integer NOT NULL,
    id_atleta integer NOT NULL
);


ALTER TABLE public.prova_atleta OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 63196)
-- Name: prova_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prova_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prova_id_seq OWNER TO postgres;

--
-- TOC entry 2286 (class 0 OID 0)
-- Dependencies: 197
-- Name: prova_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prova_id_seq OWNED BY public.prova.id;


--
-- TOC entry 200 (class 1259 OID 63221)
-- Name: resultado_provas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resultado_provas (
    id integer NOT NULL,
    tempo integer NOT NULL,
    prova_id integer NOT NULL,
    atleta_id integer NOT NULL
);


ALTER TABLE public.resultado_provas OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 63219)
-- Name: resultado_provas_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resultado_provas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resultado_provas_id_seq OWNER TO postgres;

--
-- TOC entry 2287 (class 0 OID 0)
-- Dependencies: 199
-- Name: resultado_provas_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resultado_provas_id_seq OWNED BY public.resultado_provas.id;


--
-- TOC entry 186 (class 1259 OID 63083)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    matricula character varying(20) NOT NULL,
    nome character varying(100) NOT NULL,
    senha character varying(50) NOT NULL,
    permissao_id integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 63081)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2288 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_seq OWNED BY public.usuario.id;


--
-- TOC entry 2083 (class 2604 OID 63109)
-- Name: associacao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.associacao ALTER COLUMN id SET DEFAULT nextval('public.associacao_id_seq'::regclass);


--
-- TOC entry 2084 (class 2604 OID 63130)
-- Name: atleta id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atleta ALTER COLUMN id SET DEFAULT nextval('public.atleta_id_seq'::regclass);


--
-- TOC entry 2081 (class 2604 OID 63078)
-- Name: categoria id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN id SET DEFAULT nextval('public.categoria_id_seq'::regclass);


--
-- TOC entry 2086 (class 2604 OID 63158)
-- Name: centro_aquatico id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.centro_aquatico ALTER COLUMN id SET DEFAULT nextval('public.centro_aquatico_id_seq'::regclass);


--
-- TOC entry 2085 (class 2604 OID 63150)
-- Name: classe id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.classe ALTER COLUMN id SET DEFAULT nextval('public.classe_id_seq'::regclass);


--
-- TOC entry 2087 (class 2604 OID 63183)
-- Name: competicao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competicao ALTER COLUMN id SET DEFAULT nextval('public.competicao_id_seq'::regclass);


--
-- TOC entry 2080 (class 2604 OID 63067)
-- Name: permissao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissao ALTER COLUMN id SET DEFAULT nextval('public.permissao_id_seq'::regclass);


--
-- TOC entry 2088 (class 2604 OID 63201)
-- Name: prova id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prova ALTER COLUMN id SET DEFAULT nextval('public.prova_id_seq'::regclass);


--
-- TOC entry 2089 (class 2604 OID 63224)
-- Name: resultado_provas id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resultado_provas ALTER COLUMN id SET DEFAULT nextval('public.resultado_provas_id_seq'::regclass);


--
-- TOC entry 2082 (class 2604 OID 63086)
-- Name: usuario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id SET DEFAULT nextval('public.usuario_id_seq'::regclass);


--
-- TOC entry 2256 (class 0 OID 63106)
-- Dependencies: 188
-- Data for Name: associacao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.associacao (id, numero_oficio, data_oficio, nome, sigla, matricula, telefone, num_comprovante_pgto, endereco) FROM stdin;
1	n_oficio_teste	2018-07-10	nome teste	sigla	12838128	99999-9999	546455646	\N
\.


--
-- TOC entry 2258 (class 0 OID 63127)
-- Dependencies: 190
-- Data for Name: atleta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.atleta (id, matricula, nome, associacao_id, data_nascimento, data_entrada_associacao, data_oficio, categoria_id, numero_oficio, num_comprovante_pgto) FROM stdin;
1	1	Atleta da Silva	1	1955-01-01	2018-07-10	2012-06-06	2	123456789012345	\N
\.


--
-- TOC entry 2252 (class 0 OID 63075)
-- Dependencies: 184
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id, nome) FROM stdin;
1	Feminino
2	Masculino
\.


--
-- TOC entry 2262 (class 0 OID 63155)
-- Dependencies: 194
-- Data for Name: centro_aquatico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.centro_aquatico (id, nome, endereco, tamanho_piscina) FROM stdin;
\.


--
-- TOC entry 2260 (class 0 OID 63147)
-- Dependencies: 192
-- Data for Name: classe; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.classe (id, nome) FROM stdin;
1	Mirim
2	Mirim I
3	Mirim II
4	Petiz I
5	Petiz II
6	Infantil I
7	Infantil II
8	Juvenil I
9	Juvenil II
10	Junior I
11	Junior II
12	Sênior
13	Master
\.


--
-- TOC entry 2264 (class 0 OID 63180)
-- Dependencies: 196
-- Data for Name: competicao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.competicao (id, nome, centro_aquatico_id, data_competicao, tamanho_piscina) FROM stdin;
\.


--
-- TOC entry 2250 (class 0 OID 63064)
-- Dependencies: 182
-- Data for Name: permissao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permissao (id, nome) FROM stdin;
1	Diretor Técnico
2	Técnico Associação
3	Secretário
\.


--
-- TOC entry 2266 (class 0 OID 63198)
-- Dependencies: 198
-- Data for Name: prova; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prova (id, nome, classe_id, categoria_id, competicao_id) FROM stdin;
\.


--
-- TOC entry 2269 (class 0 OID 63250)
-- Dependencies: 201
-- Data for Name: prova_atleta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prova_atleta (id_prova, id_atleta) FROM stdin;
\.


--
-- TOC entry 2268 (class 0 OID 63221)
-- Dependencies: 200
-- Data for Name: resultado_provas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resultado_provas (id, tempo, prova_id, atleta_id) FROM stdin;
\.


--
-- TOC entry 2254 (class 0 OID 63083)
-- Dependencies: 186
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, matricula, nome, senha, permissao_id) FROM stdin;
1	teste	Sr. Diretor Técnico	teste	1
\.


--
-- TOC entry 2289 (class 0 OID 0)
-- Dependencies: 187
-- Name: associacao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.associacao_id_seq', 1, false);


--
-- TOC entry 2290 (class 0 OID 0)
-- Dependencies: 189
-- Name: atleta_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.atleta_id_seq', 1, true);


--
-- TOC entry 2291 (class 0 OID 0)
-- Dependencies: 183
-- Name: categoria_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_id_seq', 2, true);


--
-- TOC entry 2292 (class 0 OID 0)
-- Dependencies: 193
-- Name: centro_aquatico_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.centro_aquatico_id_seq', 1, false);


--
-- TOC entry 2293 (class 0 OID 0)
-- Dependencies: 191
-- Name: classe_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.classe_id_seq', 13, true);


--
-- TOC entry 2294 (class 0 OID 0)
-- Dependencies: 195
-- Name: competicao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.competicao_id_seq', 1, true);


--
-- TOC entry 2295 (class 0 OID 0)
-- Dependencies: 181
-- Name: permissao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.permissao_id_seq', 3, true);


--
-- TOC entry 2296 (class 0 OID 0)
-- Dependencies: 197
-- Name: prova_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prova_id_seq', 1, false);


--
-- TOC entry 2297 (class 0 OID 0)
-- Dependencies: 199
-- Name: resultado_provas_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resultado_provas_id_seq', 1, false);


--
-- TOC entry 2298 (class 0 OID 0)
-- Dependencies: 185
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_seq', 1, false);


--
-- TOC entry 2099 (class 2606 OID 63119)
-- Name: associacao associacao_matricula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.associacao
    ADD CONSTRAINT associacao_matricula_key UNIQUE (matricula);


--
-- TOC entry 2101 (class 2606 OID 63115)
-- Name: associacao associacao_nome_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.associacao
    ADD CONSTRAINT associacao_nome_key UNIQUE (nome);


--
-- TOC entry 2103 (class 2606 OID 63113)
-- Name: associacao associacao_numero_oficio_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.associacao
    ADD CONSTRAINT associacao_numero_oficio_key UNIQUE (numero_oficio);


--
-- TOC entry 2105 (class 2606 OID 63111)
-- Name: associacao associacao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.associacao
    ADD CONSTRAINT associacao_pkey PRIMARY KEY (id);


--
-- TOC entry 2107 (class 2606 OID 63117)
-- Name: associacao associacao_sigla_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.associacao
    ADD CONSTRAINT associacao_sigla_key UNIQUE (sigla);


--
-- TOC entry 2109 (class 2606 OID 63134)
-- Name: atleta atleta_matricula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atleta
    ADD CONSTRAINT atleta_matricula_key UNIQUE (matricula);


--
-- TOC entry 2111 (class 2606 OID 63132)
-- Name: atleta atleta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atleta
    ADD CONSTRAINT atleta_pkey PRIMARY KEY (id);


--
-- TOC entry 2093 (class 2606 OID 63080)
-- Name: categoria categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id);


--
-- TOC entry 2115 (class 2606 OID 63162)
-- Name: centro_aquatico centro_aquatico_nome_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.centro_aquatico
    ADD CONSTRAINT centro_aquatico_nome_key UNIQUE (nome);


--
-- TOC entry 2117 (class 2606 OID 63160)
-- Name: centro_aquatico centro_aquatico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.centro_aquatico
    ADD CONSTRAINT centro_aquatico_pkey PRIMARY KEY (id);


--
-- TOC entry 2113 (class 2606 OID 63152)
-- Name: classe classe_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.classe
    ADD CONSTRAINT classe_pkey PRIMARY KEY (id);


--
-- TOC entry 2119 (class 2606 OID 63185)
-- Name: competicao competicao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competicao
    ADD CONSTRAINT competicao_pkey PRIMARY KEY (id);


--
-- TOC entry 2091 (class 2606 OID 63072)
-- Name: permissao permissao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permissao
    ADD CONSTRAINT permissao_pkey PRIMARY KEY (id);


--
-- TOC entry 2121 (class 2606 OID 63203)
-- Name: prova prova_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_pkey PRIMARY KEY (id);


--
-- TOC entry 2123 (class 2606 OID 63226)
-- Name: resultado_provas resultado_provas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resultado_provas
    ADD CONSTRAINT resultado_provas_pkey PRIMARY KEY (id);


--
-- TOC entry 2095 (class 2606 OID 63090)
-- Name: usuario usuario_matricula_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_matricula_key UNIQUE (matricula);


--
-- TOC entry 2097 (class 2606 OID 63088)
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2125 (class 2606 OID 63135)
-- Name: atleta atleta_associacao_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atleta
    ADD CONSTRAINT atleta_associacao_id_fkey FOREIGN KEY (associacao_id) REFERENCES public.associacao(id);


--
-- TOC entry 2126 (class 2606 OID 63140)
-- Name: atleta atleta_categoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.atleta
    ADD CONSTRAINT atleta_categoria_id_fkey FOREIGN KEY (categoria_id) REFERENCES public.categoria(id);


--
-- TOC entry 2127 (class 2606 OID 63186)
-- Name: competicao competicao_centro_aquatico_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competicao
    ADD CONSTRAINT competicao_centro_aquatico_id_fkey FOREIGN KEY (centro_aquatico_id) REFERENCES public.centro_aquatico(id);


--
-- TOC entry 2134 (class 2606 OID 63258)
-- Name: prova_atleta prova_atleta_id_atleta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prova_atleta
    ADD CONSTRAINT prova_atleta_id_atleta_fkey FOREIGN KEY (id_atleta) REFERENCES public.atleta(id);


--
-- TOC entry 2133 (class 2606 OID 63253)
-- Name: prova_atleta prova_atleta_id_prova_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prova_atleta
    ADD CONSTRAINT prova_atleta_id_prova_fkey FOREIGN KEY (id_prova) REFERENCES public.prova(id);


--
-- TOC entry 2129 (class 2606 OID 63209)
-- Name: prova prova_categoria_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_categoria_id_fkey FOREIGN KEY (categoria_id) REFERENCES public.categoria(id);


--
-- TOC entry 2128 (class 2606 OID 63204)
-- Name: prova prova_classe_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_classe_id_fkey FOREIGN KEY (classe_id) REFERENCES public.classe(id);


--
-- TOC entry 2130 (class 2606 OID 63214)
-- Name: prova prova_competicao_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prova
    ADD CONSTRAINT prova_competicao_id_fkey FOREIGN KEY (competicao_id) REFERENCES public.competicao(id);


--
-- TOC entry 2132 (class 2606 OID 63232)
-- Name: resultado_provas resultado_provas_atleta_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resultado_provas
    ADD CONSTRAINT resultado_provas_atleta_id_fkey FOREIGN KEY (atleta_id) REFERENCES public.atleta(id);


--
-- TOC entry 2131 (class 2606 OID 63227)
-- Name: resultado_provas resultado_provas_prova_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resultado_provas
    ADD CONSTRAINT resultado_provas_prova_id_fkey FOREIGN KEY (prova_id) REFERENCES public.prova(id);


--
-- TOC entry 2124 (class 2606 OID 63091)
-- Name: usuario usuario_permissao_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_permissao_id_fkey FOREIGN KEY (permissao_id) REFERENCES public.permissao(id);


--
-- TOC entry 2277 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-07-12 02:26:26 -03

--
-- PostgreSQL database dump complete
--

