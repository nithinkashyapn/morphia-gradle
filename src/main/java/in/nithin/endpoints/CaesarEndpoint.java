package in.nithin.endpoints;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jersey.repackaged.com.google.common.collect.Lists;
import in.nithin.model.Caesar;

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
    @Consumes({MediaType.APPLICATION_JSON})
    public Response encryption(Caesar caesar){
        System.out.println(caesar.message +" "+ caesar.offset);
        String result = "Encryption";
        return Response.status(200).entity(caesar).build();
    }

    @POST
    @Path("decrypt")
    @Produces({MediaType.APPLICATION_JSON})
    public Response decryption(@FormParam("message") String message, @FormParam("offset") int offset){

        JsonObject jsObj = new JsonObject();
        jsObj.addProperty("Status", "Decryption");
        jsObj.addProperty("message", message);
        jsObj.addProperty("offset", offset);

        String result = jsObj.toString();
        return Response.status(200).entity(result).build();
    }
}
