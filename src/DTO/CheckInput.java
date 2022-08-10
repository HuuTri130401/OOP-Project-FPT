package DTO;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CheckInput {

    static Scanner sc = new Scanner(System.in);

    public static int getAnInterger(String inputMsg, String errorMsg) {
        int intNumber;
        do {
            try {
                System.out.print(inputMsg);
                intNumber = Integer.parseInt(sc.nextLine());
                return intNumber;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        } while (true);
    }

    public static double getADouble(String inputMsg, String errorMsg) {
        double doubleNumber;
        do {
            try {
                System.out.print(inputMsg);
                doubleNumber = Double.parseDouble(sc.nextLine());
                return doubleNumber;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        } while (true);
    }

    public static String getAString(String inputMsg, String errorMsg) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine().trim();
            if (str.length() == 0 || str.isEmpty()) {
                System.err.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public static String inputVaccineID(String inputMsg, String errorMsg, VaccineList vclist, String format) {
        String idCheck;
        boolean match;
        do {
            System.out.print(inputMsg);
            idCheck = sc.nextLine().trim().toUpperCase();
            match = idCheck.matches(format);
            if (vclist.searchVcc(idCheck) != null && match == true) {
                break;
            }
            if (idCheck.length() == 0 || idCheck.isEmpty() || match == false) {
                System.err.println(errorMsg);
            } else {
                if (vclist.searchVcById(idCheck) == false) {
                    System.err.println("Vaccine not exist");
                }
            }
        } while (vclist.searchVcc(idCheck) == null || match == false);
        return idCheck;
    }

    public static int getAnInteger(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.err.println(errorMsg);
            }
        }
    }

    public static String getID(String inputMsg, String errorMsg, String format) {
        String idCheck;
        boolean match;
        do {
            System.out.print(inputMsg);
            idCheck = sc.nextLine().trim();
            match = idCheck.matches(format);
            if (idCheck.length() == 0 || idCheck.isEmpty() || match == false) {
                System.err.println(errorMsg);
            } else {
                return idCheck;
            }
        } while (idCheck.length() == 0 || idCheck.isEmpty() || match == false);
        return idCheck;
    }

    public static boolean getYN(String inputMsg) {
        if (inputMsg.isEmpty()) {
            inputMsg = "Do you want to continue?(Y/N)";
        }
        String YN = getID(inputMsg.toUpperCase(), "Input invalid. Please input Y/N ", "^[YNyn]$");
        return YN.equalsIgnoreCase("Y");
    }
}
