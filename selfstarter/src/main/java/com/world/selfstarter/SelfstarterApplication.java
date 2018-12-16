package com.world.selfstarter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SelfstarterApplication extends Application {

	private ConfigurableApplicationContext springContext;
	private Parent root;

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(SelfstarterApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login_entry.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		root = fxmlLoader.load();
	}
//microservices https://www.youtube.com/watch?v=LDW0QWie21s
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}


	public static void main(String[] args) {
		launch(SelfstarterApplication.class, args);
	}
}