/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.bitpayproperties;

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

    void setToken(final String token) {
        this.token = token;
    }

    public String getNotificationEmail() {
        return this.notificationEmail;
    }

    void setNotificationEmail(final String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public String getCurrency() {
        return this.getDesign().getPosData().getFields().stream()
            .filter(field -> "price".equals(field.getType()))
            .findFirst()
            .map(Field::getCurrency)
            .orElse(null);
    }
}
