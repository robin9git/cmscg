package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


/**
 * The persistent class for the zk_content_info database table.
 * 
 */
@Entity
@Cacheable  
@Table(name="zk_en_comp_info")
//@NamedQuery(name="ZkCompInfo.findAll", query="SELECT z FROM ZkCompInfo z")
@PrimaryKeyJoinColumn(name = "id")
public class ZkCompInfoEN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=false,length=32)
	private String id;

	private String addr;
	
	private String tele;
	
	private String fax;
	
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creatTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

}