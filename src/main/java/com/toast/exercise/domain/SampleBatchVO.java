package com.toast.exercise.domain;

public class SampleBatchVO {
	
	private String itemId;
	private String itemName;
	private long price;
	private String descn;
	private String createdId;
	
	/**
	 * @return the itemId
	 */
	public String getItemId() {
		return itemId;
	}
	
	/**
	 * @param itemId the itemId to set
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}
	
	/**
	 * @return the descn
	 */
	public String getDescn() {
		return descn;
	}
	
	/**
	 * @param descn the descn to set
	 */
	public void setDescn(String descn) {
		this.descn = descn;
	}
	
	/**
	 * @return the createdId
	 */
	public String getCreatedId() {
		return createdId;
	}
	
	/**
	 * @param createdId the createdId to set
	 */
	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SampleBatchVO [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", descn=" + descn
				+ ", createdId=" + createdId + "]";
	}

}
