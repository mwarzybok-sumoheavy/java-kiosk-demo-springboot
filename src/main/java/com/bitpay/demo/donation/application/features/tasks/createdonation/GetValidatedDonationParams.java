/*
 * Copyright 2023 BitPay.
 * All rights reserved.
 */

package com.bitpay.demo.donation.application.features.tasks.createdonation;

import com.bitpay.demo.DependencyInjection;
import com.bitpay.demo.shared.bitpayproperties.BitPayProperties;
import com.bitpay.demo.shared.bitpayproperties.Field;
import com.bitpay.demo.shared.form.EmailValidator;
import com.bitpay.demo.shared.form.GetValidatedParams;
import com.bitpay.demo.shared.form.GetValidatedPosParams;
import com.bitpay.demo.shared.form.MissingRequiredField;
import com.bitpay.demo.shared.form.Validator;
import com.bitpay.demo.shared.form.WrongFieldValue;
import com.bitpay.demo.shared.form.ZipCodeValidator;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;

@DependencyInjection
@ConditionalOnExpression("'${bitpay.design.mode:standard}'.equals('donation')")
class GetValidatedDonationParams implements GetValidatedParams {

    private final Collection<String> allowedRegions = List.of(
        "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
        "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC",
        "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"
    );

    private final double maxPrice;
    private final BitPayProperties bitPayProperties;
    private final GetValidatedPosParams getValidatedPosParams;
    private final EmailValidator emailValidator = new EmailValidator();
    private final ZipCodeValidator zipCodeValidator = new ZipCodeValidator();

    GetValidatedDonationParams(@NonNull final BitPayProperties bitPayProperties) {
        this.bitPayProperties = bitPayProperties;
        this.maxPrice = bitPayProperties.getMaxPrice();
        this.getValidatedPosParams = new GetValidatedPosParams(bitPayProperties);
    }

    @NonNull
    @Override
    public Map<String, Object> execute(
        @NonNull final Map<String, Object> requestParameters
    ) throws MissingRequiredField {
        final var validatedParams = new HashMap<String, Object>();
        addValidatedText(requestParameters, "buyerName", validatedParams, null);
        addValidatedText(requestParameters, "buyerAddress1", validatedParams, null);
        addValidatedText(requestParameters, "buyerLocality", validatedParams, null);
        addValidatedText(requestParameters, "buyerPostalCode", validatedParams, this.zipCodeValidator);
        addValidatedText(requestParameters, "buyerPhone", validatedParams, null);
        addValidatedText(requestParameters, "buyerEmail", validatedParams, this.emailValidator);
        addValidatedSelect(requestParameters, "buyerRegion", validatedParams, this.allowedRegions);
        addValidatedPrice(requestParameters, validatedParams);

        final var address2 = requestParameters.getOrDefault("buyerAddress2", null);
        if (address2 != null) {
            validatedParams.put("buyerAddress2", address2);
        }

        final var validatedPosDataParams = this.getValidatedPosParams.execute(requestParameters);
        validatedParams.putAll(validatedPosDataParams);

        return validatedParams;
    }

    private void addValidatedPrice(
        final Map<String, Object> requestParameters,
        final HashMap<String, Object> validatedParams
    ) {
        final var value = requestParameters.getOrDefault("price", null);
        final var field = Field.createPriceField();

        if (Objects.isNull(value)) {
            throw new MissingRequiredField(field);
        }

        final Double price = Double.parseDouble(requestParameters.get("price").toString());

        if (isPriceInvalid(price)) {
            throw new WrongFieldValue(field, value);
        }

        validatedParams.put("price", value);
    }

    private boolean isPriceInvalid(final Double price) {
        final var donation = this.bitPayProperties.getDesign().getDonation();

        return price > this.maxPrice
            || (!donation.isEnableOther() && !donation.getDenominations().contains(price));
    }

    private void addValidatedSelect(
        final Map<String, Object> requestParameters,
        final String parameterName,
        final HashMap<String, Object> validatedParams,
        final Collection<String> allowedValues
    ) {
        final var value = requestParameters.getOrDefault(parameterName, null);
        final var field = new Field(
            "select",
            true,
            parameterName,
            parameterName
        );

        if (Objects.isNull(value)) {
            throw new MissingRequiredField(field);
        }

        if (!allowedValues.contains(value)) {
            throw new WrongFieldValue(field, value);
        }

        validatedParams.put(parameterName, value);
    }

    private void addValidatedText(
        final Map<String, Object> requestParameters,
        final String parameterName,
        final HashMap<String, Object> validatedParams,
        final Validator validator
    ) {
        final var value = requestParameters.getOrDefault(parameterName, null);
        final var field = new Field(
            "text",
            true,
            parameterName,
            parameterName
        );

        if (Objects.isNull(value)) {
            throw new MissingRequiredField(field);
        }

        if (Objects.nonNull(validator) && !validator.execute(value.toString())) {
            throw new WrongFieldValue(field, value);
        }

        validatedParams.put(parameterName, value);
    }
}
