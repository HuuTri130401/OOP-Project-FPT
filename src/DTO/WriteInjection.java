package DTO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class WriteInjection {

    ArrayList<Injection> listInjection = new ArrayList<>();
    StudentList list1 = new StudentList();
    VaccineList list2 = new VaccineList();
    public static void main(String[] args) throws Exception {
        WriteInjection w = new WriteInjection();
        w.wrireFile();
        w.readFromFile();
    }
    
    public ArrayList<Injection> wrireFile() {
        try {
            InjectionList list = new InjectionList(list1, list2);
            FileWriter fw = new FileWriter("injection.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            listInjection = list.injectionList;
            
            for (Injection li : listInjection) {
                bw.write(li.toString());
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
        }
        return listInjection;
    }

        public ArrayList<Injection> readFromFile() {
        try {
            FileReader fr = new FileReader("injection.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String injectionId = txt[0];
                String studentId = txt[1];
                String firstDate = txt[2];
                String firstPlace = txt[3];
                String secondDate = txt[4];
                String secondPlace = txt[5];
                String vaccineId = txt[6];
                listInjection.add(new Injection(injectionId, list1.searchSTById(studentId), firstDate, firstPlace, secondDate, secondPlace, list2.searchVcc(vaccineId)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listInjection;
    }
}
