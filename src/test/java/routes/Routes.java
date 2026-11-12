package routes;

public class Routes {

    public static final String QA_BASE_URL = "https://fakestoreapi.com";
    public static final String dev_BASE_URL=  "https://fakestoreapi.com";

    //product
    public static final String Get_all_products="/products";
    public static final String Get_product_by_id="/products/{id}";
    public static final String Get_product_by_limit="/products?limit={limit}";
    public static final String get_product_sorted=" /carts?sort={order}";
    public static final String get_all_category=" /products/categories";
    public static final String get_prodiuct_by_category="products/category/{category}";
    public static final String create_product="/products";
    public static final String update_product="/products/{id}";
    public static final String delete_product="/products/{id}";
}
