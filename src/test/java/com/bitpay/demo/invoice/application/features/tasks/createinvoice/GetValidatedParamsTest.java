/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.invoice.application.features.tasks.createinvoice;

import com.bitpay.demo.UnitTest;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import com.bitpay.demo.shared.bitpayproperties.Field;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GetValidatedParamsTest implements UnitTest, GetBitPayInvoice {

    private final BitPayProperties bitPayProperties = new BitPayProperties();

    @Test
    void shouldReturnOnlyValidatedParams() {
        // given
        this.bitPayProperties.getDesign().getPosData().getFields()
            .add(Field.createPriceField());

        // when
        final var result = getTestedClass().execute(Map.of(
            "store", "store-1",
            "register", "2",
            "reg_transaction_no", "test",
            "price", 123
        ));

        // then
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.containsKey("price"));
    }

    @Test
    void shouldThrowMissingRequiredFieldError() {
        // given
        this.bitPayProperties.getDesign().getPosData().getFields()
            .add(Field.createPriceField());

        // when
        Assertions.assertThrows(
            MissingRequiredField.class,
            () -> getTestedClass().execute(Map.of(
                "store", "store-1",
                "register", "2",
                "reg_transaction_no", "test"
            ))
        );

        // then
        // throw MissingRequiredField;
    }

    private GetValidatedParams getTestedClass() {
        return new GetValidatedParams(this.bitPayProperties);
    }
}
