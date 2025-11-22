CREATE TABLE HouseholdBookChange (
    ChangeID         VARCHAR(20) NOT NULL PRIMARY KEY,
    householdBookID  VARCHAR(20) NOT NULL,
    changeType       VARCHAR(200) NOT NULL,
    changeContent    VARCHAR(1000),
    changeDate       DATE NOT NULL,
    FOREIGN KEY (householdBookID) REFERENCES HouseholdBook(householdBookID)
);