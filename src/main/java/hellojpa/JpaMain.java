package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        //비영속
        //Member member = new Member();
        //member.setId(101L);
        //member.setName("abcd");

        //영속
        //System.out.println("---- before ----");
        //em.persist(member);
        //System.out.println("---- after ----");

        //Member findMember = em.find(Member.class, 101L);
        //System.out.println("id : " + findMember.getId());
        //System.out.println("name : " + findMember.getName());

        // Member findMember1 = em.find(Member.class, 101L);
        // Member findMember2 = em.find(Member.class, 101L); 29 번째 줄에서 context 에 가져오므로 캐시로 접근해서 가져옴.


        // 영속
        //Member mem1 = new Member(150L, "a1");
        //Member mem2 = new Member(160L, "a2");
        //em.persist(mem1);
        //em.persist(mem2);
        //System.out.println("---- here ---- ");
        tx.commit();

        //code
        em.close();
        emf.close();
    }
}
