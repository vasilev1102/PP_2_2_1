package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      Car car1 = new Car("LADA1",1);
      Car car2 = new Car("LADA2",2);

      User user1 = new User("USER1","LASTNAME1","@MAIL1");
      User user2 = new User("USER2","LASTNAME2","@MAIL2");

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));

      System.out.println(userService.getUserByCar("LADA1",1));
      context.close();
   }
}
