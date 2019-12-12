package com.gh.dubbo.security.config;

import com.gh.dubbo.security.authentication.LogOutHandler;
import com.gh.dubbo.security.authentication.LoginHandler;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;

import java.util.Properties;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //spring session为spring security 提供的用于在集群环境下控制会话并发的会话注册表实现类
    @Autowired
    private SpringSessionBackedSessionRegistry springSessionBackedSessionRegistry;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/captcha/getCaptcha", "/**.html").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/myLogin.html").loginProcessingUrl("/login")
                .successHandler(LoginHandler.successHandler).failureHandler(LoginHandler.failureHandler)
                .permitAll().and().csrf().disable()

                .logout().logoutSuccessHandler(LogOutHandler.successHandler)
                //使该用户的httpSession 失效
                .invalidateHttpSession(true)

                .and()
                .sessionManagement()
                .maximumSessions(1)
                //阻止新会话登录
                .maxSessionsPreventsLogin(true)
                .sessionRegistry(springSessionBackedSessionRegistry);


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(20);
    }

    @Bean
    public Producer Captcha() {
        Properties properties = new Properties();
        //是否有边框
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.border.color", "no");
        properties.put("kaptcha.textproducer.font.color", "blue");
        properties.put("kaptcha.textproducer.font.size", "45");
        properties.put("kaptcha.image.width", "125");
        properties.put("kaptcha.image.height", "60");
        properties.put("kaptcha.textproducer.char.length", 4);
        properties.put("kaptcha.textproducer.char.string", "0123456789");
        properties.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
