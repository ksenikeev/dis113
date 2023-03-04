#JAVA + PostgreSQL
#JDBC

1. Добавление в проект зависимости
    ```xml
            <dependency>
                <groupId>org.postgresql</groupId>
                <artifactId>postgresql</artifactId>
                <version>42.5.0</version>
            </dependency>
    ```
2. Подключение к БД (connection)
    ```java
            import java.sql.Connection;
            import java.sql.DriverManager;
            import java.sql.SQLException;
            
            public class TestJDBCConnection {
                public static void main(String[] args){
                   
                    String url = "jdbc:postgresql://localhost:5432/dbname";
                    try (Connection conn = 			
                        DriverManager.getConnection(url,"postgres","passwd")){
                        // работа с БД;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
    ```

3. В ряде случаев необходимо принудительно загрузить класс драйвера:
    Class.forName("org.postgresql.Driver");

4. Выполнение запросов к БД
    
    _Statement.executeQuery_ - SELECT
    
    ```java
        Statement statement = conn.createStatement();
    
                ResultSet resultSet = statement.executeQuery(
                        "select name,birthdate,gender,facultet_name,height from student");
    
                while(resultSet.next()) {
                    //get data from resultSet
                }
                
                resultSet.close();
                statement.close();
   ```
   К результату мы можем обратиться либо по номеру колонки, либо по имени
   
   resultSet.getString(1)
   
   resultSet.getString("name)
   
   _Statement.executeUpdate_ - INSERT, UPDATE, DELETE
   
``` java
            sql = "INSERT INTO facultet (name,build)" +
                    " VALUES ('ИТИС','Кремлевская 35')";
            int rows = statement.executeUpdate(sql);

            System.out.println("inserted " + rows + " rows");

            sql = "UPDATE student SET height = 187 WHERE name = 'Ахмад'";

            rows = statement.executeUpdate(sql);

            System.out.println("updated " + rows + " rows");

            sql = "DELETE FROM student WHERE name = 'Иван'";
            rows = statement.executeUpdate(sql);

            System.out.println("deleted " + rows + " rows");

```