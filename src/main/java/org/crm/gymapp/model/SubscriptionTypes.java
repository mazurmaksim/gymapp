package org.crm.gymapp.model;

public enum SubscriptionTypes {
    YERLY("YERLY"),
    WEEKLY("WEEKLY"),
    MONTHLY("MONTHLY"),
    ONCE("ONCE"),
    VIP("VIP"),
    BASIC("BASIC"),
    STANDART("STANDART"),
    PREMIUM("PREMIUM");

    private final String type;

    SubscriptionTypes(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
