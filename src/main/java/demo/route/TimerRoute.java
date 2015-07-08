package demo.route;

import java.time.LocalDate;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        // from("timer:test?period=1s")
        from("quartz2://myGroup/myTimerName?cron=*+*+10-18+?+*+MON-FRI").process(printDate);
    }

    private Processor printDate = new Processor() {

        @Override
        public void process(Exchange exchange) throws Exception {
            System.out.println("+++ " + LocalDate.now().parse("HH:mm:ss"));
        }

    };

}