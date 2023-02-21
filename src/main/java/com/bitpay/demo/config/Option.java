/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.config;

class Option {
    private String id;
    private String label;
    private String value;

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
