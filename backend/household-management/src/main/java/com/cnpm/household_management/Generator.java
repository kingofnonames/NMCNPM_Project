package com.cnpm.household_management;

import net.datafaker.Faker;
import com.opencsv.*;
import java.io.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Generator {
    private final int numberOfPermanentHouseholdBooks;
    private final int numberOfTemporaryHouseholdBooks;
    private int numberOfResidents = 0;
    private final File HOUSEHOLD_BOOKS_FILE = new File("backend/household-management/src/main/resources/dataset/HouseholdBooksData.csv");
    private final File RESIDENTS_FILE = new File("backend/household-management/src/main/resources/dataset/ResidentsData.csv");
    private final File DEPENDENTS_FILE = new File("backend/household-management/src/main/resources/dataset/DependentsData.csv");
    private final Random RANDOM = new Random(22);
    private final Faker FAKER = new Faker(Locale.of("vi"), RANDOM);


    public Generator(int numberOfPermanentHouseholdBooks, int numberOfTemporaryHouseholdBooks) {
        this.numberOfPermanentHouseholdBooks = numberOfPermanentHouseholdBooks;
        this.numberOfTemporaryHouseholdBooks = numberOfTemporaryHouseholdBooks;
    }

    private LocalDate randomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = startEpochDay + RANDOM.nextLong(endEpochDay - startEpochDay + 1);
        return LocalDate.ofEpochDay(randomDay);
    }

    public void generateHouseholdBooks() {
        try {
            FileWriter output = new FileWriter(HOUSEHOLD_BOOKS_FILE);
            CSVWriter writer = new CSVWriter(output);
            String[] header = { "HouseholdBookID", "HouseholderID", "Address", "IssueDate", "Status" };
            writer.writeNext(header);
            int currentNumberOfPermanentHouseholdBooks = 0;
            int currentNumberOfTemporaryHouseholdBooks = 0;
            for (int i = 0; i < numberOfPermanentHouseholdBooks + numberOfTemporaryHouseholdBooks; ++i) {
                String householdBookID = String.format("%09d", i);
                String householderID = String.format("%011d", numberOfResidents);
                String address = String.format("Số %d tổ dân phố 7 phường La Khê", i + 1);
                LocalDate issueDate = randomDate(LocalDate.of(1975, 1, 1), LocalDate.of(2024, 12, 31));
                String status;
                if (currentNumberOfPermanentHouseholdBooks <= numberOfPermanentHouseholdBooks && currentNumberOfTemporaryHouseholdBooks <= numberOfTemporaryHouseholdBooks) {
                    if (RANDOM.nextBoolean()) {
                        status = "valid";
                        ++currentNumberOfPermanentHouseholdBooks;
                        generatePermanentResident(householdBookID, address, issueDate);
                    }
                    else {
                        status = "temporary";
                        ++currentNumberOfTemporaryHouseholdBooks;
                        generateTemporaryResidents(householdBookID);
                    }
                }
                else if (currentNumberOfPermanentHouseholdBooks <= numberOfPermanentHouseholdBooks) {
                    status = "valid";
                    ++currentNumberOfPermanentHouseholdBooks;
                    generatePermanentResident(householdBookID, address, issueDate);
                }
                else {
                    status = "temporary";
                    ++currentNumberOfTemporaryHouseholdBooks;
                    generateTemporaryResidents(householdBookID);
                }
                writer.writeNext(new String[] { householdBookID, householderID, address, issueDate.toString(), status });
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generatePermanentResident(String householdBookID, String address, LocalDate issueDate) {
        try {
            FileWriter output = new FileWriter(RESIDENTS_FILE, true);
            CSVWriter writer = new CSVWriter(output);
            if (RESIDENTS_FILE.length() == 0) {
                String[] header = { "ResidentID", "HouseholdBookID", "IDIssueDate", "IDIssuePlace", "FullName", "Alias", "DateOfBirth", "PlaceOfBirth", "Hometown", "Ethnicity", "Occupation", "Workplace", "PermanentRegistrationDate", "PermanentResidentAddress", "IsDead" };
                writer.writeNext(header);
            }
            String residentID = String.format("%011d", numberOfResidents++);
            LocalDate IDIssueDate = randomDate(LocalDate.of(2022, 1, 1), LocalDate.of(2024, 12, 31));
            String lastName = FAKER.name().lastName();
            String fullName = lastName + " " + FAKER.name().malefirstName();
            LocalDate dateOfBirth = randomDate(LocalDate.of(1950, 1, 1), LocalDate.of(2000, 12, 31));
            String placeOfBirth = FAKER.address().city();
            String hometown = FAKER.address().city();
            String ethnicity = FAKER.options().option("Kinh", "Tày", "Thái", "Mường", "Hoa", "Khmer", "Nùng", "H'Mông", "Dao", "Gia Rai", "Ê Đê");
            LocalDate permanentRegistrationDate = randomDate(dateOfBirth.isAfter(issueDate) ? dateOfBirth : issueDate, LocalDate.of(2024, 12, 31));
            writer.writeNext(new String[] { residentID, householdBookID, IDIssueDate.toString(), "Cục cảnh sát quản lý về trật tự xã hội", fullName, null, dateOfBirth.toString(), placeOfBirth, hometown, ethnicity, null, null, permanentRegistrationDate.toString(), address, "false" });
            if (RANDOM.nextBoolean()) {
                residentID = String.format("%011d", numberOfResidents++);
                IDIssueDate = randomDate(LocalDate.of(2022, 1, 1), LocalDate.of(2024, 12, 31));
                fullName = FAKER.name().lastName() + " " + FAKER.name().femaleFirstName();
                dateOfBirth = randomDate(dateOfBirth, dateOfBirth.plusYears(1));
                placeOfBirth = FAKER.address().city();
                hometown = FAKER.address().city();
                String ethnicityOfWife = FAKER.options().option("Kinh", "Tày", "Thái", "Mường", "Hoa", "Khmer", "Nùng", "H'Mông", "Dao", "Gia Rai", "Ê Đê");
                permanentRegistrationDate = randomDate(dateOfBirth.plusYears(19).isAfter(permanentRegistrationDate) ? dateOfBirth.plusYears(19) : permanentRegistrationDate, LocalDate.of(2024, 12, 31));
                boolean isDead = RANDOM.nextDouble(1) < 0.2;
                writer.writeNext(new String[] { residentID, householdBookID, IDIssueDate.toString(), "Cục cảnh sát quản lý về trật tự xã hội", fullName, null, dateOfBirth.toString(), placeOfBirth, hometown, ethnicityOfWife, null, null, permanentRegistrationDate.toString(), address, String.valueOf(isDead) });
                generateDependents(householdBookID, residentID, "wife");
            }
            for (int i = 0; i < RANDOM.nextInt(3); ++i) {
                residentID = String.format("%011d", numberOfResidents++);
                fullName = lastName + " " + FAKER.name().firstName();
                LocalDate dateOfBirthOfChild = randomDate(dateOfBirth.plusYears(20), dateOfBirth.plusYears(24));
                IDIssueDate = dateOfBirthOfChild.isBefore(LocalDate.of(2022, 1, 1)) ? randomDate(LocalDate.of(2022, 1, 1), LocalDate.of(2024, 12, 31)) : dateOfBirthOfChild;
                permanentRegistrationDate = randomDate(dateOfBirthOfChild.isAfter(permanentRegistrationDate) ? dateOfBirthOfChild : permanentRegistrationDate, LocalDate.of(2024, 12, 31));
                boolean isDead = RANDOM.nextDouble(1) < 0.2;
                writer.writeNext(new String[] { residentID, householdBookID, IDIssueDate.toString(), "Cục cảnh sát quản lý về trật tự xã hội", fullName, null, dateOfBirthOfChild.toString(), "Hà Nội", "Hà Nội", ethnicity, null, null, permanentRegistrationDate.toString(), address, String.valueOf(isDead) });
                generateDependents(householdBookID, residentID, "offspring");
            }
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateTemporaryResidents(String householdBookID) {
        try {
            FileWriter output = new FileWriter(RESIDENTS_FILE, true);
            CSVWriter writer = new CSVWriter(output);
            if (RESIDENTS_FILE.length() == 0) {
                String[] header = { "ResidentID", "HouseholdBookID", "IDIssueDate", "IDIssuePlace", "FullName", "Alias", "DateOfBirth", "PlaceOfBirth", "Hometown", "Ethnicity", "Occupation", "Workplace", "PermanentRegistrationDate", "PermanentResidentAddress", "IsDead" };
                writer.writeNext(header);
            }
            String residentID = String.format("%011d", numberOfResidents++);
            LocalDate IDIssueDate = randomDate(LocalDate.of(2022, 1, 1), LocalDate.of(2024, 12, 31));
            String fullName = FAKER.name().fullName();
            LocalDate dateOfBirth = randomDate(LocalDate.of(1950, 1, 1), LocalDate.of(2000, 12, 31));
            String placeOfBirth = FAKER.address().city();
            String hometown = FAKER.address().city();
            String ethnicity = FAKER.options().option("Kinh", "Tày", "Thái", "Mường", "Hoa", "Khmer", "Nùng", "H'Mông", "Dao", "Gia Rai", "Ê Đê");
            LocalDate permanentRegistrationDate = randomDate(dateOfBirth, LocalDate.of(2024, 12, 31));
            String permanentResidentAddress = FAKER.address().fullAddress();
            writer.writeNext(new String[] { residentID, householdBookID, IDIssueDate.toString(), "Cục cảnh sát quản lý về trật tự xã hội", fullName, null, dateOfBirth.toString(), placeOfBirth, hometown, ethnicity, null, null, permanentRegistrationDate.toString(), permanentResidentAddress, "false" });
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateDependents(String householdBookID, String residentID, String relationship) {
        try {
            FileWriter output = new FileWriter(DEPENDENTS_FILE, true);
            CSVWriter writer = new CSVWriter(output);
            if (DEPENDENTS_FILE.length() == 0) {
                String[] header = { "HouseholdBookID", "ResidentID", "Relationship" };
                writer.writeNext(header);
            }
            writer.writeNext(new String[] { householdBookID, residentID, relationship });
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Generator generator = new Generator(400, 80);
        generator.generateHouseholdBooks();
    }
}