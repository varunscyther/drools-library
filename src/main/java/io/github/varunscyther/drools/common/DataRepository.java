package io.github.varunscyther.drools.common;

import io.github.varunscyther.drools.crossproduct.facts.Passport;
import io.github.varunscyther.drools.crossproduct.facts.VisaApplication;

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
                .build());

        visaApplications.add(VisaApplication.newBuilder()
                .withApplicationId("KL9091")
                .withPassportNumber(K_SINGH_PASSPORT_NO)
                .withVisaStartDate(LocalDate.of(2019, Month.MAY, 10))
                .withVisaExpiryDate(LocalDate.of(2019, Month.NOVEMBER, 10))
                .build());


        visaApplications.add(VisaApplication.newBuilder()
                .withApplicationId("KL9092")
                .withPassportNumber(VARUN_SINGH_PASSPORT_NO)
                .withVisaStartDate(LocalDate.of(2020, Month.JANUARY, 01))
                .withVisaExpiryDate(LocalDate.of(2020, Month.MAY, 01))
                .build());

        visaApplications.add(VisaApplication.newBuilder()
                .withApplicationId("KL9093")
                .withPassportNumber(SWATI_SINGH_PASSPORT_NO)
                .withVisaStartDate(LocalDate.of(2020, Month.APRIL, 18))
                .withVisaExpiryDate(LocalDate.of(2020, Month.AUGUST, 18))
                .build());

        return visaApplications;
    }

}
