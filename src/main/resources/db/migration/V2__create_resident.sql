CREATE TABLE Resident (
    residentID                 VARCHAR(20) NOT NULL PRIMARY KEY,
    householdBookID            VARCHAR(20) NOT NULL,
    idIssueDate                DATE NOT NULL,
    idIssuePlace               VARCHAR(100) NOT NULL, 
    fullName                   VARCHAR(100) NOT NULL,
    alias                      VARCHAR(100), 
    dateOfBirth                DATE NOT NULL,
    placeOfBirth               VARCHAR(100) NOT NULL,
    hometown                   VARCHAR(100) NOT NULL, 
    ethnicity                  VARCHAR(50) NOT NULL,
    occupation                 VARCHAR(100),
    workplace                  VARCHAR(200), 
    permanentRegistrationDate  DATE NOT NULL,
    permanentResidenceAddress  VARCHAR(200) NOT NULL,
    isDead                     BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (householdBookID) REFERENCES HouseholdBook(householdBookID)
);  
