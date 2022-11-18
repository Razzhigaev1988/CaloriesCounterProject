import java.util.Scanner;

public class StepTracker {

  public  MonthData[] monthToData;
     int goalForDay = 10_000;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
            monthToData[i].fillStepsByDefault();
        }
    }

    public void enterSteps(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Сколько шагов вы сделали?");
        int stepsDoneForDay = scanner.nextInt();
        if (stepsDoneForDay >= 0) {
            System.out.println("B каком месяце вы сделали шаги?");
            printMonthMenu();
            int monthChoice = scanner.nextInt();
            if (monthChoice >= 0 && monthChoice <= stepTracker.monthToData.length - 1) {
                System.out.println("В какой день вы делали шаги?");
                int dayChoice = scanner.nextInt();
                if (dayChoice > 0 && dayChoice <= 30) {
                    stepTracker.monthToData[monthChoice].monthDates[dayChoice - 1] += stepsDoneForDay;
                }
                else {
                    System.out.println("вы вводите неправильное значение дня. Пожалуйста, попробуйте еще раз");
                    System.out.println();
                }
            }
            else {
                System.out.println("Номер месяца выходит за рамки допустимого значения");
                System.out.println("");
            }
        }
        else {
            System.out.println("Количество шагов не может быть отрицательным");
            System.out.println("");
        }
    }


    public  void printMonthMenu() {
        System.out.println("Январь - Нажмите 0, февраль - Нажмите 1, март - Нажмите 2, апрель - Нажмите 3, май - Нажмите 4, июнь - Нажмите 5,");
        System.out.println("июль - Нажмите 6, август - Нажмите 7, сентябрь - Нажмите 8, октябрь - Нажмите 9, ноябрь - Нажмите 10, декабрь - Нажмите - 11");

    }

    public   void printStatMenuMonth() {
        System.out.println("вывод статистики за указанный пользователем месяц о количестве пройденных шагов по дням. Нажмите 1");
        System.out.println("вывод статистики об общем количестве шагов за месяц. Нажмите 2");
        System.out.println("вывод статистики про максимальное пройденное количество шагов в месяце. Нажмите 3");
        System.out.println("вывод статистики о среднем количестве шагов за месяц. Нажмите 4");
        System.out.println("вывод статистики о пройденной дистанция (в км) за месяц. Нажмите 5");
        System.out.println("вывод статистики о количестве сожжённых килокалорий за месяц. Нажмите 6");
        System.out.println("вывод статистики о лучшей серии: максимальном количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого за месяц. Нажмите 7");
    }
    public   void printStatMenu() {
        System.out.println("вывод статистики за указанный пользователем месяц. Нажмите 1");
        System.out.println("вывод статистики за год.(Extra effort) Нажмите 2");
    }
    public  void printStatMenuYear() {
        System.out.println("вывод статистики о среднем и общем количестве шагов за год. Нажмите 1");
        System.out.println("вывод статистики о пройденной дистанция (в км) за год. Нажмите 2");
        System.out.println("вывод статистики о количестве сожжённых килокалорий за год. Нажмите 3");
        System.out.println("вывод статистики о лучшей серии: максимальном количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого за год. Нажмите 4");
    }
    public  int changeGoalForDay(Scanner scanner, int newGoal) {
        System.out.println("Введите новую цель по количеству шагов в день. Текущая цель " + newGoal + " шагов");
        int newGoalSteps = scanner.nextInt();
        if (newGoalSteps >= 0) {
            System.out.println("установлена новая цель - " + newGoalSteps+ " шагов");
            System.out.println();
            return newGoalSteps;
        } else {
            System.out.println("новая цель не может быть отрицательной");
            System.out.println();
        }
        return newGoal;
    }
    public  void printStepsPerDayInMonth (Scanner scanner, StepTracker stepTracker){
        System.out.println("выберите месяц, в котором вы хотите получить статистику о пройденных шагах за день");
        printMonthMenu();
        int chooseMonthStat = scanner.nextInt();
        for (int i = 0; i < stepTracker.monthToData[chooseMonthStat].monthDates.length; i++) {
            if (i >= 0 && i < 29) {
                System.out.print((i + 1) + " день: " + stepTracker.monthToData[chooseMonthStat].monthDates[i] + ", ");
            } else if (i == 29) {
                System.out.print((i + 1) + " день: " + stepTracker.monthToData[chooseMonthStat].monthDates[i]);
                System.out.println();
                System.out.println();
            }
        }
    }
    public  void printStepsTotalMonth(Scanner scanner, StepTracker stepTracker) {
        System.out.println("выберите месяц, в котором вы хотите получить статистику об общем количестве пройденных шагов за месяц");
        printMonthMenu();
        int chooseMonthStat = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < stepTracker.monthToData[chooseMonthStat].monthDates.length; i++) {
            sum += stepTracker.monthToData[chooseMonthStat].monthDates[i];
        }
        System.out.println("общем количестве пройденных шагов за " + chooseMonthStat + " месяц" + " сосвтавляет " + sum);
        System.out.println();
    }
    public  void printMaxStepsPerDayInMonth (Scanner scanner, StepTracker stepTracker) {
        System.out.println("выберите месяц, в котором вы хотите получить статистику об максимальном пройденном количестве шагов за один день");
        printMonthMenu();
        int chooseMonthStat = scanner.nextInt();
        int max = 0;
        for (int i = 0; i < stepTracker.monthToData[chooseMonthStat].monthDates.length; i++) {
            if (max < stepTracker.monthToData[chooseMonthStat].monthDates[i]) {
                max = stepTracker.monthToData[chooseMonthStat].monthDates[i];
            }
        }
        System.out.println("максимальное количество пройденных шагов за " + chooseMonthStat + " месяц" + " сосвтавляет " + max);
        System.out.println();
    }
    public  void printAvgStepsPerMonth(Scanner scanner, StepTracker stepTracker) {
        System.out.println("выберите месяц, в котором вы хотите получить статистику об среднем количестве шагов");
        printMonthMenu();
        int chooseMonthStat = scanner.nextInt();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < stepTracker.monthToData[chooseMonthStat].monthDates.length; i++) {
            if (stepTracker.monthToData[chooseMonthStat].monthDates[i] != 0) {
                count++;
                sum += stepTracker.monthToData[chooseMonthStat].monthDates[i];
            }
        }
        System.out.println("Среднее количество шагов  за " + chooseMonthStat + " месяц" + " сосвтавляет " + sum / count);
        System.out.println();
    }
    public  void printStepsInKmPerMonth(Scanner scanner, StepTracker stepTracker, Converter converter) {
        System.out.println("выберите месяц, в котором вы хотите получить статистику о пройденной дистанция (в км)");
        printMonthMenu();
        int chooseMonthStat = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < stepTracker.monthToData[chooseMonthStat].monthDates.length; i++) {
            if (stepTracker.monthToData[chooseMonthStat].monthDates[i] != 0) {
                sum += stepTracker.monthToData[chooseMonthStat].monthDates[i];
            }
        }

        System.out.println("Пройденная дистанция (в км)  за " + chooseMonthStat + " месяц" + " сосвтавляет " + converter.stepsToKm(sum));
        System.out.println();
    }
    public  void printStepsToKcalPerMonth(Scanner scanner, StepTracker stepTracker, Converter converter) {
        System.out.println("выберите месяц, в котором вы хотите получить статистику о количестве сожжённых килокалорий");
        printMonthMenu();
        int chooseMonthStat = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < stepTracker.monthToData[chooseMonthStat].monthDates.length; i++) {
            if (stepTracker.monthToData[chooseMonthStat].monthDates[i] != 0) {
                sum += stepTracker.monthToData[chooseMonthStat].monthDates[i];
            }
        }

        System.out.println("Количество сожжённых килокалорий за " + chooseMonthStat + " месяц" + " сосвтавляет " + converter.stepsToKcal(sum));
        System.out.println();
    }
    public  void printBestStepsStack(Scanner scanner, StepTracker stepTracker) {
        System.out.println("выберите месяц, в котором вы хотите получить статистику о лучшей серии");
        printMonthMenu();
        int chooseMonthStat = scanner.nextInt();
        int count = 0;
        int stack = 0;
        for (int i = 0; i < stepTracker.monthToData[chooseMonthStat].monthDates.length; i++) {
            if (stepTracker.monthToData[chooseMonthStat].monthDates[i] > goalForDay) {
                count++;
                if (count > stack) {
                    stack = count;
                }
            }
            else if (stepTracker.monthToData[chooseMonthStat].monthDates[i] < goalForDay) {
                count = 0;
            }
        }
        System.out.println("лучшая серия за " + chooseMonthStat + " месяц" + " сосвтавляет " + stack);
        System.out.println();
    }
    public void printAvgStepsInYear(StepTracker stepTracker) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < stepTracker.monthToData.length; i++) {
            for (int j = 0; j < stepTracker.monthToData[i].monthDates.length; j++) {
                if (stepTracker.monthToData[i].monthDates[j] != 0) {
                    count++;
                    sum += stepTracker.monthToData[i].monthDates[j];
                }
            }
        }
        System.out.println("Среднее количество шагов равно " + sum / count);
        System.out.println("Общее количество шагов за весь год " + sum);
        System.out.println();
    }
    public void printStepsToKmInYear(StepTracker stepTracker, Converter converter) {
        int sum = 0;
        for (int i = 0; i < stepTracker.monthToData.length; i++) {
            for (int j = 0; j < stepTracker.monthToData[i].monthDates.length; j++) {
                if (stepTracker.monthToData[i].monthDates[j] != 0) {
                    sum += stepTracker.monthToData[i].monthDates[j];
                }
            }
        }
        System.out.println("Пройденная дистанция (в км) равно " + converter.stepsToKm(sum));
        System.out.println();
    }
    public void printStepsToKcalInYear(StepTracker stepTracker, Converter converter) {
        int sum = 0;
        for (int i = 0; i < stepTracker.monthToData.length; i++) {
            for (int j = 0; j < stepTracker.monthToData[i].monthDates.length; j++) {
                if (stepTracker.monthToData[i].monthDates[j] != 0) {
                    sum += stepTracker.monthToData[i].monthDates[j];
                }
            }
        }
        System.out.println("Количество сожжённых килокалорий равно " + converter.stepsToKcal(sum));
        System.out.println();
    }
    public void printBestStepsStackInYear(StepTracker stepTracker) {
        // I played with loops. Nevermind;) BTW it works!
        int max = 0;
        int result = 0;
        int count = 0;
        for (int i = 0; i < stepTracker.monthToData.length; i++) {
            for (int j = 0; j < stepTracker.monthToData[i].monthDates.length; j++) {
                for (int k = 0; stepTracker.monthToData[i].monthDates[j + k] >= goalForDay && j + k < stepTracker.monthToData[i].monthDates.length - 1; k++) {
                    count++;
                    if (stepTracker.monthToData[i].monthDates[stepTracker.monthToData[i].monthDates.length - 1] >= goalForDay && j + k == 28) {
                        count++;
                    }
                }
                for (int k = 0; k < stepTracker.monthToData[i].monthDates.length; k++) {
                    if (count == 0 && stepTracker.monthToData[i].monthDates[stepTracker.monthToData[i].monthDates.length - 1] >= goalForDay) {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                }
                count = 0;
            }
            if (result < max) {
                result = max;
            }
            max = 0;
        }
        System.out.println("лучшая серия - стек из " + result);
        System.out.println();
    }
}