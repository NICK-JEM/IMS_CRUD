package com.qa.unnamedcrud.operations;

import com.qa.unnamedcrud.DBconfig;
import com.qa.unnamedcrud.Equipment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class CRUDoperations {
	
	private Connection conn; //connection to db
	private Statement stmt;  //query statement for SQL 
	public ResultSet rs; 	 //results returned from SQL db
	
	public String forTest;
	public String created;
	public String deleted;
	public String updated;
	
	public CRUDoperations() {
		//attempt to open a connection using credentials stored in DBconfig
		try {
			//created methods to get credentials, as previously not visible to this class
			conn = DriverManager.getConnection(DBconfig.getUrl(), DBconfig.getUser(), DBconfig.getPass());
			this.stmt = conn.createStatement();
			
			forTest = "connection successful";
			System.out.println(forTest);
			
		} catch(SQLException e) { 
			System.out.println("incorrect credentials");
			e.printStackTrace();
			forTest = "NotOkay";
		}
		
	}
	
	public Equipment create(Equipment item) {
		String createItem = "INSERT INTO equipment(item_name, item_desc, dept, quantity, stored_by, store_date) VALUES('"+item.getItem_name()+"', '"+item.getItem_desc()+"' ,'"+item.getDept()+"',"+item.getQuantity()+", '"+item.getStored_by()+"','"+item.getDate()+"');"; 
		
		try {
			stmt.executeUpdate(createItem);
			
			System.out.println("new item added to labs database");
			return item;
		} catch(SQLException e) {
			
			System.out.println("bad query");
			e.printStackTrace();
			return item;
		}
	}
	
	public void read() {
		
		String readData = "SELECT*FROM equipment;";
		try {
			rs = stmt.executeQuery(readData);
			
			while(rs.next()) {
				
				ArrayList<String> readList = new ArrayList<String>();	
				String[] colNames = {"ID: ", "Name: ", "Description: ", "Department: ", "Quantity: ","Stored By: ", "Date Stored: "};
				
				String rid = Integer.toString(rs.getInt("item_id"));
				String rname = rs.getString("item_name");
				String rdesc = rs.getString("item_desc");
				String rdept = rs.getString("dept");
				String rquant = Integer.toString(rs.getInt("quantity"));
				String rbywhom = rs.getString("stored_by");
				String rdate = rs.getString("store_date");
								
				readList.add(rid); 
				readList.add(rname); 
				readList.add(rdesc);
				readList.add(rdept);
				readList.add(rquant); 
				readList.add(rbywhom);
				readList.add(rdate);
				
				for(int i =0; i<readList.size(); i++ ) {
					System.out.println(colNames[i]+readList.get(i).toString());
				}
				
				/*
				System.out.println("ID: "+ rs.getInt("item_id"));
				System.out.println("item name: "+rs.getString("item_name"));
				System.out.println("item description: "+rs.getString("item_desc"));
				System.out.println("department: "+rs.getString("dept"));
				System.out.println("quantity: "+rs.getInt("quantity"));
				System.out.println("stored by: "+rs.getString("stored_by"));
				System.out.println("date stored: "+rs.getString("store_date"));
				*/
			}
			
			
		} catch(SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			
		}
	}
	
	public void update(int item_id, String upItemName, String upItemDesc, String upDept, int upQuant, String upByWhom, String upStoreDate) {
		
		String upStmt = "UPDATE equipment SET item_name = '"+upItemName+"', item_desc = '"+upItemDesc+"', dept = '"+upDept+"', quantity = "+upQuant+", stored_by = '"+upByWhom+"', store_date = '"+upStoreDate+"' WHERE item_id = "+item_id+"; ";
		
		try {
			stmt.executeUpdate(upStmt);
			updated = "update successful";
			System.out.println(updated);
		} catch(SQLException e){
			updated = "bad query";
			System.out.println(updated);
			e.printStackTrace();
			
		}
		
	}
	
	public void delete(int item_id) {
		String delStmt = "DELETE FROM equipment WHERE item_id="+ item_id+";";
		
		try {
			stmt.executeUpdate(delStmt);
			deleted = "record successfully removed from database.";
			System.out.println(deleted);
		} catch(SQLException e) {
			deleted = "bad query";
			System.out.println(deleted);
			e.printStackTrace();
		}
		
	}
	
	
	public void closeConn() {
		try {
			//attempt to close connection
			conn.close();
			System.out.println("connection terminated.");
		} catch(SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
		}
	}

}
