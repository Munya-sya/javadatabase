**Setting up Datagrip and intellij**
1. Install Datagrip, intellj and Dockerhub
2. Setting up docker
3. Pull mysql image from dockerhub

```
docker run --name mysql1 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql:5.7
```
4. Open dataGrip and setup the database link 
Example
```
String driverClassName
                = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "root";
        String password = "root";
```

5. Add the sql dependency on pom file
```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
```
or
```
<dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.30</version>
        </dependency>
    </dependencies>
```

Edit the file to be like
```
package org.example;
import java.sql.*;

public class Main {

    public static void main(String[] args)
    throws SQLException, ClassNotFoundException{
        String driverClassName
                = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/bank"; //Bank is the database
        String username = "root";
        String password = "root";
        String query
                = "insert into students values(109, 'bhatt')";

        // Load driver class
        Class.forName(driverClassName);

        // Obtain a connection
        Connection con = DriverManager.getConnection(
                url, username, password);

        // Obtain a statement
        Statement st = con.createStatement();

        // Execute the query
        int count = st.executeUpdate(query);
        System.out.println(
                "number of rows affected by this query= "
                        + count);

        // Closing the connection as per the
        // requirement with connection is completed
        con.close();

    }
}
```

More information check: https://baumannalexj.medium.com/connect-your-db-tool-to-a-dockerized-mysql-server-container-bc18853524ed

**Other Examples**
> **Select**

```
package org.example;

import java.sql.*;

import java.time.Year;

public class selectoption {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "SELECT id, name FROM students";

    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                System.out.print("ID: "+rs.getInt("id")+ "\t");
                System.out.print("Name: "+rs.getString("name")+ "\n");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
```
> **Create**
```
package org.example;

import java.sql.*;

import java.time.Year;

public class selectoption {
    static final String DB_URL = "jdbc:mysql://localhost:3306/bank";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "insert into students values(111, 'bhatt')";


    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(QUERY);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
other info: https://www.mitrais.com/news-updates/step-by-step-making-a-simple-crud-application-using-java-servlet-jsp/
