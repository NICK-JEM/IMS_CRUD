package com.qa.unnamedcrud;

public class Equipment {
	
	private int item_id;
	private String item_name;
	private String item_desc;
	private String dept;
	private int quantity;
	private String stored_by;
	private String store_date; //date is string because SQL takes int or string format for date inputs.
	
	public Equipment() {
		super();
	}

	public Equipment(int item_id, String item_name, String item_desc, String dept, int quantity, String stored_by,
			String store_date) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.item_desc = item_desc;
		this.dept = dept;
		this.quantity = quantity;
		this.stored_by = stored_by;
		this.store_date = store_date;
	}
	

	public Equipment(String item_name, String item_desc, String dept, int quantity, String stored_by, String store_date) {
		super();
		this.item_name = item_name;
		this.item_desc = item_desc;
		this.dept = dept;
		this.quantity = quantity;
		this.stored_by = stored_by;
		this.store_date = store_date;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_desc() {
		return item_desc;
	}

	public void setItem_desc(String item_desc) {
		this.item_desc = item_desc;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStored_by() {
		return stored_by;
	}

	public void setStored_by(String stored_by) {
		this.stored_by = stored_by;
	}

	public String getDate() {
		return store_date;
	}

	public void setDate(String store_date) {
		this.store_date = store_date;
	}

	@Override
	public String toString() {
		return "Equipment [item_id=" + item_id + ", item_name=" + item_name + ", item_desc=" + item_desc + ", dept="
				+ dept + ", quantity=" + quantity + ", stored_by=" + stored_by + ", date=" + store_date + "]";
	} 
		

}
