package org.vaadin.example.back;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



@Stateless
public class CreditosRepository {
  
    @PersistenceContext(unitName = "oracle_PU")
    EntityManager em;


    public List<Creditos> findAll(){
        Query q = em.createQuery("Select c from Creditos c");
        return q.getResultList();
    }

    public Creditos findById(BigDecimal id) {
        return   em.find(Creditos.class, id);
    }

    public Creditos create(Creditos credito) {
         em.persist(credito);
         return credito;
    }

    public Creditos update(Creditos credito) {
        em.merge(credito);
        return credito;
    }

    public void delete(Creditos credito) {
        if (!em.contains(credito)) {
            credito = em.merge(credito);
        }

        em.remove(credito);
    }


    


}
