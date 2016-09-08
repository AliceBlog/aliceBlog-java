import com.witdor.core.filter.CORSFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 2016/9/3 15:28
 * @Description: admin启动器
 * @Copyright(©) 2016 by xiaomo.
 **/

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.witdor")
@EntityScan("com.witdor.*.model")
@EnableTransactionManagement
@EnableJpaRepositories("com.witdor.*.dao")
public class AdminMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdminMain.class, args);
    }

    @Bean
    public CORSFilter corsFilter() {
        return new CORSFilter();
    }

}
