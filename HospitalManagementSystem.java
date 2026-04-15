import java.util.*;

class Doctor{
    int id;
    String name;
    String specialization;

    Doctor(int id,String name,String specialization){
        this.id=id;
        this.name=name;
        this.specialization=specialization;
    }

    void display(){
        System.out.println(id+" "+name+" "+specialization);
    }
}

class Patient{
    int id;
    String name;
    int age;
    int wardId;

    Patient(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
        this.wardId=-1;
    }

    void display(){
        System.out.println(id+" "+name+" Age:"+age+" Ward:"+wardId);
    }
}

class Ward{
    int id;
    String type;

    Ward(int id,String type){
        this.id=id;
        this.type=type;
    }

    void display(){
        System.out.println(id+" "+type);
    }
}

class Appointment{
    int id;
    int doctorId;
    int patientId;

    Appointment(int id,int doctorId,int patientId){
        this.id=id;
        this.doctorId=doctorId;
        this.patientId=patientId;
    }

    void display(){
        System.out.println("Appointment:"+id+" Doctor:"+doctorId+" Patient:"+patientId);
    }
}

class Billing{
    int patientId;
    double amount;

    Billing(int patientId,double amount){
        this.patientId=patientId;
        this.amount=amount;
    }

    void display(){
        System.out.println("Patient:"+patientId+" Bill:"+amount);
    }
}

public class HospitalSystem{

    static Scanner sc=new Scanner(System.in);

    static ArrayList<Doctor> doctors=new ArrayList<>();
    static ArrayList<Patient> patients=new ArrayList<>();
    static ArrayList<Ward> wards=new ArrayList<>();
    static ArrayList<Appointment> appointments=new ArrayList<>();
    static ArrayList<Billing> bills=new ArrayList<>();
    static void addDoctor(){

        System.out.print("Doctor ID: ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name=sc.nextLine();

        System.out.print("Specialization: ");
        String sp=sc.nextLine();

        doctors.add(new Doctor(id,name,sp));

        System.out.println("Doctor Added");
    }

    static void listDoctors(){

        for(Doctor d:doctors)
            d.display();
    }

    static void searchDoctor(){

        System.out.print("Enter Doctor ID: ");
        int id=sc.nextInt();

        for(Doctor d:doctors){
            if(d.id==id){
                d.display();
                return;
            }
        }

        System.out.println("Doctor Not Found");
    }
    static void addPatient(){

        System.out.print("Patient ID: ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name=sc.nextLine();

        System.out.print("Age: ");
        int age=sc.nextInt();

        patients.add(new Patient(id,name,age));

        System.out.println("Patient Added");
    }

    static void listPatients(){

        for(Patient p:patients)
            p.display();
    }

    static void searchPatient(){

        System.out.print("Enter Patient ID: ");
        int id=sc.nextInt();

        for(Patient p:patients){
            if(p.id==id){
                p.display();
                return;
            }
        }

        System.out.println("Patient Not Found");
    }

    static void addWard(){

        System.out.print("Ward ID: ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.print("Ward Type: ");
        String type=sc.nextLine();

        wards.add(new Ward(id,type));

        System.out.println("Ward Added");
    }

    static void assignWard(){

        System.out.print("Patient ID: ");
        int pid=sc.nextInt();

        System.out.print("Ward ID: ");
        int wid=sc.nextInt();

        for(Patient p:patients){
            if(p.id==pid){
                p.wardId=wid;
                System.out.println("Ward Assigned");
                return;
            }
        }

        System.out.println("Patient Not Found");
    }
    static void addAppointment(){

        System.out.print("Appointment ID: ");
        int id=sc.nextInt();

        System.out.print("Doctor ID: ");
        int did=sc.nextInt();

        System.out.print("Patient ID: ");
        int pid=sc.nextInt();

        appointments.add(new Appointment(id,did,pid));

        System.out.println("Appointment Booked");
    }

    static void showDoctorAppointments(){

        System.out.print("Doctor ID: ");
        int id=sc.nextInt();

        for(Appointment a:appointments){
            if(a.doctorId==id){
                a.display();
            }
        }
    }

    static void addBill(){

        System.out.print("Patient ID: ");
        int pid=sc.nextInt();

        System.out.print("Amount: ");
        double amt=sc.nextDouble();

        bills.add(new Billing(pid,amt));

        System.out.println("Bill Added");
    }

    static void showPatientBill(){

        System.out.print("Patient ID: ");
        int pid=sc.nextInt();

        for(Billing b:bills){
            if(b.patientId==pid){
                b.display();
            }
        }
    }

    public static void main(String[] args){

        int mainChoice=0;

        do{

            System.out.println("\n--- HOSPITAL SYSTEM ---");
            System.out.println("1 Login");
            System.out.println("2 Exit");

            try{
                mainChoice=sc.nextInt();
            }
            catch(InputMismatchException e){

                System.out.println("Invalid Input");
                sc.nextLine();
                continue;
            }

            if(mainChoice==1){

                int choice=0;

                do{

                    System.out.println("\n--- DASHBOARD ---");
                    System.out.println("1 Add Doctor");
                    System.out.println("2 List Doctors");
                    System.out.println("3 Search Doctor");
                    System.out.println("4 Add Patient");
                    System.out.println("5 Search Patient");
                    System.out.println("6 Add Ward");
                    System.out.println("7 Assign Patient to Ward");
                    System.out.println("8 Book Appointment");
                    System.out.println("9 Show Doctor Appointments");
                    System.out.println("10 Add Bill");
                    System.out.println("11 Show Patient Bill");
                    System.out.println("12 Logout");

                    choice=sc.nextInt();

                    switch(choice){

                        case 1: addDoctor(); break;
                        case 2: listDoctors(); break;
                        case 3: searchDoctor(); break;
                        case 4: addPatient(); break;
                        case 5: searchPatient(); break;
                        case 6: addWard(); break;
                        case 7: assignWard(); break;
                        case 8: addAppointment(); break;
                        case 9: showDoctorAppointments(); break;
                        case 10: addBill(); break;
                        case 11: showPatientBill(); break;

                    }

                }while(choice!=12);

            }

        }while(mainChoice!=2);

    }
}