DROP TABLE IF EXISTS responsable;
DROP TABLE IF EXISTS centrale;
DROP TABLE IF EXISTS logisticien;
DROP TABLE IF EXISTS camion;
DROP TABLE IF EXISTS chauffeur;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS mission;
DROP TABLE IF EXISTS chantier;
DROP TABLE IF EXISTS contrat;
DROP TABLE IF EXISTS livraison;

CREATE TABLE chantier
(
    id_chantier         LONG AUTO_INCREMENT NOT NULL,
    nom_chantier        VARCHAR(50),
    adresse_chantier    VARCHAR(50),
    cp_chantier         VARCHAR(5),
    ville_chantier      VARCHAR(50),
    coordonnee_chantier VARCHAR(16),
    CONSTRAINT pk_chantier PRIMARY KEY(id_chantier)
);

CREATE TABLE client
(
    id_client      LONG AUTO_INCREMENT NOT NULL,
    nom_client     VARCHAR(25),
    prenom_client  VARCHAR(25),
    tel_client     VARCHAR(13),
    mail_client    VARCHAR(50),
    adresse_client VARCHAR(50),
    cp_client      VARCHAR(5),
    ville_client   VARCHAR(50),
    CONSTRAINT pk_client PRIMARY KEY (id_client)
);
CREATE TABLE camion
(
    id_camion LONG AUTO_INCREMENT NOT NULL,
    immatriculation  VARCHAR(7),
    nettoyage   INT(4),
    vidange     INT(4),
    remplissage INT(4),
    CONSTRAINT pk_camion PRIMARY KEY (id_camion)
);

Create table centrale
(
    id_centrale        LONG AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    nom_centrale       varchar(25),
    tel_centrale      varchar(13),
    adresse_centrale   varchar(50),
    cp_centrale        varchar(5),
    ville_centrale    varchar(50),
    coordonne_centrale varchar (20),
    capacite_prod  int(4)

);

CREATE TABLE contrat
(
    num_contrat           LONG AUTO_INCREMENT NOT NULL,
    date_debut_contrat   DATE,
    date_fin_contrat     DATE,
    qte_a_livrer_contrat DECIMAL(10, 2),
    id_client  INT(4),
    id_chantier INT(4),
  CONSTRAINT pk_contrat PRIMARY KEY (num_contrat),
  CONSTRAINT fk_contrat_client FOREIGN KEY (id_client) REFERENCES client (id_client),
  CONSTRAINT fk_contrat_chantier FOREIGN KEY (id_chantier) REFERENCES chantier(id_chantier)
);

CREATE TABLE responsable
(
    id_responsable          LONG AUTO_INCREMENT NOT NULL,
    nom_responsable          VARCHAR(25),
    prenom_responsable       VARCHAR(25),
    tel_responsable          VARCHAR(13),
    mail_responsable        VARCHAR(25),
    passwd_responsable       VARCHAR(50),
    id_centrale INT(4),
      CONSTRAINT pk_reponsable PRIMARY KEY (id_responsable),
  CONSTRAINT fk_responsable_centrale FOREIGN KEY (id_centrale) REFERENCES centrale (id_centrale)
);

CREATE TABLE logisticien
(
    id_logisticien            LONG AUTO_INCREMENT NOT NULL,
    nom_logisticien            VARCHAR(25),
    prenom_logisticien        VARCHAR(25),
    tel_logisticien            VARCHAR(13),
    mail_logisticien           VARCHAR(50),
    passwd_logisticien         VARCHAR(50),
    id_responsable INT(4),
  CONSTRAINT pk_logisticien PRIMARY KEY (id_logisticien),
  CONSTRAINT fk_logisticien_reponsable FOREIGN KEY (id_responsable) REFERENCES responsable (id_responsable)
);


CREATE TABLE chauffeur
(
    id_chauffeur        LONG AUTO_INCREMENT NOT NULL,
    nom_chauffeur       VARCHAR(25),
    prenom_chauffeur    VARCHAR(25),
    tel_chauffeur       VARCHAR(13),
    mail_chauffeur      VARCHAR(50),
    passwd_chauffeur    VARCHAR(50),
    id_camion INT(4),
  CONSTRAINT pk_chauffeur PRIMARY KEY (id_chauffeur),
  CONSTRAINT fk_chauffeur_camion FOREIGN KEY (id_camion) REFERENCES camion (id_camion)
    
);

CREATE TABLE mission
(
    id_mission                LONG AUTO_INCREMENT NOT NULL,
    date_heure_mission         DATETIME,
    qte_a_transporter_mission  DECIMAL(4, 2),
    accepter_mission  TINYINT(1),
    id_logisticien   INT(4),
    id_chauffeur     INT(4)
,
  CONSTRAINT pk_mission PRIMARY KEY (id_mission),
  CONSTRAINT fk_mission_chauffeur FOREIGN KEY (id_chauffeur) REFERENCES chauffeur(id_chauffeur),
  CONSTRAINT fk_mission_logisticien FOREIGN KEY (id_logisticien) REFERENCES logisticien (id_logisticien)
);


CREATE TABLE livraison
(
    id_livraison LONG AUTO_INCREMENT NOT NULL,
    id_chantier INT(4),
    id_camion   INT(4),
    qte_livree  DECIMAL(8, 2),
    nb_tour     INT(4),
    
  CONSTRAINT pk_livraison PRIMARY KEY(id_livraison),
  CONSTRAINT fk_livrer_camion FOREIGN KEY (id_camion) REFERENCES camion (id_camion),
  CONSTRAINT fk_livrer_chantier FOREIGN KEY (id_chantier) REFERENCES chantier (id_chantier)
);

INSERT INTO client
VALUES (1,
        'Barry',
        'Coudert',
        '0125936450',
        'BarryCoudert@teleworm.us ',
        '77  Avenue Millies Lacroix',
        '95600',
        'EAUBONNE'),
       (2,
        'Peverell',
        'Boucher',
        '0240817968',
        'PeverellBoucher@dayrep.com',
        '94, rue Ernest Renan',
        '50100',
        'CHERBOURG');

INSERT INTO chantier
VALUES (1,
        'Stade Bollaert',
        'Av. Alfred Maes',
        '62300',
        'Lens',
        '50.43287,2.81508');

INSERT INTO centrale
VALUES (1,
        'Cemex Betons Nord Ouest',
        '0321946559',
        '680 route de saint josse',
        '62155',
        'Merlimont',
        '50.45725, 1.62103',
        1000),
       (2,
        'Cemex Betons Nord Ouest',
        '0321342299',
        'R des mouettes zone industrielle des dunes',
        '62100',
        'Calais',
        '50.96574,1.89556',
        1000),
       (3,
        'Eqiom Betons Nord',
        '0321317649',
        '6, Rue louis bleriot',
        '62360',
        'Saint-Léonard',
        '50.69704,1.60628',
        1000),
       (4,
        'Cemex Betons Nord Ouest',
        '0321868011',
        'Rue du grand marais',
        '62140',
        'Marconnelle',
        '50.37743,2.00901',
        1000),
       (5,
        'Eqiom Betons Nord',
        '0327870541',
        '820 r francisco ferrer',
        '59286',
        'Roost - Warendin',
        '50.40104,3.10693',
        1000),
       (6,
        'Cb Pre-mix',
        '0320625959',
        '5 Rue les Longues Royes',
        '59750',
        'Feignies',
        '50.27651,3.92672',
        1000),
       (7,
        'Eqiom Betons Nord',
        '0321567676',
        'Port Fluvial',
        '62400',
        'Béthune',
        '50.53668,2.67293',
        1000),
       (8,
        'Unibeton Nord Ouest',
        '0327476159',
        'Rue du Chevalier de la Barre',
        '59860',
        'Bruay-sur-lEscaut',
        '50.39694,3.54158',
        1000),
       (9,
        'Unibeton Nord Ouest',
        '0320432082',
        '24 Rue du Pont dArdennes',
        '62570',
        'Wizernes',
        '50.70977,2.24424',
        1000),
       (10,
        'Unibeton Nord Ouest',
        '0327601498',
        '32 Av. des Bureaux',
        '59610',
        'Fourmies',
        '50.01055,4.05292',
        1000),
       (11,
        'Unibeton Nord Ouest',
        '0328274143',
        'Rte des Salines,Port autonome',
        '59760',
        'Grande-Synthe',
        '51.04003,2.27835',
        1000),
       (12,
        'Eqiom Beton Nord',
        '0327730802',
        'Z.I, Rue Cantimpré',
        '59267',
        'Proville',
        '50.1706 ,3.20753',
        1000),
       (13,
        'Unibeton Nord Ouest',
        '0320351375',
        '19 Rue René Laennec',
        '59930',
        'Chapelle-dArmentières (La)',
        '50.65016,2.90291',
        1000),
       (14,
        'Eqiom Betons Nord',
        '0321221212',
        'Av. dImmercourt',
        '62223',
        'Saint-Laurent-Blangy',
        '50.43287,2.81508',
        1000),
       (15,
        'Centrale Cemex de Loos',
        '0320170385',
        '18eme Rue',
        '59120',
        'Loos',
        '50.62287,3.01784',
        2000),
       (16,
        'Cb Pre-mix',
        '0328388840',
        'Rte de vendeville',
        '59175',
        'Templemars',
        '50.56511,3.06662',
        1000);

INSERT INTO responsable
VALUES (1,
        'Fields',
        'Sophia',
        '0743736706',
        'neque.nullam@google.couk',
        'fields',
        5),
       (2,
        'Desforges',
        'Laure',
        '0536471797',
        'LaureSavoie@rhyta.com ',
        'desforges',
        8);

INSERT INTO logisticien
VALUES (1,
        'Swanson',
        'Darius',
        '0382381911',
        'quis.pede.suspendisse@google.edu',
        'swanson',
        1),
       (2,
        'Schneider',
        'Oliver',
        '0823307257',
        'risus@outlook.ca',
        'scneider',
        1),
       (3,
        'Rodriguez',
        'Abra',
        '0388657754',
        'dolor.egestas@protonmail.couk',
        'rodriguez',
        2),
       (4,
        'Kramer',
        'Jin',
        '0612546136',
        'lacus.etiam.bibendum@aol.couk',
        'kramer',
        1),
       (5,
        'Clavette',
        'Dorothée',
        '0595489168',
        'DorotheeClavette@jourrapide.com ',
        'clavette',
        2);

INSERT INTO camion
VALUES (1,'AA345EE' ,30, 15, 30),
       (2, 'EE453AA',30, 15, 30);

INSERT INTO chauffeur
VALUES (1,
        'Fecteau',
        'Marlon',
        '0193874663',
        'MarlonFecteau@teleworm.us',
        'fecteau',
        2),
       (2,
        'Gougeon',
        'Bruce',
        '0363657897',
        'BruceGougeon@rhyta.com',
        'gougeon',
        1);

INSERT INTO mission
VALUES (1,
        '2022-03-01 08:54:32',
        7.5,
        1,
        1,
       2);

INSERT INTO contrat
VALUES (1,
        '2022-04-01',
        null,
        300000,
       1,
        1);

INSERT INTO livraison
VALUES (1,1, 1, 6000, 10);
