CREATE TABLE TemporaryAbsenceDeclaration (
    declarationID             VARCHAR(20) NOT NULL PRIMARY KEY,  
    residentID                VARCHAR(20) NOT NULL,     
    temporaryResidenceAddress VARCHAR(200),             
    destination               VARCHAR(200) NOT NULL,             
    startDate                 DATE NOT NULL,                     
    endDate                   DATE NOT NULL,                     
    reason                    VARCHAR(1000) NOT NULL,    
    status                    VARCHAR(200) NOT NULL, 
    FOREIGN KEY (residentID) REFERENCES Resident(residentID) ON DELETE CASCADE
);
