import java.sql.*;
import java.util.Scanner;


import java.sql.*;
import java.util.Scanner;

    public class dbconnection {


        public static void getdata() throws SQLException {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");
                String s = "select * from information";
                PreparedStatement ps = con.prepareStatement(s);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println( "id = "+id);
                    System.out.println("name = "+name);
                    System.out.println("age = "+age);
                }
            } catch (SQLException n) {
                n.printStackTrace();
            }
        }

        public static void insert()throws SQLException
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");
            PreparedStatement ps=con.prepareStatement("insert into information(id,name,age) values(1,'krish patel',19)" );
            int x=ps.executeUpdate();
            if(x>0)
            {
                System.out.println("inserted succesfully");
            }
            else{
                System.out.println("not inserted");
            }

        }


        public static void update()throws SQLException{
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");
                PreparedStatement ps = con.prepareStatement("update information set name='priya',age=18 where id=1");
                int x = ps.executeUpdate();
                if (x > 0) {
                    System.out.println("updated succesfully");
                } else {
                    System.out.println("not updated");
                }
            }
        }

        public static void Delete()throws SQLException{
            {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");
                PreparedStatement ps = con.prepareStatement("delete from information where id=1");
                int x = ps.executeUpdate();
                if (x > 0) {
                    System.out.println("deleted succesfully");
                } else {
                    System.out.println("not deleted");
                }
            }
        }




        public static void insertplaceholder()throws SQLException
        {
            Scanner sc=new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");
            PreparedStatement ps=con.prepareStatement("insert into information(id,name,age) values(?,?,?)" );


            System.out.print("id=");
            int id=sc.nextInt();
            ps.setInt(1,id);
            sc.nextLine();

            System.out.print("name=");
            String name=sc.nextLine();
            ps.setString(2,name);


            System.out.print("age=");
            int age=sc.nextInt();
            ps.setInt(3,age);


            int x=ps.executeUpdate();

            if(x>0)
            {
                System.out.println("inserted succesfully");
            }
            else{
                System.out.println("not inserted");
            }

        }

        public static void delteplaceholder()throws SQLException
        {
            Scanner sc=new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");
            PreparedStatement ps=con.prepareStatement("delete from information where id=?" );

            System.out.print("enter id:");
            int id=sc.nextInt();
            ps.setInt(1,id);

            int x= ps.executeUpdate();
            if(x>0)
            {
                System.out.println("Deleted successfully");
            }else{
                System.out.println("Operation failed");
            }
        }

        public static void udatepalceholder()throws SQLException
        {
            Scanner sc=new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");
            PreparedStatement ps=con.prepareStatement("update information set name=? where id=?");

            System.out.print("Enter id : ");
            int id=sc.nextInt();
            ps.setInt(2,id);
            sc.nextLine();

            System.out.print("enter name : ");
            String name=sc.nextLine();
            ps.setString(1,name);
            sc.nextLine();

            int x=ps.executeUpdate();
            if(x>0)
            {
                System.out.println("Updated Successfully");
            }else {
                System.out.println("Operation failed");
            }
        }

        public static void Selectpalceholder()throws SQLException {

            Scanner sc = new Scanner(System.in);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "krishpatel13579");

            PreparedStatement ps = con.prepareStatement("select name,age from information where id=?");
            System.out.print("enter id:");
            int id = sc.nextInt();
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                String name=rs.getString("name");
                System.out.println("name:"+name);
                int age=rs.getInt("age");
                System.out.println("age:"+age);



            }
            rs.close();
            ps.close();
            con.close();
        }

        public static void main(String[] args) throws SQLException {
//        dbconnection.getdata();
//        dbconnection.insert();
//        dbconnection.update();
//        dbconnection.Delete();

//        dbconnection.insertplaceholder();
//        dbconnection.delteplaceholder();
//        dbconnection.udatepalceholder();
//        dbconnection.Selectpalceholder();
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter 1->View Enteries");
            System.out.println("Enter 2->Insert values into table");
            System.out.println("Enter 3->Update Enteries");
            System.out.println("Enter 4->Delete Enteries");
            System.out.println("Enter 0-> Exit.........");

            int choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    dbconnection.Selectpalceholder();
                    break;
                case 2:
                    dbconnection.insertplaceholder();
                    break;
                case 3:
                    dbconnection.udatepalceholder();
                    break;
                case 4:
                    dbconnection.delteplaceholder();
                    break;
                case 0:
                    System.out.println("Exiting.............!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entered Wrong input Please enter choice again.......");
            }

        }
    }
