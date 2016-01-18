package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the zk_channel_info database table.
 * 
 */
@Entity
@Cacheable  
@Table(name="zk_en_channel_info")
//@NamedQuery(name="ZkChannelInfo.findAll", query="SELECT z FROM ZkChannelInfo z")
public class ZkChannelInfoEN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

//	private int 父编号;

	@Column(name="best_img_path")
	private String bestImgPath;

	@Column(name="channel_name")
	private String channelName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Column(name="is_best")
	private String isBest;

	@Column(name="seq_no")
	private int seqNo;

	private String status;

	public ZkChannelInfoEN() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int get父编号() {
//		return this.父编号;
//	}
//
//	public void set父编号(int 父编号) {
//		this.父编号 = 父编号;
//	}

	public String getBestImgPath() {
		return this.bestImgPath;
	}

	public void setBestImgPath(String bestImgPath) {
		this.bestImgPath = bestImgPath;
	}

	public String getChannelName() {
		return this.channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIsBest() {
		return this.isBest;
	}

	public void setIsBest(String isBest) {
		this.isBest = isBest;
	}

	public int getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}