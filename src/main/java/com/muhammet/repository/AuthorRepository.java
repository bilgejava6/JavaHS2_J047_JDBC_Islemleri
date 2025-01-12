package com.muhammet.repository;
import com.muhammet.entity.Author;
import com.muhammet.utility.DataBaseManagement;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository implements Repository<Author>{
    // Todo: ARAŞTIRILACAK, Geç Bağlanma
    private final DataBaseManagement dataBaseManagement;
    private String SQL;
    public AuthorRepository(){
        dataBaseManagement = new DataBaseManagement();
//        String E = "";
//        String K = "";
//        String ifade = "spor salonunda ["+E+"] ile ["+K+"] bugün buluşacak";
    }

    public void save(Author author) {
        SQL = "INSERT INTO author(first_name, last_name, birth_date, city) VALUES" +
                "('"+author.getFirstName()+"','"+author.getLastName()+"','"+author.getBirthDate()+"','"+author.getCity()+"')";
        dataBaseManagement.executeQuery(SQL);
    }

    public void update(Author author) {
        SQL = "UPDATE author SET first_name='"+author.getFirstName()+"'," +
                " last_name='"+author.getLastName()+"'," +
                " birth_date='"+author.getBirthDate()+"'," +
                " city='"+author.getCity()+"'" +
                " WHERE id="+author.getId();
        dataBaseManagement.executeQuery(SQL);
    }

    public void delete(Integer id) {
        SQL = "DELETE FROM author WHERE id="+id;
        dataBaseManagement.executeQuery(SQL);
    }

    public List<Author> findAll() {
        SQL = "SELECT * FROM author";
        ResultSet rs = dataBaseManagement.getResultSet(SQL);
        /**
         * ResultSet -> DB den sorgu neticesinde dönen tablonun içerisinde bulunduğu java nesnesi
         * bunun içerisinde tablo satır satır bulunmaktadır. Bu veriyi okuyarak bir listeye aktar
         * mamız gereklidir.
         */
        List<Author> authorList = new ArrayList<>();
        try{
            while (rs.next()){ // resultset içindeki tüm satırları tek tek dönmek için kullanıyoruz.
                // resultset içerisinde konumlandığım satırdaki verileri okuyorum.
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Date birthDate = rs.getDate("birth_date");
                String city = rs.getString("city");
                // okunan veriler ile author nesnesi oluşturuyoruz.
                Author author = new Author(id,firstName,lastName,birthDate,city,null,null,null);
                // oluşturduğum nesneyi listenin içerisine ekliyorum.
                authorList.add(author);
            }
        }catch (Exception exception){
            System.out.println("okuma işleminde hata...: "+ exception.getMessage());
        }
        return authorList;
    }
}
