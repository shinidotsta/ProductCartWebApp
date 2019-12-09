package com.face.BO;

public class ProductBO
{
        //generating all the getters and setters in this class for product.
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String pdctNmae;
	private String quantity;
	private String price;

	public String getPdctNmae() {
		return pdctNmae;
	}
	public void setPdctNmae(String pdctNmae) {
		this.pdctNmae = pdctNmae;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
