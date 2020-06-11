package deploy.logback.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class LogBackApiController {
    private static final Logger log = LoggerFactory.getLogger("console");
    private static final Logger fileLogger = LoggerFactory.getLogger("file");


    @GetMapping("/level")
    public String index() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message : {}", LocalDateTime.now());
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        return "로그 레벨 확인 페이지입니다.";
    }

    @GetMapping("/file")
    public String logbackTest() {
        log.info("콘솔 로깅 입니다.");
        fileLogger.info("파일 로깅 입니다.");
        return "로깅 파일을 확인해주세요.";
    }
}
