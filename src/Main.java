// ... (previous imports and class definition remain unchanged)

import com.veganmarket.checkout.CheckoutProcess;
import com.veganmarket.decorator.BestSellerDecorator;
import com.veganmarket.decorator.DiscountDecorator;
import com.veganmarket.decorator.NewProductDecorator;
import com.veganmarket.factory.ProductFactory;
import com.veganmarket.factory.TRproductFactory;
import com.veganmarket.factory.UKproductFactory;
import com.veganmarket.factory.USproductFactory;
import com.veganmarket.observer.DiscountObserver;
import com.veganmarket.observer.InsufficientStockObserver;
import com.veganmarket.product.Product;
import com.veganmarket.strategy.CashPayment;
import com.veganmarket.strategy.CreditCardPayment;
import com.veganmarket.strategy.DebitCardPayment;
import com.veganmarket.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    //    Factories
    static ProductFactory ukProductFactory = new UKproductFactory();
    static ProductFactory trProductFactory = new TRproductFactory();
    static ProductFactory usProductFactory = new USproductFactory();

    //  Observers
    static DiscountObserver discountObserver = new DiscountObserver();
    static InsufficientStockObserver insufficientStockObserver = new InsufficientStockObserver();

    // Dummy product arrays for each country and category
    static Product[] ukFoodProducts = {
            ukProductFactory.createProduct("food", "UK Banana", 4.99, 10),
            ukProductFactory.createProduct("food", "UK Apple", 2.99, 10),
            // Add more UK food products as needed
    };

    static Product[] ukBeautyProducts = {
            ukProductFactory.createProduct("beauty", "UK Face Cream", 50.0, 10),
            ukProductFactory.createProduct("beauty", "UK Body Cream", 19.99, 7),
            // Add more UK beauty products as needed
    };
    static Product[] ukClothingProducts = {
            ukProductFactory.createProduct("clothing", "UK T-Shirt", 19.99, 6),
            ukProductFactory.createProduct("clothing", "UK Shirt", 20.0, 11),
            // Add more UK clothing products as needed
    };

    static Product[] trFoodProducts = {
            trProductFactory.createProduct("food", "Turkish Banana", 4.99, 10),
            trProductFactory.createProduct("food", "Turkish Apple", 2.99, 10),
            // Add more Turkish food products as needed
    };
    static Product[] trBeautyProducts = {
            trProductFactory.createProduct("beauty", "Turkish Face Cream", 50.0, 10),
            trProductFactory.createProduct("beauty", "Turkish Body Cream", 19.99, 7),
            // Add more Turkish beauty products as needed
    };
    static Product[] trClothingProducts = {
            trProductFactory.createProduct("clothing", "Turkish T-Shirt", 19.99, 6),
            trProductFactory.createProduct("clothing", "Turkish Shirt", 20.0, 11),
            // Add more Turkish clothing products as needed
    };

    static Product[] usFoodProducts = {
            usProductFactory.createProduct("food", "US Banana", 4.99, 10),
            usProductFactory.createProduct("food", "US Apple", 2.99, 10),
            // Add more US food products as needed
    };
    static Product[] usBeautyProducts = {
            usProductFactory.createProduct("beauty", "US Face Cream", 50.0, 10),
            usProductFactory.createProduct("beauty", "US Body Cream", 19.99, 7),
            // Add more US beauty products as needed
    };
    static Product[] usClothingProducts = {
            usProductFactory.createProduct("clothing", "US T-Shirt", 19.99, 6),
            usProductFactory.createProduct("clothing", "US Shirt", 20.0, 11),
            // Add more US clothing products as needed
    };

    //    Payment Strategies
    static PaymentStrategy cashPayment = new CashPayment();
    static PaymentStrategy creditCardPayment = new CreditCardPayment();
    static  PaymentStrategy debitCardPayment = new DebitCardPayment();
    static CheckoutProcess checkoutProcess = new CheckoutProcess();

    static List<Product> shoppingBag = new ArrayList<>();

    public static void main(String[] args) {
        trClothingProducts[0] = new BestSellerDecorator(trClothingProducts[0]);
        trFoodProducts[0] = new NewProductDecorator(trFoodProducts[0]);
        welcomeMessage();

        showMainMenu();

    }

    private static void welcomeMessage() {
        System.out.println("Welcome to Vegan Market!");
    }

    private static int showMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. UK Products");
        System.out.println("2. TR Products");
        System.out.println("3. US Products");
        System.out.println("4. Exit");
        System.out.print("Enter your factory choice: ");
        int factoryChoice = scanner.nextInt();

        switch (factoryChoice) {
            case 1:
                System.out.println("UK Products");
                return showProductCategoryMenu("UK");
            case 2:
                System.out.println("TR Products");
                return showProductCategoryMenu("TR");
            case 3:
                System.out.println("US Products");
                return showProductCategoryMenu("US");
            case 4:
                System.out.println("Exiting Vegan Market. Thank you for shopping!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
                return showMainMenu();
        }
    }

    private static int showProductCategoryMenu(String country) {
        System.out.println("\nSelect Product Category:");
        System.out.println("1. Food Products");
        System.out.println("2. Beauty Products");
        System.out.println("3. Clothing Products");
        System.out.println("0. Return to Main Menu");
        System.out.print("Enter your choice: ");
        int categoryChoice = scanner.nextInt();

        switch (categoryChoice) {
            case 1:
                processCategory(getProducts(country, "food"), country);
                break;
            case 2:
                processCategory(getProducts(country, "beauty"), country);
                break;
            case 3:
                processCategory(getProducts(country, "clothing"), country);
                break;
            case 0:
                return showMainMenu();
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        return showProductCategoryMenu(country);
    }

    private static Product[] getProducts(String country, String category) {
        switch (country) {
            case "UK":
                return getCategoryProducts(ukFoodProducts, ukBeautyProducts, ukClothingProducts, category);
            case "TR":
                return getCategoryProducts(trFoodProducts, trBeautyProducts, trClothingProducts, category);
            case "US":
                return getCategoryProducts(usFoodProducts, usBeautyProducts, usClothingProducts, category);
            default:
                System.out.println("Invalid country.");
                return new Product[0];
        }
    }

    private static Product[] getCategoryProducts(Product[] food, Product[] beauty, Product[] clothing, String category) {
        switch (category) {
            case "food":
                return food;
            case "beauty":
                return beauty;
            case "clothing":
                return clothing;
            default:
                System.out.println("Invalid category.");
                return new Product[0];
        }
    }

    private static int showShoppingBagMenu(Product[] products, String country) {
        System.out.println("\nShopping Bag Menu:");
        System.out.println("1. View Shopping Bag Contents");
        System.out.println("2. Continue Shopping");
        System.out.println("3. Proceed to Payment");
        System.out.print("Enter your choice: ");
        int shoppingBagChoice = scanner.nextInt();

        switch (shoppingBagChoice) {
            case 1:
                displayShoppingBagContents();
                return showShoppingBagMenu(products, country);
            case 2:
                return showProductCategoryMenu(country);
            case 3:
                processPayment(products);
                return 0; // Payment is complete, return 0 to exit the loop
            default:
                System.out.println("Invalid choice. Please try again.");
                return showShoppingBagMenu(products, country);
        }
    }

    private static void displayShoppingBagContents() {
        System.out.println("\nShopping Bag Contents:");

        double total = 0.0; // To calculate total price

        for (int i = 0; i < shoppingBag.size(); i++) {
            Product product = shoppingBag.get(i);

//            System.out.println((i + 1) + ". " + product.getName() +
//                    " - Price: " + product.getPrice() +
//                    " - Stock: " + product.getStock());
            String description = product.getDescription() +" , Remaining Stock : " + product.getStock();
            System.out.println(description);

            total += product.getPrice();
        }

        System.out.println("Total Price: " + total);
    }

    private static void processCategory(Product[] products, String country) {
        System.out.println("\nProducts:");

        // Display products for the selected category with price and stock information
        for (int i = 0; i < products.length; i++) {
            // Add observers to each product
            products[i].addObserver(discountObserver);
            products[i].addObserver(insufficientStockObserver);

            // Example: Apply a discount to the product
            double discountedPrice = products[i].getPrice() * 0.9; // 10% discount
            products[i].setPrice(discountedPrice);
            products[i] = new DiscountDecorator(products[i]);

//            System.out.println((i + 1) + ". " + products[i].getName() +
//                    " - Price: " + products[i].getPrice() +
//                    " - Stock: " + products[i].getStock());
            String description = products[i].getDescription() +" , Remaining Stock : " + products[i].getStock();
            System.out.println(description);

        }

        System.out.println("0. Return to Product Category Menu");
        System.out.print("Enter the number of the product you want to add to your shopping bag or 0 to return: ");
        int productChoice = scanner.nextInt();

        if (productChoice == 0) {
            // Go back to the product category menu
            showProductCategoryMenu(country);
            return;
        }

        products[productChoice - 1].addObserver(insufficientStockObserver);
        //setStock = -1;
        products[productChoice - 1].setStock(products[productChoice - 1].getStock()-1);

        // Add the selected product to the shopping bag
        shoppingBag.add(products[productChoice - 1]);

        System.out.println("Product added to your shopping bag!");

        // Provide options to the user (View Shopping Bag, Continue Shopping, Proceed to Payment)
        int result = showShoppingBagMenu(products, country);

        if (result == 0) {
            // Payment process is complete, exit the method
            return;
        }

        // If the result is not 0, continue with the product category menu
        showProductCategoryMenu(country);
    }

    private static void processPayment(Product[] products) {
        // Display the contents of the shopping bag before processing payment
        displayShoppingBagContents();

        System.out.println("\nPayment Options:");
        System.out.println("1. Cash Payment");
        System.out.println("2. Credit Card Payment");
        System.out.println("3. Debit Card Payment");
        System.out.println("0. Return to Previous Product");
        System.out.print("Enter your payment choice: ");
        int paymentChoice = scanner.nextInt();

        switch (paymentChoice) {
            case 1:
                checkoutProcess.setPaymentStrategy(cashPayment);
                checkoutProcess.initiatePayment(products);
                shoppingBag.clear();
                break;
            case 2:
                checkoutProcess.setPaymentStrategy(creditCardPayment);
                checkoutProcess.initiatePayment(products);
                shoppingBag.clear();
                break;
            case 3:
                checkoutProcess.setPaymentStrategy(debitCardPayment);
                checkoutProcess.initiatePayment(products);
                shoppingBag.clear();
                break;
            case 0:
                System.out.println("Returning to Previous Product...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                processPayment(products);
        }
    }
}

