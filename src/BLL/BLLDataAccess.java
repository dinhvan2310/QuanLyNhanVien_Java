package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.NhanVien;

public class BLLDataAccess 
{
    public static ResultSet getListFullNhanVien() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv");
    }

    public static ResultSet getListFullNhanVienSortAcsByID() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv");
    }

    public static ResultSet getListFullNhanVienSortDesByID() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by id desc");
    }

    public static ResultSet getListFullNhanVienSortAcsByName() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Name");
    }

    public static ResultSet getListFullNhanVienSortDesByName() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Name desc");
    }

    public static ResultSet getListFullNhanVienSortAcsByStartDay() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by StartDate");
    }

    public static ResultSet getListFullNhanVienSortDesByStartDay() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by StartDate desc");
    }

    public static ResultSet getListFullNhanVienSortAcsByGender() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Gender");
    }

    public static ResultSet getListFullNhanVienSortDesByGender() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Gender desc");
    }

    public static ResultSet getListFullNhanVienSortAcsByPosition() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Position");
    }

    public static ResultSet getListFullNhanVienSortDesByPosition() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Position desc");
    }

    public static ResultSet getListFullNhanVienSortAcsByAddress() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Address");
    }

    public static ResultSet getListFullNhanVienSortDesByAddress() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Address desc");
    }

    public static ResultSet getListFullNhanVienSortAscSalary() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Salary");
    }

    public static ResultSet getListFullNhanVienSortDesBySalary() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by Salary desc");
    }

    public static ResultSet getListFullNhanVienSortAcsWorkShift() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by WorkShift");
    }

    public static ResultSet getListFullNhanVienSortDesByWorkShift() throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv ORder by WorkShift desc");
    }


    public static ResultSet getNhanVienById(int id) throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv WHERE Id ='" + id + "';");
    }

    public static ResultSet getNhanVienByName(String name) throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv WHERE Name ='" + name + "';");
    }

    public static ResultSet getNhanVienByGender(String gender) throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv WHERE Gender ='" + gender + "';");
    }

    public static ResultSet getNhanVienByPosition(String position) throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv WHERE Position ='" + position + "';");
    }

    public static ResultSet getNhanVienByAddress(String address) throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv WHERE Address ='" + address + "';");
    }

    public static ResultSet getNhanVienByWorkShift(String workShift) throws SQLException
    {
        return DataAccess.DataHelper.getInstance().getResultSet("SELECT * FROM qlnv WHERE WorkShift ='" + workShift + "';");
    }


    public static boolean addNhanVien(NhanVien nhanVien) 
    {
        String qr;
        if(nhanVien.getId() == -1)
        {
            qr = "INSERT INTO `baitapnhomjava`.`qlnv` (`Name`, `Gender`, `StartDate`, `Position`, `Address`, `PhoneNumber`, `Salary`, `WorkShift`) VALUES ('" + nhanVien.getName() + "', '" + nhanVien.getGender() + "', '" + nhanVien.getStarDate().toString() + "', '" + nhanVien.getPosition() + "', '" + nhanVien.getAddress() + "', '" + nhanVien.getPhoneNumber() + "', '" + nhanVien.getSalary() + "', '" + nhanVien.getWorkShift() + "');";
        } 
        else
        {
            qr = "UPDATE `baitapnhomjava`.`qlnv` SET `Name` = '" + nhanVien.getName() + "', `Gender` = '" + nhanVien.getGender() + "', `StartDate` = '" + nhanVien.getStarDate().toString() + "', `Position` = '" + nhanVien.getPosition() +"', `Address` = '" + nhanVien.getAddress() + "', `PhoneNumber` = '" + nhanVien.getPhoneNumber() + "', `Salary` = '" + nhanVien.getSalary() + "', `WorkShift` = '" + nhanVien.getWorkShift() + "' WHERE (`Id` = '" + nhanVien.getId() + "');";
        }
            try{
                DataAccess.DataHelper.getInstance().updateDatabase(qr);
            return true;
            }
            catch(Exception e)
            {
                return false;
            }
    }

    public static boolean deleteNhanVien(int id)
    {
        
        String qr = "DELETE FROM `baitapnhomjava`.`qlnv` WHERE (Id = '" + id + "');";
            try{
                DataAccess.DataHelper.getInstance().updateDatabase(qr);
            return true;
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
                return false;
            }
    }
}