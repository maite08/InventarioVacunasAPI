PGDMP     /    $                z            inventario_vacuna    14.0    14.0                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    548830    inventario_vacuna    DATABASE     o   CREATE DATABASE inventario_vacuna WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Ecuador.1252';
 !   DROP DATABASE inventario_vacuna;
                postgres    false            ?            1259    565283 	   empleados    TABLE     ?  CREATE TABLE public.empleados (
    id_empleado bigint NOT NULL,
    apellidos character varying(255) NOT NULL,
    cedula character varying(10),
    correo character varying(100) NOT NULL,
    direccion character varying(255),
    estado_vacuna boolean NOT NULL,
    fecha_nacimiento character varying(255),
    fecha_vacunacion timestamp without time zone,
    nombres character varying(255) NOT NULL,
    numero_dosis character varying(255),
    telefono character varying(255),
    tipo_vacuna bigint
);
    DROP TABLE public.empleados;
       public         heap    postgres    false            ?            1259    565282    empleados_id_empleado_seq    SEQUENCE     ?   CREATE SEQUENCE public.empleados_id_empleado_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.empleados_id_empleado_seq;
       public          postgres    false    215                       0    0    empleados_id_empleado_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.empleados_id_empleado_seq OWNED BY public.empleados.id_empleado;
          public          postgres    false    214            ?            1259    549016    roles    TABLE     ?   CREATE TABLE public.roles (
    nombre character varying(255) NOT NULL,
    estado_registro boolean NOT NULL,
    role_description character varying(255)
);
    DROP TABLE public.roles;
       public         heap    postgres    false            ?            1259    548875    tipo_vacunas    TABLE     o   CREATE TABLE public.tipo_vacunas (
    id_vacunas bigint NOT NULL,
    nombre_vacuna character varying(255)
);
     DROP TABLE public.tipo_vacunas;
       public         heap    postgres    false            ?            1259    548874    tipo_vacunas_id_vacunas_seq    SEQUENCE     ?   CREATE SEQUENCE public.tipo_vacunas_id_vacunas_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.tipo_vacunas_id_vacunas_seq;
       public          postgres    false    210                       0    0    tipo_vacunas_id_vacunas_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.tipo_vacunas_id_vacunas_seq OWNED BY public.tipo_vacunas.id_vacunas;
          public          postgres    false    209            ?            1259    557096    usuarios    TABLE     ?   CREATE TABLE public.usuarios (
    username character varying(10) NOT NULL,
    apellidos character varying(255),
    correo character varying(255),
    nombres character varying(255),
    password character varying(100)
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            ?            1259    557103    usuarios_roles    TABLE     ?   CREATE TABLE public.usuarios_roles (
    id_usuario character varying(255) NOT NULL,
    id_roles character varying(255) NOT NULL
);
 "   DROP TABLE public.usuarios_roles;
       public         heap    postgres    false            n           2604    565286    empleados id_empleado    DEFAULT     ~   ALTER TABLE ONLY public.empleados ALTER COLUMN id_empleado SET DEFAULT nextval('public.empleados_id_empleado_seq'::regclass);
 D   ALTER TABLE public.empleados ALTER COLUMN id_empleado DROP DEFAULT;
       public          postgres    false    214    215    215            m           2604    548878    tipo_vacunas id_vacunas    DEFAULT     ?   ALTER TABLE ONLY public.tipo_vacunas ALTER COLUMN id_vacunas SET DEFAULT nextval('public.tipo_vacunas_id_vacunas_seq'::regclass);
 F   ALTER TABLE public.tipo_vacunas ALTER COLUMN id_vacunas DROP DEFAULT;
       public          postgres    false    209    210    210                      0    565283 	   empleados 
   TABLE DATA           ?   COPY public.empleados (id_empleado, apellidos, cedula, correo, direccion, estado_vacuna, fecha_nacimiento, fecha_vacunacion, nombres, numero_dosis, telefono, tipo_vacuna) FROM stdin;
    public          postgres    false    215   8$       	          0    549016    roles 
   TABLE DATA           J   COPY public.roles (nombre, estado_registro, role_description) FROM stdin;
    public          postgres    false    211   ,%                 0    548875    tipo_vacunas 
   TABLE DATA           A   COPY public.tipo_vacunas (id_vacunas, nombre_vacuna) FROM stdin;
    public          postgres    false    210   z%       
          0    557096    usuarios 
   TABLE DATA           R   COPY public.usuarios (username, apellidos, correo, nombres, password) FROM stdin;
    public          postgres    false    212   ?%                 0    557103    usuarios_roles 
   TABLE DATA           >   COPY public.usuarios_roles (id_usuario, id_roles) FROM stdin;
    public          postgres    false    213   ?'                  0    0    empleados_id_empleado_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.empleados_id_empleado_seq', 6, true);
          public          postgres    false    214                       0    0    tipo_vacunas_id_vacunas_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.tipo_vacunas_id_vacunas_seq', 1, false);
          public          postgres    false    209            x           2606    565290    empleados empleados_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_pkey PRIMARY KEY (id_empleado);
 B   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_pkey;
       public            postgres    false    215            r           2606    549022    roles roles_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (nombre);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    211            p           2606    548880    tipo_vacunas tipo_vacunas_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.tipo_vacunas
    ADD CONSTRAINT tipo_vacunas_pkey PRIMARY KEY (id_vacunas);
 H   ALTER TABLE ONLY public.tipo_vacunas DROP CONSTRAINT tipo_vacunas_pkey;
       public            postgres    false    210            t           2606    557102    usuarios usuarios_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (username);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    212            v           2606    557109 "   usuarios_roles usuarios_roles_pkey 
   CONSTRAINT     r   ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT usuarios_roles_pkey PRIMARY KEY (id_usuario, id_roles);
 L   ALTER TABLE ONLY public.usuarios_roles DROP CONSTRAINT usuarios_roles_pkey;
       public            postgres    false    213    213            y           2606    557110 *   usuarios_roles fkloit1qf0j3sitt3pwjcrucabd    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT fkloit1qf0j3sitt3pwjcrucabd FOREIGN KEY (id_roles) REFERENCES public.roles(nombre);
 T   ALTER TABLE ONLY public.usuarios_roles DROP CONSTRAINT fkloit1qf0j3sitt3pwjcrucabd;
       public          postgres    false    211    3186    213            {           2606    565291 %   empleados fkpww1fli3l2cfnr98c82cfnm1g    FK CONSTRAINT     ?   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT fkpww1fli3l2cfnr98c82cfnm1g FOREIGN KEY (tipo_vacuna) REFERENCES public.tipo_vacunas(id_vacunas);
 O   ALTER TABLE ONLY public.empleados DROP CONSTRAINT fkpww1fli3l2cfnr98c82cfnm1g;
       public          postgres    false    210    215    3184            z           2606    557115 *   usuarios_roles fkt5th9sao5wjukq9ij7154ktuw    FK CONSTRAINT     ?   ALTER TABLE ONLY public.usuarios_roles
    ADD CONSTRAINT fkt5th9sao5wjukq9ij7154ktuw FOREIGN KEY (id_usuario) REFERENCES public.usuarios(username);
 T   ALTER TABLE ONLY public.usuarios_roles DROP CONSTRAINT fkt5th9sao5wjukq9ij7154ktuw;
       public          postgres    false    3188    213    212               ?   x?]?Qk?0ǟ/?"_?rI?4ݓAEKQ?}	RGG??u{ا_"s??A?????v???j??B?B?N???[|?١???sg??Ze?g?)?õ2????,c??5?2???vr?8Z*????(??{????5??ԅ?ZcDm?????????,a8???l?O??q?	?#^7ƭM?E4?B?'?K???????؉4<W?????o/?-Wؽ`=#?? :ASs      	   >   x?sL????,???QH?3?K?S???\srR?,?dA~?BJjZjrI??B*T?+F??? 6-?         :   x?3?.(-????2?t,.)J?J?KMN?2?HˬJ-?2?????+??S??\1z\\\ ??R      
   ?  x?e?K??P???+\?????? ???"`??7(????????3&???T*?;?Kf??T]?fv%S??**?i????_٤J*?+b)?6?3I?Ub?Ds?w?V?X?Z?n,_?:a<,mQ	*??cz??u??x?ܤ?#?G$@P?x????!?(?H?$gV?iY??$`(?pP??e?g??ks?.ُ??^??????l$}k!???$??'!?i??ex]H??v?0?-Q?塞?Fn,???L?Yc%???ܕ?8?d???W??E\?????;_?????K!??A.????????a>)?~?[??g???n??
?K?v$Ͱ/??Ŀz??gI?&?P(?^?JZ????5???D??a??`??ՙI??฽{?+?[??0??M??"??%??G????????[????"^??1l???u?r?Y?e??Ԣ1lN?I??O?$???1??         O   x?3426153??4?t?-?IML??2?4
??X?#?Y??? 	Y??cJnfPT?YX????=... b??     