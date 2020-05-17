package io.github.varunscyther.drools.crossproduct.facts;

import io.github.varunscyther.drools.common.Validation;

import java.time.LocalDate;
import java.util.Objects;

public class VisaApplication {
    private String applicationId;
    private String passportNumber;
    private LocalDate visaStartDate;
    private LocalDate visaExpiryDate;
    private String comment;
    private Validation validation;

    @Override
    public String toString() {
        return "VisaApplication{" +
                "applicationId='" + applicationId + '\'' +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    public static VisaApplicationBuilder newBuilder() {
        return new VisaApplicationBuilder();
    }

    public static final class VisaApplicationBuilder {
        private String applicationId;
        private String passportNumber;
        private LocalDate visaStartDate;
        private LocalDate visaExpiryDate;
        private String comment;
        private Validation validation;

        private VisaApplicationBuilder() {
        }

        public VisaApplicationBuilder withApplicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }

        public VisaApplicationBuilder withPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        public VisaApplicationBuilder withVisaStartDate(LocalDate visaStartDate) {
            this.visaStartDate = visaStartDate;
            return this;
        }

        public VisaApplicationBuilder withVisaExpiryDate(LocalDate visaExpiryDate) {
            this.visaExpiryDate = visaExpiryDate;
            return this;
        }

        public VisaApplicationBuilder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public VisaApplicationBuilder withValidation(Validation validation) {
            this.validation = validation;
            return this;
        }

        public VisaApplication build() {
            VisaApplication visaApplication = new VisaApplication();
            visaApplication.applicationId = applicationId;
            visaApplication.passportNumber = passportNumber;
            visaApplication.visaStartDate = visaStartDate;
            visaApplication.visaExpiryDate = visaExpiryDate;
            visaApplication.comment = comment;
            visaApplication.validation = validation;
            return visaApplication;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisaApplication)) return false;
        VisaApplication that = (VisaApplication) o;
        return Objects.equals(getApplicationId(), that.getApplicationId()) &&
                Objects.equals(getPassportNumber(), that.getPassportNumber()) &&
                Objects.equals(getVisaStartDate(), that.getVisaStartDate()) &&
                Objects.equals(getVisaExpiryDate(), that.getVisaExpiryDate()) &&
                Objects.equals(getComment(), that.getComment()) &&
                getValidation() == that.getValidation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getApplicationId(), getPassportNumber(), getVisaStartDate(), getVisaExpiryDate(), getComment(), getValidation());
    }
}
