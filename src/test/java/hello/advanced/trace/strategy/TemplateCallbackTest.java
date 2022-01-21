package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {


    @Test
    void callbackV1(){

        TimeLogTemplate template = new TimeLogTemplate();
        template.excute(()-> log.info("비즈니스 로직1 실행"));
        template.excute(()-> log.info("비즈니스 로직2 실행"));

    }

}
