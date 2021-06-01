package javaexams;

import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Q2 {

    Q1 qnesne = new Q1();

    @Test
    public void localTime() {
        String date = LocalDate
                .parse("2014-05-04:13:00")
                .format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(date);

    }

    @Test
    public void whileQ() {
        int idx = 0;
        int size = 3;

        while (idx < size) {
            idx++;
        }

        System.out.println("idx = " + idx);

    }

    @Test
    public void switchQ() {

        int x = 15;

        switch (x) {
            case 14+1:
                System.out.println("ilk");
               break;
            case 6:
                System.out.println("iki");
                break;
            case 7:
                System.out.println("uc");
                break;

//            default :
//                System.out.println("default");


        }
    }


    @Test
    public void testName() {
//        try {
//        throw new Exception("abc");
//        }
//        catch (Exception e) {}
//        catch (IOException e) {}


    }

    @Test
    public void test01() {

        String [] [] arr = { {"A", "B", "C"}, {"D", "E"}  };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
         //       System.out.print(arr[i][j] + " ");
                if(arr[i][j].equals("B")) {
                    continue;
             //       System.out.println("harfler");
                }
               // System.out.print(" harfyim ");
                System.out.print(arr[i][j] + " ");
            }
            continue;
         //   System.out.println("harfler");
        }

        int x = 100;
        int a = x++;
        System.out.println();
        System.out.println(x);
        System.out.println(a);
        
    }
}
