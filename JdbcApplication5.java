package com.july27.choice_opration;

import java.sql.*;

import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

public class JdbcApplication5 
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","MANAGER");
				PreparedStatement ps1 = con.prepareStatement("insert into Employee55 values(?,?,?,?,?)");
			    PreparedStatement ps2 = con.prepareStatement("select * from Employee55");
			    PreparedStatement ps3 = con.prepareStatement("select * from Employee55 where eid=?");
			    PreparedStatement ps4 = con.prepareStatement("update Employee55 set bSal=? , totSal = ? where eid=?");
			    PreparedStatement ps5 = con.prepareStatement("delete from Employee55 where eid = ?");

				while(true)
				{
					System.out.println("==================Choice===============");
					System.out.println(
					"\t1.Add Employee"+
					"\n\t2.View All Employee"+
					"\n\t3.View Employee ID"+
					"\n\t4.Update Empoyee By ID"+
					"\n\t5.Delete Employee ById"+
					"\n\t6.exit");
					
					System.out.println("Enter the Choice.");
					int choice= Integer.parseInt(s.nextLine());
					switch(choice)
					{
					case 1:
						System.out.println("------------Employee Details----------");
						System.out.println("Enter the EmpId:");
						String eId = s.nextLine();
						System.out.println("Enter the EmpName");
						String eName = s.nextLine();
						System.out.println("Enter the EMpDesg");
						String eDesg = s.nextLine();
						System.out.println("Enter the basic sal");
						int bSal = Integer.parseInt(s.nextLine());
						
						float totSal = bSal+(0.96F*bSal)+(0.53F*bSal);
						
						ps1.setString(1, eId);
						ps1.setString(2,eName);
						ps1.setString(3, eDesg);
						ps1.setInt(4, bSal);
						ps1.setFloat(5, totSal);
						
						int k= ps1.executeUpdate();
						if(k>0)
						{
							System.out.println("Employee Added succfully");
						}
						
						break;
						
					case 2:
						ResultSet rs = ps2.executeQuery();
						while(rs.next())
						{
							System.out.println(rs.getString(1)
							+"\t"+rs.getString(2)
							+"\t"+rs.getString(3)
							+"\t"+rs.getInt(4)
							+"\t"+rs.getFloat(5));
						}
						
						break;
						
					case 3:
						System.out.println("Enter the EmpId");
						String eId2 = s.nextLine();
						ps3.setString(1, eId2);
						ResultSet rs2 = ps3.executeQuery();
						
						if(rs2.next())
						{
							System.out.println("Id :"+rs2.getString(1)
							+"\nName:"+rs2.getString(2)
							+"\nDesg:"+rs2.getString(3)
							+"\nBSal:"+rs2.getInt(4)
							+"\nTotSal:"+rs2.getFloat(5));					   
						}
						else 
						{
							System.out.println("Invalid EmpId...");
						}
						break;
						
					case 4:
						System.out.println("Enter the EmpId");
						String eId3 = s.nextLine();
						ps3.setString(1, eId3);
						ResultSet rs3 = ps3.executeQuery();
						if(rs3.next())
						{
							System.out.println("Enter new bSal:");
							int nBSal = Integer.parseInt(s.nextLine());
							float nTotSal = nBSal+(0.96F*nBSal)+(0.53F*nBSal);
							ps4.setInt(1, nBSal);
							ps4.setFloat(2, nTotSal);
							ps4.setString(3, eId3);
							int k2 = ps4.executeUpdate();
							if(k2>0)
							{
								System.out.println("Employee Upload...");
								
							}
						}
							else
							{
								System.out.println("Invalid EmpId..");
							}
						
						break;
						
					case 5:
						    System.out.println("Enter the Employee Id");
						    String eId4 = s.nextLine();
						    ps3.setString(1, eId4);
						    ResultSet rs4 = ps3.executeQuery();
						    if(rs4.next())
						    {
						    	ps5.setString(1, eId4);
						    	int k3 = ps5.executeUpdate();
						        if(k3>0)
						        {
						        	System.out.println("Employee Deleted ");
						        	
						        }
						    }
						        else
						        {
						        	System.out.println("Invalid id");
						        }						    
						
				 	break;
					case 6:
						System.out.println("Program will be stop");
						System.exit(0);
						break;
					default :
							System.out.println("Invalide Choice");
						
					}
				}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
	    }
    }
}