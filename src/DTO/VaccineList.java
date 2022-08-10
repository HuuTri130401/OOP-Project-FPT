package DTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class VaccineList implements UsedForDisplay {

    public ArrayList<Vaccine> list = new ArrayList<>();

    public VaccineList() {
//        this.readDataFromFile();
         list.add(new Vaccine("02", "Sinopharm"));
         list.add(new Vaccine("04", "AstraZeneca"));
         list.add(new Vaccine("10", "Pfizer"));
    }
    
    public ArrayList<Vaccine> readDataFromFile() {
        try {
            FileReader fr = new FileReader("vaccine.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String idVc = txt[0];
                String nameVc = txt[1];
                list.add(new Vaccine(idVc, nameVc));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public boolean checkIdVcExist(String idVc) {
        return searchVcc(idVc) != null;
    }

    public boolean checkNameVcExist(String nameVc) {
        return searchVcc(nameVc) != null;
    }
// public Vaccine searchVcByName(String name) {
//        for (Vaccine vc : list) {
//            if (vc.getNameVc().equalsIgnoreCase(name)) {
//                return vc;
//            }
//        }
//        return null;
//    }

    public Vaccine searchVcc(String id) {
        for (Vaccine vc : list) {
            if (vc.getIdVc().equalsIgnoreCase(id)) {
                vc.getNameVc();
                return vc;
            }
        }
        return null;
    }

    public String getInforVc(String id) {
        for (Vaccine vaccine : list) {
            if (vaccine.getIdVc().equalsIgnoreCase(id)) {
                vaccine.getNameVc();
                return vaccine.toString();
            }
        }
        return null;
    }

    public boolean searchVcById(String vcId) {
        if (list == null || list.isEmpty()) {
            return false;
        } else {
            return searchVcc(vcId) != null;
        }
    }

    @Override
    public void display() {
        if (list == null || list.isEmpty()) {
            System.out.println("The list is empty");
        }
        System.out.println("=======Infor of Vaccine=========*");
        System.out.printf("%-14s%-22s\n", "|ID Vaccine", "|Name of Vaccine");
        for (Vaccine vaccine : list) {
            vaccine.displayInforVc();
        }
        System.out.println("--------------------------------*");
    }
}
