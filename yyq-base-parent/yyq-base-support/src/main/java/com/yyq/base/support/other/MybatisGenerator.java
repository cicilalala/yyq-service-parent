package com.yyq.base.support.other;

import com.yyq.base.support.utils.StrUtil;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.*;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangyunqi on 2017/7/18.
 */
public class MybatisGenerator {

    private static final String MASTERDB = "jdbc:mysql://rm-2zezf1dl45yqvh4zzo.mysql.rds.aliyuncs.com:3306/vc-manager";
    private static final String CLUSTERDB = "jdbc:mysql://localhost:3306/clusterDB";

    public void mybatisGenerator(String tableName, String dataBase) {

        String targetDomainPackage = "com.yyq.data.master.domain.master";
        String targetRepositoryPackage = "com.yyq.data.master.repository.master";
        final String modelName = StrUtil.underline2Camel(tableName, false);

        if (dataBase.equals(MASTERDB)) {
            targetDomainPackage = "com.yyq.data.master.domain.master";
            targetRepositoryPackage = "com.yyq.data.master.repository.master";
        } else if (dataBase.equals(CLUSTERDB)){
            targetDomainPackage = "com.yyq.data.master.domain.cluster";
            targetRepositoryPackage = "com.yyq.data.master.repository.cluster";
        }

        Map<String, String> map = new HashMap<>();

        map.put("connectionURL", dataBase);
        map.put("targetDomainPackage", targetDomainPackage);
        map.put("targetRepositoryPackage", targetRepositoryPackage);
        map.put("tableName", tableName);
        map.put("modelName", modelName);

        try {
            execute(map);
        } catch (InvalidConfigurationException | InterruptedException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void execute(Map<String, String> map) throws InvalidConfigurationException, InterruptedException, SQLException, IOException {

        List<String> warnings = new ArrayList<>();

        //每次生成重写
        boolean overwrite = true;

        Configuration config = new Configuration();

        //添加jar包
        config.addClasspathEntry("/Users/yangyunqi/.m2/repository/mysql/mysql-connector-java/5.1.40/mysql-connector-java-5.1.40.jar");

        Context context = new Context(ModelType.CONDITIONAL);

        context.setId("MySQLTables");
        context.setTargetRuntime("MyBatis3");

        //配置是否生成注释
        CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
        commentGeneratorConfiguration.addProperty("suppressAllComments", "true");
        commentGeneratorConfiguration.addProperty("suppressDate", "true");
        context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

        //配置数据库链接
        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setDriverClass("com.mysql.jdbc.Driver");

        jdbcConnectionConfiguration.setConnectionURL(map.get("connectionURL"));
        jdbcConnectionConfiguration.setUserId("root");
        jdbcConnectionConfiguration.setPassword("admin123");
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        JavaTypeResolverConfiguration javaTypeResolverConfiguration = new JavaTypeResolverConfiguration();
        javaTypeResolverConfiguration.addProperty("forceBigDecimals", "true");
        context.setJavaTypeResolverConfiguration(javaTypeResolverConfiguration);

        //配置实体
        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetPackage(map.get("targetDomainPackage"));
        javaModelGeneratorConfiguration.setTargetProject("/Users/yangyunqi/Documents/yyq-service-parent/yyq-data-parent/yyq-data-master/yyq-data-master-api/src/main/java");
        javaModelGeneratorConfiguration.addProperty("constructorBased", "true");
        javaModelGeneratorConfiguration.addProperty("enableSubPackages", "true");
        javaModelGeneratorConfiguration.addProperty("trimStrings", "true");
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        //配置Mapper
        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");

        sqlMapGeneratorConfiguration.setTargetProject("/Users/yangyunqi/Documents/yyq-service-parent/yyq-data-parent/yyq-data-master/yyq-data-master-service/src/main/resources");
        sqlMapGeneratorConfiguration.addProperty("enableSubPackages", "true");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        //配置Dao
        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        javaClientGeneratorConfiguration.setTargetPackage(map.get("targetRepositoryPackage"));

        javaClientGeneratorConfiguration.setTargetProject("/Users/yangyunqi/Documents/yyq-service-parent/yyq-data-parent/yyq-data-master/yyq-data-master-service/src/main/java");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        //配置表
        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(map.get("tableName"));
        tableConfiguration.setDomainObjectName(map.get("modelName"));
        tableConfiguration.addProperty("useActualColumnNames", "false");
        tableConfiguration.addProperty("useColumnIndexes", "true");

        context.addTableConfiguration(tableConfiguration);

        config.addContext(context);

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    public static void main(String[] args) {
        MybatisGenerator mybatisGenerator = new MybatisGenerator();
        mybatisGenerator.mybatisGenerator("log_tribe_statistics", MybatisGenerator.MASTERDB);
    }
}