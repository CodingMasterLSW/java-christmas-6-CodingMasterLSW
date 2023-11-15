package christmas.domain;

import christmas.utils.DomainValidator;


public class VisitDate {

    private final int visitDate;

    DomainValidator domainValidator = new DomainValidator();

    public VisitDate(String input) {
        int visitDate = convertInteger(input);
        domainValidator.ensureValidVisitDate(visitDate);
        this.visitDate = visitDate;
    }

    private int convertInteger(String input){
        return Integer.parseInt(input);
    }

    @Override
    public String toString() {
        return String.valueOf(visitDate);
    }

    public int getVisitDate(){
        return visitDate;
    }
}

