
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();
        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 0) {
                System.out.println("Программа завершена");
                break;

            } else if (userInput == 1) {
                stepTracker.enterSteps(scanner, stepTracker);


            } else if (userInput == 2) {
                stepTracker.printStatMenu();
                int statMenuCommand = scanner.nextInt();

                if (statMenuCommand == 1) {
                    stepTracker.printStatMenuMonth();
                    int statCommand = scanner.nextInt();

                    if (statCommand == 1) {
                        stepTracker.printStepsPerDayInMonth(scanner, stepTracker);
                    } else if (statCommand == 2) {
                        stepTracker.printStepsTotalMonth(scanner, stepTracker);

                    } else if (statCommand == 3) {
                        stepTracker.printMaxStepsPerDayInMonth(scanner,stepTracker);
                    }
                    else if (statCommand == 4) {
                        stepTracker.printAvgStepsPerMonth(scanner, stepTracker);
                    }
                    else if (statCommand == 5) {
                        stepTracker.printStepsInKmPerMonth(scanner, stepTracker, converter);
                    }
                    else if (statCommand == 6) {
                        stepTracker.printStepsToKcalPerMonth(scanner, stepTracker, converter);
                    }
                    else if (statCommand == 7) {
                        stepTracker.printBestStepsStack(scanner, stepTracker);
                    }
                    else {
                        System.out.println("Извините, такой команды пока нет");
                        System.out.println();
                    }
                }

                if (statMenuCommand == 2) {
                    stepTracker.printStatMenuYear();
                    int statCommand = scanner.nextInt();

                 if (statCommand == 1) {
                     stepTracker.printAvgStepsInYear(stepTracker);
                    } else if (statCommand == 2) {
                     stepTracker.printStepsToKmInYear(stepTracker, converter);
                    } else if (statCommand == 3) {
                     stepTracker.printStepsToKcalInYear(stepTracker, converter);
                    } else if (statCommand == 4) {
                     stepTracker.printBestStepsStackInYear(stepTracker);
                    } else {
                        System.out.println("Извините, такой команды пока нет");
                        System.out.println();
                    }
                }
            }

            else if (userInput == 3) {

                stepTracker.goalForDay =  stepTracker.changeGoalForDay(scanner, stepTracker.goalForDay);

            }
            else{
                    System.out.println("Извините, такой команды пока нет");
                System.out.println();
                }
            }

        }

    private static  void printMenu() {
        System.out.println("Ввести количество шагов за определённый день. Нажмите 1");
        System.out.println("Напечатать статистику шагов за определённый месяц или весь год. Нажмите 2");
        System.out.println("Изменить цель по количеству шагов в день. Нажмите 3");
        System.out.println("Выйти из приложения. Нажмите 0");
    }


} 