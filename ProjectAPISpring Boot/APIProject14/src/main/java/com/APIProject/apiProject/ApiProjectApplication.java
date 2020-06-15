package com.APIProject.apiProject;

import com.APIProject.apiProject.Model.FactionProperties;
import com.APIProject.apiProject.service.GuerrillaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiProjectApplication {
	public static void main(String[] args) {

		org.springframework.context.ApplicationContext context = (ApplicationContext) SpringApplication.run(ApiProjectApplication.class, args);
		FactionProperties factionProperties = new FactionProperties();
		GuerrillaService serviceGuerrilla = (GuerrillaService) context.getBean("guerrillaService");

		Runnable runnable= new Runnable() {
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(60000);
						factionProperties.UpdateProperties(serviceGuerrilla);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		Thread actualizador= new Thread(runnable);
		actualizador.start();


	}//MAIN
}
