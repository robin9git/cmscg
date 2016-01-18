package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;

import javax.persistence.*;

import org.jeecgframework.core.common.entity.IdEntity;

import java.util.Date;

/**
 * The persistent class for the ZkBanner database table.
 * 
 */
@Entity
@Table(name = "zk_en_banner")
@Cacheable  
//@NamedQuery(name = "ZkBanner.findAll", query = "SELECT zb FROM ZkBanner zb")
@PrimaryKeyJoinColumn(name = "id")
public class ZkBannerEN extends IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date creatTime;

	private String titleEN;
	private Short functionOrder;

	// 是否首页展示
	private Short isshow;
	private MenuEN TSFunction;

	@OneToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "menu_id", referencedColumnName = "id")
	public MenuEN getTSFunction() {
		return TSFunction;
	}

	public void setTSFunction(MenuEN tSFunction) {
		TSFunction = tSFunction;
	}

	private String picSrc;

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public String getTitleEN() {
		return titleEN;
	}

	public void setTitleEN(String titleEN) {
		this.titleEN = titleEN;
	}

	public Short getIsshow() {
		return isshow;
	}

	public void setIsshow(Short isshow) {
		this.isshow = isshow;
	}

	public Short getFunctionOrder() {
		return functionOrder;
	}

	public void setFunctionOrder(Short functionOrder) {
		this.functionOrder = functionOrder;
	}

	@Column(name="pic_src")
	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}

}