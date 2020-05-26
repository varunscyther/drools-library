package io.github.varunscyther.drools.crossproduct.facts;

import java.util.Objects;

public class InvalidFamilyVisaApplication {
    private FamilyVisaApplication familyVisaApplication;

    public InvalidFamilyVisaApplication(FamilyVisaApplication familyVisaApplication) {
        this.familyVisaApplication = familyVisaApplication;
    }

    public FamilyVisaApplication getFamilyVisaApplication() {
        return familyVisaApplication;
    }

    public void setFamilyVisaApplication(FamilyVisaApplication familyVisaApplication) {
        this.familyVisaApplication = familyVisaApplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidFamilyVisaApplication)) return false;
        InvalidFamilyVisaApplication that = (InvalidFamilyVisaApplication) o;
        return Objects.equals(getFamilyVisaApplication(), that.getFamilyVisaApplication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFamilyVisaApplication());
    }

    @Override
    public String toString() {
        return "InvalidFamilyVisaApplication{" +
                "familyVisaApplication=" + familyVisaApplication +
                '}';
    }
}
