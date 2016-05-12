/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelapimodel.auto.annotation.validators;

/*
 * #%L
 * HotelAPI Model
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


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.hotelbeds.hotelapimodel.auto.model.Stay;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidStayValidator implements ConstraintValidator<ValidStay, Stay> {
    private long maxDaysRange;

    @Override
    public void initialize(final ValidStay constraintAnnotation) {
        maxDaysRange = constraintAnnotation.maxDaysRange();
    }

    @Override
    public boolean isValid(final Stay stay, final ConstraintValidatorContext context) {
        boolean result = true;
        if (stay != null && stay.getCheckIn() != null && stay.getCheckOut() != null) {
            context.disableDefaultConstraintViolation();
            if (stay.getCheckIn().isBefore(LocalDate.now().minusDays(2))) {
                context.buildConstraintViolationWithTemplate("{com.hotelbeds.Stay.dates.checkin.future.message}").addConstraintViolation();
                result = false;
                if (log.isDebugEnabled()) {
                    log.debug("property must be in the future " + stay.getCheckIn());
                }
            } else if (stay.getCheckIn().isEqual(stay.getCheckOut()) || stay.getCheckIn().isAfter(stay.getCheckOut())) {
                context.buildConstraintViolationWithTemplate("{com.hotelbeds.Stay.dates.before.message}").addConstraintViolation();
                result = false;
                if (log.isDebugEnabled()) {
                    log.debug("CheckIn must be prior to checkOut date, checkin: " + stay.getCheckIn() + " , checkout: " + stay.getCheckOut());
                }
            } else if (!isValidDateRange(stay.getCheckIn(), stay.getCheckOut())) {
                context.buildConstraintViolationWithTemplate("{com.hotelbeds.Stay.dates.range.message}").addConstraintViolation();
                result = false;
                if (log.isDebugEnabled()) {
                    log.debug("The number of nights must be less than or equal to " + maxDaysRange + ", checkin: " + stay.getCheckIn()
                        + " , checkout: " + stay.getCheckOut());
                }
            }
        }
        return result;
    }

    private boolean isValidDateRange(LocalDate checkIn, LocalDate checkOut) {
        final long days = ChronoUnit.DAYS.between(checkIn, checkOut);
        boolean result = true;
        if (Long.valueOf(days).compareTo(maxDaysRange) > 0) {
            result = false;
        }
        return result;
    }
}
