package DTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class StudentList implements UsedForDisplay {

    ArrayList<Student> list = new ArrayList<>();

    public StudentList() {
//        this.readDataFromFile();
           list.add(new Student("SE140001","Nguyen Van An"));
           list.add(new Student("SE140002", "Tran Thanh Binh"));
           list.add(new Student("SE150003", "Pham Ngoc Mai"));
    }

    public ArrayList<Student> readDataFromFile() {
        try {
            FileReader fr = new FileReader("student.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String idSt = txt[0];
                String nameSt = txt[1];
                list.add(new Student(idSt, nameSt));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

//  public Student searchSTByName(String name) {
//        for (Student st : list) {
//            if (st.getIdST().equalsIgnoreCase(name)) {
//                return st;
//            }
//        }
//        return null;
//    }

    public Student searchSTById(String id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getIdST().equalsIgnoreCase(id))
                return list.get(i);
        }
        return null;
    }

    public boolean searchStudentByID(String studentID) {
        if (list == null || list.isEmpty()) {
            return false;
        } else {
            return searchSTById(studentID) != null;
        }
    }

    public String getInforSt(String id) {
        for (Student st : list) {
            if (st.getIdST().equalsIgnoreCase(id)) {
                st.getNameST();
                return st.toString();
            }
        }
        return null;
    }

    @Override
    public void display() {
        if (list == null || list.isEmpty()) {
            System.out.println("The list is empty");
        }
        System.out.println("\n=========Infor of Student=========*");
        System.out.printf("%-17s%-21s\n", "|ID Student ", "|Name of Student");
        for (Student student : list) {
            student.displayInforSt();
        }
        System.out.println("----------------------------------*");
    }
}
