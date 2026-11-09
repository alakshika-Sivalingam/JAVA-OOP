package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    // Empty no-arg constructor for Jackson JSON deserialization
    public PhysicalProduct() {
    }

    // Full constructor passing super fields to Product
    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | Weight: " + weightKg + "kg";
    }

    @Override
    public void applyDiscount(double rate) {
        double cappedRate = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - cappedRate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    // getWeightKg() and getDimensions()
    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}