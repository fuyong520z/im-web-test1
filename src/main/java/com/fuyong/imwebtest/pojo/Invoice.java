package com.fuyong.imwebtest.pojo;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class Invoice {

	private String invoiceCode; //��Ʊ����
	private String invoiceDate; //��Ʊʱ��
	private String purchaserName; //��������
	private String purchaserRegisterNum; //������˰��ʶ���
	private BigDecimal amountInFiguers; //��˰�ϼ�
	private String sellerName; //�۷�����
	private String sellerRegisterNum; //�۷���˰��ʶ���
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
