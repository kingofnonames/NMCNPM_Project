ALTER TABLE HouseholdBook
ADD CONSTRAINT fk_householder
FOREIGN KEY (householderID) REFERENCES Resident(residentID);