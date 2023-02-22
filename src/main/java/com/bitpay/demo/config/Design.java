/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.config;

public class Design {
    private Hero hero = new Hero();
    private String logo;
    private PosData posData = new PosData();

    public Hero getHero() {
        return this.hero;
    }

    public void setHero(final Hero hero) {
        this.hero = hero;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(final String logo) {
        this.logo = logo;
    }

    public PosData getPosData() {
        return this.posData;
    }

    public void setPosData(final PosData posData) {
        this.posData = posData;
    }
}
