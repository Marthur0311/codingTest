package jp.co.testPjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring-Bootの根幹クラス
 * @author masahisa
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }
}