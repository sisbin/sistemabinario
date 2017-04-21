package br.com.comerciobinario.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	
	private static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager(){		
        
		if(emf == null){
			try {
				emf = Persistence.createEntityManagerFactory("binario");
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		return emf.createEntityManager();
	}

}
