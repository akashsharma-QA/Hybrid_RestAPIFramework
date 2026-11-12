package pojo;

public class products {


    private String title;
    private String description;
    private double price;
    private String category;
    private String image;

    public products( String title,double price, String description, String category,String image) {

        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }


//products(name,price,description,imageurl,categories);


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /*
        * {
      "id": 0,
      "title": "string",
      "price": 0.1,
      "description": "string",
      "category": "string",
      "image": "http://example.com"
      *
    }*/

}
