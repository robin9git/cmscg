package org.jeecgframework.web.zkyen.pojo.base;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the zk_channel_content database table.
 * 
 */
@Entity
@Table(name="zk_en_channel_content")
@Cacheable  
//@NamedQuery(name="ZkChannelContent.findAll", query="SELECT z FROM ZkChannelContent z")
public class ZkChannelContentEN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="channel_id")
	private int channelId;

	@Column(name="content_id")
	private int contentId;

	public ZkChannelContentEN() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChannelId() {
		return this.channelId;
	}

	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}

	public int getContentId() {
		return this.contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

}