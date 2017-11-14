package com.training.navigasyon.model;

public enum EYolTipi {
	ASFALT(1.0D), TOPRAK(1.3D);

	private double katsayi;

	private EYolTipi(final double katsayi) {
		this.katsayi = katsayi;

	}

	public double getKatsayi() {
		return this.katsayi;
	}
}
