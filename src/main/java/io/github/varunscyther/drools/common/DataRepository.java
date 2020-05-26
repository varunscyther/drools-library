package io.github.varunscyther.drools.common;

import io.github.varunscyther.drools.crossproduct.facts.FamilyVisaApplication;
import io.github.varunscyther.drools.crossproduct.facts.Passport;
import io.github.varunscyther.drools.crossproduct.facts.VisaApplication;
import io.github.varunscyther.drools.facts.Person;
import static java.util.Arrays.asList;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DataRepository {

    private static final String ANITA_SINGH_PASSPORT_NO = "NG12345";
    private static final String K_SINGH_PASSPORT_NO = "NG12346";
    private static final String VARUN_SINGH_PASSPORT_NO = "NG12347";
    private static final String SWATI_SINGH_PASSPORT_NO = "NG12348";


    public static List<Passport> getPassports() {
        List<Passport> passports = new ArrayList<>();

        passports.add(Passport.newBuilder()
        .withName("ANITA SINGH")
        .withPassportNumber(ANITA_SINGH_PASSPORT_NO)
        .withPassportExpiryDate(LocalDate.of(2028, Month.AUGUST, 4))
        .withUnusedVisaPages(20)
        .withValidation(Validation.UNKNOWN)
        .build());

        passports.add(Passport.newBuilder()
                .withName("VARUN SINGH")
                .withPassportNumber(VARUN_SINGH_PASSPORT_NO)
                .withPassportExpiryDate(LocalDate.of(2020, Month.AUGUST, 10))
                .withUnusedVisaPages(10)
                .withValidation(Validation.UNKNOWN)
                .build());

        passports.add(Passport.newBuilder()
                .withName("K SINGH")
                .withPassportNumber(K_SINGH_PASSPORT_NO)
                .withPassportExpiryDate(LocalDate.of(2024, Month.FEBRUARY, 28))
                .withUnusedVisaPages(28)
                .withValidation(Validation.UNKNOWN)
                .build());

        passports.add(Passport.newBuilder()
                .withName("SWATI SINGH")
                .withPassportNumber(SWATI_SINGH_PASSPORT_NO)
                .withPassportExpiryDate(LocalDate.of(2019, Month.JULY, 19))
                .withUnusedVisaPages(4)
                .withValidation(Validation.FAILED)
                .build());

        return passports;
    }

    public static List<VisaApplication> getVisaApplications() {
        List<VisaApplication> visaApplications = new ArrayList<>();

        visaApplications.add(VisaApplication.newBuilder()
                .withApplicationId("KL9090")
                .withPassportNumber(ANITA_SINGH_PASSPORT_NO)
                .withVisaStartDate(LocalDate.of(2020, Month.MAY, 14))
                .withVisaExpiryDate(LocalDate.of(2020, Month.NOVEMBER, 14))
                .withValidation(Validation.UNKNOWN)
                .build());

        visaApplications.add(VisaApplication.newBuilder()
                .withApplicationId("KL9091")
                .withPassportNumber(K_SINGH_PASSPORT_NO)
                .withVisaStartDate(LocalDate.of(2019, Month.MAY, 10))
                .withVisaExpiryDate(LocalDate.of(2019, Month.NOVEMBER, 10))
                .withValidation(Validation.UNKNOWN)
                .build());


        visaApplications.add(VisaApplication.newBuilder()
                .withApplicationId("KL9092")
                .withPassportNumber(VARUN_SINGH_PASSPORT_NO)
                .withVisaStartDate(LocalDate.of(2020, Month.JANUARY, 01))
                .withVisaExpiryDate(LocalDate.of(2020, Month.MAY, 01))
                .withValidation(Validation.UNKNOWN)
                .build());

        visaApplications.add(VisaApplication.newBuilder()
                .withApplicationId("KL9093")
                .withPassportNumber(SWATI_SINGH_PASSPORT_NO)
                .withVisaStartDate(LocalDate.of(2020, Month.APRIL, 18))
                .withVisaExpiryDate(LocalDate.of(2020, Month.AUGUST, 18))
                .withValidation(Validation.UNKNOWN)
                .build());

        return visaApplications;
    }

    public static List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();

        Person person1 = new Person("VARUN", "SINGH");
        person1.setHouseNumber("103");
        person1.setStreetNumber("PENYSTON ROAD");
        persons.add(person1);

        Person person2 = new Person("ANITA", "SINGH");
        person2.setHouseNumber("1401");
        person2.setStreetNumber("RG RESIDENCY");
        persons.add(person2);

        return persons;

    }

    public static List<FamilyVisaApplication> getFamilyVisaApplication() {
        List<FamilyVisaApplication> familyVisaApplication = new ArrayList<>();

        familyVisaApplication.add(FamilyVisaApplication.newBuilder()
                .withApplicationId("KL9090")
                .withPassportNumbers(asList(ANITA_SINGH_PASSPORT_NO, K_SINGH_PASSPORT_NO))
                .withVisaStartDate(LocalDate.of(2020, Month.MAY, 14))
                .withVisaExpiryDate(LocalDate.of(2020, Month.NOVEMBER, 14))
                .build());


        familyVisaApplication.add(FamilyVisaApplication.newBuilder()
                .withApplicationId("KL9092")
                .withPassportNumbers(asList(VARUN_SINGH_PASSPORT_NO, SWATI_SINGH_PASSPORT_NO))
                .withVisaStartDate(LocalDate.of(2020, Month.JANUARY, 01))
                .withVisaExpiryDate(LocalDate.of(2020, Month.MAY, 01))
                .build());

        return familyVisaApplication;
    }

}
