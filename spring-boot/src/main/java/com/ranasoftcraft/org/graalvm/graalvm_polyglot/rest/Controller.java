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

@RestController @RequiredArgsConstructor
public class Controller {

    private final CustomCode customCode;

    @PostMapping("/execute-me")
    public ResponseEntity<?> executeMe(@RequestBody String code) throws IOException {
        customCode.executeMe(code);
        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("status","Executed"));
    }
}
