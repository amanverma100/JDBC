import java.sql.*;
public class Main {
    private static final String user ="root";
    private static final  String password ="Aman@1811";
    private static final String url="jdbc:mysql://localhost:3306/students";

    public static void main(String[] args)
    {
       // String query= String.format("insert into student (name) values('%s')","prashant");
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
    }
}