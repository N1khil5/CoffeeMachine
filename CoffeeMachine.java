package machine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void printAmount(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        coffee("remaining", water, milk, beans, cups, money);

    }

    public static void coffee(String action, int water, int milk, int beans, int cups, int money) {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu");
                    String buyOption = scanner.next();

                    switch (buyOption) {
                        case "1": // espresso
                            if (water < 250) {
                                System.out.println("Sorry, not enough water");
                            } else if (beans < 16) {
                                System.out.println("Sorry, not enough beans");
                            } else {
                                System.out.println("I have enough resources, making you a coffee");
                                water -= 250;
                                beans -= 16;
                                cups--;
                                money += 4;
                            }
                            break;
                        case "2": // latte
                            if (water < 350) {
                                System.out.println("Sorry, not enough water");
                            } else if (milk < 75) {
                                System.out.println("Sorry, not enough milk");
                            } else if (beans < 20) {
                                System.out.println("Sorry, not enough beans");
                            } else {
                                System.out.println("I have enough resources, making you a coffee");
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups--;
                                money += 7;
                            }
                            break;
                        case "3": // cappuccino
                            if (water < 200) {
                                System.out.println("Sorry, not enough water");
                            } else if (milk < 100) {
                                System.out.println("Sorry, not enough milk");
                            } else if (beans < 12) {
                                System.out.println("Sorry, not enough beans");
                            } else {
                                System.out.println("I have enough resources, making you a coffee");
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups--;
                                money += 6;
                            }
                            break;
                        case "back":
                            coffee(action, water, milk, beans, cups, money);
                            break;
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println();
                    System.out.println("Write how many ml of water do you want to add: ");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    cups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println();
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    System.out.println();
                    printAmount(water, milk, beans, cups, money);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        }
    }

}