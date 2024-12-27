package com.example.fastfood.model;

public class Order {
    private int idOrder, idUser;
    private String orderTime, deliveryAddress, orderStatus;
    private double amount;
    private int totalFood;
    private String paymentStatus, paymentTime, foodIds, foodQuantites;

    public Order(int idOrder, int idUser, String orderTime, String deliveryAddress, String orderStatus, double amount, int totalFood, String paymentStatus, String paymentTime, String foodIds, String foodQuantites) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.orderTime = orderTime;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = orderStatus;
        this.amount = amount;
        this.totalFood = totalFood;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
        this.foodIds = foodIds;
        this.foodQuantites = foodQuantites;
    }

    public Order(int idOrder, int idUser, String orderTime, String deliveryAddress, String orderStatus, double amount, int totalFood, String paymentStatus, String paymentTime) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.orderTime = orderTime;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = orderStatus;
        this.amount = amount;
        this.totalFood = totalFood;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;

    }

    public Order (int idUser, String deliveryAddress, String paymentStatus, String paymentTime, String foodIds, String foodQuantites) {
        this.idUser = idUser;
        this.deliveryAddress = deliveryAddress;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
        this.foodIds = foodIds;
        this.foodQuantites = foodQuantites;
    }

    public Order(int idOrder, String orderTime, String orderStatus, double amount, int totalFood) {
        this.idOrder = idOrder;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.amount = amount;
        this.totalFood = totalFood;
    }

    @Override
    public String toString() {
        return "OrderServlet{" +
                "idOrder=" + idOrder +
                ", idUser=" + idUser +
                ", orderTime='" + orderTime + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", amount=" + amount +
                ", totalFood=" + totalFood +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentTime='" + paymentTime + '\'' +
                ", foodIds='" + foodIds + '\'' +
                ", foodQuantites='" + foodQuantites + '\'' +
                '}';
    }

    public String getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(String foodIds) {
        this.foodIds = foodIds;
    }

    public String getFoodQuantites() {
        return foodQuantites;
    }

    public void setFoodQuantites(String foodQuantites) {
        this.foodQuantites = foodQuantites;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getTotalFood() {
        return totalFood;
    }

    public void setTotalFood(int totalFood) {
        this.totalFood = totalFood;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }
}
