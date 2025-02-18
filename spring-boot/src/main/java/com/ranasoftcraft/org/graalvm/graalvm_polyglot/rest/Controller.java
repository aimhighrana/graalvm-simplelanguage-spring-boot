package com.ranasoftcraft.org.graalvm.graalvm_polyglot.rest;

import com.ranasoftcraft.org.graalvm.graalvm_polyglot.code.CustomCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeoutException;

@RestController @RequiredArgsConstructor
public class Controller {

    private final CustomCode customCode;

    @PostMapping("/execute-me")
    public ResponseEntity<?> executeMe(@RequestBody String code) throws IOException {
        try {
            customCode.executeMe(code);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Collections.singletonMap("status", "Executed"));
        } catch (TimeoutException e) {
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)
                    .body(Collections.singletonMap("error", "Script execution timed out after 2 seconds"));
        }
    }
}
