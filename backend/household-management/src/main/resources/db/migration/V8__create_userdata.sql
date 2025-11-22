create table UserData (
	residentID varchar(20) primary key,
    password varchar(200) not null,
    email varchar(200) not null,
    isActive tinyint not null,
    FOREIGN KEY (residentID) REFERENCES Resident(residentID) ON DELETE CASCADE
);