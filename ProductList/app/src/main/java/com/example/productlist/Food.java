package com.example.productlist;

public class Food {
    private String Name;
    private String info;
    private int pic;

    public Food(String name, String info, int pic) {
        Name = name;
        this.info = info;
        this.pic = pic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}
