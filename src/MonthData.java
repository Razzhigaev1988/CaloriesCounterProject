public class MonthData {

    int [] monthDates;
    public void fillStepsByDefault(){
        monthDates = new int[30];
        for (int i = 0; i < monthDates.length; i++) {
            monthDates[i] = 0;
        }
    }
}
