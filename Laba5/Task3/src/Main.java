import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

abstract class Employee{
    private String NameEmployee;
    private int id;

    public Employee( int id,String NameEmployee){
        this.NameEmployee = NameEmployee;
        this.id = id;
    }
    public String getNameEmployee(){
        return NameEmployee;
    }
    public int getId(){
        return id;
    }
    public void setNameEmployee(String NameEmployee){
        this.NameEmployee = NameEmployee;
    }
    public void setId(int id){
        this.id = id;
    }
    public abstract double MiddleMonthSalary();
    public abstract void Output();
}

class HourSalaryEmployee extends Employee {
    private double HourSalary;

    public HourSalaryEmployee(int id, String NameEmployee, double HourSalary){
        super(id, NameEmployee);
        this.HourSalary = HourSalary;
    }
    public HourSalaryEmployee() {
        super(0,"");
        this.HourSalary = 0;
    }
    public double getHourSalary(){
        return HourSalary;
    }
    public void setHourSalary(double HourSalary){
        this.HourSalary = HourSalary;
    }
    public double MiddleMonthSalary(){
        return 20.8*8*HourSalary;
    }
    public void Output(){
        System.out.println("HourSalaryEmployee:id: " + this.getId() + " Name: " + this.getNameEmployee() + " HourSalary: " + this.getHourSalary());
    }
}

class FixSalaryEmployee extends Employee {
    private double FixSalary;

    public FixSalaryEmployee(int id, String NameEmployee, double FixSalary){
        super(id, NameEmployee);
        this.FixSalary = FixSalary;
    }
    public FixSalaryEmployee() {
        super(0,"");
        this.FixSalary = 0;
    }
    public double getFixSalary(){
        return FixSalary;
    }
    public void setFixSalary(double FixSalary){
        this.FixSalary = FixSalary;
    }
    public double MiddleMonthSalary(){
        return FixSalary;
    }
    public void Output(){
        System.out.println("FixSalaryEmployee: id: " + this.getId() + " Name: " + this.getNameEmployee() + " FixSalary: " + this.getFixSalary());
    }
}

class SortEmployee implements Comparator<Employee>{
    public int compare(Employee Obj1, Employee Obj2){
        if(Obj1.MiddleMonthSalary() != Obj2.MiddleMonthSalary())
            return (int)(Obj1.MiddleMonthSalary() - Obj2.MiddleMonthSalary());
        else
            return Obj1.getNameEmployee().compareTo(Obj2.getNameEmployee());
    }
}

public class Main {

    public static void main(String[] args) {
        //Employee[] ArrEployee = new Employee[15];
        List<Employee> ArrEmployee = new ArrayList<>();
        int IdNumber = 0;

        try{
            File file = new File("HourSalaryEmployee.txt");
            System.out.println(file.createNewFile() ? "HourSalaryEmployee.txt created":"HourSalaryEmployee.txt exists");

            Scanner Reader = new Scanner (file);
            while(Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String[] Str = data.split(" ");
                HourSalaryEmployee ObjHourEmployee = new HourSalaryEmployee(IdNumber,Str[0],Integer.parseInt(Str[1]));
                ArrEmployee.add(ObjHourEmployee);
                IdNumber++;
            }
            Reader.close();
        }catch (IOException except){
            System.out.println("Problem with file: HourSalaryEmployee.txt");
        }
        try{
            File file = new File("FixSalaryEmployee.txt");
            System.out.println(file.createNewFile() ? "FixSalaryEmployee.txt created":"FixSalaryEmployee.txt exists");

            Scanner Reader = new Scanner (file);
            while(Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String[] Str = data.split(" ");
                FixSalaryEmployee ObjFixEmployee = new FixSalaryEmployee(IdNumber,Str[0],Integer.parseInt(Str[1]));
                ArrEmployee.add(ObjFixEmployee);
                IdNumber++;
            }
            Reader.close();
        }catch (IOException except){
            System.out.println("Problem with file: FixSalaryEmployee.txt");
        }
        Comparator CompareEmployee = new SortEmployee();
        Collections.sort(ArrEmployee,Comparator.comparing((Employee p)->p.MiddleMonthSalary()).reversed().thenComparing(p->p.getNameEmployee()));
        System.out.println("After sorting");
        int i = 0;
        for(Employee k:ArrEmployee){
            System.out.println(Integer.toString(k.getId()) + " " + k.getNameEmployee()
                    + " " + Double.toString(k.MiddleMonthSalary()) );
        }

        try {
            File OutFile = new File("OutFile.txt");
            System.out.println(OutFile.createNewFile() ? "OutFile.txt created":"OutFile.txt exists");

            FileWriter WriteFile = new FileWriter("OutFile.txt");
            for(Employee k:ArrEmployee){
                WriteFile.write(Integer.toString(k.getId()) + " " + k.getNameEmployee()
                        + " " + Double.toString(k.MiddleMonthSalary()) + "\n");
            }

            WriteFile.close();
        }catch(IOException except){
            System.out.println("Problem with file: OutFile.txt");
        }
    }
}