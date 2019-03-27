package az.kapital.data;


import az.kapital.config.DBHelper;
import az.kapital.model.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    Connection c;
    PreparedStatement ps;
    ResultSet rs;

    public List<Phone> getPhoneList() throws SQLException {

        List<Phone> phones = new ArrayList<>();
        String query = "select *  from samsung";

        try {
            c = DBHelper.connect();
            if (c != null) {
                ps = c.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {

                    Phone phone = new Phone();
                    phone.setId(rs.getInt("id"));
                    phone.setVersion(rs.getString("version"));
                    phone.setCount(rs.getInt("count"));
                    phone.setActive(rs.getInt("active"));
                    phone.setSamsungid(rs.getInt("samsung_id"));
                    phones.add(phone);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.disconnect(c, ps, rs);
        }
        return phones;

    }


    public Phone getPhoneById(int id) throws SQLException {
        Phone phone = new Phone();
        String query = "select *  from samsung where id=?";

        try {
            c = DBHelper.connect();
            if (c != null) {
                ps = c.prepareStatement(query);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                while (rs.next()) {

                    phone.setId(rs.getInt("id"));
                    phone.setVersion(rs.getString("version"));
                    phone.setCount(rs.getInt("count"));
                    phone.setActive(rs.getInt("active"));
                    phone.setSamsungid(rs.getInt("samsung_id"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.disconnect(c, ps, rs);
        }
        return phone;
    }

    public boolean addPhone(Phone phone) throws SQLException {
        String query = "insert into samsung values(SAMSUNG_SEQ.nextval,?,?,?,?)";

        try {
            c = DBHelper.connect();
            if (c != null) {
                ps = c.prepareStatement(query);
                ps.setString(1, phone.getVersion());
                ps.setInt(2, phone.getCount());
                ps.setInt(3, phone.getActive());
                ps.setInt(4, phone.getSamsungid());
                ps.execute();
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.disconnect(c, ps, rs);
        }
        return false;

    }


}

