package DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InjectionList implements UsedForDisplay {
    
    ArrayList<Injection> injectionList = new ArrayList<>();
    
    StudentList studentList = new StudentList();
    VaccineList vaccineList = new VaccineList();

    public InjectionList(StudentList studentList, VaccineList vaccineList) {
//        this.writeFile();
        this.studentList = studentList;
        this.vaccineList = vaccineList;
//        this.readFile();
    }

    public void readFile() {
        WriteInjection w = new WriteInjection();
        this.injectionList = w.readFromFile();
    }

    public void writeFile() {
        WriteInjection w = new WriteInjection();
        this.injectionList = w.wrireFile();
    }

    public void addInjection() {
        String idInj;
        String idSt;
        String idVc;
        String firstDate = null;
        String firstPlace;
        Student student;
        Vaccine vaccine;
        String secondDate = null;
        String secondPlace = null;
        boolean check1 = true;
        boolean check2 = true;
        Date date;
        Date date1;
        Date date2;
        do {
            idInj = CheckInput.getID("Input injection id [XXX]: ", "Input invalid !", "[0-9]{3}");
            check1 = searchInjById(idInj);
            if (check1 == true) {
                System.err.println("The injection id is existed");
            }
        } while (check1 == true);

        studentList.display();
        do {
            idSt = CheckInput.getID("Input student ID format [SE(XXXXXX)]: ", "Input invalid !", "SE[0-9]{6}");
            if (check2 == findSTInInjec(idSt)) {
                System.err.println("The Student ID is existed (has 1 or 2 Injected) !");
                check2 = true;
            } else {
                if (studentList.searchSTById(idSt) == null) {
                    System.err.println("The Student ID is not existed !");
                } else {
                    break;
                }
            }
        } while (check2 == true || studentList.searchSTById(idSt) == null);
        student = studentList.searchSTById(idSt);
        student.displayInforSt();

        vaccineList.display();
        do {
            idVc = CheckInput.getID("Input vaccine ID format [XX]: ", "Input invalid !", "[0-9]{2}");
            if (vaccineList.searchVcc(idVc) == null) {
                System.err.println("The Vaccine ID is not existed !");
            } else {
                break;
            }
        } while (vaccineList.searchVcc(idVc) == null);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        vaccine = vaccineList.searchVcc(idVc);
        vaccine.displayInforVc();
        
        do {
            try {
                firstDate = CheckInput.getAString("Input first Date as format [dd/MM/yyyy] : ", "Input invalid !");
                date = df.parse(firstDate);
                df.setLenient(false);
                df.format(date);
                date1 = df.parse("08/03/2021");
                date2 = df.parse("17/10/2021");
                df.format(date1);
                df.format(date2);
                if (date.before(date1) || date.after(date2)) {
                    System.err.println("Date input invalid !");
                    check2 = true;
                } else {
                    break;
                }
            } catch (ParseException ex) {
                System.err.println("Please input again as format [dd/MM/yyyy] !");
                check2 = true;
            }
        } while (check2 == true);

        firstPlace = CheckInput.getAString("Input the first dose place: ", "Invalid. Please input place again");
        
        secondPlace = null;
        secondDate = null;

        injectionList.add(new Injection(idInj, student, firstPlace, firstDate, secondPlace, secondDate, vaccine));
        System.err.println("Added first injection ");
    }

    @Override
    public void display() {
        if (injectionList.isEmpty()) {
            System.err.println("Nothing to print ! ");
        } else {
            System.out.println("\n============================= * Infor table * =================================|");
            String header = String.format("%-15s%-17s%-22s%-15s%-16s%-15s%-15s%-15s%-22s", "|ID injection", "|ID student", "|Name student", "|1st Date", "|1st Place", "|2nd Date", "|2nd Place", "|Vaccine Id ", "|Name Vaccine|");
            System.out.println(header);
            for (Injection injection : injectionList) {
                injection.showInfor();
            }
        }
    }

    private boolean searchInjById(String idInj) {
        for (Injection injection : injectionList) {
            if (idInj.equalsIgnoreCase(injection.getInjectionId())) {
                return true;
            }
        }
        return false;
    }

    public boolean findSTInInjec(String id) {
        if (injectionList.isEmpty()) {
            return false;
        } else {
            for (Injection injection : injectionList) {
                if (id.equals(injection.getStudent().getIdST())) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean check(String ID) {
        if (injectionList != null || !injectionList.isEmpty()) {
            for (int i = 0; i < injectionList.size(); i++) {
                if (injectionList.get(i).getInjectionId().equals(ID)) {
                    return true;
                }
            }
        }
        return false;
    }

}   
   
    


//        do {
//            studentList.display();
//            idSt = CheckInput.getID("Input student Id format [SEXXXXXX]: ", "Input invalid !", "SE|se[0-9]{6}");
//            check2 = searchByStID(idSt);
//            check3 = studentList.searchStudentByID(idSt);
//            if (check2 == true) {
//                System.err.println("The student's ID is existed or injected one injection.");
//            } else if (check3 == false) {
//                System.err.println("The student's ID is not existed in student list.");
//            }
//        } while (check2 == true || check3 == false);
//
//        do {
//            vaccineList.display();
//            idVc = CheckInput.getID("Input vaccine id format [XX]: ", "Invalid. Please input again.", "[0-9]{2}");
//            check5 = vaccineList.checkIdVcExist(idVc);
//            if (check5 == false) {
//                System.err.println("The vaccine is not existed");
//            }
//        } while (check5 == false);
