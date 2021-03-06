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
            System.out.println("Account saved!");
            session.close();
        } catch(Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }

    public void deleteAccount(Long accountId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Account account = session.get(Account.class, accountId);
            if (account != null) {
                session.delete(account);
                System.out.println("Account is deleted!");
            }
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void updateAccount(Account account){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction  = session.beginTransaction();
            session.update(account);
            transaction.commit();
            System.out.println("Account updated!");
            session.close();
        } catch(Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
    }
    public Account getAccount(long accountId){
        Transaction transaction = null;
        Account account = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction  = session.beginTransaction();
            account = session.get(Account.class, accountId);
            transaction.commit();
            session.close();
        } catch(Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return account;
    }

    public List<Account> getAccounts() {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            List<Account> listAllAccount = session.createQuery("from Account", Account.class).list();
            return listAllAccount;
        }
    }
}
