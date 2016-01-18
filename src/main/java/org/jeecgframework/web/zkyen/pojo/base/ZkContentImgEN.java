package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;

import javax.persistence.*;

import org.jeecgframework.core.common.entity.IdEntity;

import java.util.Date;


/**
 * The persistent class for the zk_content_img database table.
 * 
 */
@Entity
@Cacheable  
@Table(name="zk_en_content_img")
//@NamedQuery(name="ZkContentImg.findAll", query="SELECT z FROM ZkContentImg z")
@PrimaryKeyJoinColumn(name = "id")
public class ZkContentImgEN extends IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date addTime;
	private String contentId;
	private String imgUrl;//图片
	private short status;

//	private ZkContentInfo zkContentInfo;
//
//	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY)
//	@JoinColumn(name="content_id")
//	public ZkContentInfo getZkContentInfo() {
//		return zkContentInfo;
//	}
//	public void setZkContentInfo(ZkContentInfo zkContentInfo) {
//		this.zkContentInfo = zkContentInfo;
//	}
	@Column(name="add_time")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
//	@Column(name="content_id")
//	public String getContentId() {
//		return contentId;
//	}
//	public void setContentId(String contentId) {
//		this.contentId = contentId;
//	}
	
	@Column(name="img_url")
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	@Column(name="status")
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	@Column(name="content_id")
	public String getContentId() {
		return contentId;
	}
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	
}