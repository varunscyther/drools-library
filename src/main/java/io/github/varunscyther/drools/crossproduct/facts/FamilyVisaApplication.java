package io.github.varunscyther.drools.crossproduct.facts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyVisaApplication {
    private String applicationId;
    private List<String> passportNumbers;
    private LocalDate visaStartDate;
    private LocalDate visaExpiryDate;
    private Boolean validationPassed = null;

    public FamilyVisaApplication(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public List<String> getPassportNumbers() {
        return passportNumbers;
    }

    public void setPassportNumbers(List<String> passportNumbers) {
        this.passportNumbers = passportNumbers;
    }

    public LocalDate getVisaStartDate() {
        return visaStartDate;
    }

    public void setVisaStartDate(LocalDate visaStartDate) {
        this.visaStartDate = visaStartDate;
    }

    public LocalDate getVisaExpiryDate() {
        return visaExpiryDate;
    }

    public void setVisaExpiryDate(LocalDate visaExpiryDate) {
        this.visaExpiryDate = visaExpiryDate;
    }

    public Boolean getValidationPassed() {
        return validationPassed;
    }

    public void setValidationPassed(Boolean validationPassed) {
        this.validationPassed = validationPassed;
    }

    public static String join(Collection<String> collection) {
        return collection.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }

    @Override
    public String toString() {
        return String.format("FamilyVisaApplication[#%s, %s]", applicationId, join(passportNumbers));
    }

    public static FamilyVisaApplicationBuilder newBuilder() {
        return new FamilyVisaApplicationBuilder();
    }


    public static final class FamilyVisaApplicationBuilder {
        private String applicationId;
        private List<String> passportNumbers = new ArrayList<>();
        private LocalDate visaStartDate;
        private LocalDate visaExpiryDate;

        private FamilyVisaApplicationBuilder() {
        }


        public FamilyVisaApplicationBuilder withApplicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public FamilyVisaApplicationBuilder withPassportNumbers(List<String> passportNumbers) {
            this.passportNumbers = passportNumbers;
            return this;
        }

        public FamilyVisaApplicationBuilder withVisaStartDate(LocalDate visaStartDate) {
            this.visaStartDate = visaStartDate;
            return this;
        }

        public FamilyVisaApplicationBuilder withVisaExpiryDate(LocalDate visaExpiryDate) {
            this.visaExpiryDate = visaExpiryDate;
            return this;
        }

        public FamilyVisaApplication build() {
            FamilyVisaApplication familyVisaApplication = new FamilyVisaApplication(applicationId);
            familyVisaApplication.visaExpiryDate = this.visaExpiryDate;
            familyVisaApplication.passportNumbers = this.passportNumbers;
            familyVisaApplication.visaStartDate = this.visaStartDate;
            return familyVisaApplication;
        }
    }

}
