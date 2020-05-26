package io.github.varunscyther.drools.crossproduct.facts;

public class Visa {
  private String passportNumber;

  public Visa(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  @Override
  public String toString() {
    return "Visa[passport:" + passportNumber + "]";
  }
}
