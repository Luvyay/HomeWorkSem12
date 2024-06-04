package ru.gb.library_online.model;

import lombok.Data;

@Data
public class Book {
    private int id;
    private String nameBook;
    private int price;
    private String description;
}
