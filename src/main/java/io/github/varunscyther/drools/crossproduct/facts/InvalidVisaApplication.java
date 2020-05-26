package io.github.varunscyther.drools.crossproduct.facts;

import java.util.Objects;

public class InvalidVisaApplication {
    private VisaApplication visaApplication;

    public InvalidVisaApplication(VisaApplication visaApplication) {
        this.visaApplication = visaApplication;
    }

    public VisaApplication getVisaApplication() {
        return visaApplication;
    }

    public void setVisaApplication(VisaApplication visaApplication) {
        this.visaApplication = visaApplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidVisaApplication)) return false;
        InvalidVisaApplication that = (InvalidVisaApplication) o;
        return Objects.equals(getVisaApplication(), that.getVisaApplication());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVisaApplication());
    }

    @Override
    public String toString() {
        return "InvalidVisaApplication{" +
                "visaApplication=" + visaApplication +
                '}';
    }
}
