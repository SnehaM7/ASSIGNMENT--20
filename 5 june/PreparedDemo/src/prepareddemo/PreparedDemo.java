package prepareddemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class PreparedDemo {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cdac_java", "root", "root");
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO products VALUES(?,?,?)");
		    // Callable Statement
			Scanner sc = new Scanner(System.in);
			do {
				System.out.print("Enter Id: ");
				int id=sc.nextInt();
				System.out.print("Enter Name: ");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.print("Enter Price: ");
				float price = sc.nextFloat();
				
				pstmt.setInt(1,id);
				pstmt.setString(2, name);
				pstmt.setFloat(3, price);
				int result = pstmt.executeUpdate();
				System.out.println(result+" row/s affected");
				
				System.out.print("Do you want to insert more products? (y/n)");
				char choice = sc.next().charAt(0);
				if(choice=='n') {
					break;
				}
			}
			while(true);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
