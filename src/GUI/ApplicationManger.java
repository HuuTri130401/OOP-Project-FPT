package GUI;

import DTO.CheckInput;
import DTO.Injection;
import DTO.InjectionList;
import DTO.Student;
import DTO.StudentList;
import DTO.VaccineList;

public class ApplicationManger {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        VaccineList vaccineList = new VaccineList();
        InjectionList list1 = new InjectionList(studentList, vaccineList);
//        list1.readFile();
        System.out.println("  #Welcome to Application Management - @ 2021 by <SE151390 - Tran Huu Tri >");
        int choice = 0;
        do {
            System.out.println("\n|=========================* App Mangement *=========================|");
            System.out.println("*   1. Show information all students have been injected             *");
            System.out.println("*   2. Add student's vaccine injection information                  *");
            System.out.println("*   3. Updating information of students' vaccine injection          *");
            System.out.println("*   4. Delete student vaccine injection information                 *");
            System.out.println("*   5. Search for injection information by studentID                *");
            System.out.println("*   6. Others - Quit !                                              *");
            System.out.println("|___________________________________________________________________|");

            choice = CheckInput.getAnInterger("Please input number 1 to 5 to manage the Menu : ", "Input invalid , please input again!!!");
            switch (choice) {
                case 1:
                    list1.display();
                    break;
                case 2:
                    list1.addInjection();
                    list1.writeFile();
                    break;
                case 3:
                    list1.display();
                    break;
                case 4:
                    System.out.println("___________________________________________________________");
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Bye Bye for this choice@@");
                    list1.writeFile();
                    break;
            }
        } while (choice != 6);
    }
}
