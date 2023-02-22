/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.bitpayproperties;

class Hero {
    private String bgColor;
    private String title;
    private String body;

    public String getBgColor() {
        return this.bgColor;
    }

    void setBgColor(final String bgColor) {
        this.bgColor = bgColor;
    }

    public String getTitle() {
        return this.title;
    }

    void setTitle(final String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    void setBody(final String body) {
        this.body = body;
    }
}
