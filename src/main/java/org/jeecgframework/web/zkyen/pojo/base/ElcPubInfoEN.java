package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;

import javax.persistence.*;

import org.jeecgframework.core.common.entity.IdEntity;

import java.util.Date;

/**
 * The persistent class for the zk_content_info database table.
 * 
 */
@Entity
@Table(name="zk_en_attachment")
//@NamedQuery(name="ElcPubInfoEN.findAll", query="SELECT z FROM ElcPubInfoEN z")
@Cacheable  
@PrimaryKeyJoinColumn(name = "id")
public class ElcPubInfoEN extends IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String menu;//所属栏目
	private String year;//年份
	private String title1;//title1
	private String title2;//title2
	private String picSrc;//图片路径
	private String fileSrc;//file路径
	private String des;//描述
	private Date creatDate;//创建日期
	
	private String fileSize;//文件大小 M
	private String filsType;//文件类型
	
	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilsType() {
		return filsType;
	}

	public void setFilsType(String filsType) {
		this.filsType = filsType;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}

	public String getFileSrc() {
		return fileSrc;
	}

	public void setFileSrc(String fileSrc) {
		this.fileSrc = fileSrc;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

}