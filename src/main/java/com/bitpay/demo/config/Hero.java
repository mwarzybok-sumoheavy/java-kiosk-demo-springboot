/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.config;

class Hero {
    private String bgColor;
    private String title;
    private String body;

    public String getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(final String bgColor) {
        this.bgColor = bgColor;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(final String body) {
        this.body = body;
    }
}
