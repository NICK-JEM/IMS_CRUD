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
	private ResultSet rs; 	 //results returned from SQL db
	
	public String forTest;
	public String created;
	public String confirm;
	public boolean deleted;
	public boolean updated;	
	public ArrayList<Object> readList = new ArrayList<>();
	
	
	
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
	
	public ArrayList<Object> read() {
		
		String readData = "SELECT*FROM equipment;";
		try {
			rs = stmt.executeQuery(readData);
			
			while(rs.next()) {
				
				
				int rid = rs.getInt("item_id");
				String rname = rs.getString("item_name");
				String rdesc = rs.getString("item_desc");
				String rdept = rs.getString("dept");
				int rquant = rs.getInt("quantity");
				String rbywhom = rs.getString("stored_by");
				String rdate = rs.getString("store_date");
				
				
				//add object to list 
				Equipment reading = new Equipment(rid, rname, rdesc, rdept, rquant, rbywhom, rdate);
				readList.add((reading)); 
				
				
				for(int i =0; i<readList.size(); i++ ) {
					System.out.println(readList.get(i).toString());
					
				}
					
			}
			return readList;
			
		} catch(SQLException e) { 
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
			
		}
	}
	
	public boolean update(int item_id, String upItemName, String upItemDesc, String upDept, int upQuant, String upByWhom, String upStoreDate) {
		
		String upStmt = "UPDATE equipment SET item_name = '"+upItemName+"', item_desc = '"+upItemDesc+"', dept = '"+upDept+"', quantity = "+upQuant+", stored_by = '"+upByWhom+"', store_date = '"+upStoreDate+"' WHERE item_id = "+item_id+"; ";
		
		try {
			stmt.executeUpdate(upStmt);
			updated = true;
			System.out.println("update successful");
		} catch(SQLException e){
			updated = false;
			System.out.println("bad query");
			e.printStackTrace();
			
		}
		return updated;
	}
	
	public boolean delete(int item_id) {
		String delStmt = "DELETE FROM equipment WHERE item_id="+ item_id+";";
		
		//IMPLEMENT THE AUTO INC RESET IF TABLE EMPTY (to do after MVP passes)
		//String reset = "ALTER TABLE equipment AUTO_INCREMENT = 1";
		
		//return bool
		
		try {
			stmt.executeUpdate(delStmt);
			deleted = true;
			System.out.println("record successfully removed from database.");
		} catch(SQLException e) {
			deleted = false;
			System.out.println("bad query");
			e.printStackTrace();
		} 
		return deleted;
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
