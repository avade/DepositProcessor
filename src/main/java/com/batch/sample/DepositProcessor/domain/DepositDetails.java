package com.batch.sample.DepositProcessor.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author alex.ley
 * Implementation of the DepositDetails interface as a POJO
 */
@SuppressWarnings("rawtypes")
@Entity
@Transactional
@Table(name = "deposit_details")
public class DepositDetails implements Comparable, Serializable {


	private static final long serialVersionUID = 0001;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = true)
	private Long id;
	
	@Column(name = "account_id", unique = false, nullable = false)
	private Integer accountId;
	
	@Column(name = "deposit_amount", unique = false, nullable = false)
	private BigDecimal depositAmount;
	
	@Column(name = "timestamp", unique = false, nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	public DepositDetails(){
		
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setAccountId(int account_id) {
		this.accountId = account_id;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setDepositAmount(BigDecimal depositAmount) {
		this.depositAmount = depositAmount.setScale(2, RoundingMode.HALF_EVEN);
	}

	public BigDecimal getDepositAmount() {
		return depositAmount;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
	public Date getTimestamp() {
		return timestamp;
	}
	
	@Override
	 public String toString() { 
		 return "Account:" + getAccountId() + " Deposit Amount:" + getDepositAmount();
	 }
	 
	public int compareTo(Object o) {
		//check that the object is a deposit etails object
		if(o instanceof DepositDetails){
			//cast the input to deposit details type
			DepositDetails depositDetails = (DepositDetails) o;
			//do the id's match?
			if(depositDetails.getId() == getId()){
				return 0;
			}else{
				return -1;
			}
		}
		return -1;
	}
}
