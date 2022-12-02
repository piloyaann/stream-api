import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    private static final Random random = new Random();
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            productList.add(createRandomProduct());
        }
        List<Product> books = productList.
                stream().
                filter(element -> element.getPrice() == 100).
                filter(product -> product.getCategory() == Category.Book).
                collect(Collectors.toList());

        System.out.println(books);

        List<Product> babyList = productList.stream()
                .filter(product -> product.getCategory() == Category.Baby)
                .collect(Collectors.toList());

    }
    private static Product createRandomProduct() {
        int randomNumber = random.nextInt(0, 2);
        Product product = new Product();
        product.setPrice(random.nextInt(100, 110));
        product.setName(String.valueOf(random.nextInt()));
        if (randomNumber == 1){
            product.setCategory(Category.Book);
        }else{
            product.setCategory(Category.Baby);
        }
        return product;
    }
}