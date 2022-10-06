package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Team teamA = new Team();
        teamA.setName("teamA");
        em.persist(teamA);

        Team teamB = new Team();
        teamB.setName("teamB");
        em.persist(teamB);

        Member member1 = new Member();
        member1.setAge(10L);
        member1.setUsername("member1");
        member1.setTeam(teamA);
        em.persist(member1);

        Member member2 = new Member();
        member2.setUsername("member2");
        member2.setTeam(teamA);
        em.persist(member2);

        Member member3 = new Member();
        member3.setUsername("member3");
        member3.setTeam(teamB);
        em.persist(member3);

        em.flush();
        em.clear();

        // 단일값 연관 경로 : 묵시적 내부 join 발생함
        String query = "select m from Member m join m.team";

        List<Member> list = em.createQuery(query, Member.class)
                .getResultList();

        for(Member s : list){
            System.out.println("s : " + s.getUsername() + " , " + s.getTeam());
        }

        tx.commit();
        //code
        em.close();
        emf.close();
    }
}
