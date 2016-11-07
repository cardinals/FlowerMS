package cn.coselding.flowerms.model;

/**
 * Created by 宇强 on 2016/7/13 0013.
 */
public class Flower {

    private int flowerID;
    private String flowerName;
    private double price;
    private String images;
    private String remarks;
    private int number;

    @Override
    public String toString() {
        return "Flower{" +
                "flowerID=" + flowerID +
                ", flowerName='" + flowerName + '\'' +
                ", price=" + price +
                ", images='" + images + '\'' +
                ", remarks='" + remarks + '\'' +
                ", number=" + number +
                '}';
    }

    public int getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(int flowerID) {
        this.flowerID = flowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
