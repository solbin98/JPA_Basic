package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();

        tx.commit();

        //code
        em.close();
        emf.close();
    }
}
