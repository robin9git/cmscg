package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.Date;


/**
 * The persistent class for the recruit_info database table.
 * 
 */
@Entity
@Table(name="zk_en_recruit_info")
@Cacheable  
//@NamedQuery(name="RecruitInfo.findAll", query="SELECT r FROM RecruitInfo r")
@PrimaryKeyJoinColumn(name = "id")
public class RecruitInfoEN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=false,length=32)
	private String id;

	private String category;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name="job_title")
	private String jobTitle;

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="required")
	private String required;

	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="spec_orentation")
	private String specOrentation;
	
	@Column(name="rec_num")
	private Short recNum;

	public Short getRecNum() {
		return recNum;
	}

	public void setRecNum(Short recNum) {
		this.recNum = recNum;
	}

	public RecruitInfoEN() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getRequired() {
		return this.required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getSpecOrentation() {
		return this.specOrentation;
	}

	public void setSpecOrentation(String specOrentation) {
		this.specOrentation = specOrentation;
	}

}