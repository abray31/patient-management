package service;

import dao.PrescriptionDAO;
import model.Prescription;

import java.sql.SQLException;
import java.util.List;

public class PrescriptionService {


    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    public void addPrescription(Prescription prescription){

        try {
            prescriptionDAO.addPrescription(prescription);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void updateDosage(int id, String info){
        try{
            prescriptionDAO.updateDosage(id, info);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateRefillInfo(int id, String info){
        try {
            prescriptionDAO.updateRefill(id, info);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deletePrescription(int id){
        try {
            prescriptionDAO.deletePrescription(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void viewPrescription(int id){
        try {
            prescriptionDAO.viewPrescription(id);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Prescription> getAllPrescriptions(){

        List<Prescription> prescriptionList = null;

        try {
            prescriptionList = prescriptionDAO.getAllPrescriptions();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return prescriptionList;
    }


}
