package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Member member = new Member();
        member.setUsername("member1");
        member.setHomeAddress(new Address("homeCity", "street", "ddd"));

        member.getFavoriteFoods().add("치킨");
        member.getFavoriteFoods().add("족발");
        member.getFavoriteFoods().add("피자");

        member.getAddressList().add(new Address("old1", "street", "ddd"));
        member.getAddressList().add(new Address("old2", "street", "ddd"));

        em.persist(member);
        tx.commit();

        //code
        em.close();
        emf.close();
    }
}
