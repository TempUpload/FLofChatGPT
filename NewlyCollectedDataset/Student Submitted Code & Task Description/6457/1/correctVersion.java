import java.util.Calendar;import java.util.Date;import java.util.GregorianCalendar;import java.util.Scanner;class Main {    public static void main(String[] args) {        Calendar res = new GregorianCalendar(2000, Calendar.JANUARY, 1), dst = new GregorianCalendar(2020, Calendar.OCTOBER, 1);        int sum = 0;        while (res.compareTo(dst) <= 0) {            if (res.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || res.get(Calendar.DAY_OF_MONTH) == 1) {                sum += 2;            } else {                sum++;            }            res.add(Calendar.DAY_OF_MONTH, 1);        }        System.out.println(sum);    }}