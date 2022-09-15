package ASS_4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import EntityUtil.Util;

public class Demo2 {
	
	public static void main(String[] args) {
		
		EntityManager em=Util.provideManager();
		String jpql="from ConractualEmployee";
		
		Query q=em.createQuery(jpql);
		
		List<ConractualEmployee> li=q.getResultList();
		
		
		for(ConractualEmployee s:li) {
			System.out.println(s);
		}
		
	}

}
