package com.example.cravy.model;

public class Food {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private String price;

    // Constructor
    public Food(String id, String name, String description, String imageUrl, String price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    // Getter (untuk mengambil data nanti)
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getImageUrl() { return imageUrl; }
    public String getPrice() { return price; }
}