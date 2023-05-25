/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.donation.application.features.tasks.createdonation;

import com.bitpay.demo.UnitTest;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import com.bitpay.demo.shared.form.MissingRequiredField;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetValidatedDonationParamsTest implements UnitTest {

    @Test
    void shouldReturnOnlyValidatedParams() {
        // given
        final var params = new HashMap<String, Object>();
        params.put("buyerName", "fake name");
        params.put("buyerAddress1", "fake address");
        params.put("buyerAddress2", "fake address 2");
        params.put("buyerLocality", "fake location");
        params.put("buyerRegion", "AK");
        params.put("buyerPostalCode", "10010");
        params.put("buyerPhone", "123456789");
        params.put("buyerEmail", "test@example.com");
        params.put("store", "store-1");
        params.put("register", "2");
        params.put("reg_transaction_no", "test");
        params.put("price", "100");
        params.put("fake", "123");

        // when
        final var result = getTestedClass().execute(params);

        // then
        Assertions.assertEquals(12, result.size());
        Assertions.assertTrue(result.containsKey("store"));
        Assertions.assertTrue(result.containsKey("register"));
        Assertions.assertTrue(result.containsKey("reg_transaction_no"));
        Assertions.assertTrue(result.containsKey("buyerName"));
        Assertions.assertTrue(result.containsKey("buyerAddress1"));
        Assertions.assertTrue(result.containsKey("buyerAddress2"));
        Assertions.assertTrue(result.containsKey("buyerLocality"));
        Assertions.assertTrue(result.containsKey("buyerRegion"));
        Assertions.assertTrue(result.containsKey("buyerPostalCode"));
        Assertions.assertTrue(result.containsKey("buyerPhone"));
        Assertions.assertTrue(result.containsKey("buyerEmail"));
    }

    @Test
    void shouldThrowMissingRequiredFieldError() {
        // given
        final var params = new HashMap<String, Object>();
        params.put("buyerName", "fake name");
        params.put("buyerAddress1", "fake address");
        params.put("buyerAddress2", "fake address 2");
        params.put("buyerLocality", "fake location");
        params.put("buyerRegion", "AK");
        params.put("buyerPostalCode", "10010");
        params.put("buyerPhone", "123456789");
        params.put("buyerEmail", "test@example.com");
        params.put("store", "store-1");
        params.put("register", "2");
        params.put("reg_transaction_no", "test");
        params.put("fake", "123");

        // when
        Assertions.assertThrows(
            MissingRequiredField.class,
            () -> getTestedClass().execute(params)
        );

        // then
        // throw MissingRequiredField;
    }

    @Test
    void shouldThrowMissingRequiredPosFieldError() {
        // given
        final var params = new HashMap<String, Object>();
        params.put("buyerName", "fake name");
        params.put("buyerAddress1", "fake address");
        params.put("buyerAddress2", "fake address 2");
        params.put("buyerLocality", "fake location");
        params.put("buyerRegion", "AK");
        params.put("buyerPostalCode", "10010");
        params.put("buyerPhone", "123456789");
        params.put("buyerEmail", "test@example.com");
        params.put("store", "store-1");
        params.put("reg_transaction_no", "test");
        params.put("price", "100");
        params.put("fake", "123");

        // when
        Assertions.assertThrows(
            MissingRequiredField.class,
            () -> getTestedClass().execute(params)
        );

        // then
        // throw MissingRequiredField;
    }

    private GetValidatedDonationParams getTestedClass() {
        var bitPayPropertiesJson = getDataFromFile("bitPayProperties.json");
        var bitPayProperties = toObject(bitPayPropertiesJson, BitPayProperties.class);

        return new GetValidatedDonationParams(bitPayProperties);
    }
}
