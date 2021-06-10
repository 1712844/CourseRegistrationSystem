import com.mysql.cj.Session;
import dao.AccountDAO;
import model.Account;
import java.util.List;
import util.HibernateUtil;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        Account account = new Account("account1", "password1");
        accountDAO.saveAccount(account);

        List<Account> accounts = accountDAO.getAccounts();
        accounts.forEach(a -> System.out.println(a));
    }
}
