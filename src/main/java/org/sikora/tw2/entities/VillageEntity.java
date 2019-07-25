package org.sikora.tw2.entities;

import javax.persistence.*;

@Entity
@Table(name="village")
public class VillageEntity {

	public VillageEntity() {
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "coord_id")
	private CoordEntity coord;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	private int headquarters;
	private int timber;
	private int clay;
	private int iron;
	private int farm;
	private int warehouse;
	private int church;
	private int rallypoint;
	private int barracks;
	private int statue;
	private int wall;
	private int hospital;
	private int market;
	private int tavern;
	private int academy;
	private int halloforders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CoordEntity getCoord() {
		return coord;
	}

	public void setCoord(CoordEntity coord) {
		this.coord = coord;
	}

	public int getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(int headquarters) {
		this.headquarters = headquarters;
	}

	public int getTimber() {
		return timber;
	}

	public void setTimber(int timber) {
		this.timber = timber;
	}

	public int getClay() {
		return clay;
	}

	public void setClay(int clay) {
		this.clay = clay;
	}

	public int getIron() {
		return iron;
	}

	public void setIron(int iron) {
		this.iron = iron;
	}

	public int getFarm() {
		return farm;
	}

	public void setFarm(int farm) {
		this.farm = farm;
	}

	public int getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(int warehouse) {
		this.warehouse = warehouse;
	}

	public int getChurch() {
		return church;
	}

	public void setChurch(int church) {
		this.church = church;
	}

	public int getRallypoint() {
		return rallypoint;
	}

	public void setRallypoint(int rallypoint) {
		this.rallypoint = rallypoint;
	}

	public int getBarracks() {
		return barracks;
	}

	public void setBarracks(int barracks) {
		this.barracks = barracks;
	}

	public int getStatue() {
		return statue;
	}

	public void setStatue(int statue) {
		this.statue = statue;
	}

	public int getWall() {
		return wall;
	}

	public void setWall(int wall) {
		this.wall = wall;
	}

	public int getHospital() {
		return hospital;
	}

	public void setHospital(int hospital) {
		this.hospital = hospital;
	}

	public int getMarket() {
		return market;
	}

	public void setMarket(int market) {
		this.market = market;
	}

	public int getTavern() {
		return tavern;
	}

	public void setTavern(int tavern) {
		this.tavern = tavern;
	}

	public int getAcademy() {
		return academy;
	}

	public void setAcademy(int academy) {
		this.academy = academy;
	}

	public int getHalloforders() {
		return halloforders;
	}

	public void setHalloforders(int halloforders) {
		this.halloforders = halloforders;
	}
}
