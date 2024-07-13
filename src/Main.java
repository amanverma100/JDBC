import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String user ="root";
    private static final  String password ="Aman@1811";
    private static final String url="jdbc:mysql://localhost:3306/students";

    public static void main(String[] args)
    {

        try
        {
            Class.forName("com.mysql.jdbc.driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String query = "insert into student(name) values(?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            while(true)
            {
                Scanner scanner=new Scanner(System.in);
                System.out.println("enter name");
                String name=scanner.next();
                preparedStatement.setString( 2,name);
                System.out.print("Do you want to again enter Yes or No");
                String temp=scanner.next();
                preparedStatement.addBatch(query);
                if(temp.equals("Yes"))
                {
                    continue;
                }
                break;
            }
           int [] arr = preparedStatement.executeBatch();
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==0)
                {
                   System.out.println( i + "query is not executed");
                }
                else
                {
                    System.out.println(i +"query is executed");
                }
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }






















      /* // String query= String.format("insert into student (name) values('%s')","prashant");
        String query="insert into student (name) values(?)";
        try {
            Class.forName("com.mysql.jdbc.driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try{
            Connection con = DriverManager.getConnection(url,user,password);
            // Statement statement=con.createStatement();
            PreparedStatement preparedStatement=con.prepareStatement(query);
            preparedStatement.setString(1,"Jagman");
            // ResultSet rs=statement.executeQuery(query);
//             while(rs.next())
//             {
//                 int id= rs.getInt("id");
//                 String name = rs.getString("name");
//                   System.out.println(id + " "+ name);
//             }
           // int affected_row= statement.executeUpdate(query);
            int affected_row=preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
            if(affected_row>0)
            {
                System.out.println("data inserted successfully");
            }
            else
            {
                System.out.println("data not inserted");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        System.out.println("Hello world!");

       */
    }
}