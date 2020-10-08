import cn.alan.entity.Book;
import cn.alan.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class JdbcTemplateTest {
    private static BookService bookService;

    static {
        //把beans.xml的类加载到容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        //从容器获取目标对象
        bookService = (BookService) applicationContext.getBean("bookService");
    }

    /**
     * 1. add a book to db
     */
    @Test
    public void testAdd() {
        Book book = new Book("5", "Python", "0");
        int result = bookService.add(book);
        System.out.println("add result = " + result);
    }

    /**
     * 2. update a book
     */
    @Test
    public void testUpdate() {
        Book book = new Book("5", "HTML", "1");
        int result = bookService.update(book);
        System.out.println("update result = " + result);
    }

    /**
     * 3. delete a book
     */
    @Test
    public void testDelete() {
        Book book = new Book("5", "Java", "1");
        int result = bookService.delete(book);
        System.out.println("delete result = " + result);
    }

    /**
     * 4. test query a value
     */
    @Test
    public void testQueryCount() {
        int result = bookService.queryCount();
        System.out.println("count = " + result);
    }

    /**
     * 5. query one record
     */
    @Test
    public void testQueryOne() {
        Book book = bookService.queryOne("1");
        System.out.println("query one record :" + book);
    }

    /**
     * 6. test query records
     */
    @Test
    public void testQueryBooks() {
        List<Book> list = bookService.queryBooks("select * from t_book");
        System.out.println(list);
    }

    /**
     * 7. test batch add records
     */
    @Test
    public void testBatchAdd() {
        List<Book> list = bookService.queryBooks("select * from t_book");
        List<Book> list2 = new ArrayList<Book>();//
        // batch add
        for (int index = 0; index < list.size(); index++) {
            Book book2 = list.get(index);
            int id = Integer.parseInt(book2.getBookId());
            book2.setBookId(String.valueOf(id * 10));
            list2.add(book2);
        }
        int[] batchResult = bookService.batchAdd(list2);
        System.out.println("batch add:" + Arrays.toString(batchResult));
    }


    /**
     * 8. test batch update records
     */
    @Test
    public void testBatchUpdate() {
        List<Book> list = bookService.queryBooks("select * from t_book");
        List<Book> list2 = new ArrayList<Book>();//

        for (int index = 0; index < list.size(); index++) {
            Book book2 = list.get(index);
            int id = Integer.parseInt(book2.getBookId());
            book2.setBookName(book2.getBookName() + "-" + book2.getBookId());
            list2.add(book2);
        }

        int[] batchResult = bookService.batchUpdate(list2);
        System.out.println("batch update:" + Arrays.toString(batchResult));
    }

    /**
     * 9. test batch delete records
     */
    @Test
    public  void testBatchDelete() {
        List<Book> list = bookService.queryBooks("select * from t_book");
        List<Book> list2 = new ArrayList<Book>();//
        for (int index = 0; index < list.size(); index++) {
            Book book2 = list.get(index);
            int id = Integer.parseInt(book2.getBookId());
            if (id % 2 == 0) {
                list2.add(book2);
            }
        }

        int[] batchResult = bookService.batchDelete(list2);
        System.out.println("batch delete:" + Arrays.toString(batchResult));
    }

}