package com.fuyong.imwebtest.pojo;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class Invoice {

	private String invoiceCode; //发票代码
	private String invoiceDate; //开票时间
	private String purchaserName; //购方名称
	private String purchaserRegisterNum; //购方纳税人识别号
	private BigDecimal amountInFiguers; //价税合计
	private String sellerName; //售方名称
	private String sellerRegisterNum; //售方纳税人识别号
	public String getInvoiceCode() {
		return invoiceCode;
	}
	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getPurchaserName() {
		return purchaserName;
	}
	public void setPurchaserName(String purchaserName) {
		this.purchaserName = purchaserName;
	}
	public String getPurchaserRegisterNum() {
		return purchaserRegisterNum;
	}
	public void setPurchaserRegisterNum(String purchaserRegisterNum) {
		this.purchaserRegisterNum = purchaserRegisterNum;
	}
	public BigDecimal getAmountInFiguers() {
		return amountInFiguers;
	}
	public void setAmountInFiguers(BigDecimal amountInFiguers) {
		this.amountInFiguers = amountInFiguers;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerRegisterNum() {
		return sellerRegisterNum;
	}
	public void setSellerRegisterNum(String sellerRegisterNum) {
		this.sellerRegisterNum = sellerRegisterNum;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceCode=" + invoiceCode + ", invoiceDate=" + invoiceDate + ", purchaserName="
				+ purchaserName + ", purchaserRegisterNum=" + purchaserRegisterNum + ", amountInFiguers="
				+ amountInFiguers + ", sellerName=" + sellerName + ", sellerRegisterNum=" + sellerRegisterNum + "]";
	}
	
	
	
	
} 
