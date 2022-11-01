/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
import java.util.ArrayList;
/**
 *
 * @author duykhanh
 */
public class StudentList extends ArrayList<Student> {
    public StudentList(){}

    public Student search(String code){
        code = code.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).getCode().equals(code))
                return this.get(i);
        }
        return null;
    }

    private boolean isCodeDuplicated(String code){
        code = code.trim().toUpperCase();
        return search(code) != null;
    }

    public void addStudent(){
        String newCode, newName;
        int newMark;
        boolean codeCodeDuplicated = false;
        do {
            newCode = Inputter.inputPattern("St. code S000: ", "[sS][\\d]{3}");
            codeCodeDuplicated = isCodeDuplicated(newCode);
            if (codeCodeDuplicated) 
                System.out.println("Code is duplicated!");
        } while (codeCodeDuplicated==true);
        newName = Inputter.inputNonBlackStr("Name of new student: ").toUpperCase();
        newMark = Inputter.inputInt("Mark: ", 0, 10);

        Student st = new Student(newCode, newName, newMark);

        this.add(st);
        System.out.println("Student " + newCode + " has been added.");
    }

    public void searchStudent(){
        if(this.isEmpty()) 
            System.out.println("Empty list. No search can be performed!");
        else {
            String sCode = Inputter.inputStr("Input student code for search: ");
            Student st = this.search(sCode);
            if (st == null) System.out.println("Student " + sCode + " doesn't existed!");
            else System.out.println("Found: " + st);
        }
    }

    public void updateStudent(){
        if (this.isEmpty())
            System.out.println("Empty list. No update can be performed!");
        else {
            String uCode = Inputter.inputStr("Input student code for update: ");
            Student st = this.search(uCode);
            if (st == null) 
                System.out.println("Student " + uCode + " doesn't existed!");
            else {
                String oldName = st.getName();
                String msg = "Old name: " + oldName + ", new name: ";
                String newName = Inputter.inputNonBlackStr(msg);
                st.setName(newName);
                int oldMark = st.getMark();
                msg = "Old mark: " + oldMark + ", new mark: ";
                int newMark = Inputter.inputInt(msg, 0, 10);
                st.setMark(newMark);
                System.out.println("Student " + uCode + " has been updated!");
            }
        }
    }

    public void removeStudent(){
        if (this.isEmpty())
            System.out.println("Empty list. No remove can be performed!");
        else {
            String rCode = Inputter.inputStr("Input student code for remove: ");
            Student st = this.search(rCode);
            if (st == null) 
                System.out.println("Student " + rCode + " doesn't existed!");
            else {
                this.remove(st);
                System.out.println("Student " + rCode + " has been removed!");
            }
        }
    }

    public void printAll(){
        if (this.isEmpty())
            System.out.println("Empty list!");
        else {
            System.out.println("Student List:");
            for (Student st : this) System.out.println(st);
            System.out.println("Total: " + this.size() + " student(s).");
        }
    }
}
