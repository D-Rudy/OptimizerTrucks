DROP DATABASE IF EXISTS otBdd;

CREATE DATABASE IF NOT EXISTS otBdd;

use otBdd;

CREATE TABLE client
(
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



CREATE TABLE chantier
(
idChantier INT (4),
nom VARCHAR(25), 
adresse VARCHAR(50), 
cp VARCHAR(5), 
ville VARCHAR(50),
CONSTRAINT pk_chantier PRIMARY KEY (idChantier)
);



CREATE TABLE camion
(
immatriculation VARCHAR(7),
tpsNettoyage INT (4),
tpsVidange INT (4),
tpsRemplissage INT (4),
CONSTRAINT pk_camion PRIMARY KEY (immatriculation)
);



CREATE TABLE centrale
(
idCentrale VARCHAR(6), 
adresse VARCHAR(50), 
cp VARCHAR(5),
ville VARCHAR(50),
tel VARCHAR(13),
capaciteProd INT (8),
CONSTRAINT pk_centrale PRIMARY KEY (idCentrale)
);



CREATE TABLE employe
(
matricule VARCHAR(6),
nom VARCHAR(25),
prenom VARCHAR(25),
tel VARCHAR(13),
mail VARCHAR(50),
fonction VARCHAR(20),
password VARCHAR(25),
idCentrale VARCHAR(6),
matriculeResponsable VARCHAR(6),
CONSTRAINT pk_employe PRIMARY KEY (matricule),
CONSTRAINT fk_employe FOREIGN KEY (matriculeResponsable) REFERENCES employe (matricule),
CONSTRAINT fk_employe_centrale FOREIGN KEY (idCentrale) REFERENCES centrale
);



CREATE TABLE chauffeur
(
matricule VARCHAR(6),
nom VARCHAR(25), 
prenom VARCHAR(25), 
tel VARCHAR(13), 
mail VARCHAR(50), 
immatriculation VARCHAR(7),
CONSTRAINT pk_chauffeur PRIMARY KEY (matricule),
CONSTRAINT fk_chauffeur FOREIGN KEY (immatriculation) REFERENCES camion
);



CREATE TABLE contrat
(
numContrat VARCHAR(6),
dateDebut DATE,
dateFin DATE,
qteALivrer DECIMAL (10,2),
idClient VARCHAR(6),
idChantier INT (4),
CONSTRAINT pk_contrat PRIMARY KEY (numContrat),
CONSTRAINT fk_contrat_client FOREIGN KEY (idClient) REFERENCES client,
CONSTRAINT fk_contrat_chantier FOREIGN KEY (idChantier) REFERENCES chantier(idChantier)
);



CREATE TABLE mission
(
numMission INT (6),
dateHeure DATETIME,
qteAtransporter DECIMAL (4,2),
AccepterMission TINYINT (1) DEFAULT 0,
matriculeChauffeur VARCHAR(6),
matriculeEmploye VARCHAR(6),
CONSTRAINT pk_mission PRIMARY KEY (numMission),
CONSTRAINT fk_mission_employe FOREIGN KEY (matriculeEmploye) REFERENCES employe(matricule),
CONSTRAINT fk_mission_chauffeur FOREIGN KEY (matriculeChauffeur) REFERENCES chauffeur(matricule)
);



CREATE TABLE livrer
(
idChantier INT (4),
immatriculation VARCHAR(7),
qteLivree DECIMAL (10,2),
nbTour INT (4),
CONSTRAINT pk_livrer PRIMARY KEY(idChantier, immatriculation),
CONSTRAINT fk_livrer_camion FOREIGN KEY (immatriculation) REFERENCES camion,
CONSTRAINT fk_livrer_chantier FOREIGN KEY (idChantier) REFERENCES chantier

);

