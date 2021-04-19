package com.example.recycleview;

public class Person {
    private int id;
    private String name;
    private int ImageBig;



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ImageBig=" + ImageBig +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageBig() {
        return ImageBig;
    }

    public void setImageBig(int imageBig) {
        ImageBig = imageBig;
    }

    public Person(int id, String name, int imageBig) {
        this.id = id;
        this.name = name;
        ImageBig = imageBig;
    }
}
