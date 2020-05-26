package io.github.varunscyther.drools.crossproduct.facts;

import java.util.Objects;

public class InvalidPassport {
    private Passport passport;

    public InvalidPassport(Passport passport) {
        this.passport = passport;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvalidPassport)) return false;
        InvalidPassport that = (InvalidPassport) o;
        return Objects.equals(getPassport(), that.getPassport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPassport());
    }

    @Override
    public String toString() {
        return "InvalidPassport{" +
                "passport=" + passport +
                '}';
    }
}
