import java.util.ArrayList;
public class University {
    String uName;
    ArrayList<Student>studentlist=new ArrayList<Student>();
    ArrayList<Departement>deptName=new ArrayList<Departement>();

    University(String uName,String[]dname,String []sname){
        this.uName=uName;
        for (int i=0;i<dname.length;i++){
            deptName.add(new Departement(dname[i]));

        }
        for (int i=0;i<sname.length;i++){
            studentlist.add(new Student(sname[i]));
        }
    }
    class Departement{
        String dname;
        ArrayList<Student>studentsEnroll=new ArrayList<Student>();
        Departement(String dname){
            this.dname=dname;
        }
        void display(){
            System.out.println("student dept name is "+dname);
            for (int i=0;i<studentsEnroll.size();i++){
                System.out.println("Students name is "+studentsEnroll.get(i).sname);
            }
        }
    }
    Departement getDepartment(String dname){
        for (int i=0;i<deptName.size();i++){
            if (deptName.get(i).dname.equals(dname)){
                return deptName.get(i);
            }
        }return null;
    }
    Student getStudent(String sname){
        for(int i=0;i<studentlist.size();i++){
            if (studentlist.get(i).sname.equals(sname)){
                return studentlist.get(i);
            }
        }return null;
    }
    class Student{
        String sname;
        Departement sdept;
        Student(String sname){
            this.sname=sname;
        }
        void display(){
            System.out.println("Student name is "+sname);
            System.out.println("Student dept name is "+sdept.dname);
        }
    }
    public void enrollIn(Departement d,Student s){
        s.sdept=d;
        d.studentsEnroll.add(s);
    }void displayStudents(Departement d){
        d.display();
    }

}class test{
    public static void main(String[] args) {
        String[]sname={"sumair","sachal","nadeem","shaheer"};
        String[]dname={"Sw","Cs","Te","Pg"};
        University muet=new University("muet",dname,sname);
        muet.enrollIn(muet.getDepartment("Sw"),muet.getStudent("sumair"));
        muet.enrollIn(muet.getDepartment("Cs"),muet.getStudent("nadeem"));
        muet.displayStudents(muet.getDepartment("Sw"));
    }
}
