package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Movie movie = new Movie();
        movie.setDirector("aaa");
        movie.setActor("bbb");
        movie.setName("바람과 함께 사라지다");
        movie.setPrice(10000);
        em.persist(movie);
        tx.commit();

        //code
        em.close();
        emf.close();
    }
}
