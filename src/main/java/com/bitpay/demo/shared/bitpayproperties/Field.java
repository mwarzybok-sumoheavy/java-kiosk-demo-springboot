/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.bitpayproperties;

import java.util.ArrayList;
import java.util.Collection;

public class Field {
    private String type;
    private Boolean required = false;
    private String id;
    private String name;
    private String label;
    private Collection<Option> options = new ArrayList<>();
    private String currency = "USD";

    public static Field createPriceField() {
        final var field = new Field();
        field.type = "price";
        field.required = true;
        field.id = "price";
        field.name = "price";

        return field;
    }

    public String getType() {
        return this.type;
    }

    void setType(final String type) {
        this.type = type;
    }

    public Boolean isRequired() {
        return this.required;
    }

    void setRequired(final Boolean required) {
        this.required = required;
    }

    public String getId() {
        return this.id;
    }

    void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    void setName(final String name) {
        this.name = name;
    }

    public String getLabel() {
        return this.label;
    }

    void setLabel(final String label) {
        this.label = label;
    }

    public Collection<Option> getOptions() {
        return this.options;
    }

    void setOptions(final Collection<Option> options) {
        this.options = options;
    }

    public String getCurrency() {
        return this.currency;
    }

    void setCurrency(final String currency) {
        this.currency = currency;
    }
}
