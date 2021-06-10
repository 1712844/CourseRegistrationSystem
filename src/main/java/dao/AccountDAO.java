package dao;

import model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import java.util.List;

public class AccountDAO {
    public void saveAccount(Account account){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction  = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch(Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Account> getAccounts() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            return session.createQuery("from Account", Account.class).list();
        }
    }
}
