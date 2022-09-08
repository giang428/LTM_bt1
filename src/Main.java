import model.SV;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({"unchecked"})
public class Main {
    private static ArrayList<SV> listSV = new ArrayList<>();
    private static String LIST_SV = "data.dat";
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        load(LIST_SV);
        while (true) {
            options();
            try {
                int k = Integer.parseInt(sc.nextLine());
                switch (k) {
                    case 1:
                        add();
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        print();
                        break;
                    case 4:
                        save(LIST_SV);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invaild option!");
                        System.out.println("Press Enter key to continue...");
                        sc.nextLine();

                }
            } catch (Exception e) {
                System.out.println("Lmao");
            }
        }
    }

    private static void load(String file) throws IOException {
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object oj = ois.readObject();
            listSV.addAll((ArrayList<SV>) oj);
            System.out.println("Done! " + listSV.size() + " student(s) read from file" );
        } catch (IOException | ClassNotFoundException e) {
            File n = new File("data.dat");
            if (n.createNewFile()) {
                System.out.println("Created!");
            } else
                System.out.println("File existed!" + e);
        }
    }

    private static void add() {
        System.out.print("Enter id: ");
        String masv = sc.nextLine();
        System.out.print("Enter name: ");
        String ten = sc.nextLine();
        System.out.print("Enter group: ");
        int nhom = Integer.parseInt(sc.nextLine());
        try {
            SV a = new SV(masv, ten, nhom);
            listSV.add(a);
            System.out.println("Succesfully added!");
            System.out.println("Press Enter key to continue...");
            sc.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void save(String file) throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listSV);
            System.out.println("Successfully saved!");
            System.out.println("Press Enter key to continue...");
            sc.nextLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (oos != null) oos.close();
        }
    }

    private static void print() {
        if (listSV.isEmpty()) {
            System.out.println("No data!");
        } else {
            for (SV i : listSV) {
                System.out.println(i);
            }
        }
        System.out.println("Press Enter key to continue...");
        sc.nextLine();
    }

    private static void update() {
        System.out.print("Enter student id: ");
        String id = sc.nextLine();

        boolean exist = false;

        for (SV sinhvien : listSV) {
            if (sinhvien.getMaSV().equals(id)) {
                System.out.println("Found 1 student with id: " + id);
                System.out.println(sinhvien);
                exist = true;
                System.out.print("Enter new id: ");
                String nid = sc.nextLine();
                System.out.print("Enter new name: ");
                String nname = sc.nextLine();
                System.out.print("Enter new group: ");
                int ngroup = Integer.parseInt(sc.nextLine());
                try {
                    sinhvien.setMaSV(nid);
                    sinhvien.setHoten(nname);
                    sinhvien.setNhom(ngroup);
                    System.out.println("Successfully updated!");
                    System.out.println("Press Enter key to continue...");
                    sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Error! " + e);
                }
            }
        }
        if(!exist){
            System.out.println("Cannot find student with id: " + id);
            System.out.println("Press Enter key to continue...");
            sc.nextLine();
        }
    }

    private static void options() {
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Choose option:");
        System.out.println("1. Add new student");
        System.out.println("2. Update student");
        System.out.println("3. Show all students");
        System.out.println("4. Save to file");
        System.out.println("5. Exit");
        System.out.println();
    }

}