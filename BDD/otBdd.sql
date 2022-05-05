DROP DATABASE IF EXISTS otBdd;

CREATE DATABASE IF NOT EXISTS otBdd;

use otBdd;

CREATE TABLE client (
  idClient VARCHAR(6),
  nom VARCHAR(25),
  prenom VARCHAR(25),
  tel VARCHAR (13),
  mail VARCHAR(50),
  adresse VARCHAR(50),
  cp VARCHAR(5),
  ville VARCHAR(50),
  CONSTRAINT pk_client PRIMARY KEY (idClient)
);

CREATE TABLE chantier (
  idChantier INT (4),
  nom VARCHAR(25),
  adresse VARCHAR(50),
  cp VARCHAR(5),
  ville VARCHAR(50),
  CONSTRAINT pk_chantier PRIMARY KEY (idChantier)
);

CREATE TABLE camion (
  immatriculation VARCHAR(7),
  tpsNettoyage INT (4),
  tpsVidange INT (4),
  tpsRemplissage INT (4),
  CONSTRAINT pk_camion PRIMARY KEY (immatriculation)
);

CREATE TABLE centrale (
  idCentrale VARCHAR(6),
  adresse VARCHAR(50),
  cp VARCHAR(5),
  ville VARCHAR(50),
  tel VARCHAR(13),
  capaciteProd INT (8),
  CONSTRAINT pk_centrale PRIMARY KEY (idCentrale)
);

CREATE TABLE responsable (
  matriculeResponsable VARCHAR(6),
  nom VARCHAR(25),
  prenom VARCHAR(25),
  tel VARCHAR(13),
  mail VARCHAR(50),
  passwd VARCHAR(25),
  idCentrale VARCHAR(6),
  CONSTRAINT pk_reponsable PRIMARY KEY (matriculeResponsable),
  CONSTRAINT fk_responsable_centrale FOREIGN KEY (idCentrale) REFERENCES centrale (idCentrale)
);

CREATE TABLE logisticien (
  matriculeLogisticien VARCHAR(6),
  nom VARCHAR(25),
  prenom VARCHAR(25),
  tel VARCHAR(13),
  mail VARCHAR(50),
  passwd VARCHAR(25),
  matriculeResponsable VARCHAR(6),
  CONSTRAINT pk_logisticien PRIMARY KEY (matriculeLogisticien),
  CONSTRAINT fk_logisticien_reponsable FOREIGN KEY (matriculeResponsable) REFERENCES responsable (matriculeResponsable)
);

CREATE TABLE chauffeur (
  matriculeChauffeur VARCHAR(6),
  nom VARCHAR(25),
  prenom VARCHAR(25),
  tel VARCHAR(13),
  mail VARCHAR(50),
  passwd VARCHAR (25),
  immatriculation VARCHAR(7),
  CONSTRAINT pk_chauffeur PRIMARY KEY (matriculeChauffeur),
  CONSTRAINT fk_chauffeur_camion FOREIGN KEY (immatriculation) REFERENCES camion (immatriculation)
);

CREATE TABLE contrat (
  numContrat VARCHAR(8),
  dateDebut DATE,
  dateFin DATE,
  qteALivrer DECIMAL (10, 2),
  idClient VARCHAR(6),
  idChantier INT (4),
  CONSTRAINT pk_contrat PRIMARY KEY (numContrat),
  CONSTRAINT fk_contrat_client FOREIGN KEY (idClient) REFERENCES client (idClient),
  CONSTRAINT fk_contrat_chantier FOREIGN KEY (idChantier) REFERENCES chantier(idChantier)
);

CREATE TABLE mission (
  numMission INT (6),
  dateHeure DATETIME,
  qteAtransporter DECIMAL (4, 2),
  AccepterMission TINYINT (1),
  matriculeChauffeur VARCHAR(6),
  matriculeLogisticien VARCHAR(6),
  CONSTRAINT pk_mission PRIMARY KEY (numMission),
  CONSTRAINT fk_mission_chauffeur FOREIGN KEY (matriculeChauffeur) REFERENCES chauffeur(matriculeChauffeur),
  CONSTRAINT fk_mission_logisticien FOREIGN KEY (matriculeLogisticien) REFERENCES logisticien (matriculeLogisticien)
);

CREATE TABLE livrer (
  idChantier INT (4),
  immatriculation VARCHAR(7),
  qteLivree DECIMAL (10, 2),
  nbTour INT (4),
  CONSTRAINT pk_livrer PRIMARY KEY(idChantier, immatriculation),
  CONSTRAINT fk_livrer_camion FOREIGN KEY (immatriculation) REFERENCES camion (immatriculation),
  CONSTRAINT fk_livrer_chantier FOREIGN KEY (idChantier) REFERENCES chantier (idChantier)
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
    'Lens'
  );

INSERT INTO
  camion
VALUES
  ('AA345FG', 30, 15, 30),
  ('AE456RE', 30, 15, 30);

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
  centrale
VALUES
  (
    '5LOO',
    '18eme Rue',
    '59120',
    'Loos',
    '0320170385',
    2000
  ),
  (
    '4TEM',
    'Z.I',
    '59175',
    'Templemars',
    '0328388840',
    1000
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
  )
  -- ,
 -- (
 --   'OLB446',
  --  'Olivie',
  --  ' Bertrand',
 --   '0251687830',
 --   'OlivieBertrand@rhyta.com',
 --   'olivie',
 --   null
--  ),
 -- (
   -- 'FOL357',
 --   'Fortin',
 --   'Logistilla',
 --   '0217011338',
 --   'LogistillaFortin@armyspy.com',
 --   'fortin',
 --   null
 -- ),
 -- (
  --  'PLM759',
  --  'Plourde',
  --  'Mélodie',
  --  '0169489277',
  --  'MelodiePlourde@teleworm.us',
  --  'plourde',
  --  null
  -- )
  ;

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
    1,'SWD471',
    'GOB592'
    
  );

INSERT INTO
  livrer
VALUES
  (1, 'AA345FG', 6000, 10);
