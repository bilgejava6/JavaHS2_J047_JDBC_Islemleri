package com.muhammet.repository;
import com.muhammet.entity.Author;
import com.muhammet.utility.DataBaseManagement;

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
        return List.of();
    }
}
