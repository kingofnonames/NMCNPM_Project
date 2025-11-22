CREATE TABLE HouseholdMember (
    householdBookID         VARCHAR(20) NOT NULL,
    residentID              VARCHAR(20) NOT NULL,
    role                    VARCHAR(200) NOT NULL, -- có thể là chủ hộ, vợ/ chồng, con cái, ...
    PRIMARY KEY (householdBookID, residentID),
    FOREIGN KEY (householdBookID) REFERENCES HouseholdBook(householdBookID),
    FOREIGN KEY (residentID) REFERENCES Resident(residentID)
);