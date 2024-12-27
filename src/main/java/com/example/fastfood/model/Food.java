package com.example.fastfood.model;

public class Food {
    private int id;
    private String name, description;
    private double price;
    private int quantity;
    private String imageUrl, type, orderStatus;

    public Food(int id, String name, String description, double price, int quantity, String imageUrl, String type, String orderStatus) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.type = type;
        this.orderStatus = orderStatus;
    }

    public Food(int id, String name, String description, double price, int quantity, String imageUrl, String type) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.type = type;
    }

    public Food(String name, String description, double price, int quantity, String imageUrl, String type) {
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.type = type;
    }

    public Food(int id, String name, double price, int quantity, String imageUrl) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", imageUrl='" + imageUrl + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
