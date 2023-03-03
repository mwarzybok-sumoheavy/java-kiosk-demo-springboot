/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.domain.buyer;

import lombok.NonNull;

public class InvoiceBuyer {

    private Long id;
    private BuyerName name;
    private BuyerAddress address1;
    private BuyerAddress address2;
    private BuyerLocality locality;
    private BuyerRegion region;
    private BuyerPostalCode postalCode;
    private BuyerCountry country;
    private BuyerEmailAddress email;
    private BuyerPhoneNumber phone;
    private BuyerNotify notify;
    private BuyerProvidedEmail buyerProvidedEmail;

    public InvoiceBuyer(
        @NonNull final BuyerName name,
        @NonNull final BuyerAddress address1,
        @NonNull final BuyerAddress address2,
        @NonNull final BuyerLocality locality,
        @NonNull final BuyerRegion region,
        @NonNull final BuyerPostalCode postalCode,
        @NonNull final BuyerCountry country,
        @NonNull final BuyerEmailAddress email,
        @NonNull final BuyerPhoneNumber phone,
        @NonNull final BuyerNotify notify,
        @NonNull final BuyerProvidedEmail buyerProvidedEmail
    ) {
        this.name = name;
        this.address1 = address1;
        this.address2 = address2;
        this.locality = locality;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.notify = notify;
        this.buyerProvidedEmail = buyerProvidedEmail;
    }

    public InvoiceBuyer(@NonNull BuyerProvidedEmail buyerProvidedEmail) {
        this.buyerProvidedEmail = buyerProvidedEmail;
    }

    InvoiceBuyer() {
    }
}
