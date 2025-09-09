package com.aashditcart.test.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_cart_msg_processor")
public class MessageProcessor {

	private static final long serialVersionUID = -6974103749030920423L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "msg_id")
	private Long msgId;
	
	@Column(name = "template_name")
	private String templateName;

	@Column(name = "msg_content")
	private String content;
	
	@Column(name = "reason")
	private String reason;

	@Column(name = "is_send")
	private Boolean isSend;
	
	@Column(name = "cell_no")
	private String cellNo;
	
	@Column(name = "created_date")
	private Date createdOn;
	
	@Column(name = "updated_date")
	private Date updatedOn;
	
//	@Column(name = "is_active")
//	private Boolean isActive;
	
	public MessageProcessor(){}
	
	public MessageProcessor(String message, String mobileNumber, String templateName) {
		this.content=message;
		this.cellNo=mobileNumber;
		this.templateName=templateName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getIsSend() {
		return isSend;
	}

	public void setIsSend(Boolean isSend) {
		this.isSend = isSend;
	}
}
