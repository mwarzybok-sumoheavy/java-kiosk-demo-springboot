/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.bitpayproperties;

public class Design {
    private Hero hero = new Hero();
    private String logo;
    private PosData posData = new PosData();

    public Hero getHero() {
        return this.hero;
    }

    void setHero(final Hero hero) {
        this.hero = hero;
    }

    public String getLogo() {
        return this.logo;
    }

    void setLogo(final String logo) {
        this.logo = logo;
    }

    public PosData getPosData() {
        return this.posData;
    }

    void setPosData(final PosData posData) {
        this.posData = posData;
    }
}
