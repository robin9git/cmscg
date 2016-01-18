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
@Cacheable  
@Table(name = "zk_en_logo")
//@NamedQuery(name = "ZkLogo.findAll", query = "SELECT zb FROM ZkLogo zb")
@PrimaryKeyJoinColumn(name = "id")
public class ZkLogoEN extends IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date creatDate;
	private String picSrc;

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}

}