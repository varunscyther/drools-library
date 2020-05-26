package io.github.varunscyther.drools.crossproduct.facts;

import io.github.varunscyther.drools.common.Validation;

import java.time.LocalDate;
import java.util.Objects;

public class Passport {
    private String name;
    private String passportNumber;
    private int unusedVisaPages;
    private LocalDate passportExpiryDate;
    private String comment;
    private Validation validation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getUnusedVisaPages() {
        return unusedVisaPages;
    }

    public void setUnusedVisaPages(int unusedVisaPages) {
        this.unusedVisaPages = unusedVisaPages;
    }

    public LocalDate getPassportExpiryDate() {
        return passportExpiryDate;
    }

    public void setPassportExpiryDate(LocalDate passportExpiryDate) {
        this.passportExpiryDate = passportExpiryDate;
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

    @Override
    public String toString() {
        return "Passport(#" + name + ", pass:" + passportNumber + ")";
    }

    public static PassportBuilder newBuilder() {
        return new PassportBuilder();
    }

    public static final class PassportBuilder {
        private String name;
        private String passportNumber;
        private int unusedVisaPages;
        private LocalDate passportExpiryDate;
        private String comment;
        private Validation validation;

        private PassportBuilder() {
        }

        public PassportBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PassportBuilder withPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        public PassportBuilder withUnusedVisaPages(int unusedVisaPages) {
            this.unusedVisaPages = unusedVisaPages;
            return this;
        }

        public PassportBuilder withPassportExpiryDate(LocalDate passportExpiryDate) {
            this.passportExpiryDate = passportExpiryDate;
            return this;
        }

        public PassportBuilder withComment(String comment) {
            this.comment = comment;
            return this;
        }

        public PassportBuilder withValidation(Validation validation) {
            this.validation = validation;
            return this;
        }

        public Passport build() {
            Passport passport = new Passport();
            passport.name = name;
            passport.passportNumber = passportNumber;
            passport.passportExpiryDate = passportExpiryDate;
            passport.comment = comment;
            passport.validation = validation;
            return passport;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Passport)) return false;
        Passport passport = (Passport) o;
        return getUnusedVisaPages() == passport.getUnusedVisaPages() &&
                Objects.equals(getName(), passport.getName()) &&
                Objects.equals(getPassportNumber(), passport.getPassportNumber()) &&
                Objects.equals(getPassportExpiryDate(), passport.getPassportExpiryDate()) &&
                Objects.equals(getComment(), passport.getComment()) &&
                getValidation() == passport.getValidation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassportNumber(), getUnusedVisaPages(), getPassportExpiryDate(), getComment(), getValidation());
    }

}
