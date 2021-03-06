package ca.blackperl.toursdb;
// Generated Mar 27, 2016 10:34:39 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.sql.Blob;

/**
 * Maps generated by hbm2java
 */
public class Maps implements java.io.Serializable {

	private int mapId;
	private String mapName;
	private String region;
	private BigDecimal area;
	private String photoFormat;
	private Blob picture;

	public Maps() {
	}

	public Maps(int mapId, String mapName, BigDecimal area, String photoFormat) {
		this.mapId = mapId;
		this.mapName = mapName;
		this.area = area;
		this.photoFormat = photoFormat;
	}

	public Maps(int mapId, String mapName, String region, BigDecimal area, String photoFormat, Blob picture) {
		this.mapId = mapId;
		this.mapName = mapName;
		this.region = region;
		this.area = area;
		this.photoFormat = photoFormat;
		this.picture = picture;
	}

	public int getMapId() {
		return this.mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public String getMapName() {
		return this.mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public BigDecimal getArea() {
		return this.area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public String getPhotoFormat() {
		return this.photoFormat;
	}

	public void setPhotoFormat(String photoFormat) {
		this.photoFormat = photoFormat;
	}

	public Blob getPicture() {
		return this.picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

}
