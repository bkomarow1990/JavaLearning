package application;

import application.models.Category;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.postgresql.core.ConnectionFactory.openConnection;

public class Menu {
    Session session;
    Scanner scanner = new Scanner(System.in);
    private void printCategories(){
        //Query query = session.createQuery("from Student");
        List<Category> categories = session.createQuery("from Category", Category.class).list();
        for (Category category : categories){
            System.out.println("Id: " + category.getId() + " Name: " + category.getName() + " Image: " + category.getImage());
        }
    }
    private void addCategory(){
        Category category = new Category();
        System.out.println("Enter a name: ");
        category.setName(scanner.next());
        System.out.println("Enter an image: ");
        category.setImage(scanner.next());
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }
    private void deleteCategory(){
        //getting transaction object from session object
        //session.beginTransaction();
        System.out.println("Enter an id:");
        int id = scanner.nextInt();
        Category category = (Category)session.get(Category.class, id);
        session.beginTransaction();
        session.remove(category);
        session.getTransaction().commit();
    }
    private void updateCategory(){
        System.out.println("Enter an id:");
        int id = scanner.nextInt();
        session.beginTransaction();
        Category category = (Category)session.get(Category.class, id);
        System.out.println("Enter a name: ");
        category.setName(scanner.next());
        System.out.println("Enter an image: ");
        category.setImage(scanner.next());
        session.getTransaction().commit();
    }
    void start(){
        session = HibernateSession.getSessionFactory().openSession();
//        Connection connection = openConnection();
//        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection())
//        try (Liquibase liquibase = new liquibase.Liquibase("path/to/changelog.xml", new ClassLoaderResourceAccessor(), database)){
//            properties.forEach((key, value) -> liquibase.setChangeLogParameter(Objects.toString(key), value));
//            liquibase.update(new Contexts(), new LabelExpression());
//        }
        int answer = -1;
        while(answer != 0){
//            System.out.flush();
//            for (int i = 0; i < 50; ++i) System.out.println();
//            System.out.print("\033\143");
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("1.Show all\n2.Add new\n3.Edit\n4.Delete\n0.Exit");
            answer = scanner.nextInt();
            switch (answer){
                case 1:
                    printCategories();
                    //session.ge
                    break;
                    case 2:
                        addCategory();
                        break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                default:
                    break;
            }
        }
        session.close();
    }
}
