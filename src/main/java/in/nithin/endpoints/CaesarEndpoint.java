package in.nithin.endpoints;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jersey.repackaged.com.google.common.collect.Lists;
import in.nithin.controller.CaesarED;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import org.codehaus.jettison.json.JSONObject;

@Path("/caesar")
public class CaesarEndpoint {

    @POST
    @Path("encrypt")
    @Produces({MediaType.APPLICATION_JSON})
    public Response encryption(@FormParam("message") String message, @FormParam("offset") int offset){

        String eMessage = CaesarED.encrypt(message, offset);

        JsonObject jsObj = new JsonObject();
        jsObj.addProperty("status", "Encryption");
        jsObj.addProperty("message", message);
        jsObj.addProperty("eMessage", eMessage);
        jsObj.addProperty("offset", offset);

        String result = jsObj.toString();
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("decrypt")
    @Produces({MediaType.APPLICATION_JSON})
    public Response decryption(@FormParam("message") String message, @FormParam("offset") int offset){

        String dMessage = CaesarED.decrypt(message, offset);

        JsonObject jsObj = new JsonObject();
        jsObj.addProperty("status", "Decryption");
        jsObj.addProperty("message", message);
        jsObj.addProperty("dMessage", dMessage);
        jsObj.addProperty("offset", offset);

        String result = jsObj.toString();
        return Response.status(200).entity(result).build();
    }
}
