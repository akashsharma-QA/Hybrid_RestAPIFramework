package payload;

import com.github.javafaker.Faker;
import pojo.products;

import java.util.Random;

public class payload
{

    //product
   public static final Faker faker = new Faker();
    public static final String categories[]={"electronic","furniture","clothing","books"};
  public static final  Random random=new Random();

   public static products productpayload()
    {
        String name=faker.commerce().productName();
        double price=Double.parseDouble(faker.commerce().price());
        String description=faker.lorem().sentence();
        String imageUrl="https://i.pravatar.cc/100";
        String category= categories[random.nextInt(categories.length)];

        new products(name, price, description, imageUrl, category);
        return new products(name, price, description, imageUrl, category);
    }


}
