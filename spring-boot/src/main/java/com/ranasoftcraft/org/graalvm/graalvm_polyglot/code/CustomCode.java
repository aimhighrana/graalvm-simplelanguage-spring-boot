package com.ranasoftcraft.org.graalvm.graalvm_polyglot.code;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.graalvm.polyglot.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration @Slf4j
public class CustomCode {

    @Value("classpath:code/ExecuteMe.sl")
    private Resource code;

    @PostConstruct
    public void runCode() throws IOException {

        log.info("Trying to execute custom code");

        try (Context context = Context.newBuilder()
                .allowPolyglotAccess(PolyglotAccess.ALL)
                .allowHostClassLookup(cls -> true)
                .allowHostAccess(HostAccess.ALL)
                .allowHostClassLoading(true)
                .build()) {

            String actualCode = asString(code);

            Source source = Source
                    .newBuilder("sl", actualCode, "source.sl")
                    .interactive(Boolean.TRUE)
                    .build();

            context.eval(source);

        }

        log.info("After completion of custom code execution");
    }


    public boolean executeMe(String jsCode) throws IOException {
        try (Context context = Context.newBuilder()
                .allowPolyglotAccess(PolyglotAccess.ALL)
                .allowHostClassLookup(cls -> true)
                .allowHostAccess(HostAccess.ALL)
                .allowHostClassLoading(true)
                .build()) {

            Source source = Source
                    .newBuilder("sl", jsCode, "source.sl")
                    .interactive(Boolean.TRUE)
                    .build();

            context.eval(source);
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
