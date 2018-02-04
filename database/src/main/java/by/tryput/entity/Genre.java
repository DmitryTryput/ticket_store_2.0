package by.tryput.entity;

import lombok.Getter;

@Getter
public enum Genre {

    ANIMATION("анимационный"),
    DRAMA("драма"),
    COMEDY("комедия"),
    FANTASTIC("фантастика"),
    DETECTIVE("детектив"),
    ACTION("боевик"),
    DOCUMENTARY("документальный"),
    HISTORIC("исторический"),
    HORROR("ужасы"),
    THRILLER("триллер"),
    ADVENTURE("приключение"),
    FANTASY("фэнтази"),
    FAMILY("семейный");

    private final String name;

    Genre(String name) {
        this.name = name;
    }

}
