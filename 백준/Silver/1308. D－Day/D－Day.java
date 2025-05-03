import java.util.*;

public class Main {
    static int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y1 = sc.nextInt(), m1 = sc.nextInt(), d1 = sc.nextInt();
        int y2 = sc.nextInt(), m2 = sc.nextInt(), d2 = sc.nextInt();

        if (isOver1000Years(y1, m1, d1, y2, m2, d2)) {
            System.out.println("gg");
            return;
        }

        int today = countDays(y1, m1, d1);
        int dday = countDays(y2, m2, d2);

        System.out.println("D-" + (dday - today));
    }

    static boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    static int countDays(int year, int month, int day) {
        int days = 0;
        for (int y = 1; y < year; y++) {
            days += isLeap(y) ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            if (m == 2 && isLeap(year)) days += 29;
            else days += daysInMonth[m - 1];
        }
        days += day;
        return days;
    }

    static boolean isOver1000Years(int y1, int m1, int d1, int y2, int m2, int d2) {
        if (y2 - y1 > 1000) return true;
        if (y2 - y1 < 1000) return false;
        if (m2 > m1) return true;
        if (m2 < m1) return false;
        return d2 >= d1;
    }
}