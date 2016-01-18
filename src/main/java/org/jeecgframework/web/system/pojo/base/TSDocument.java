package org.jeecgframework.web.system.pojo.base;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

/**
 * 文档下载,新闻,法规表
 * @author  张代浩
 */
@Entity
@Table(name = "t_s_document")
@PrimaryKeyJoinColumn(name = "id")
public class TSDocument extends TSAttachment implements java.io.Serializable {
	private String documentTitle;//文档标题
	private byte[] pictureIndex;//焦点图导航
	private Short documentState;//状态：0未发布，1已发布
	private Short showHome;//是否首页显示
	private TSType TSType;//文档分类
	
	//类别 1.pdf文件 2.图片 3.视频
	@Column(name = "category")
	private Short category;//
	
	@Column(name = "conId")
	private String conId;//对应菜单id
	@Column(name = "conName")
	private String conName;//对应菜单name
	
	private String year;//PDF文件-年份
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeid")
	public TSType getTSType() {
		return TSType;
	}
	
	public Short getCategory() {
		return category;
	}


	public void setCategory(Short category) {
		this.category = category;
	}


	public void setTSType(TSType tSType) {
		TSType = tSType;
	}
	@Column(name = "documenttitle", length = 100)
	public String getDocumentTitle() {
		return documentTitle;
	}
	public void setDocumentTitle(String documentTitle) {
		this.documentTitle = documentTitle;
	}
	@Column(name = "pictureindex",length=3000)
	public byte[] getPictureIndex() {
		return pictureIndex;
	}
	public void setPictureIndex(byte[] pictureIndex) {
		this.pictureIndex = pictureIndex;
	}
	@Column(name = "documentstate")
	public Short getDocumentState() {
		return documentState;
	}
	public void setDocumentState(Short documentState) {
		this.documentState = documentState;
	}
	@Column(name = "showhome")
	public Short getShowHome() {
		return showHome;
	}
	public void setShowHome(Short showHome) {
		this.showHome = showHome;
	}
}