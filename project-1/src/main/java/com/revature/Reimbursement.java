package com.revature;

import java.time.LocalDateTime;

public class Reimbursement {
	private Integer id;
	private Double amount;
	private LocalDateTime submitted;
	private LocalDateTime resolved;
	private String description;
	
	private Integer authorId;
	private String authorName;
	private Integer resolverId;
	private String resolverName;
	private Integer statusId;
	private String status;
	private Integer typeId;
	private String type;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getSubmitted() {
		return submitted;
	}
	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}
	public void setSubmitted() {
		this.submitted = LocalDateTime.now();
	}
	public LocalDateTime getResolved() {
		return resolved;
	}
	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}
	public void setResolved() {
		this.resolved = LocalDateTime.now();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Integer getResolverId() {
		return resolverId;
	}
	public void setResolverId(Integer resolverId) {
		this.resolverId = resolverId;
	}
	public String getResolverName() {
		return resolverName;
	}
	public void setResolverName(String resolverName) {
		this.resolverName = resolverName;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", authorName=" + authorName
				+ ", resolverName=" + resolverName + ", status=" + status + ", type=" + type + "]";
	}
	
}
