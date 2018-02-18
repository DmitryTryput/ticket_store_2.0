package by.tryput.entity;

import lombok.Getter;

@Getter
public enum Country {

    USA("США"),
    GBR("Великобритания"),
    RUS("Россия"),
    BYN("Беларусь"),
    FRA("Франция"),
    GER("Германия"),
    AUS("Австралия"),
    ESP("Испания"),
    CAN("Канада"),
    UKR("Украина"),
    ITA("Италия"),
    MEX("Мексика"),
    DAN("Дания"),
    AUT("Австрия"),
    TUR("Турция"),
    BRA("Бразилия"),
    BEL("Бельгия"),
    ISR("Израиль"),
    SWE("Швеция");

    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
