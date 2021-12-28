package com.tenpo.tenpo.business.record;

import com.tenpo.tenpo.business.model.Record;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackerAspect {

    private IRecordService recorderService;

    @AfterReturning(value = "@annotation(trackingRequest)")
    public void recordRequest(JoinPoint joinPoint, RqTracker trackingRequest) {
        this.recordRequest(trackingRequest, "OK");
    }

    @AfterThrowing(value = "@annotation(RqTracker)")
    public void recordFailedRequest(JoinPoint joinPoint, TrackingRequest trackingRequest) {
        this.recordRequest(trackingRequest, FAILURE);
    }

    private void recordRequest(TrackingRequest trackingRequest, RequestStatus requestStatus) {
        Record trackingRecorder = new Record();
        trackingRecorder.setRequestType(trackingRequest.requestType());
        trackingRecorder.setEmail(getUsername());
        trackingRecorder.setRequestStatus(requestStatus);
        recorderService.recordTracking(trackingRecorder);
    }

}
