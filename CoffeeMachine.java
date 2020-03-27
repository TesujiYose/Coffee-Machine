package machine;

import java.util.Scanner;

public class CoffeeMachine {

    private Scanner sc;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;


    private CoffeeMachine() {
        this.sc = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }



    private void buy(int drink) {
        int water = 0;
        int milk = 0;
        int beans = 0;
        int money = 0;

        switch (drink) {
            case 1:
                water = 250;
                beans = 16;
                money = 4;
                break;
            case 2:
                water = 350;
                milk = 75;
                beans = 20;
                money = 7;
                break;
            case 3:
                water = 200;
                milk = 100;
                beans = 12;
                money = 6;
                break;
            default:
                System.out.println("Wrong number!");
        }

        if (water > this.water) {
            System.out.println("Sorry, not enough water!");
        } else if (milk > this.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans > this.beans) {
            System.out.print("Sorry, not enough coffee beans!");
        } else if (1 > this.cups) {
            System.out.print("Sorry, not enough disposable cups!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.beans -= beans;
            this.cups--;
            this.money += money;
        }
    }

    private void fill (int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    private void take() {
        this.money = 0;
    }

    private void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.printf("%d of water%n", this.water);
        System.out.printf("%d of milk%n", this.milk);
        System.out.printf("%d of coffee beans%n", this.beans);
        System.out.printf("%d of disposable cups%n", this.cups);
        System.out.printf("$%d of money%n", this.money);
    }

    private void processBuy() {

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String opinion = this.sc.next();

        if (opinion.equals("back")) {
            return;
        }

        int drink = Integer.parseInt(opinion);
        buy(drink);


    }

    private void processFill() {
        int water = 0;
        int milk = 0;
        int beans = 0;
        int cups = 0;

        System.out.println("Write how many ml of water do you want to add:");
        water = this.sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk = this.sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans = this.sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups = this.sc.nextInt();

        fill(water, milk, beans, cups);
    }

    private void processTake() {
        System.out.printf("I gave you $%d%n", this.money);
        this.take();
    }

    private void processRemaining() {
        this.remaining();
    }


    private boolean processAction() {

        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String operator = sc.next();

        switch (operator) {
            case "buy":
                processBuy();

                break;

            case "fill":
                processFill();
                break;

            case "take":
                processTake();
                break;

            case "remaining":
                processRemaining();
                break;

            case "exit":
                return false;

            default:
                System.out.println("Wrong command");
                break;
        }
        return true;

    }

    public static void main(String[] args) {

        boolean status = false;

        CoffeeMachine machine = new CoffeeMachine();

        do {
            status = machine.processAction();
        } while (status);


    }
}
