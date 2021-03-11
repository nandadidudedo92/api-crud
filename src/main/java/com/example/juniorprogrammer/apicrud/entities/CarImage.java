package com.example.juniorprogrammer.apicrud.entities;

import javax.persistence.*;

@Entity
public class CarImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private CarEntity car;

    @Lob
    private String base64;

    private String contentType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
