DROP DATABASE IF EXISTS otbdd;

CREATE DATABASE otbdd;

USE otbdd;

DROP TABLE IF EXISTS client;

CREATE TABLE client (
    id_client VARCHAR(6),
    nom_client VARCHAR(25),
    prenom_client VARCHAR(25),
    tel_client VARCHAR(13),
    mail_client VARCHAR(50),
    adresse_client VARCHAR(50),
    cp_client VARCHAR(5),
    ville_client VARCHAR(50),
    CONSTRAINT pk_client PRIMARY KEY (id_client)
);

DROP TABLE IF EXISTS chantier;

CREATE TABLE chantier(
    id_chantier INT(6),
    nom_chantier VARCHAR(50),
    adresse_chantier VARCHAR(50),
    cp_chantier VARCHAR(5),
    ville_chantier VARCHAR(50),
    coordonnee_chantier VARCHAR (16),
    CONSTRAINT pk_chantier PRIMARY KEY (id_chantier)
);

DROP TABLE IF EXISTS camion;

CREATE TABLE camion(
    immatriculation VARCHAR(7),
    tps_nettoyage INT(4),
    tps_vidange INT(4),
    tps_remplissage INT(4),
    CONSTRAINT pk_camion PRIMARY KEY (immatriculation)
);

DROP TABLE IF EXISTS centrale;

CREATE TABLE centrale(
    id_centrale VARCHAR(6),
    nom_centrale VARCHAR(50),
    tel_centrale VARCHAR(13),
    adresse_centrale VARCHAR(50),
    cp_centrale VARCHAR(6),
    ville_centrale VARCHAR(50),
    coordonne_centrale VARCHAR (20),
    capacite_prod INT(6),
    CONSTRAINT pk_centrale PRIMARY KEY (id_centrale)
);

DROP TABLE IF EXISTS contrat;

CREATE TABLE contrat(
    num_contrat VARCHAR(10),
    date_debut_contrat DATE,
    date_fin_contrat DATE,
    qte_a_livrer DECIMAL(10, 2),
    id_client VARCHAR(6),
    id_chantier INT(6),
    CONSTRAINT pk_contrat PRIMARY KEY (num_contrat),
    CONSTRAINT fk_contrat_client FOREIGN KEY (id_client) REFERENCES client (id_client),
    CONSTRAINT fk_contrat_chantier FOREIGN KEY (id_chantier) REFERENCES chantier (id_chantier)
);

DROP TABLE IF EXISTS responsable;

CREATE TABLE responsable(
    matricule_responsable VARCHAR(6),
    nom_responsable VARCHAR(25),
    prenom_responsable VARCHAR(25),
    tel_responsable VARCHAR(13),
    mail_responsable VARCHAR(25),
    passwd_responsable VARCHAR(50),
    id_centrale VARCHAR(6),
    CONSTRAINT pk_responsable PRIMARY KEY (matricule_responsable),
    CONSTRAINT fk_responsable_centrale FOREIGN KEY (id_centrale) REFERENCES centrale (id_centrale)
);

DROP TABLE IF EXISTS logisticien;

CREATE TABLE logisticien(
    matricule_logisticien VARCHAR(6),
    nom_logisticien VARCHAR(25),
    prenom_logisticien VARCHAR(25),
    tel_logisticien VARCHAR(13),
    mail_logisticien VARCHAR(50),
    passwd_logisticien VARCHAR(50),
    matricule_responsable VARCHAR(6),
    CONSTRAINT pk_logisticien PRIMARY KEY (matricule_logisticien),
    CONSTRAINT fk_responsable_logisticien FOREIGN KEY (matricule_responsable) REFERENCES responsable (matricule_responsable)
);

DROP TABLE IF EXISTS chauffeur;

CREATE TABLE chauffeur(
    matricule_chauffeur VARCHAR(6),
    nom_chauffeur VARCHAR(25),
    prenom_chauffeur VARCHAR(25),
    tel_chauffeur VARCHAR(13),
    mail_chauffeur VARCHAR(50),
    passwd_chauffeur VARCHAR(50),
    immatriculation VARCHAR(7),
    CONSTRAINT pk_chauffeur PRIMARY KEY (matricule_chauffeur),
    CONSTRAINT fk_chauffeur_camion FOREIGN KEY (immatriculation) REFERENCES camion (immatriculation)
);

DROP TABLE IF EXISTS mission;

CREATE TABLE mission(
    num_mission INT(6),
    date_heure_mission DATETIME,
    qte_a_transporter DECIMAL(4, 2),
    accepter_mission TINYINT(1),
    matricule_logisticien VARCHAR(6),
    matricule_chauffeur VARCHAR(6),
    CONSTRAINT pk_mission PRIMARY KEY (num_mission),
    CONSTRAINT fk_mission_logisticien FOREIGN KEY (matricule_logisticien) REFERENCES logisticien (matricule_logisticien),
    CONSTRAINT fk_mission_chauffeur FOREIGN KEY (matricule_chauffeur) REFERENCES chauffeur (matricule_chauffeur)
);

DROP TABLE IF EXISTS livrer;

CREATE TABLE livrer(
    id_chantier INT(6),
    immatriculation VARCHAR(7),
    qte_livree DECIMAL(8, 2),
    nb_tour INT(6),
    CONSTRAINT pk_louer PRIMARY KEY (id_chantier, immatriculation),
    CONSTRAINT fk_livrer_chantier FOREIGN KEY (id_chantier) REFERENCES chantier (id_chantier),
    CONSTRAINT fk_livrer_camion FOREIGN KEY (immatriculation) REFERENCES camion (immatriculation)
);

INSERT INTO
    client
VALUES
    (
        'BAC951',
        'Barry',
        'Coudert',
        '0125936450',
        'BarryCoudert@teleworm.us ',
        '77  Avenue Millies Lacroix',
        '95600',
        'EAUBONNE'
    ),
    (
        'PEB501',
        'Peverell',
        'Boucher',
        '0240817968',
        'PeverellBoucher@dayrep.com',
        '94, rue Ernest Renan',
        '50100',
        'CHERBOURG'
    );

INSERT INTO
    chantier
VALUES
    (
        1,
        'Stade Bollaert',
        'Av. Alfred Maes',
        '62300',
        'Lens',
        '50.43287,2.81508'
    );

INSERT INTO
    camion
VALUES
    ('AA345FG', 30, 15, 30),
    ('AE456RE', 30, 15, 30);

INSERT INTO
    centrale
VALUES
    (
        '5MER',
        'Cemex Betons Nord Ouest',
        '0321946559',
        '680 route de saint josse',
        '62155',
        'Merlimont',
        '50.45725, 1.62103',
        1000
    ),
    (
        '5CAL',
        'Cemex Betons Nord Ouest',
        '0321342299',
        'R des mouettes zone industrielle des dunes',
        '62100',
        'Calais',
        '50.96574,1.89556',
        1000
    ),
    (
        '6STL',
        'Eqiom Betons Nord',
        '0321317649',
        '6, Rue louis bleriot',
        '62360',
        'Saint-Léonard',
        '50.69704,1.60628',
        1000
    ),
    (
        '5MAR',
        'Cemex Betons Nord Ouest',
        '0321868011',
        'Rue du grand marais',
        '62140',
        'Marconnelle',
        '50.37743,2.00901',
        1000
    ),
    (
        '1RW',
        'Eqiom Betons Nord',
        '0327870541',
        '820 r francisco ferrer',
        '59286',
        'Roost - Warendin',
        '50.40104,3.10693',
        1000
    ),
    (
        '4FEI',
        'Cb Pre-mix',
        '0320625959',
        '5 Rue les Longues Royes',
        '59750',
        'Feignies',
        '50.27651,3.92672',
        1000
    ),
    (
        '6BET',
        'Eqiom Betons Nord',
        '0321567676',
        'Port Fluvial',
        '62400',
        'Béthune',
        '50.53668,2.67293',
        1000
    ),
    (
        '7BSE',
        'Unibeton Nord Ouest',
        '0327476159',
        'Rue du Chevalier de la Barre',
        '59860',
        'Bruay-sur-l\'Escaut',
        '50.39694,3.54158',
        1000
    ),
    (
        '7W',
        'Unibeton Nord Ouest',
        '0320432082',
        '24 Rue du Pont d\'Ardennes',
        '62570',
        'Wizernes',
        '50.70977,2.24424',
        1000
    ),
    (
        '7FOU',
        'Unibeton Nord Ouest',
        '0327601498',
        '32 Av. des Bureaux',
        '59610',
        'Fourmies',
        '50.01055,4.05292',
        1000
    ),
    (
        '7GRS',
        'Unibeton Nord Ouest',
        '0328274143',
        'Rte des Salines,Port autonome',
        '59760',
        'Grande-Synthe',
        '51.04003,2.27835',
        1000
    ),
    (
        '6PRO',
        'Eqiom Beton Nord',
        '0327730802',
        'Z.I, Rue Cantimpré',
        '59267',
        'Proville',
        '50.1706 ,3.20753',
        1000
    ),
    (
        '7LCA',
        'Unibeton Nord Ouest',
        '0320351375',
        '19 Rue René Laennec',
        '59930',
        'Chapelle-d\' Armentières (La)',
        '50.65016,2.90291',
        1000
    ),
    (
        '6SLB',
        'Eqiom Betons Nord',
        '0321221212',
        'Av. d\' Immercourt',
        '62223',
        'Saint-Laurent-Blangy',
        '50.43287,2.81508',
        1000
    ),
    (
        '5LOO',
        'Centrale Cemex de Loos',
        '0320170385',
        '18eme Rue',
        '59120',
        'Loos',
        '50.62287,3.01784',
        2000
    ),
    (
        '4TEM',
        'Cb Pre-mix',
        '0328388840',
        'Rte de vendeville',
        '59175',
        'Templemars',
        '50.56511,3.06662',
        1000
    );

INSERT INTO
    contrat
VALUES
    (
        'SBBAC951',
        '2022-04-01',
        null,
        300000,
        'BAC951',
        1
    );

INSERT INTO
    responsable
VALUES
    (
        'FIS712',
        'Fields',
        'Sophia',
        '0743736706',
        'neque.nullam@google.couk',
        'fields',
        '4TEM'
    ),
    (
        'DSL340',
        'Desforges',
        'Laure',
        '0536471797',
        'LaureSavoie@rhyta.com ',
        'desforges',
        '5LOO'
    );

INSERT INTO
    logisticien
VALUES
    (
        'SWD471',
        'Swanson',
        'Darius',
        '0382381911',
        'quis.pede.suspendisse@google.edu',
        'swanson',
        'FIS712'
    ),
    (
        'SCO813',
        'Schneider',
        'Oliver',
        '0823307257',
        'risus@outlook.ca',
        'scneider',
        'FIS712'
    ),
    (
        'ROA414',
        'Rodriguez',
        'Abra',
        '0388657754',
        'dolor.egestas@protonmail.couk',
        'rodriguez',
        'DSL340'
    ),
    (
        'KRJ595',
        'Kramer',
        'Jin',
        '0612546136',
        'lacus.etiam.bibendum@aol.couk',
        'kramer',
        'DSL340'
    ),
    (
        'CLD338',
        'Clavette',
        'Dorothée',
        '0595489168',
        'DorotheeClavette@jourrapide.com ',
        'clavette',
        'DSL340'
    );

INSERT INTO
    chauffeur
VALUES
    (
        'FEM921',
        'Fecteau',
        'Marlon',
        '0193874663',
        'MarlonFecteau@teleworm.us',
        'fecteau',
        'AA345FG'
    ),
    (
        'GOB592',
        'Gougeon',
        'Bruce',
        '0363657897',
        'BruceGougeon@rhyta.com',
        'gougeon',
        'AE456RE'
    );

INSERT INTO
    mission
VALUES
    (
        1,
        '2022-03-01 08:54:32',
        7.5,
        1,
        'SWD471',
        'GOB592'
    );

INSERT INTO
    livrer
VALUES
    (1, 'AA345FG', 6000, 10);