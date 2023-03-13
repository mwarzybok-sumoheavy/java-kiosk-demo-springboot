/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.buyer;

import javax.annotation.Nullable;
import lombok.NonNull;

public class InvoiceBuyer {

    private Long id;
    private BuyerName name;
    private BuyerAddress address1;
    private BuyerAddress address2;
    private BuyerCity city;
    private BuyerRegion region;
    private BuyerPostalCode postalCode;
    private BuyerCountry country;
    private BuyerEmailAddress email;
    private BuyerPhoneNumber phone;
    private BuyerNotify notify;
    private BuyerProvidedEmail buyerProvidedEmail;
    private InvoiceBuyerProvidedInfo invoiceBuyerProvidedInfo;

    public InvoiceBuyer(
        @NonNull final InvoiceBuyerProvidedInfo invoiceBuyerProvidedInfo,
        @Nullable final BuyerName name,
        @Nullable final BuyerAddress address1,
        @Nullable final BuyerAddress address2,
        @Nullable final BuyerCity city,
        @Nullable final BuyerRegion region,
        @Nullable final BuyerPostalCode postalCode,
        @Nullable final BuyerCountry country,
        @Nullable final BuyerEmailAddress email,
        @Nullable final BuyerPhoneNumber phone,
        @Nullable final BuyerNotify notify,
        @Nullable final BuyerProvidedEmail buyerProvidedEmail
    ) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.notify = notify;
        this.buyerProvidedEmail = buyerProvidedEmail;
        this.invoiceBuyerProvidedInfo = invoiceBuyerProvidedInfo;
    }

    public InvoiceBuyer(
        @NonNull final BuyerProvidedEmail buyerProvidedEmail,
        @NonNull final InvoiceBuyerProvidedInfo invoiceBuyerProvidedInfo
    ) {
        this.buyerProvidedEmail = buyerProvidedEmail;
        this.invoiceBuyerProvidedInfo = invoiceBuyerProvidedInfo;
    }

    InvoiceBuyer() {
    }

    public BuyerName getName() {
        return this.name;
    }

    public BuyerAddress getAddress1() {
        return this.address1;
    }

    public BuyerAddress getAddress2() {
        return this.address2;
    }

    public BuyerCity getCity() {
        return this.city;
    }

    public BuyerRegion getRegion() {
        return this.region;
    }

    public BuyerPostalCode getPostalCode() {
        return this.postalCode;
    }

    public BuyerCountry getCountry() {
        return this.country;
    }

    public BuyerEmailAddress getEmail() {
        return this.email;
    }

    public BuyerPhoneNumber getPhone() {
        return this.phone;
    }

    public BuyerNotify getNotify() {
        return this.notify;
    }

    public BuyerProvidedEmail getBuyerProvidedEmail() {
        return this.buyerProvidedEmail;
    }

    public InvoiceBuyerProvidedInfo getInvoiceBuyerProvidedInfo() {
        return this.invoiceBuyerProvidedInfo;
    }

    public void update(@NonNull final InvoiceBuyer invoiceBuyer) {
        this.name = invoiceBuyer.getName();
        this.address1 = invoiceBuyer.getAddress1();
        this.address2 = invoiceBuyer.getAddress2();
        this.city = invoiceBuyer.getCity();
        this.region = invoiceBuyer.getRegion();
        this.postalCode = invoiceBuyer.getPostalCode();
        this.country = invoiceBuyer.getCountry();
        this.email = invoiceBuyer.getEmail();
        this.phone = invoiceBuyer.getPhone();
        this.notify = invoiceBuyer.getNotify();
        this.buyerProvidedEmail = invoiceBuyer.getBuyerProvidedEmail();
    }
}
