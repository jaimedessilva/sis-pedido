
CREATE TABLE public.tb_category (
    id bigint NOT NULL,
    name character varying(255)
);


--
-- TOC entry 196 (class 1259 OID 16683)
-- Name: tb_category_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 196
-- Name: tb_category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_category_id_seq OWNED BY public.tb_category.id;


--
-- TOC entry 199 (class 1259 OID 16693)
-- Name: tb_order; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_order (
    id bigint NOT NULL,
    moment timestamp without time zone,
    order_status integer,
    client_id bigint
);


--
-- TOC entry 198 (class 1259 OID 16691)
-- Name: tb_order_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 198
-- Name: tb_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_order_id_seq OWNED BY public.tb_order.id;


--
-- TOC entry 200 (class 1259 OID 16699)
-- Name: tb_order_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_order_item (
    price double precision,
    quantity integer,
    product_id bigint NOT NULL,
    order_id bigint NOT NULL
);


--
-- TOC entry 201 (class 1259 OID 16704)
-- Name: tb_payment; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_payment (
    moment timestamp without time zone,
    order_id bigint NOT NULL
);


--
-- TOC entry 203 (class 1259 OID 16711)
-- Name: tb_product; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_product (
    id bigint NOT NULL,
    description character varying(255),
    img_url character varying(255),
    name character varying(255),
    price double precision
);


--
-- TOC entry 204 (class 1259 OID 16720)
-- Name: tb_product_category; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_product_category (
    product_id bigint NOT NULL,
    category_id bigint NOT NULL
);


--
-- TOC entry 202 (class 1259 OID 16709)
-- Name: tb_product_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 202
-- Name: tb_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_product_id_seq OWNED BY public.tb_product.id;


--
-- TOC entry 206 (class 1259 OID 16727)
-- Name: tb_user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tb_user (
    id bigint NOT NULL,
    email character varying(255),
    nome character varying(255),
    password character varying(255),
    phone character varying(255)
);


--
-- TOC entry 205 (class 1259 OID 16725)
-- Name: tb_user_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tb_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2974 (class 0 OID 0)
-- Dependencies: 205
-- Name: tb_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.tb_user_id_seq OWNED BY public.tb_user.id;


--
-- TOC entry 2818 (class 2604 OID 16688)
-- Name: tb_category id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_category ALTER COLUMN id SET DEFAULT nextval('public.tb_category_id_seq'::regclass);


--
-- TOC entry 2819 (class 2604 OID 16696)
-- Name: tb_order id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_order ALTER COLUMN id SET DEFAULT nextval('public.tb_order_id_seq'::regclass);


--
-- TOC entry 2820 (class 2604 OID 16714)
-- Name: tb_product id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product ALTER COLUMN id SET DEFAULT nextval('public.tb_product_id_seq'::regclass);


--
-- TOC entry 2821 (class 2604 OID 16730)
-- Name: tb_user id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user ALTER COLUMN id SET DEFAULT nextval('public.tb_user_id_seq'::regclass);


--
-- TOC entry 2823 (class 2606 OID 16690)
-- Name: tb_category tb_category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_category
    ADD CONSTRAINT tb_category_pkey PRIMARY KEY (id);


--
-- TOC entry 2827 (class 2606 OID 16703)
-- Name: tb_order_item tb_order_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_order_item
    ADD CONSTRAINT tb_order_item_pkey PRIMARY KEY (order_id, product_id);


--
-- TOC entry 2825 (class 2606 OID 16698)
-- Name: tb_order tb_order_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_order
    ADD CONSTRAINT tb_order_pkey PRIMARY KEY (id);


--
-- TOC entry 2829 (class 2606 OID 16708)
-- Name: tb_payment tb_payment_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_payment
    ADD CONSTRAINT tb_payment_pkey PRIMARY KEY (order_id);


--
-- TOC entry 2833 (class 2606 OID 16724)
-- Name: tb_product_category tb_product_category_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product_category
    ADD CONSTRAINT tb_product_category_pkey PRIMARY KEY (product_id, category_id);


--
-- TOC entry 2831 (class 2606 OID 16719)
-- Name: tb_product tb_product_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product
    ADD CONSTRAINT tb_product_pkey PRIMARY KEY (id);


--
-- TOC entry 2835 (class 2606 OID 16735)
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


--
-- TOC entry 2837 (class 2606 OID 16741)
-- Name: tb_order_item fk4h5xid5qehset7qwe5l9c997x; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_order_item
    ADD CONSTRAINT fk4h5xid5qehset7qwe5l9c997x FOREIGN KEY (product_id) REFERENCES public.tb_product(id);


--
-- TOC entry 2840 (class 2606 OID 16756)
-- Name: tb_product_category fk5r4sbavb4nkd9xpl0f095qs2a; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product_category
    ADD CONSTRAINT fk5r4sbavb4nkd9xpl0f095qs2a FOREIGN KEY (category_id) REFERENCES public.tb_category(id);


--
-- TOC entry 2841 (class 2606 OID 16761)
-- Name: tb_product_category fkgbof0jclmaf8wn2alsoexxq3u; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_product_category
    ADD CONSTRAINT fkgbof0jclmaf8wn2alsoexxq3u FOREIGN KEY (product_id) REFERENCES public.tb_product(id);


--
-- TOC entry 2838 (class 2606 OID 16746)
-- Name: tb_order_item fkgeobgl2xu916he8vhljktwxnx; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_order_item
    ADD CONSTRAINT fkgeobgl2xu916he8vhljktwxnx FOREIGN KEY (order_id) REFERENCES public.tb_order(id);


--
-- TOC entry 2836 (class 2606 OID 16736)
-- Name: tb_order fki0x0rv7d65vsceuy33km9567n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_order
    ADD CONSTRAINT fki0x0rv7d65vsceuy33km9567n FOREIGN KEY (client_id) REFERENCES public.tb_user(id);


--
-- TOC entry 2839 (class 2606 OID 16751)
-- Name: tb_payment fkokaf4il2cwit4h780c25dv04r; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tb_payment
    ADD CONSTRAINT fkokaf4il2cwit4h780c25dv04r FOREIGN KEY (order_id) REFERENCES public.tb_order(id);


-- Completed on 2020-08-04 00:17:20 -03

--
-- PostgreSQL database dump complete
--

