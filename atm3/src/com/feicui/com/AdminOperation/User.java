package com.feicui.com.AdminOperation;

public class User {

	// 用户ID
	private String id;
	// 姓名
	private String name;
	// 密码
	private String passwd;
	// 性别
	private String sex;
	// 身份证
	private String card;
	// 学历
	private String education;
	// 地址
	private String address;
	// 账号
	private String account;
	// 余额
	private Double amount;
	// 取款金额
	private Double draw;
	// 存款金额
	private Double opera;
	// 取款时间
	private String drawdate;
	// 存款时间
	private String operationdate;
	// 转账时间
	private String transferdate;
	// 转账金额
	private double othermoney;

	// 用戶狀態
	private String status;

	// 用于区别用户状态

	private String judge;

	public String getDrawdate() {
		return drawdate;
	}

	public void setDrawdate(String drawdate) {
		this.drawdate = drawdate;
	}

	public String getOperationdate() {
		return operationdate;
	}

	public void setOperationdate(String operationdate) {
		this.operationdate = operationdate;
	}

	public String getTransferdate() {
		return transferdate;
	}

	public void setTransferdate(String transferdate) {
		this.transferdate = transferdate;
	}

	public double getOthermoney() {
		return othermoney;
	}

	public void setOthermoney(double othermoney) {
		this.othermoney = othermoney;
	}

	public Double getOpera() {
		return opera;
	}

	public void setOpera(Double opera) {
		this.opera = opera;
	}

	public Double getDraw() {
		return draw;
	}

	public void setDraw(Double draw) {
		this.draw = draw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String password) {
		this.passwd = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\n" + "账号:" + getAccount() + "\n" + "姓名:" + getName() 
				+ "\n" + "密码:" + getPasswd() + "\n" + "身份证:"
				+ getCard() + "\n" + "学历:" + getEducation() + "\n"
				+ "性别:" + getSex() + "\n" + "地址:" + getAddress() + "\n"
				+ "余额:" + getAmount() + "\n" + "用户状态:"+getStatus() + "\n";
	}

}
