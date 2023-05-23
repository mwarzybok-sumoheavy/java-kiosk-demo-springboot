/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.shared.bitpayproperties;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Donation {
    private Collection<Double> denominations = new ArrayList<>();
    private boolean enableOther = true;
    private String footerText;
    private String buttonSelectedBgColor;
    private String buttonSelectedTextColor;

    public Collection<Double> getDenominations() {
        return this.denominations;
    }

    public void setDenominations(final Collection<Double> denominations) {
        this.denominations = denominations;
    }

    public boolean isEnableOther() {
        return this.enableOther;
    }

    public void setEnableOther(final boolean enableOther) {
        this.enableOther = enableOther;
    }

    public String getFooterText() {
        return this.footerText;
    }

    public void setFooterText(final String footerText) {
        this.footerText = footerText;
    }

    public String getButtonSelectedBgColor() {
        return this.buttonSelectedBgColor;
    }

    public void setButtonSelectedBgColor(final String buttonSelectedBgColor) {
        this.buttonSelectedBgColor = buttonSelectedBgColor;
    }

    public String getButtonSelectedTextColor() {
        return this.buttonSelectedTextColor;
    }

    public void setButtonSelectedTextColor(final String buttonSelectedTextColor) {
        this.buttonSelectedTextColor = buttonSelectedTextColor;
    }

    public double getMaxPrice() {
        return Collections.max(this.denominations);
    }
}
