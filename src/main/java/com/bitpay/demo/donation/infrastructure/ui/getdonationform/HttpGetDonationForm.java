/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.donation.infrastructure.ui.getdonationform;

import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@ConditionalOnExpression("'${bitpay.design.mode:standard}'.equals('donation')")
@Controller
public class HttpGetDonationForm {

    private final BitPayProperties bitPayProperties;

    public HttpGetDonationForm(@NonNull final BitPayProperties bitPayProperties) {
        this.bitPayProperties = bitPayProperties;
    }

    @GetMapping("/")
    public String execute(@NonNull final Model model) {
        model.addAttribute("design", this.bitPayProperties.getDesign());

        return "donationForm";
    }
}
