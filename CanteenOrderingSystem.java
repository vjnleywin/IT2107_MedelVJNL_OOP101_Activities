import java.util.Scanner;

public class CanteenOrderingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] foodItems = {
            "John Burger",
            "Too Addictive, red-hot Cheetos",
            "Sugar Honey Ice Tea",
            "Diget Cereal",
            "Lemon soda"
        };

        double[] prices = {
            80.00,
            120.00,
            100.00,
            70.00,
            90.00
        };

        int totalItems = 0;
        double totalBeforeDiscount = 0;
        double totalDiscount = 0;

        char orderAgain = 'Y';

        while (orderAgain == 'Y') {

            System.out.println("===== **EXTREMELY** OVERPRICED MENU =====");

            for (int i = 0; i < foodItems.length; i++) {
                System.out.printf("%d. %-10s - $%.2f%n",
                        i + 1, foodItems[i], prices[i]);
            }

            System.out.println();

            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > foodItems.length
                    || quantity < 1 || quantity > 10) {

                System.out.println();
                System.out.println(
                    "Invalid! Please enter a valid item and quantity."
                );
                System.out.println();

                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = input.next().toUpperCase().charAt(0);

            double subtotal = prices[itemNumber - 1] * quantity;

            double discountRate = 0;

            if (student == 'Y' && subtotal >= 500) {
                discountRate = 0.15;
            } else if (subtotal >= 500) {
                discountRate = 0.05;
            } else if (student == 'Y') {
                discountRate = 0.10;
            }

            double discount = subtotal * discountRate;
            double orderTotal = subtotal - discount;

            totalItems += quantity;
            totalBeforeDiscount += subtotal;
            totalDiscount += discount;

            System.out.printf("%nSubtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n%n", orderTotal);

            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = input.next().toUpperCase().charAt(0);

            System.out.println();
        }

        double finalAmount = totalBeforeDiscount - totalDiscount;

        System.out.println("===== LIST OF ITEMS =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n",
                totalDiscount);
        System.out.printf("Final amount: $%.2f%n",
                finalAmount);
        System.out.println("Thank you for ordering at the OVERPRICED CANTEEN. We hope you never see us again!");

        input.close();
    }
}