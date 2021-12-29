import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
    数据层内容生成
 */
public class EntityGenerator {

    private String outputDir = "E:\\service\\work\\im-service\\src\\main\\java";
    // 生成类的作者
    private String author = "im";
    // 数据源相关配置
    private String url = "jdbc:mysql://8.129.109.206:3306/im?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false&serverTimezone=UTC";
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String userName = "im";
    private String userPwd = "123456";
    // 包路径
    private String daoPackage = "com.im.service";
    // 待生成的表名，注意是覆盖更新
    private static String[] tableNames;

    /**
     * 当前数据库所有的表
     * tb_user tb_token tb_praise tb_goods_list tb_feed_back tb_category tb_article
     * sys_user_role sys_user sys_role_menu sys_role_dept sys_role sys_oss
     * sys_menu sys_log sys_dict sys_dept sys_config sys_app_version sys_app_template
     * schedule_job_log schedule_job qrtz_triggers qrtz_simprop_triggers qrtz_simple_triggers
     * qrtz_paused_trigger_grps qrtz_locks qrtz_job_details qrtz_cron_triggers qrtz_calendars qrtz_blob_triggers
     *
     * 数组中我只放了一小部分，如过重新生成或者表有改动，tableNames数组中的数据补全或重写
     */
    static {
        tableNames = new String[]{
//                "message"
        };
    }
@Test
    public void entityGenerator() {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setTemplateEngine(new BeetlTemplateEngine());
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(false);
        gc.setAuthor(author);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        // dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(userPwd);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setTablePrefix(new String[]{"_"});// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(tableNames);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setController(daoPackage + ".controller");
        pc.setService(daoPackage + ".service");
        pc.setServiceImpl(daoPackage + ".service.impl");
        pc.setEntity(daoPackage + ".dao.entity");
        pc.setMapper(daoPackage + ".dao.mapper");
        pc.setXml(daoPackage + ".dao.mapper.mapper.xml");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        mpg.setCfg(cfg);

        // 执行生成
        mpg.execute();

        // 打印注入设置
        System.err.println(mpg.getCfg().getMap().get("abc"));

    }

}
