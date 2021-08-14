package br.com.dlm.picpayclone.enums;

public enum CardFlag {

    VISA("Visa"),
    MASTERCARD("Master Card"),
    ELO("Elo");

    private String drescription;

    CardFlag(String description) {
        this.drescription = description;
    }

    public String getDrescription() {
        return drescription;
    }
}
