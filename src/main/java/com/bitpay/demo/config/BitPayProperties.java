/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.config;

public class BitPayProperties {

    private Design design = new Design();
    private String token;
    private String notificationEmail;

    public Design getDesign() {
        return this.design;
    }

    public void setDesign(final Design design) {
        this.design = design;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public String getNotificationEmail() {
        return this.notificationEmail;
    }

    public void setNotificationEmail(final String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }
}
