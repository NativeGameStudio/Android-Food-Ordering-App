package com.example.ratingapp.item;

/** Category include kind of all food
 */
public class Category {

    private String name;
    private int imageUrl;

    public Category(String name, int imageUrl){
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

}
