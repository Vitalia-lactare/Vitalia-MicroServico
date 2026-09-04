create table doadoras (
    id bigint not null auto_increment,
    nome varchar(150) not null,
    email varchar(150) not null,
    senha_hash varchar(64) not null,
    telefone varchar(20),
    cep varchar(9) not null,
    data_nascimento date not null,
    data_cadastro datetime not null,
    consentimento_lgpd bit not null,
    data_consentimento_lgpd datetime not null,
    primary key (id),
    unique key uk_doadoras_email (email)
) engine = InnoDB;

create table pontos_coleta (
    id bigint not null auto_increment,
    nome_hospital varchar(150) not null,
    cep varchar(9) not null,
    endereco varchar(200),
    telefone varchar(20),
    horario_funcionamento varchar(100),
    nivel_estoque varchar(10) not null,
    ativo bit not null,
    primary key (id)
) engine = InnoDB;

create table quiz_triagens (
    id bigint not null auto_increment,
    doadora_id bigint,
    amamentando_atualmente bit not null,
    idade_bebe_meses int,
    usa_medicamento bit not null,
    fumante bit not null,
    realizou_exames_recentes bit not null,
    cep varchar(9) not null,
    resultado varchar(30) not null,
    motivo_alerta varchar(50),
    data_resposta datetime not null,
    primary key (id),
    constraint fk_triagem_doadora foreign key (doadora_id) references doadoras (id)
) engine = InnoDB;

create table doacoes (
    id bigint not null auto_increment,
    doadora_id bigint not null,
    ponto_coleta_id bigint not null,
    estagio_leite varchar(20),
    status varchar(20) not null,
    volume_ml int,
    data_agendamento datetime not null,
    data_coleta datetime,
    data_conclusao datetime,
    primary key (id),
    constraint fk_doacao_doadora foreign key (doadora_id) references doadoras (id),
    constraint fk_doacao_ponto_coleta foreign key (ponto_coleta_id) references pontos_coleta (id)
) engine = InnoDB;

create table logs_doacao (
    id bigint not null auto_increment,
    doacao_id bigint not null,
    status_anterior varchar(20),
    status_novo varchar(20) not null,
    observacao varchar(255),
    data_hora datetime not null,
    primary key (id),
    constraint fk_log_doacao foreign key (doacao_id) references doacoes (id)
) engine = InnoDB;

create table pesquisas_satisfacao (
    id bigint not null auto_increment,
    doadora_id bigint not null,
    doacao_id bigint,
    nota int not null,
    comentario varchar(500),
    data_resposta datetime not null,
    primary key (id),
    constraint fk_pesquisa_doadora foreign key (doadora_id) references doadoras (id),
    constraint fk_pesquisa_doacao foreign key (doacao_id) references doacoes (id)
) engine = InnoDB;

create table eventos_funil (
    id bigint not null auto_increment,
    session_id varchar(36) not null,
    doadora_id bigint,
    tipo_evento varchar(30) not null,
    step_number int,
    cep varchar(9),
    data_hora datetime not null,
    primary key (id),
    constraint fk_evento_doadora foreign key (doadora_id) references doadoras (id)
) engine = InnoDB;
