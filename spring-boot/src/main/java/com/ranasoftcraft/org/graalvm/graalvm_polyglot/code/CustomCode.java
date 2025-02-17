package com.ranasoftcraft.org.graalvm.graalvm_polyglot.code;

import lombok.extern.slf4j.Slf4j;
import org.graalvm.polyglot.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration @Slf4j
public class CustomCode {

    @Value("classpath:code/ExecuteMe.sl")
    private Resource code;

    private List<String> capturedLogs = new ArrayList<>();
    
    @PostConstruct
    public void runCode() throws IOException {
        log.info("Trying to execute custom code");
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        
        try (Context context = Context.newBuilder()
                .allowPolyglotAccess(PolyglotAccess.ALL)
                .allowHostClassLookup(cls -> true)
                .allowHostAccess(HostAccess.ALL)
                .allowHostClassLoading(true)
                .out(printStream)  // Redirect stdout to our custom stream
                .build()) {

            String actualCode = asString(code);

            Source source = Source
                    .newBuilder("sl", actualCode, "source.sl")
                    .interactive(Boolean.TRUE)
                    .build();

            org.graalvm.polyglot.Value value = context.eval(source);
            
            // Capture and log all println output
            String output = outputStream.toString(StandardCharsets.UTF_8);
            String[] lines = output.split("\n");
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    log.info("SimpleLanguage output: {}", line.trim());
                    capturedLogs.add(line.trim());
                }
            }
        }

        log.info("After completion of custom code execution");
    }

    public List<String> getCapturedLogs() {
        return new ArrayList<>(capturedLogs);
    }


    public boolean executeMe(String jsCode) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        
        try (Context context = Context.newBuilder()
                .allowPolyglotAccess(PolyglotAccess.ALL)
                .allowHostClassLookup(cls -> true)
                .allowHostAccess(HostAccess.ALL)
                .allowHostClassLoading(true)
                .out(printStream)  // Redirect stdout to our custom stream
                .build()) {

            Source source = Source
                    .newBuilder("sl", jsCode, "source.sl")
                    .interactive(Boolean.TRUE)
                    .build();

            context.eval(source);
            
            // Capture and log all println output
            String output = outputStream.toString(StandardCharsets.UTF_8);
            String[] lines = output.split("\n");
            for (String line : lines) {
                if (!line.trim().isEmpty()) {
                    log.info("SimpleLanguage output: {}", line.trim());
                    capturedLogs.add(line.trim());
                }
            }
            
            return Boolean.TRUE;
        }
    }

    public String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
