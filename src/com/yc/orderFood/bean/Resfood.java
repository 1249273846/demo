package com.yc.orderFood.bean;

public class Resfood {

	private Integer fid;
	private String fname;
	//原价
	private Double normprice;
	//现价
	private Double realprice;
	//菜品描述
	private String detail;
	//菜品图片
	private String fphoto;

	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Double getNormprice() {
		return normprice;
	}
	public void setNormprice(Double normprice) {
		this.normprice = normprice;
	}
	public Double getRealprice() {
		return realprice;
	}
	public void setRealprice(Double realprice) {
		this.realprice = realprice;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getFphoto() {
		return fphoto;
	}
	public void setFphoto(String fphoto) {
		this.fphoto = fphoto;
	}
	
	
	
}
