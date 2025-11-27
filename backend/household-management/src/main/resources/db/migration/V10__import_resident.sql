LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/ResidentsData.csv'
INTO TABLE Resident
CHARACTER SET utf8mb4
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 ROWS
(residentID, householdBookID, idIssueDate, idIssuePlace, fullName, alias, dateOfBirth, placeOfBirth, hometown, ethnicity, occupation, workplace, permanentRegistrationDate, permanentResidenceAddress, @isDead)
SET isDead = CASE WHEN @isDead='false' THEN 0
                  WHEN @isDead='true' THEN 1
                  ELSE 0 END;
