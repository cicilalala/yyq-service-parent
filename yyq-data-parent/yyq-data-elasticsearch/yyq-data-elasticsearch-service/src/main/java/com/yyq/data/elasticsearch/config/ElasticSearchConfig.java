package com.yyq.data.elasticsearch.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.File;
import java.io.IOException;

/**
 * Created by yangyunqi on 2017/7/26.
 */
@Slf4j
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.yyq.data.elasticsearch.repository")
public class ElasticSearchConfig {

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws IOException {

        File tmpDir = File.createTempFile("elastic", Long.toString(System.nanoTime()));
        log.info("Temp directory={}", tmpDir.getAbsolutePath());
        Settings.Builder elasticsearchSettings = Settings
                .settingsBuilder()
                .put("http.enabled", "true")
                .put("index.number_of_shards", "1")
                .put("path.data", new File(tmpDir, "data").getAbsolutePath())
                .put("path.logs", new File(tmpDir, "logs").getAbsolutePath())
                .put("path.work", new File(tmpDir, "work").getAbsolutePath())
                .put("path.home", tmpDir);

        return new ElasticsearchTemplate(nodeBuilder().local(true).settings(elasticsearchSettings.build()).node().client());
    }
}
