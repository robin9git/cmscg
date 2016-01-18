package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;

import javax.persistence.*;

import org.jeecgframework.core.common.entity.IdEntity;
import org.jeecgframework.core.util.StringUtil;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the zk_content_info database table.
 * 
 */
@Entity
@Cacheable  
@Table(name="zk_en_content_info")
//@NamedQuery(name="ZkContentInfo.findAll", query="SELECT z FROM ZkContentInfo z")
@PrimaryKeyJoinColumn(name = "id")
public class ZkContentInfoEN extends IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Lob
	@Basic(fetch=FetchType.LAZY)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date creatTime;
	
	//发布时间
//	private Date publicTime;
	private String publicTime;
	
	private String longTitle;

	private short status;
	
	private Short contOrder;
	
	private Short newsLevel;

	private String title;
	//文章来源
	private String newsfrom;
	
	private String picSrc;//图片
	
	private MenuEN TSFunction;
	
//	//内容对应多张图片
//	private Set<ZkContentImg> imgs;
//
//	@OneToMany(mappedBy="zkContentInfo")
//	public Set<ZkContentImg> getImgs() {
//		return imgs;
//	}
//
//	public void setImgs(Set<ZkContentImg> imgs) {
//		//图片url转化
//		Set<ZkContentImg> setList = new HashSet<ZkContentImg>();
//		if(StringUtil.isNotEmpty(picSrc)){
//			String[] arr = picSrc.split("|");
//			if(arr.length>0){
//				ZkContentImg ent = null;
//				short s = 1;
//				for(int i =0 ;i<arr.length;i++){
//					ent = new ZkContentImg();
//					ent.setAddTime(new Date());
//					ent.setImgUrl(arr[i]);
//					ent.setStatus(s);
//					setList.add(ent);
//				}
//			}
//		}
//		if(setList.size()>0){
//			this.imgs = setList;
//		}else{
//			this.imgs = imgs;
//		}
//	}

	@Column(name="pic_src")
	public String getPicSrc() {
		return picSrc;
	}

	public void setPicSrc(String picSrc) {
		this.picSrc = picSrc;
	}

	@OneToOne(optional = false, cascade = CascadeType.REFRESH)
	@JoinColumn(name = "menu_id", referencedColumnName = "id")
	public MenuEN getTSFunction() {
		return TSFunction;
	}

	public void setTSFunction(MenuEN tSFunction) {
		TSFunction = tSFunction;
	}
	
	public ZkContentInfoEN() {
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatTime() {
		return this.creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	@Column(name="long_title")
	public String getLongTitle() {
		return this.longTitle;
	}

	public void setLongTitle(String longTitle) {
		this.longTitle = longTitle;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Short getContOrder() {
		return contOrder;
	}

	public void setContOrder(Short contOrder) {
		this.contOrder = contOrder;
	}

	public Short getNewsLevel() {
		return newsLevel;
	}

	public void setNewsLevel(Short newsLevel) {
		this.newsLevel = newsLevel;
	}

	public String getNewsfrom() {
		return newsfrom;
	}

	public void setNewsfrom(String newsfrom) {
		this.newsfrom = newsfrom;
	}

	public String getPublicTime() {
		return publicTime;
	}

	public void setPublicTime(String publicTime) {
		this.publicTime = publicTime;
	}

//	@Temporal(TemporalType.TIMESTAMP)
//	public Date getPublicTime() {
//		return publicTime;
//	}
//
//	public void setPublicTime(Date publicTime) {
//		this.publicTime = publicTime;
//	}
	
	
	
}