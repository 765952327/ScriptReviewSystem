package cn.welsione.scriptcount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan(value = "cn.welsione.scriptcount.dao")

public class ScriptcountApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScriptcountApplication.class, args);
    }

}
