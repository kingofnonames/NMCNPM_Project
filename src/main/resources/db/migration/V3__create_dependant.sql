CREATE TABLE Dependant (
    householdBookID         VARCHAR(20) NOT NULL,
    residentID              VARCHAR(20) NOT NULL,
    dependantRelationship   VARCHAR(200) NOT NULL,
    PRIMARY KEY (householdBookID, residentID),
    FOREIGN KEY (householdBookID) REFERENCES HouseholdBook(householdBookID),
    FOREIGN KEY (residentID) REFERENCES Resident(residentID)
);