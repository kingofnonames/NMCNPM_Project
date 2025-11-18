CREATE TABLE ResidentChange (
    changeID           VARCHAR(20) PRIMARY KEY, 
    residentID         VARCHAR(200) NOT NULL,                 
    oldHouseholdBookID VARCHAR(200) NOT NULL,         
    newHouseholdBookID VARCHAR(200) NOT NULL,         
    reason             VARCHAR(1000) NOT NULL,                          
    changeDate 		   DATE NOT NULL,                      
    FOREIGN KEY (residentID) REFERENCES Resident(residentID),
    FOREIGN KEY (oldHouseholdBookID) REFERENCES HouseholdBook(householdBookID),
    FOREIGN KEY (newHouseholdBookID) REFERENCES HouseholdBook(householdBookID)
);