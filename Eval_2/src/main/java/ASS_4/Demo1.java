package ASS_4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import EntityUtil.Util;

public class Demo1 {
	
	public static void main(String[] args) {
		
		EntityManager em=Util.provideManager();
		String jpql="from SalariedEmployee";
		
		Query q=em.createQuery(jpql);
		
		List<SalariedEmployee> li=q.getResultList();
		
		
		for(SalariedEmployee s:li) {
			System.out.println(s);
		}
		
	}

}
