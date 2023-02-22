/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.config;

import java.util.ArrayList;
import java.util.Collection;

public class Field {
    private String type;
    private Boolean required = false;
    private String id;
    private String name;
    private String label;
    private Collection<Option> options = new ArrayList<>();
    private String currency;

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Boolean isRequired() {
        return this.required;
    }

    public void setRequired(final Boolean required) {
        this.required = required;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }

    public Collection<Option> getOptions() {
        return this.options;
    }

    public void setOptions(final Collection<Option> options) {
        this.options = options;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(final String currency) {
        this.currency = currency;
    }
}
