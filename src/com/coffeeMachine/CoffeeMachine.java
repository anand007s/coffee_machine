package com.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    static Scanner scanner = new Scanner(System.in);
    static String selectedOption = null;
    static int remainingWater = 400;
    static int remainingMilk = 540;
    static int remainingCoffeeBeans = 120;
    static int remainingCups = 9;
    static int remaingBalance = 550;
    static String buyOption = null;
    static void displayBasicInfo() {
        while (!("exit".equalsIgnoreCase(selectedOption))) {
            System.out.print("CHOOSING\n" +
                    "Write action (buy, fill, take, remaining, exit : ");
            selectedOption = scanner.next();
            switch (selectedOption) {
                case "remaining" :
                    remainingStockInfo();
                    break;
                case "buy" :
                    buying();
                    break;
                case "fill" :
                    filling();
                    break;
                case "take" :
                    taking();
                    break;
                default :
                    System.out.println("please give correct input to machine");
            }
        }
        System.out.println("EXITING\n");
    }

    static void remainingStockInfo() {
        if("remaining".equalsIgnoreCase(selectedOption)) {
            System.out.println("REMAINING\n\n" +
                    "The coffee machine has : \n" +
                    remainingWater + " of water\n" +
                    remainingMilk + " of milk\n" +
                    remainingCoffeeBeans + " of coffee beans\n" +
                    remainingCups + " of disposable cups\n" +
                    remaingBalance + " of money.\n");
        }
    }

    static void buying() {
        System.out.print("BUYING\n\n" +
                "What do you want to buy ? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu : ");
        buyOption = scanner.next();
        if(!(buyOption.equalsIgnoreCase("back"))) {
            switch (buyOption) {
                case "1" :
                    if (remainingWater >= 100 && remainingMilk >= 20 && remainingCoffeeBeans >= 10) {
                        remainingWater -= 100;
                        remainingMilk -= 20;
                        remainingCoffeeBeans -= 10;
                        remaingBalance += 50;
                        System.out.println("I have enough resource, making you a coffee!\n");
                    } else {
                        System.out.println("I don't have enough resource, can't make your coffee!\n");
                    }
                    break;
                case "2" :
                    if (remainingWater >= 100 && remainingMilk >= 30 && remainingCoffeeBeans >= 15) {
                        remainingWater -= 100;
                        remainingMilk -= 30;
                        remainingCoffeeBeans -= 15;
                        remaingBalance += 75;
                        System.out.println("I have enough resource, making you a coffee!\n");
                    } else {
                        System.out.println("I don't have enough resource, can't make your coffee!\n");
                    }
                    break;
                case "3" :
                    if (remainingWater >= 100 && remainingMilk >= 40 && remainingCoffeeBeans >= 20) {
                        remainingWater -= 100;
                        remainingMilk -= 40;
                        remainingCoffeeBeans -= 20;
                        remaingBalance += 100;
                        System.out.println("I have enough resource, making you a coffee!\n");
                    } else {
                        System.out.println("I don't have enough resource, can't make your coffee!\n");
                    }
                    break;
                case "back" :
                    displayBasicInfo();
                    break;
                default :
                    System.out.println("please give correct input to machine.\n");
            }
        }
    }

    static void filling() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("FILLING\n\n" +
                "Write how many ml of water do you want to add : ");
        remainingWater += scanner.nextInt();
        System.out.print("Write how many ml of milk do you want to add : ");
        remainingMilk += scanner.nextInt();
        System.out.print("Write how many gram of coffee beans do you want to add : ");
        remainingCoffeeBeans += scanner.nextInt();
        System.out.print("Write how many disposable cups of coffee do you want to add : ");
        remainingCups += scanner.nextInt();
        scanner.nextLine();
    }

    static void taking() {
        System.out.println("TAKING\n\n" +
                "I gave you $" + remaingBalance + "\n");
    }
}
