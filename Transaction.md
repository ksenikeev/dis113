# Управление транзакциями в JDBC

https://docs.oracle.com/javase/tutorial/jdbc/basics/transactions.html

```
    import java.sql.Connection;
    
    public void tr_func(){
        Connection connection=dataSource.getConnection(); // (1)

        try(connection){
        connection.setAutoCommit(false); // (2)
        // выполнить несколько SQL-запросов...
        connection.commit(); // (3)

        }catch(SQLException e){
        connection.rollback(); // (4)
        } finally {
        connection.setAutoCommit(true); 
        }
    }
```


## Уровни изоляции транзакции (Isolation level)

```
    connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED); // (1)
    
    // propagation=TransactionDefinition.NESTED
    
    Savepoint savePoint = connection.setSavepoint(); // (2)
    ...
    connection.rollback(savePoint);
```