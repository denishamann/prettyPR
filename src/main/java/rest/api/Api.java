package rest.api;

/**
 * Created by denis on 23/03/16.
 */


import prettyPR.PrettyPR;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class Api {

    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {

        return "Test";
    }

    @GET
    @Path("test2")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Message> test2() throws Exception {

        List<Message> messages = new ArrayList<Message>();

        Message m = new Message();
        m.setText("Hello World!");
        m.setAuthor("Denis");
        messages.add(m);
        System.out.println("getAllMessages(): found " + messages.size() + " message(s) on DB");

        return messages;
    }

    /*
    Envoyer:

        {
        "text": "Hello World!",
        "author": "Denis"
        }

     */
    @POST
    @Path("/test3")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.TEXT_PLAIN})
    public String test3(Message msg) throws Exception {
        System.out.println("First Name = " + msg.getText());
        System.out.println("Last Name  = " + msg.getAuthor());
        return "ok";
    }


    @POST
    @Path("/test4")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Message> test4(Message msg) throws Exception {

        System.out.println("First Name = " + msg.getText());
        System.out.println("Last Name  = " + msg.getAuthor());

        List<Message> messages = new ArrayList<Message>();
        Message m = new Message();
        m.setText("Hello World!");
        m.setAuthor("Jackie");
        messages.add(m);

        Message m2 = new Message();
        m2.setText("Zmele");
        m2.setAuthor("jimmi");
        messages.add(m2);

        return messages;
    }

    @POST
    @Path("prettypr")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String prettypr(MessageRequest msg) throws Exception {

        PrettyPR prettyPR = new PrettyPR(msg.getOldFileName(), msg.getOlfFile(), msg.getNewFileName(), msg.getNewFile());

        return prettyPR.getListeActions();

    }

}