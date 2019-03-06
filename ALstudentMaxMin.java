package filerwintoarraylistmaxmin;

import java.io.*;
import java.util.*;


// Program reads all the lines of blrstudent2.csv
// loads student atrributes to Student object - to be done as assignment

public class ALstudentMaxMin {

    public static void main(String args[]) {

        String filepath = "G:\\java projects\\arrayliststudentmaxmin.csv";
        ArrayList<String> linesRead = new ArrayList<String>();
        ArrayList<Student> records = new ArrayList<Student>();


        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                linesRead.add(currentline);// Add line to String Arraylist
                currentline = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList<Integer> ageList = new ArrayList<Integer>();
        ArrayList<Double> marksList = new ArrayList<Double>();
        ArrayList<String> nameList = new ArrayList<>();

        //using enhanced loop to store details into objects
        Student sobj;
        for (String s : linesRead) {
            String[] tokens = s.split(","); //this splits the line based on "," as delimiter
            sobj = new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]),
                    Double.parseDouble(tokens[3]));
            records.add(sobj);
        }

        //to get the object details with max marks
        Student element;
        element = Collections.max(records, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Max marks is " + element.getMarks());
        System.out.println("Student Details with Max Marks is  :" + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());

        System.out.println();

        //to get the object details with min marks
        element = Collections.min(records, Comparator.comparingDouble(Student::getMarks));
        System.out.println("Min marks is : " + element.getMarks());
        System.out.println("Student Details with Mix Marks is  :" + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());

        System.out.println();

        //to get the object details with max age
        element = Collections.max(records, Comparator.comparingInt(Student::getAge));
        System.out.println("Max age is :" + element.getAge());
        System.out.println("Student Details with Max age is  :" + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());

        System.out.println();

        //to get the object details with min age
        element = Collections.min(records, Comparator.comparingInt(Student::getAge));
        System.out.println("Min age is :" + element.getAge());
        System.out.println("Student Details with Min age is  :" + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());

        System.out.println();

        //to get the object details with alphabetically lastname
        element = Collections.max(records, Comparator.comparing(Student::getName));
        System.out.println("Max name is :" + element.getName());
        System.out.println("Student Details with alphabetically Last name is  :" + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());

        System.out.println();

        //to get the object details with alphabetically firstname
        element = Collections.min(records, Comparator.comparing(Student::getName));
        System.out.println("Min name is :" + element.getName());
        System.out.println("Student Details with alphabetically First name is  :" + element.getRollno() + " " + element.getName() + " " + element.getAge() + " " + element.getMarks());


    }
}

// Student class and constructor
class Student {
    private int rollno;
    private String name;
    private int age;
    private double marks;

    Student(int rollno, String name, int age, double marks) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }


    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}

