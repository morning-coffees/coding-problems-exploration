package com.clgarillo.demojunit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
class HealthcheckController {
	List<String> validHealthCheck = List.of("short", "full");

    @GetMapping(value = "/healthcheck")
    public ResponseEntity<Object> healthcheck(@RequestParam(value = "format") String format) throws JsonProcessingException {
    	if (!isValidFormat(format)) {
        	String errorMessage = "Invalid format query parameter value: " + format;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse(errorMessage));
            }
        
        if (format.equals("short")) {
            return ResponseEntity.status(HttpStatus.OK).body(new HealthCheckResponse("ok"));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(new HealthCheckResponse("ok", LocalDateTime.now()));
        }
    }

    @PutMapping(value = "/healthcheck")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void healthcheckPut() {
        return;
    }

    @PostMapping(value = "/healthcheck")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void healthcheckPost() {
        return;
    }


    @DeleteMapping(value = "/healthcheck")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public void healthcheckDelete() {
        return;
    }

    
    private boolean isValidFormat(String format) {
        return validHealthCheck.contains(format);
    }
    
}


@JsonInclude(Include.NON_NULL)
class HealthCheckResponse {
    private String status;
    
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonProperty("currentTime")
    private LocalDateTime currentTime;
    
    public HealthCheckResponse(String status) {
        this.status = status;
    }
    
    public HealthCheckResponse(String status, LocalDateTime currentTime) {
        this.status = status;
        this.currentTime = currentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }
    
    
}

class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

