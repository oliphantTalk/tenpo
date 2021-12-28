package com.tenpo.tenpo.controller;

import com.tenpo.tenpo.api.math.MathOperationRs;
import com.tenpo.tenpo.business.math.MathOperationService;
import com.tenpo.tenpo.business.record.RqTracker;
import com.tenpo.tenpo.business.record.RqType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@Slf4j
public class MathOperationController {

    private static final String X_PARAM = "x";
    private static final String Y_PARAM = "y";

    private final MathOperationService mathOperationService;

    public MathOperationController(MathOperationService mathOperationService) {
        this.mathOperationService = mathOperationService;
    }

    @GetMapping("/math/sum")
    @RqTracker(requestType = RqType.SUM)
    public ResponseEntity<MathOperationRs> doSum(
            @RequestParam(X_PARAM) BigDecimal x,
            @RequestParam(Y_PARAM) BigDecimal y)
    {
        log.info("Performing sum of X={} and Y={}", x, y);
        return ResponseEntity.ok(mathOperationService.sum(x, y));
    }


}
