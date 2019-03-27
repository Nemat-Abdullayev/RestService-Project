package az.kapital.service;


import az.kapital.config.DBHelper;
import az.kapital.data.DataManager;
import az.kapital.model.Phone;
import az.kapital.model.Phones;
import az.kapital.model.ResponseStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/web")
public class WebService {

    DataManager manager = new DataManager();

    @Path("/getHtml")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getHtml() {

        return "<Students><Student><Name>Nemet</Name></Student></Students>";
    }


    @Path("/getPhoneList")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Phones getPhoneList() {
        Phones phones = new Phones();
        try {
            phones.setPhones(manager.getPhoneList());
        } catch (Exception e) {
            e.printStackTrace();
        }


        return phones;
    }

    @GET
    @Path("/getPhoneById/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Phone getPhoneById(@PathParam(value = "id") int id) {
        Phone phone = null;
        try {
            phone = manager.getPhoneById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return phone;
    }

    @POST
    @Path("/addPhone")
    @Produces( MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public ResponseStatus addPhone(Phone phone) {
        ResponseStatus status = new ResponseStatus();

        try {
            if(manager.addPhone(phone)){
                status.setCode(200);
                status.setMessage("Phone was successfully added!");
            }else {
                status.setCode(101);
                status.setMessage("FAILURE!");

            }

        } catch (Exception e) {
            status.setCode(105);
            status.setMessage("System ERROR!");
            e.printStackTrace();
        }

        return status;

    }


}
