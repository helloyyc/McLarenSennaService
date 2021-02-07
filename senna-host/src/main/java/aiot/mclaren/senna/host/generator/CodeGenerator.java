package aiot.mclaren.senna.host.generator;

import aiot.mclaren.senna.model.entity.BaseEntity;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author lsj
 * @date 2021/2/6 9:16
 */
public class CodeGenerator {
    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, IOException {
        Properties properties = new Properties();

        try(InputStream in = CodeGenerator.class.getClassLoader().getResourceAsStream("private_infos.properties")) {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("read config file error");
        }
        String jdbcUrl =
            properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");
        String driverName = "com.mysql.cj.jdbc.Driver";
        String author = "lsj";

        String packageName = "aiot.mclaren.senna";
        String entityPkg = "model.entity";
        String mapperPkg = "host.mapper";
        String servicePkg = "host.service";
        String serviceImplPkg = "host.service.impl";
        String controllerPkg = "host.controller";
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor(author);
        gc.setOpen(false);
        // 设置 resultMap
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        //        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(jdbcUrl);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setEntity(entityPkg);
        pc.setMapper(mapperPkg);
        pc.setService(servicePkg);
        pc.setServiceImpl(serviceImplPkg);
        pc.setController(controllerPkg);

        /* Path */
        Map<String, String> pathInfo = new HashMap<>();
        pathInfo.put(ConstVal.ENTITY_PATH, getPackagePath("senna-model", pc.getParent(), pc.getEntity()));
        pathInfo.put(ConstVal.MAPPER_PATH, getPackagePath("senna-host", pc.getParent(), pc.getMapper()));
        pathInfo.put(ConstVal.SERVICE_PATH, getPackagePath("senna-host", pc.getParent(), pc.getService()));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, getPackagePath("senna-host", pc.getParent(), pc.getServiceImpl()));
        pathInfo.put(ConstVal.CONTROLLER_PATH, getPackagePath("senna-host", pc.getParent(), pc.getController()));
        pc.setPathInfo(pathInfo);

        mpg.setPackageInfo(pc);
        //包配置 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        //如果模板引擎是 velocity 自定义输出配置
        String templatePath = "/templates/mapper.xml.vm";
        List<FileOutConfig> focList = new ArrayList<>();
        //自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return getResPath("senna-host") + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);
        mpg.setTemplateEngine(new VelocityTemplateEngine());

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setSuperEntityClass(BaseEntity.class);
        // 写于父类中的公共字段
        strategy.setSuperEntityColumns("id", "create_dt", "update_dt");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        //        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        mpg.execute();
    }

    private static String getPackagePath(String moduleName, String parentName, String packageName) {
        String projectPath = System.getProperty("user.dir");
        String baseDir = projectPath + "/" + moduleName + "/src/main/java/";
        return baseDir + (parentName + "." + packageName).replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
    }

    private static String getResPath(String moduleName) {
        return System.getProperty("user.dir") + "/" + moduleName + "/src/main/resources/mapper/";
    }
}
