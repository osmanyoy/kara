package com.training.navigasyon.model;

public class Yol {
	private int mesafe;
	private EYolTipi yolTipi;
	private Integer aci;

	public Yol() {
	}

	public Yol(final int mesafe, final EYolTipi yolTipi, final Integer aci) {
		super();
		this.mesafe = mesafe;
		this.yolTipi = yolTipi;
		this.aci = aci;
	}

	public int getMesafe() {
		return this.mesafe;
	}

	public void setMesafe(final int mesafe) {
		this.mesafe = mesafe;
	}

	public EYolTipi getYolTipi() {
		return this.yolTipi;
	}

	public void setYolTipi(final EYolTipi yolTipi) {
		this.yolTipi = yolTipi;
	}

	public Integer getAci() {
		return this.aci;
	}

	public void setAci(final Integer aci) {
		this.aci = aci;
	}

	@Override
	public String toString() {
		return "Yol [mesafe=" + this.mesafe + ", yolTipi=" + this.yolTipi + ", aci=" + this.aci + "]";
	}

}
