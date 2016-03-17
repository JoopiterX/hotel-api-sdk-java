/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelcontentapi.auto.messages;

/*
 * #%L
 * Hotel Content Model
 * %%
 * Copyright (C) 2015 - 2016 HOTELBEDS TECHNOLOGY, S.L.U.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(Include.NON_NULL)
@ToString
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class HotelsRQ extends AbstractGenericContentRequest {

    private String destinationCode;
    private String countryCode;
    private List<String> chainCodes;
    private List<String> accommodationTypeCodes;
    private List<String> boardCodes;
    private List<String> segmentCodes;
    private List<String> languageDescriptions;
    @Min(value = 0)
    @Digits(fraction = 1, integer = 1)
    private BigDecimal minTripadvisorRate;
    @Min(value = 0)
    @Digits(fraction = 1, integer = 1)
    private BigDecimal maxTripadvisorRate;
    private Integer minTripadvisorReviewCount;
    private List<String> accomodationTypes;
    private List<String> categoryCodes;
    private List<String> categoryGroupCodes;
    @Min(value = 1)
    private Integer minImages;
    private Boolean allIncluded;


}
