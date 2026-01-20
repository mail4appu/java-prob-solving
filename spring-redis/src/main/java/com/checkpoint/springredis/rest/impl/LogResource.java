package com.checkpoint.springredis.rest.impl;

import com.checkpoint.springredis.util.LoglevelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logs")
//@ApiIgnore
public class LogResource {
    Logger logger= LoggerFactory.getLogger(LogResource.class);

    @RequestMapping(value="/level/{logLevel}", method = RequestMethod.POST)
    public String updateLogLevel(@PathVariable("logLevel") String logLevel){
        logger.info("Switch log level called with level {}", logLevel);
        if (LoglevelUtil.switchLog(logLevel)) {
            return HttpStatus.OK.toString();
        } else {
            return HttpStatus.BAD_REQUEST.toString();
        }
    }

    @RequestMapping(value="/level", method = RequestMethod.GET)
    public String getCurrentLoglevel(){
        return LoglevelUtil.getCurrentLogLevel(logger);
    }
}
