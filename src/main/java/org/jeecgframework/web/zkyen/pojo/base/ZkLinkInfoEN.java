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
@Table(name="zk_en_link_info")
//@NamedQuery(name="ZkLinkInfo.findAll", query="SELECT z FROM ZkLinkInfo z")
@PrimaryKeyJoinColumn(name = "id")
public class ZkLinkInfoEN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="id",nullable=false,length=32)
	private String id;

	private String name;
	
	private String url;
	
	private Short category;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creatTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Short getCategory() {
		return category;
	}

	public void setCategory(Short category) {
		this.category = category;
	}

	public ZkLinkInfoEN() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}


}