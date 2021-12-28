package com.tenpo.tenpo.business.math;

import com.tenpo.tenpo.api.math.MathOperationRs;

import java.math.BigDecimal;

@FunctionalInterface
public interface ISumOperation {

    MathOperationRs sum(BigDecimal x, BigDecimal y);

}
