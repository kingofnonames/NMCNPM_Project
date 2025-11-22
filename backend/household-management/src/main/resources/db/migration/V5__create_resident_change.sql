CREATE TABLE ResidentChange (
    changeID           VARCHAR(20) PRIMARY KEY, 
    residentID         VARCHAR(20) NOT NULL,                 
    oldHouseholdBookID VARCHAR(20),         
    newHouseholdBookID VARCHAR(20),         
    reason             VARCHAR(1000) NOT NULL,                          
    changeDate 		   DATE NOT NULL,                      
    FOREIGN KEY (residentID) REFERENCES Resident(residentID),
    FOREIGN KEY (oldHouseholdBookID) REFERENCES HouseholdBook(householdBookID),
    FOREIGN KEY (newHouseholdBookID) REFERENCES HouseholdBook(householdBookID)
);