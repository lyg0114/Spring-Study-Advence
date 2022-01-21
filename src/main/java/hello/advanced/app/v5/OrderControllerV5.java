package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate templage;


    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.templage = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId){
       return templage.excute("OrderController.request()", new TraceCallback<String>() {

            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }

        });

    }


}
