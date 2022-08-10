package DTO;

/**
 *
 * @author Huu Tri
 */
public class Injection {
    private String injectionId;
    private Student student;
    private String firstPlace, firstDate;
    private String secondPlace, secondDate;
    private Vaccine vaccine;
    
    public Injection() {
    }

    public Injection(String injectionId, Student student, String firstPlace, String firstDate, String secondPlace, String secondDate, Vaccine vaccine) {
        this.injectionId = injectionId;
        this.student = student;
        this.firstPlace = firstPlace;
        this.firstDate = firstDate;
        this.secondPlace = secondPlace;
        this.secondDate = secondDate;
        this.vaccine = vaccine;
    }

    public String getFirstPlace() {
        return firstPlace;
    }

    public void setFirstPlace(String firstPlace) {
        this.firstPlace = firstPlace;
    }

    public String getInjectionId() {
        return injectionId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(String secondDate) {
        this.secondDate = secondDate;
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }

    public String getSecondPlace() {
        return secondPlace;
    }

    public void setSecondPlace(String secondPlace) {
        this.secondPlace = secondPlace;
    }
    
    @Override
    public String toString() {
        return injectionId + ";" +  student.getIdST() + ";" +  firstDate + ";" + firstPlace+ ";" + secondDate+ ";" +secondPlace+ ";" +vaccine.getIdVc() + "\n";
    }

    public void showInfor(){
        System.out.printf("|%-14s%s|%-14s|%-15s|%-14s|%-14s%s\n", injectionId, student.toString(),
                               firstDate, firstPlace, secondDate, secondPlace, vaccine.toString());
    }
}
