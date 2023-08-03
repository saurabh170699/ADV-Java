package com.july28.login_process;

import java.sql.*;
import java.util.Scanner;

public class LoginProcess 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try
			{
				
				System.out.println("\t1.Register"+"\n\t2.Login");
				System.out.println("Enter Your Choice");
				int Choice = Integer.parseInt(s.nextLine());
						
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","MANAGER");
				PreparedStatement ps1 = con.prepareStatement("insert into UserReg55 values(?,?,?,?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement("select * from UserReg55 where uname =? and pword=?");
				switch(Choice)
				{
				
				case 1:
				
					System.out.println("==========Enter Details For registration========");
					System.out.println("\t1. Enter Your userName");
					String ename = s.nextLine();
					System.out.println("\t2.Enter the Password");
					String pward = s.nextLine();
					System.out.println("\t3.Enter the First name");
					String fname = s.nextLine();
					System.out.println("\t4.Enter the Last Name");
					String lname = s.nextLine();
					System.out.println("\t5.Enter the address");
					String add = s.nextLine();
					System.out.println("\t6.Enter the mail id");
					String mid = s.nextLine();
					System.out.println("\t7.Enter the mobile number");
					double phno = s.nextDouble();
					
					ps1.setString(1, ename);
					ps1.setString(2, pward);
					ps1.setString(3, fname);
					ps1.setString(4, lname);
					ps1.setString(5, add);
					ps1.setString(6, mid);
					ps1.setDouble(7, phno);
					
					int k= ps1.executeUpdate();
					if(k>0)
					{
						System.out.println("registration successfully");
					}
					
					System.out.println("\t1.Registration"+"\n\t2.login");
					System.out.println("Enter Your Choice");
					int choice = Integer.parseInt(s.nextLine());
				
					
					break;
					
				case 2:
					
					System.out.println("============Enter Details for login==========");
					System.out.println("Enter the User Name");
					String uname = s.nextLine();
					System.out.println("Enter the password");
					String pass = s.nextLine();
					ps2.setString(1, uname);
					ps2.setString(2, pass);
					
					ResultSet rs1= ps2.executeQuery();
					if(rs1.next())
					{
						
						System.out.println("===login successfull======");
						System.out.println("\tName:" +rs1.getString(1)+
											"\n\tMiddle Name "+rs1.getString(2)+
											"\n\tLast Name :"+rs1.getString(3)+
											"\n\tpassword :"+rs1.getString(4)+
											"\n\tAdd: "+rs1.getString(5)+
											"\n\tEmail: "+rs1.getString(6)+
											"\n\tmobile :"+rs1.getInt(7));
					}
					else
					{
						System.out.println("Ivalid Login Process......");
					}
						
					break;					
			
		default:
	     	
			System.out.println("Invalid Choice Coide....");
			break;
			
		    
	     	}
    	}
		catch(Exception e)
			{
			e.printStackTrace();
			}
		}
		
	}

}
