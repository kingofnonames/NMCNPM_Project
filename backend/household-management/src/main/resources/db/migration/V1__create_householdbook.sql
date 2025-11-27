CREATE TABLE HouseholdBook (
    householdBookID  VARCHAR(20) NOT NULL PRIMARY KEY,   
    address          VARCHAR(200) NOT NULL,
    issueDate        DATE NOT NULL,
    status           VARCHAR(200) NOT NULL
);