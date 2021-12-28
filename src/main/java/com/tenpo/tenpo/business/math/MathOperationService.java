package com.tenpo.tenpo.business.math;

import com.tenpo.tenpo.api.math.MathOperationRs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class MathOperationService implements ISumOperation{


    /*
    Simple method to avoid unnecessary complex business logic like Strategy pattern on Operation Type Selection
     */
    @Override
    public MathOperationRs sum(BigDecimal x, BigDecimal y) {
        return new MathOperationRs(x.add(y));
    }
}
