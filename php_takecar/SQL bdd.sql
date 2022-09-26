#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Clients
#------------------------------------------------------------

CREATE TABLE Clients(
        NumClient    Int  Auto_increment  NOT NULL ,
        NomC         Varchar (50) NOT NULL ,
        PrenomC      Varchar (50) NOT NULL ,
        IdentifiantC Varchar (50) NOT NULL ,
        MdpC         Varchar (50) NOT NULL ,
        EmailC       Varchar (50) NOT NULL ,
        TelC         Varchar (50) NOT NULL
	,CONSTRAINT Clients_PK PRIMARY KEY (NumClient)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: VOITURES
#------------------------------------------------------------

CREATE TABLE VOITURES(
        IdVehicule     Int  Auto_increment  NOT NULL ,
        MarqueVeh      Varchar (50) NOT NULL ,
        ReferenceVeh   Varchar (50) NOT NULL ,
        TypeVeh        Varchar (50) NOT NULL ,
        AnneeVeh       Varchar (50) NOT NULL ,
        KilometrageVeh Int NOT NULL ,
        MoteurVeh      Varchar (50) NOT NULL ,
        EtatVeh        Varchar (50) NOT NULL ,
        OptionsVeh     Varchar (50) NOT NULL ,
        DisponibleVeh  Bool NOT NULL ,
        PrixHeureVeh   Double NOT NULL ,
        NumClient      Int NOT NULL
	,CONSTRAINT VOITURES_PK PRIMARY KEY (IdVehicule)

	,CONSTRAINT VOITURES_Clients_FK FOREIGN KEY (NumClient) REFERENCES Clients(NumClient)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: LocationVoiture
#------------------------------------------------------------

CREATE TABLE LocationVoiture(
        IdLoc        Int  Auto_increment  NOT NULL ,
        Loueur       Int NOT NULL ,
        Locataire    Int NOT NULL ,
        DateDebLoc   Date NOT NULL ,
        DateFinLoc   Date NOT NULL ,
        PrixTotalLoc Double NOT NULL ,
        IdVehicule   Int NOT NULL
	,CONSTRAINT LocationVoiture_PK PRIMARY KEY (IdLoc)

	,CONSTRAINT LocationVoiture_VOITURES_FK FOREIGN KEY (IdVehicule) REFERENCES VOITURES(IdVehicule)
	,CONSTRAINT LocationVoiture_Clients0_FK FOREIGN KEY (Loueur) REFERENCES Clients(NumClient)
	,CONSTRAINT LocationVoiture_Clients0_FK FOREIGN KEY (Locataire) REFERENCES Clients(NumClient)
)ENGINE=InnoDB;

