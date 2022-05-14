DROP TABLE IF EXISTS responsable;
DROP TABLE IF EXISTS centrale;
DROP TABLE IF EXISTS logisticien;
DROP TABLE IF EXISTS camion;
DROP TABLE IF EXISTS chauffeur;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS mission;
DROP TABLE IF EXISTS chantier;
DROP TABLE IF EXISTS contrat;
DROP TABLE IF EXISTS livrer;

CREATE TABLE chantier
(
    id         INT,
    nom        VARCHAR(50),
    adresse    VARCHAR(50),
    cp         VARCHAR(5),
    ville      VARCHAR(50),
    coordonnee VARCHAR(16)
);

CREATE TABLE client
(
    id      VARCHAR(6),
    nom     VARCHAR(25),
    prenom  VARCHAR(25),
    tel     VARCHAR(13),
    mail    VARCHAR(50),
    adresse VARCHAR(50),
    cp      VARCHAR(5),
    ville   VARCHAR(50)
);
CREATE TABLE camion
(
    id          VARCHAR(7),
    nettoyage   INT(4),
    vidange     INT(4),
    remplissage INT(4)
);

Create table centrale
(
    id        varchar,
    nom       varchar,
    tel       varchar,
    adresse   varchar,
    cp        varchar,
    ville     varchar,
    coordonne varchar,
    capacite_prod  int

);

CREATE TABLE contrat
(
    id           INT,
    date_debut   DATE,
    date_fin     DATE,
    qte_a_livrer DECIMAL(10, 2),
    client_id    VARCHAR(6),
    chantier_id  INT
);

CREATE TABLE responsable
(
    id          VARCHAR(6),
    nom         VARCHAR(25),
    prenom      VARCHAR(25),
    tel         VARCHAR(13),
    mail        VARCHAR(25),
    passwd      VARCHAR(50),
    centrale_id VARCHAR(6)
);

CREATE TABLE logisticien
(
    id             VARCHAR(6),
    nom            VARCHAR(25),
    prenom         VARCHAR(25),
    tel            VARCHAR(13),
    mail           VARCHAR(50),
    passwd         VARCHAR(50),
    responsable_id VARCHAR(6)
);


CREATE TABLE chauffeur
(
    id        VARCHAR(6),
    nom       VARCHAR(25),
    prenom    VARCHAR(25),
    tel       VARCHAR(13),
    mail      VARCHAR(50),
    passwd    VARCHAR(50),
    camion_id VARCHAR(7)
);

CREATE TABLE mission
(
    id                INT,
    date_heure        DATETIME,
    qte_a_transporter DECIMAL(4, 2),
    accepter_mission  TINYINT(1),
    logisticien_id    VARCHAR(6),
    chauffeur_id      VARCHAR(6)

);


CREATE TABLE livrer
(
    chantier_id INT,
    camion_id   VARCHAR(7),
    qte_livree  DECIMAL(8, 2),
    nb_tour     INT
);

INSERT INTO client
VALUES ('BAC951',
        'Barry',
        'Coudert',
        '0125936450',
        'BarryCoudert@teleworm.us ',
        '77  Avenue Millies Lacroix',
        '95600',
        'EAUBONNE'),
       ('PEB501',
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
VALUES ('3MER',
        'Cemex Betons Nord Ouest',
        '0321946559',
        '680 route de saint josse',
        '62155',
        'Merlimont',
        '50.45725, 1.62103',
        1000),
       ('5CAL',
        'Cemex Betons Nord Ouest',
        '0321342299',
        'R des mouettes zone industrielle des dunes',
        '62100',
        'Calais',
        '50.96574,1.89556',
        1000),
       ('6STL',
        'Eqiom Betons Nord',
        '0321317649',
        '6, Rue louis bleriot',
        '62360',
        'Saint-Léonard',
        '50.69704,1.60628',
        1000),
       ('5MAR',
        'Cemex Betons Nord Ouest',
        '0321868011',
        'Rue du grand marais',
        '62140',
        'Marconnelle',
        '50.37743,2.00901',
        1000),
       ('1RW',
        'Eqiom Betons Nord',
        '0327870541',
        '820 r francisco ferrer',
        '59286',
        'Roost - Warendin',
        '50.40104,3.10693',
        1000),
       ('4FEI',
        'Cb Pre-mix',
        '0320625959',
        '5 Rue les Longues Royes',
        '59750',
        'Feignies',
        '50.27651,3.92672',
        1000),
       ('6BET',
        'Eqiom Betons Nord',
        '0321567676',
        'Port Fluvial',
        '62400',
        'Béthune',
        '50.53668,2.67293',
        1000),
       ('7BSE',
        'Unibeton Nord Ouest',
        '0327476159',
        'Rue du Chevalier de la Barre',
        '59860',
        'Bruay-sur-lEscaut',
        '50.39694,3.54158',
        1000),
       ('7W',
        'Unibeton Nord Ouest',
        '0320432082',
        '24 Rue du Pont dArdennes',
        '62570',
        'Wizernes',
        '50.70977,2.24424',
        1000),
       ('7FOU',
        'Unibeton Nord Ouest',
        '0327601498',
        '32 Av. des Bureaux',
        '59610',
        'Fourmies',
        '50.01055,4.05292',
        1000),
       ('7GRS',
        'Unibeton Nord Ouest',
        '0328274143',
        'Rte des Salines,Port autonome',
        '59760',
        'Grande-Synthe',
        '51.04003,2.27835',
        1000),
       ('6PRO',
        'Eqiom Beton Nord',
        '0327730802',
        'Z.I, Rue Cantimpré',
        '59267',
        'Proville',
        '50.1706 ,3.20753',
        1000),
       ('7LCA',
        'Unibeton Nord Ouest',
        '0320351375',
        '19 Rue René Laennec',
        '59930',
        'Chapelle-dArmentières (La)',
        '50.65016,2.90291',
        1000),
       ('6SLB',
        'Eqiom Betons Nord',
        '0321221212',
        'Av. dImmercourt',
        '62223',
        'Saint-Laurent-Blangy',
        '50.43287,2.81508',
        1000),
       ('5LOO',
        'Centrale Cemex de Loos',
        '0320170385',
        '18eme Rue',
        '59120',
        'Loos',
        '50.62287,3.01784',
        2000),
       ('4TEM',
        'Cb Pre-mix',
        '0328388840',
        'Rte de vendeville',
        '59175',
        'Templemars',
        '50.56511,3.06662',
        1000);

INSERT INTO responsable
VALUES ('FIS712',
        'Fields',
        'Sophia',
        '0743736706',
        'neque.nullam@google.couk',
        'fields',
        '4TEM'),
       ('DSL340',
        'Desforges',
        'Laure',
        '0536471797',
        'LaureSavoie@rhyta.com ',
        'desforges',
        '5LOO');

INSERT INTO logisticien
VALUES ('SWD471',
        'Swanson',
        'Darius',
        '0382381911',
        'quis.pede.suspendisse@google.edu',
        'swanson',
        'FIS712'),
       ('SCO813',
        'Schneider',
        'Oliver',
        '0823307257',
        'risus@outlook.ca',
        'scneider',
        'FIS712'),
       ('ROA414',
        'Rodriguez',
        'Abra',
        '0388657754',
        'dolor.egestas@protonmail.couk',
        'rodriguez',
        'DSL340'),
       ('KRJ595',
        'Kramer',
        'Jin',
        '0612546136',
        'lacus.etiam.bibendum@aol.couk',
        'kramer',
        'DSL340'),
       ('CLD338',
        'Clavette',
        'Dorothée',
        '0595489168',
        'DorotheeClavette@jourrapide.com ',
        'clavette',
        'DSL340');

INSERT INTO camion
VALUES ('AA345FG', 30, 15, 30),
       ('AE456RE', 30, 15, 30);

INSERT INTO chauffeur
VALUES ('FEM921',
        'Fecteau',
        'Marlon',
        '0193874663',
        'MarlonFecteau@teleworm.us',
        'fecteau',
        'AA345FG'),
       ('GOB592',
        'Gougeon',
        'Bruce',
        '0363657897',
        'BruceGougeon@rhyta.com',
        'gougeon',
        'AE456RE');

INSERT INTO mission
VALUES (1,
        '2022-03-01 08:54:32',
        7.5,
        1,
        'SWD471',
        'GOB592');

INSERT INTO contrat
VALUES (1,
        '2022-04-01',
        null,
        300000,
        'BAC951',
        1);

INSERT INTO livrer
VALUES (1, 'AA345FG', 6000, 10);